package io.github.panxiaochao.system.development.application.api;

import cn.hutool.core.util.StrUtil;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.DownLoadUtil;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.operate.log.core.annotation.OperateLog;
import io.github.panxiaochao.operate.log.core.enums.BusinessType;
import io.github.panxiaochao.system.development.application.api.response.gen.PreviewResponse;
import io.github.panxiaochao.system.development.application.service.GenAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * <p>
 * 代码生成生成 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-04-01
 */
@Tag(name = "代码生成生成 接口", description = "代码生成生成 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/gen")
public class GenApi {

	/**
	 * LOGGER GenApi.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(GenApi.class);

	/**
	 * 代码生成生成 服务
	 */
	private final GenAppService genAppService;

	/**
	 * 预览代码
	 */
	@Operation(summary = "预览代码", description = "预览代码", method = "GET")
	@GetMapping("/preview/{tableId}")
	public R<List<PreviewResponse>> preview(@PathVariable String tableId) throws Exception {
		return R.ok(genAppService.preview(tableId));
	}

	/**
	 * 生成代码 - ZIP
	 * @param tableIds 数据表ID
	 */
	@Operation(summary = "生成代码 - ZIP", description = "生成代码 - ZIP", method = "GET")
	@OperateLog(key = "#tableIds", description = "生成代码 - ZIP", businessType = BusinessType.EXPORT)
	@GetMapping("/download")
	public ResponseEntity<byte[]> download(String tableIds) {
		if (StrUtil.isBlank(tableIds)) {
			return DownLoadUtil.fail();
		}
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try (ZipOutputStream zip = new ZipOutputStream(outputStream);) {
			// 生成代码
			for (String tableId : tableIds.split(StringPools.COMMA)) {
				genAppService.download(tableId, zip);
			}
		}
		catch (Exception e) {
			LOGGER.error("ZIP 下载错误", e);
			return DownLoadUtil.fail();
		}
		return DownLoadUtil.download(outputStream.toByteArray(), "GeneratorCode.zip");
	}

	/**
	 * 生成代码 - 自定义路径
	 */
	@ResponseBody
	@Operation(summary = "生成代码 - 自定义路径", description = "生成代码 - 自定义路径", method = "GET")
	@GetMapping("/generatorCode")
	public R<String> generatorCode(String tableIds) {
		for (String tableId : tableIds.split(StrUtil.COMMA)) {
			genAppService.generatorCode(tableId);
		}
		return R.ok();
	}

}
