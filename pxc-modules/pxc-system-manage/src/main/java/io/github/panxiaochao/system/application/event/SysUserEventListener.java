package io.github.panxiaochao.system.application.event;

import io.github.panxiaochao.system.application.service.SysUserAppService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * 用户监听类
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-15
 * @version 1.0
 */
@RequiredArgsConstructor
@Configuration
public class SysUserEventListener {

	/**
	 * LOGGER SysUserEventListener.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SysUserEventListener.class);

	/**
	 * 用户表 服务
	 */
	private final SysUserAppService sysUserAppService;

	/**
	 * 记录用户登录信息
	 * @param loginUser 用户信息
	 */
	@Async
	@EventListener
	public void updateUserLogin(LoginUser loginUser) {
		LOGGER.info("[记录用户登录信息]");
		sysUserAppService.updateUserLogin(loginUser.getUserId(), loginUser.getLoginTime());
	}

}
