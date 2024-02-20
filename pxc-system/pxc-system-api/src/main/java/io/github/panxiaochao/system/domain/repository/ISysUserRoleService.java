package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 * 用户角色表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysUserRoleService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 用户角色表 实体
	 */
	SysUserRole getById(String id);

	/**
	 * 保存
	 * @param sysUserRole 角色表 实体
	 * @return 用户角色表 实体
	 */
	SysUserRole save(SysUserRole sysUserRole);

	/**
	 * 根据主键更新
	 * @param sysUserRole 用户角色表 实体
	 */
	void update(SysUserRole sysUserRole);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

	/**
	 * 批量保存
	 * @param list SysUserRole 数据实体
	 */
	void saveBatch(List<SysUserRole> list);

	/**
	 * 先删除当前用户的所有关联数据
	 * @param userId 用户Id
	 */
	void deleteByUserId(String userId);

}
