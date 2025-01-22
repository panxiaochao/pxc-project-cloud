package io.github.panxiaochao.system.auth.service;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import io.github.panxiaochao.core.component.tree.Tree;
import io.github.panxiaochao.core.component.tree.TreeBuilder;
import io.github.panxiaochao.core.component.tree.TreeNode;
import io.github.panxiaochao.core.component.tree.TreeNodeProperties;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.BooleanUtil;
import io.github.panxiaochao.core.utils.IpUtil;
import io.github.panxiaochao.core.utils.ObjectUtil;
import io.github.panxiaochao.core.utils.SpringContextUtil;
import io.github.panxiaochao.operate.log.core.annotation.OperateLog;
import io.github.panxiaochao.operate.log.core.domain.OperateLogDomain;
import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.auth.api.request.LoginRequest;
import io.github.panxiaochao.system.auth.api.response.LoginUserResponse;
import io.github.panxiaochao.system.auth.api.response.TokenOnlineQueryResponse;
import io.github.panxiaochao.system.auth.api.response.UserTokenResponse;
import io.github.panxiaochao.system.auth.convert.ILoginUserDTOConvert;
import io.github.panxiaochao.system.common.constants.LoginIdentityType;
import io.github.panxiaochao.system.common.constants.RedisConstant;
import io.github.panxiaochao.system.common.exception.UserLoginException;
import io.github.panxiaochao.system.domain.entity.SysUserLogin;
import io.github.panxiaochao.system.domain.service.SysPermissionDomainService;
import io.github.panxiaochao.system.satoken.enums.DeviceType;
import io.github.panxiaochao.system.satoken.model.LoginUser;
import io.github.panxiaochao.system.satoken.utils.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

	public UserTokenResponse login(LoginRequest loginRequest) {
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
		// 登录设备, 并且检验
		loginUser.setLoginDevice(loginRequest.getLoginDevice());
		// 构建Token
		UserTokenResponse userToken = buildAuthToken(loginUser);
		// 异步更新用户数据，比如登录时间
		SpringContextUtil.publishEvent(loginUser);
		return userToken;
	}

	/**
	 * 登录校验
	 * @param sysUserLogin 登录用户
	 * @param loginRequest 登录请求对象
	 */
	private void checkLogin(SysUserLogin sysUserLogin, LoginRequest loginRequest) {
		// TODO 验证码
		// 登录设备, 并且检验
		DeviceType.ofDevice(loginRequest.getLoginDevice());
		// 账号已过期
		if (sysUserLogin.getUserExpireTime() != null
				&& sysUserLogin.getUserExpireTime().isBefore(LocalDateTime.now())) {
			throw new ServerRuntimeException(UserLoginException.USER_ACCOUNT_EXPIRE_EXCEPTION);
		}
		// 账号登录错误次数不超过5次
		String loginFailLimitKey = RedisConstant.LOGIN_FAIL_LIMIT_KEY + loginRequest.getUsername();
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
		if (CommonConstant.FAIL.toString().equals(sysUserLogin.getVerified())) {
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
		// identifier = userName
		loginUser.setUserName(sysUserLogin.getIdentifier());
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
		loginUser.setPermissions(sysPermissionDomainService.selectMenuPermissionCode(sysUserLogin.getUserId()));
		return loginUser;
	}

	/**
	 * 构建Token
	 * @param loginUser 构建过的用户
	 * @return 用户token
	 */
	private UserTokenResponse buildAuthToken(LoginUser loginUser) {
		SaLoginModel model = new SaLoginModel();
		model.setDevice(loginUser.getLoginDevice());
		// 生成token
		LoginHelper.login(loginUser, model);
		UserTokenResponse userTokenResponse = new UserTokenResponse();
		userTokenResponse.setAccessToken(StpUtil.getTokenValue());
		userTokenResponse.setExpireIn(StpUtil.getTokenTimeout());
		return userTokenResponse;
	}

	/**
	 * 移除令牌
	 * @param token 令牌
	 * @return true or false
	 */
	public Boolean removeToken(String token) {
		LoginUser loginUser = LoginHelper.getLoginUser(token);
		// 用户数据不为空, 记录退出日志
		if (null != loginUser) {
			recordLogOutLog(loginUser);
		}
		else {
			LOGGER.error("无效Token:{}", token);
		}
		// 登出
		StpUtil.logout(loginUser.getUserId(), loginUser.getLoginDevice());
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
		if (DeviceType.PC.equals(DeviceType.ofDevice(loginUser.getLoginDevice()))) {
			operateLogDomain.setOperateUsertype(OperateLog.OperatorUserType.WEB.ordinal());
		}
		else {
			operateLogDomain.setOperateUsertype(OperateLog.OperatorUserType.MOBILE.ordinal());
		}
		operateLogDomain.setValue(loginUser.getUserName());
		SpringContextUtil.publishEvent(operateLogDomain);
	}

	/**
	 * 在线用户分页令牌管理
	 */
	public PageResponse<TokenOnlineQueryResponse> tokenPage(RequestPage requestPage, String username) {
		// TODO 在线用户分页需要有优化，目前不能进行排序和查询
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<TokenOnlineQueryResponse> list = new ArrayList<>();
		// String key = String.format("%s*", RedisConstant.LOGIN_TOKEN_PREFIX);
		// // 分页
		// long start = (requestPage.getPageNo() - 1) * requestPage.getPageSize();
		// Set<String> keySet = RedissonUtil.getKeysByPattern(key,
		// GlobalConstant.KEY_COUNT);
		// if (!keySet.isEmpty()) {
		// String[] keys =
		// keySet.stream().skip(start).limit(requestPage.getPageSize()).toArray(String[]::new);
		// Map<String, LoginUser> tokenMap = RedissonUtil.get(keys);
		// list =
		// ITokenOnlineDTOConvert.INSTANCE.toQueryResponse(CollectionUtil.toList(tokenMap.values()));
		// list.forEach(s ->
		// s.setExpireAtStr(LocalDateTimeUtil.longToLocalDateTime(s.getExpiresAt())));
		// }
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 获取当前登录用户信息
	 * @return 当前登录用户对象
	 */
	public LoginUserResponse userinfo() {
		LoginUser loginUser = LoginHelper.getLoginUser();
		return ILoginUserDTOConvert.INSTANCE.toQueryResponse(loginUser);
	}

	/**
	 * 根据当前用户查询菜单列表（用户权限下的菜单）
	 * @return 菜单列表
	 */
	public List<Tree<String>> currentUserRouters() {
		LoginUser loginUser = LoginHelper.getLoginUser();
		List<SysMenuQueryResponse> list = sysPermissionDomainService.selectMenu(loginUser.getUserId());
		List<TreeNode<String>> treeNodeList = list.stream()
			.map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getMenuName(), s.getSort(), (extraMap) -> {
				extraMap.put("path", s.getUrl());
				extraMap.put("redirect", s.getRedirectUrl());
				extraMap.put("component", s.getComponent());
				extraMap.put("name", s.getComponentName());
				extraMap.put("icon", s.getIcon());
				extraMap.put("openType", BooleanUtil.toBoolean(s.getOpenType()));
				extraMap.put("keepAlive", BooleanUtil.toBoolean(s.getKeepAlive()));
				extraMap.put("hidden", BooleanUtil.toBoolean(s.getIsHidden()));
			}))
			.collect(Collectors.toList());
		// 修改节点属性
		TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
		treeNodeProperties.labelKey("title");
		treeNodeProperties.idKey("key");
		// 构建树
		List<Tree<String>> treeList = TreeBuilder.of(CommonConstant.TREE_ROOT_ID.toString(), false, treeNodeProperties)
			.append(treeNodeList)
			.fastBuild()
			.toTreeList();
		return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
	}

}
