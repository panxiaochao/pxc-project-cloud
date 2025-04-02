package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.system.development.application.api.response.gen.PreviewResponse;
import io.github.panxiaochao.system.development.application.service.GenAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
