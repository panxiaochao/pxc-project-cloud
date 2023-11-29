package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysParamAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统参数 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "系统参数", description = "系统参数Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysparam")
public class SysParamApi {

	/**
	 * 系统参数 服务
	 */
	private final SysParamAppService sysParamAppService;

}
