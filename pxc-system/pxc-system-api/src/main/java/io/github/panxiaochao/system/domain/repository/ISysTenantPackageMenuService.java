package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysTenantPackageMenu;

/**
 * <p>
 * 租户套餐菜单表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
public interface ISysTenantPackageMenuService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 租户套餐菜单表 实体
	 */
	SysTenantPackageMenu getById(String id);

	/**
	 * 保存
	 * @param sysTenantPackageMenu 角色表 实体
	 * @return 租户套餐菜单表 实体
	 */
	SysTenantPackageMenu save(SysTenantPackageMenu sysTenantPackageMenu);

	/**
	 * 根据主键更新
	 * @param sysTenantPackageMenu 租户套餐菜单表 实体
	 */
	void update(SysTenantPackageMenu sysTenantPackageMenu);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
