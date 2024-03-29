package io.github.panxiaochao.system.auth.service;

import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.IpUtil;
import io.github.panxiaochao.core.utils.ObjectUtil;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.auth.config.properties.PAuthProperties;
import io.github.panxiaochao.system.auth.request.LoginRequest;
import io.github.panxiaochao.system.common.constants.GlobalConstant;
import io.github.panxiaochao.system.common.constants.LoginIdentityType;
import io.github.panxiaochao.system.common.core.context.PTokenContext;
import io.github.panxiaochao.system.common.core.generator.PTokenGenerator;
import io.github.panxiaochao.system.common.core.token.PRefreshToken;
import io.github.panxiaochao.system.common.core.token.PToken;
import io.github.panxiaochao.system.common.core.tokentype.PAccessTokenType;
import io.github.panxiaochao.system.common.core.tokentype.PRefreshTokenType;
import io.github.panxiaochao.system.common.exception.UserLoginException;
import io.github.panxiaochao.system.common.jwt.Jwt;
import io.github.panxiaochao.system.common.model.LoginUser;
import io.github.panxiaochao.system.common.model.PAuthUserToken;
import io.github.panxiaochao.system.domain.entity.SysUserLogin;
import io.github.panxiaochao.system.domain.service.SysPermissionDomainService;
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

	/**
	 * 用户权限聚合 Domain服务类
	 */
	private final SysPermissionDomainService sysPermissionDomainService;

	/**
	 * 令牌生成
	 */
	private final PTokenGenerator<? extends PToken> pTokenGenerator;

	/**
	 * Token自定义属性
	 */
	private final PAuthProperties pAuthProperties;

	public R<PAuthUserToken> login(LoginRequest loginRequest) {
		String identityType = LoginIdentityType.detect(loginRequest.getUsername());
		SysUserLogin sysUserLogin = sysUserReadModelService.loadUserByIdentityType(loginRequest.getUsername(),
				identityType);
		if (Objects.isNull(sysUserLogin)) {
			throw new ServerRuntimeException(UserLoginException.USER_NOT_EXIST_EXCEPTION);
		}
		// 登录校验
		checkLogin(sysUserLogin, loginRequest);
		// 构建登录用户
		LoginUser loginUser = buildLoginUser(sysUserLogin);
		// 设置账号
		loginUser.setUserName(loginRequest.getUsername());
		// 构建Token
		PAuthUserToken userToken = buildAuthToken(loginUser);
		// TODO 异步更新数据

		return R.ok(userToken);
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
	 * @return 构建用户数据
	 */
	private LoginUser buildLoginUser(SysUserLogin sysUserLogin) {
		LoginUser loginUser = new LoginUser();
		loginUser.setUserId(sysUserLogin.getUserId());
		loginUser.setUserName(sysUserLogin.getUserName());
		loginUser.setRealName(sysUserLogin.getRealName());
		loginUser.setNickName(sysUserLogin.getNickName());
		loginUser.setAvatar(sysUserLogin.getAvatar());
		loginUser.setSex(sysUserLogin.getSex());
		loginUser.setEmail(sysUserLogin.getEmail());
		loginUser.setMobile(sysUserLogin.getMobile());
		loginUser.setPostCode(sysUserLogin.getPostCode());
		loginUser.setOrgId(sysUserLogin.getOrgId());
		loginUser.setOrgCode(sysUserLogin.getOrgCode());
		loginUser.setIp(IpUtil.ofRequestIp());
		loginUser.setRoles(sysPermissionDomainService.selectRolePermission(sysUserLogin.getUserId()));
		loginUser.setMenuPermissionCode(sysPermissionDomainService.selectMenuPermissionCode(sysUserLogin.getUserId()));
		return loginUser;
	}

	/**
	 * 构建Token
	 * @param loginUser 构建过的用户
	 * @return 用户token
	 */
	private PAuthUserToken buildAuthToken(LoginUser loginUser) {
		// 构造上下文
		PTokenContext.Builder pTokenContextBuilder = PTokenContext.builder()
			.JWSAlgorithm(pAuthProperties.getAlgorithm().getName())
			.principal(loginUser.getUserName())
			.loginUser(loginUser.toMap())
			.accessTokenTimeToLive(pAuthProperties.getAccessTokenTimeToLive())
			.refreshTokenTimeToLive(pAuthProperties.getRefreshTokenTimeToLive());
		// 访问令牌
		PTokenContext accessTokenContext = pTokenContextBuilder.pTokenType(PAccessTokenType.ACCESS_TOKEN).build();
		Jwt jwt = (Jwt) pTokenGenerator.generate(accessTokenContext);
		// 刷新令牌
		PTokenContext refreshTokenContext = pTokenContextBuilder.pTokenType(PRefreshTokenType.REFRESH_TOKEN).build();
		PRefreshToken refreshToken = (PRefreshToken) pTokenGenerator.generate(refreshTokenContext);
		// 组建令牌
		PAuthUserToken userToken = new PAuthUserToken();
		userToken.setAccessToken(jwt.getTokenValue());
		userToken.setRefreshToken(refreshToken.getTokenValue());
		userToken.setTokenType(pAuthProperties.getTokenType());
		userToken.setRefreshExpireIn(pAuthProperties.getRefreshTokenTimeToLive());
		userToken.setExpireIn(pAuthProperties.getAccessTokenTimeToLive());
		// 缓存令牌, 提前1分钟失效，以免击穿或穿透
		Duration expire = Duration.ofSeconds(userToken.getExpireIn() - 60);
		RedissonUtil.INSTANCE()
			.set(GlobalConstant.LOGIN_USER_TOKEN_PREFIX + userToken.getAccessToken(), userToken.getAccessToken(),
					expire);
		RedissonUtil.INSTANCE()
			.set(GlobalConstant.LOGIN_USER_TOKEN_PREFIX + userToken.getRefreshToken(), userToken.getRefreshToken(),
					Duration.ofSeconds(userToken.getRefreshExpireIn() - 60));
		RedissonUtil.INSTANCE().set(GlobalConstant.LOGIN_USER_PREFIX + loginUser.getUserName(), loginUser, expire);
		RedissonUtil.INSTANCE()
			.set(GlobalConstant.LOGIN_USER_ONLINE_PREFIX + userToken.getAccessToken(),
					String.join(StringPools.COLON, loginUser.getUserId(), loginUser.getUserName()), expire);
		return userToken;
	}

}
