package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysUserAuthsAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户授权信息表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "用户授权信息表", description = "用户授权信息表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysuserauths")
public class SysUserAuthsApi {

	/**
	 * 用户授权信息表 服务
	 */
	private final SysUserAuthsAppService sysUserAuthsAppService;

}
