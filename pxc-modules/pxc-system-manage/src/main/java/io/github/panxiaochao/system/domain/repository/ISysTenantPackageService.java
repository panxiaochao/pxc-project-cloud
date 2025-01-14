package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysTenantPackage;

/**
 * <p>
 * 租户套餐表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
public interface ISysTenantPackageService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 租户套餐表 实体
	 */
	SysTenantPackage getById(String id);

	/**
	 * 保存
	 * @param sysTenantPackage 角色表 实体
	 * @return 租户套餐表 实体
	 */
	SysTenantPackage save(SysTenantPackage sysTenantPackage);

	/**
	 * 根据主键更新
	 * @param sysTenantPackage 租户套餐表 实体
	 */
	void update(SysTenantPackage sysTenantPackage);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
