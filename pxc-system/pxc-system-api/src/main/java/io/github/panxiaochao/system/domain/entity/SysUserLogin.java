package io.github.panxiaochao.system.domain.entity;

import io.github.panxiaochao.system.common.constants.GlobalConstant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
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
public class SysUserLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 用户账号
	 */
	private String userName;

	/**
	 * 真实姓名
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
	 * 帐号超时期限
	 */
	private LocalDateTime userExpireTime;

	/**
	 * 角色集合
	 */
	private Set<String> roles;

	/**
	 * 菜单按钮权限集合
	 */
	private Set<String> menuPermissionCode;

	/**
	 * 登录类型(手机号/邮箱/用户名/微信/微博/QQ）等
	 */
	private String identityType;

	/**
	 * 登录标识(手机号/邮箱/用户名/微信/微博/QQ）等唯一标识，等同于登录账号
	 */
	private String identifier;

	/**
	 * 密码凭证（自建密码，或者第三方access_token）
	 */
	private String credential;

	/**
	 * 是否已经验证：1验证，0未验证
	 */
	private String verified;

	/**
	 * 登录标识失效时间
	 */
	private LocalDateTime identifierExpireTime;

	/**
	 * 是否是超级账号 - "root"
	 */
	public boolean isSuperUser() {
		return GlobalConstant.SUPER_USER.equalsIgnoreCase(userName);
	}

	/**
	 * 是否是超级管理员 - "superAdmin"
	 */
	public boolean isSuperAdmin() {
		if (!CollectionUtils.isEmpty(roles)) {
			return roles.contains(GlobalConstant.SUPER_ROLE);
		}
		return false;
	}

}
