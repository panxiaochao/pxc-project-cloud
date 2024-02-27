package io.github.panxiaochao.system.auth.service;

import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.ObjectUtil;
import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.auth.request.LoginRequest;
import io.github.panxiaochao.system.common.constants.GlobalConstant;
import io.github.panxiaochao.system.common.constants.LoginIdentityType;
import io.github.panxiaochao.system.common.exception.UserLoginException;
import io.github.panxiaochao.system.common.model.AuthUserToken;
import io.github.panxiaochao.system.domain.entity.SysUserLogin;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class WebLoginService {

	/**
	 * LOGGER LoginWebService.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(WebLoginService.class);

	/**
	 * 用户表 读模型服务
	 */
	private final ISysUserReadModelService sysUserReadModelService;

	public R<AuthUserToken> login(LoginRequest loginRequest) {
		String identityType = LoginIdentityType.detect(loginRequest.getUsername());
		SysUserLogin sysUserLogin = sysUserReadModelService.loadUserByIdentityType(loginRequest.getUsername(),
				identityType);
		if (Objects.isNull(sysUserLogin)) {
			throw new ServerRuntimeException(UserLoginException.USER_NOT_EXIST_EXCEPTION);
		}
		// 登录校验
		checkLogin(sysUserLogin, loginRequest);
		// 构建登录用户
		buildLoginUser(sysUserLogin);
		// 构建Token
		buildAuthToken(sysUserLogin);
		return R.ok(new AuthUserToken());
	}

	/**
	 * 登录校验
	 * @param sysUserLogin 登录用户
	 * @param loginRequest 登录请求对象
	 */
	private void checkLogin(SysUserLogin sysUserLogin, LoginRequest loginRequest) {
		// TODO 验证码

		// 账号已过期
		if (sysUserLogin.getUserExpireTime() != null
				&& sysUserLogin.getUserExpireTime().isBefore(LocalDateTime.now())) {
			throw new ServerRuntimeException(UserLoginException.USER_ACCOUNT_EXPIRE_EXCEPTION);
		}
		// 账号登录错误次数不超过5次
		String loginFailLimitKey = GlobalConstant.LOGIN_FAIL_LIMIT_KEY + loginRequest.getUsername();
		long loginFailNums = ObjectUtil.getIfNull(RedissonUtil.INSTANCE().get(loginFailLimitKey), 0L);
		if (loginFailNums > 4) {
			throw new ServerRuntimeException(UserLoginException.USER_LOGIN_FAIL_EXCEED_EXCEPTION);
		}
		// 密码已过期
		if (sysUserLogin.getIdentifierExpireTime() != null
				&& sysUserLogin.getIdentifierExpireTime().isBefore(LocalDateTime.now())) {
			throw new ServerRuntimeException(UserLoginException.USER_PASSWORD_EXPIRE_EXCEPTION);
		}
		// 密码未验证
		if ("0".equals(sysUserLogin.getVerified())) {
			throw new ServerRuntimeException(UserLoginException.USER_PASSWORD_VERIFY_EXCEPTION);
		}
		// 密码不匹配
		if (!loginRequest.getPassword().equals(sysUserLogin.getCredential())) {
			// 错误次数加一
			loginFailNums++;
			RedissonUtil.INSTANCE().set(loginFailLimitKey, loginFailNums);
			if (loginFailNums > 4) {
				// 锁定10分钟
				RedissonUtil.INSTANCE().expireIfNotSet(loginFailLimitKey, Duration.ofMinutes(10));
			}
			throw new ServerRuntimeException(UserLoginException.USER_PASSWORD_ILLEGAL_EXCEPTION);
		}
		else {
			RedissonUtil.INSTANCE().delete(loginFailLimitKey);
		}
	}

	/**
	 * 构建登录用户
	 * @param sysUserLogin 登录用户
	 */
	private void buildLoginUser(SysUserLogin sysUserLogin) {




	}

	/**
	 * 构建Token
	 * @param sysUserLogin 登录用户
	 */
	private void buildAuthToken(SysUserLogin sysUserLogin) {
	}

}
