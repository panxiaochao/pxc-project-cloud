package io.github.panxiaochao.system.application.monitor;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.SystemServerUtil;
import io.github.panxiaochao.core.utils.sysinfo.ServerInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统监控
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-08
 */
@Tag(name = "系统监控 接口", description = "系统监控 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/web/v1/monitor")
public class WebMonitorApi {

	/**
	 * 获取系统信息
	 */
	@Operation(summary = "获取系统信息", description = "获取系统信息", method = "GET")
	@GetMapping
	public R<ServerInfo> monitor() {
		return R.ok(SystemServerUtil.INSTANCE().getServerInfo());
	}

	/**
	 * 获取系统信息
	 */
	@Operation(summary = "获取网络速率", description = "获取网络速率", method = "GET")
	@GetMapping("/networkInterfaces")
	public R<Object> networkInterfaces() {
		return R.ok(SystemServerUtil.INSTANCE().ofNetworkInterfaces());
	}

}
