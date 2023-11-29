package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysMenuAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单配置 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "菜单配置", description = "菜单配置Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysmenu")
public class SysMenuApi {

	/**
	 * 菜单配置 服务
	 */
	private final SysMenuAppService sysMenuAppService;

}
