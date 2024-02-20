package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户角色表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysUserRole {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 角色ID
	 */
	private String roleId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	public SysUserRole(String userId, String roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

}
