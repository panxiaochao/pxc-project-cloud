package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 角色菜单表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Getter
@Setter
@ToString
public class SysRoleMenu {

	/**
	 * 角色ID
	 */
	private String roleId;

	/**
	 * 菜单ID
	 */
	private String menuId;

	public SysRoleMenu(String roleId, String menuId) {
		this.roleId = roleId;
		this.menuId = menuId;
	}

}
