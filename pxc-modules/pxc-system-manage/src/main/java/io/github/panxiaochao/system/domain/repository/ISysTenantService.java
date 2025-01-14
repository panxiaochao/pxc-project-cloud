package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysTenant;

/**
 * <p>
 * 租户表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
public interface ISysTenantService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 租户表 实体
	 */
	SysTenant getById(String id);

	/**
	 * 保存
	 * @param sysTenant 角色表 实体
	 * @return 租户表 实体
	 */
	SysTenant save(SysTenant sysTenant);

	/**
	 * 根据主键更新
	 * @param sysTenant 租户表 实体
	 */
	void update(SysTenant sysTenant);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
