package io.github.panxiaochao.system.runner;

import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.application.service.SysDictAppService;
import io.github.panxiaochao.system.application.service.SysParamAppService;
import io.github.panxiaochao.system.common.constants.RedisConstant;
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
		// 单线程执行
		// Executors.newSingleThreadExecutor().submit(this::publishedData);
		publishedData();
	}

	void publishedData() {
		// 数据字典缓存
		if (RedissonUtil.getKeysByPattern(RedisConstant.KEY_ALL_SYS_DICT).isEmpty()) {
			sysDictAppService.publishedData();
		}
		// 系统参数缓存
		if (RedissonUtil.getKeysByPattern(RedisConstant.KEY_ALL_SYS_PARAM).isEmpty()) {
			sysParamAppService.publishedData();
		}
	}

}
