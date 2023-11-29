package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysDictItemAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典配置表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "数据字典配置表", description = "数据字典配置表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysdictitem")
public class SysDictItemApi {

	/**
	 * 数据字典配置表 服务
	 */
	private final SysDictItemAppService sysDictItemAppService;

}
