package io.github.panxiaochao.system.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 登录用户 - 综合用户信息、角色、权限等
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-20
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginUser implements Serializable {

	private static final long serialVersionUID = 5755227248230027443L;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 登录账号
	 */
	private String account;

	/**
	 * 真是姓名
	 */
	private String realName;

	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 用户头像
	 */
	private String avatar;

	/**
	 * 性别：1男，0女
	 */
	private String sex;

	/**
	 * 机构ID
	 */
	private String orgId;

	/**
	 * 所在区域或者部门编码code，多数据请用逗号隔开
	 */
	private String orgCode;

	/**
	 * 登录IP地址
	 */
	private String ip;

	/**
	 * 登录IP地点
	 */
	private String ipAddr;

	/**
	 * 浏览器类型
	 */
	private String browser;

	/**
	 * 操作系统
	 */
	private String os;

	/**
	 * 角色权限
	 */
	private Set<String> rolePermission;

	/**
	 * 菜单权限
	 */
	private Set<String> menuPermission;

	/**
	 * 是否是超级账号 - "root"
	 */
	public boolean isSuperUser() {
		return false;
	}

	/**
	 * 是否是超级管理员 - "superAdmin"
	 */
	public boolean isSuperAdmin() {
		return false;
	}

}
