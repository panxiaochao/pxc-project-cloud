package io.github.panxiaochao.system.common.utils;

import io.github.panxiaochao.core.utils.ObjectUtil;
import io.github.panxiaochao.system.common.core.context.SContextHolder;
import io.github.panxiaochao.system.common.model.LoginUser;

/**
 * <p>
 * 登录上下文助手
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-15
 * @version 1.0
 */
public class LoginContextHelper {

	/**
	 * 获取用户
	 */
	public static LoginUser getLoginUser() {
		LoginUser loginUser = SContextHolder.getContext().getLoginUser();
		if (ObjectUtil.isEmpty(loginUser)) {
			return null;
		}
		return loginUser;
	}

	/**
	 * 获取用户ID
	 */
	public static String getUserId() {
		LoginUser loginUser = getLoginUser();
		if (null == loginUser) {
			return "";
		}
		return loginUser.getUserId();
	}

	/**
	 * 获取用户账号
	 */
	public static String getUserName() {
		LoginUser loginUser = getLoginUser();
		if (null == loginUser) {
			return "";
		}
		return loginUser.getUserName();
	}

	/**
	 * 清除当前用户信息
	 */
	public static void clear() {
		SContextHolder.clearContext();
	}

}
