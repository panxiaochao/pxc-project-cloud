package io.github.panxiaochao.system.satoken.core.service;

import cn.dev33.satoken.stp.StpInterface;
import io.github.panxiaochao.system.satoken.model.LoginUser;
import io.github.panxiaochao.system.satoken.utils.LoginHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * sa-token 权限管理实现类
 *
 * @author Lypxc
 * @since 2025-01-17
 * @version 1.0
 */
public class SaPermissionImpl implements StpInterface {

	/**
	 * 获取菜单权限列表
	 */
	@Override
	public List<String> getPermissionList(Object loginId, String loginType) {
		LoginUser loginUser = LoginHelper.getLoginUser();
		return new ArrayList<>(loginUser.getPermissions());
	}

	/**
	 * 获取角色权限列表
	 */
	@Override
	public List<String> getRoleList(Object loginId, String loginType) {
		LoginUser loginUser = LoginHelper.getLoginUser();
		return new ArrayList<>(loginUser.getRoles());
	}

}
