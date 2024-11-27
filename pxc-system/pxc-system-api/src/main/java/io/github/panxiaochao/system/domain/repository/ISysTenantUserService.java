package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysTenantUser;

import java.util.List;

/**
 * <p>
 * 租户用户表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
public interface ISysTenantUserService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 租户用户表 实体
	 */
	SysTenantUser getById(String id);

	/**
	 * 保存
	 * @param sysTenantUser 角色表 实体
	 * @return 租户用户表 实体
	 */
	SysTenantUser save(SysTenantUser sysTenantUser);

	/**
	 * 根据主键更新
	 * @param sysTenantUser 租户用户表 实体
	 */
	void update(SysTenantUser sysTenantUser);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

	/**
	 * 批量保存
	 * @param list 批量数据
	 */
	void saveBath(List<SysTenantUser> list);

	/**
	 * 根据租户ID和用户ID删除
	 * @param sysTenantUser 实体
	 */
    void deleteTenantUser(SysTenantUser sysTenantUser);
}
