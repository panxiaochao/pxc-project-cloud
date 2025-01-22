package io.github.panxiaochao.system.satoken.utils;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import io.github.panxiaochao.core.utils.ObjectUtil;
import io.github.panxiaochao.system.satoken.model.LoginUser;

/**
 * 登录鉴权助手
 * <p>
 * user_type 为 用户类型 同一个用户表 可以有多种用户类型 例如 pc,app deivce 为 设备类型 同一个用户类型 可以有 多种设备类型 例如 web,ios
 * 可以组成 用户类型与设备类型多对多的 权限灵活控制
 * <p>
 * 多用户体系 针对 多种用户类型 但权限控制不一致 可以组成 多用户类型表与多设备类型 分别控制权限
 *
 * @author Lypxc
 * @since 2025-01-17
 * @version 1.0
 */
public class LoginHelper {

	public static final String LOGIN_USER_KEY = "LoginUser";

	public static final String TENANT_KEY = "tenantId";

	public static final String USER_KEY = "userId";

	public static final String USER_NAME_KEY = "userName";

	public static final String ORG_KEY = "orgId";

	public static final String ORG_CODE_KEY = "orgCode";

	/**
	 * 登录系统 基于 设备类型 针对相同用户体系不同设备
	 * @param loginUser 登录用户信息
	 * @param model 配置参数
	 */
	public static void login(LoginUser loginUser, SaLoginModel model) {
		model = ObjectUtil.getIfNull(model, new SaLoginModel());
		StpUtil.login(loginUser.getUserId(),
				model.setExtra(USER_KEY, loginUser.getUserId())
					.setExtra(USER_NAME_KEY, loginUser.getUserName())
					.setExtra(ORG_KEY, loginUser.getOrgId())
					.setExtra(ORG_CODE_KEY, loginUser.getOrgCode()));
		StpUtil.getTokenSession().set(LOGIN_USER_KEY, loginUser);
	}

	/**
	 * 获取用户(多级缓存)
	 */
	public static LoginUser getLoginUser() {
		SaSession session = StpUtil.getTokenSession();
		if (ObjectUtil.isEmpty(session)) {
			return null;
		}
		return (LoginUser) session.get(LOGIN_USER_KEY);
	}

	/**
	 * 获取用户基于token
	 */
	public static LoginUser getLoginUser(String token) {
		SaSession session = StpUtil.getTokenSessionByToken(token);
		if (ObjectUtil.isEmpty(session)) {
			return null;
		}
		return (LoginUser) session.get(LOGIN_USER_KEY);
	}

	/**
	 * 获取用户id
	 */
	public static Long getUserId() {
		return Convert.toLong(getExtra(USER_KEY));
	}

	/**
	 * 获取用户账户
	 */
	public static String getUserName() {
		return Convert.toStr(getExtra(USER_NAME_KEY));
	}

	/**
	 * 获取租户ID
	 */
	public static String getTenantId() {
		return Convert.toStr(getExtra(TENANT_KEY));
	}

	/**
	 * 获取部门ID
	 */
	public static Long getOrgId() {
		return Convert.toLong(getExtra(ORG_KEY));
	}

	/**
	 * 获取部门Code
	 */
	public static String getOrgCode() {
		return Convert.toStr(getExtra(ORG_CODE_KEY));
	}

	/**
	 * 获取当前 Token 的扩展信息
	 * @param key 键值
	 * @return 对应的扩展数据
	 */
	private static Object getExtra(String key) {
		try {
			return StpUtil.getExtra(key);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 检查当前用户是否已登录
	 * @return 结果
	 */
	public static boolean isLogin() {
		try {
			return getLoginUser() != null;
		}
		catch (Exception e) {
			return false;
		}
	}

}
