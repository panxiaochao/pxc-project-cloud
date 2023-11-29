package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysLogLoginAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统日志登录/登出表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "系统日志登录/登出表", description = "系统日志登录/登出表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysloglogin")
public class SysLogLoginApi {

	/**
	 * 系统日志登录/登出表 服务
	 */
	private final SysLogLoginAppService sysLogLoginAppService;

}
