package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 租户套餐菜单表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Getter
@Setter
@ToString
public class SysTenantPackageMenu {

	/**
	 * 租户套餐id
	 */
	private String packageId;

	/**
	 * 菜单ID
	 */
	private String menuId;

	public SysTenantPackageMenu(String packageId, String menuId) {
		this.packageId = packageId;
		this.menuId = menuId;
	}

}
