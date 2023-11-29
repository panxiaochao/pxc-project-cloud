package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysPostAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 岗位表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "岗位表", description = "岗位表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/syspost")
public class SysPostApi {

	/**
	 * 岗位表 服务
	 */
	private final SysPostAppService sysPostAppService;

}
