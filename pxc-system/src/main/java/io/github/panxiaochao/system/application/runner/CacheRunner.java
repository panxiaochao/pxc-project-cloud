package io.github.panxiaochao.system.application.runner;

import io.github.panxiaochao.system.application.service.SysDictAppService;
import io.github.panxiaochao.system.application.service.SysParamAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 数据字典 内存加载
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-15
 */
@Order(1)
@Component
@RequiredArgsConstructor
public class CacheRunner implements ApplicationRunner {

	/**
	 * 数据字典表 App服务类.
	 */
	private final SysDictAppService sysDictAppService;

	/**
	 * 系统参数 App服务类.
	 */
	private final SysParamAppService sysParamAppService;

	@Override
	public void run(ApplicationArguments args) {
		sysDictAppService.publishedData();
		sysParamAppService.publishedData();
	}

}
