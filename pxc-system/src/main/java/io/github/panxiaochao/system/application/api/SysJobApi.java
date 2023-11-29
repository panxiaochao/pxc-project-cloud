package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysJobAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 定时任务调度表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "定时任务调度表", description = "定时任务调度表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysjob")
public class SysJobApi {

	/**
	 * 定时任务调度表 服务
	 */
	private final SysJobAppService sysJobAppService;

}
