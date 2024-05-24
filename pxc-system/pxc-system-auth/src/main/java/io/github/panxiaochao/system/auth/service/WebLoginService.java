package io.github.panxiaochao.system.auth.service;

import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.CollectionUtil;
import io.github.panxiaochao.core.utils.IpUtil;
import io.github.panxiaochao.core.utils.ObjectUtil;
import io.github.panxiaochao.core.utils.SpringContextUtil;
import io.github.panxiaochao.core.utils.date.LocalDateTimeUtil;
import io.github.panxiaochao.operate.log.core.annotation.OperateLog;
import io.github.panxiaochao.operate.log.core.domain.OperateLogDomain;
import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.auth.api.response.TokenOnlineQueryResponse;
import io.github.panxiaochao.system.auth.config.properties.PAuthProperties;
import io.github.panxiaochao.system.auth.convert.ITokenOnlineDTOConvert;
import io.github.panxiaochao.system.auth.request.LoginRequest;
import io.github.panxiaochao.system.common.constants.GlobalConstant;
import io.github.panxiaochao.system.common.constants.LoginIdentityType;
import io.github.panxiaochao.system.common.core.context.PTokenContext;
import io.github.panxiaochao.system.common.core.generator.PTokenGenerator;
import io.github.panxiaochao.system.common.core.token.PRefreshToken;
import io.github.panxiaochao.system.common.core.token.PToken;
import io.github.panxiaochao.system.common.core.tokentype.PTokenType;
import io.github.panxiaochao.system.common.exception.UserLoginException;
import io.github.panxiaochao.system.common.model.LoginUser;
import io.github.panxiaochao.system.common.model.PAuthUserToken;
import io.github.panxiaochao.system.common.utils.LoginContextHelper;
import io.github.panxiaochao.system.domain.entity.SysUserLogin;
import io.github.panxiaochao.system.domain.service.SysPermissionDomainService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
		// 异步更新用户数据，比如登录时间
		SpringContextUtil.publishEvent(loginUser);
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
		long loginFailNums = ObjectUtil.getIfNull(RedissonUtil.get(loginFailLimitKey), 0L);
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
			RedissonUtil.set(loginFailLimitKey, loginFailNums);
			if (loginFailNums > 4) {
				// 锁定10分钟
				RedissonUtil.expireIfNotSet(loginFailLimitKey, Duration.ofMinutes(10));
			}
			throw new ServerRuntimeException(UserLoginException.USER_PASSWORD_ILLEGAL_EXCEPTION);
		}
		else {
			RedissonUtil.delete(loginFailLimitKey);
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
		loginUser.setLoginTime(LocalDateTime.now());
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
		PTokenContext accessTokenContext = pTokenContextBuilder.pTokenType(pAuthProperties.getTokenStyle().getType())
			.build();
		PToken token = pTokenGenerator.generate(accessTokenContext);
		// 刷新令牌
		PTokenContext refreshTokenContext = pTokenContextBuilder.pTokenType(PTokenType.REFRESH_TOKEN).build();
		PRefreshToken refreshToken = (PRefreshToken) pTokenGenerator.generate(refreshTokenContext);
		// 组建令牌
		loginUser.setAccessToken(token.getTokenValue());
		loginUser.setExpiresAt(Date.from(token.getExpiresAt()).getTime());
		loginUser.setIssuedAt(Date.from(token.getIssuedAt()).getTime());
		loginUser.setRefreshToken(refreshToken.getTokenValue());
		loginUser.setTokenType(pAuthProperties.getTokenType());
		loginUser.setRefreshExpireIn(pAuthProperties.getRefreshTokenTimeToLive());
		loginUser.setExpireIn(pAuthProperties.getAccessTokenTimeToLive());

		// 缓存令牌
		Duration expire = Duration.ofSeconds(loginUser.getExpireIn());
		// Auth-user:login:token:[authUserToken]
		RedissonUtil.set(GlobalConstant.LOGIN_TOKEN_PREFIX + loginUser.getAccessToken(), loginUser, expire);
		return loginUser.toAuthUserToken();
	}

	/**
	 * 移除令牌
	 * @param token 令牌
	 * @return true or false
	 */
	public Boolean removeToken(String token) {
		LoginUser loginUser = RedissonUtil.getAndDelete(GlobalConstant.LOGIN_TOKEN_PREFIX + token);
		LoginContextHelper.clear();
		// 用户数据不为空
		if (null != loginUser) {
			recordLogOutLog(loginUser);
		}
		return true;
	}

	/**
	 * 记录登出日志
	 * @param loginUser 用户信息
	 */
	private void recordLogOutLog(LoginUser loginUser) {
		OperateLogDomain operateLogDomain = OperateLogDomain.build(null, WebLoginService.class, "removeToken");
		operateLogDomain.setTitle("登录管理");
		operateLogDomain.setDescription("移除令牌");
		operateLogDomain.setBusinessType(OperateLog.BusinessType.LOGOUT.ordinal());
		operateLogDomain.setOperateUsertype(OperateLog.OperatorUserType.WEB.ordinal());
		operateLogDomain.setValue(loginUser.getUserName());
		SpringContextUtil.publishEvent(operateLogDomain);
	}

	/**
	 * 在线用户分页令牌管理
	 */
	public PageResponse<TokenOnlineQueryResponse> tokenPage(RequestPage pageRequest, String username) {
		// TODO 在线用户分页需要有优化，目前不能进行排序和查询
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<TokenOnlineQueryResponse> list = new ArrayList<>();
		String key = String.format("%s*", GlobalConstant.LOGIN_TOKEN_PREFIX);
		// 分页
		long start = (pageRequest.getPageNo() - 1) * pageRequest.getPageSize();
		Set<String> keySet = RedissonUtil.getKeysByPattern(key, GlobalConstant.KEY_COUNT);
		if (!keySet.isEmpty()) {
			String[] keys = keySet.stream().skip(start).limit(pageRequest.getPageSize()).toArray(String[]::new);
			Map<String, LoginUser> tokenMap = RedissonUtil.get(keys);
			list = ITokenOnlineDTOConvert.INSTANCE.toQueryResponse(CollectionUtil.toList(tokenMap.values()));
			list.forEach(s -> s.setExpireAtStr(LocalDateTimeUtil.longToLocalDateTime(s.getExpiresAt())));
		}
		return new PageResponse<>(pagination, list);
	}

}
