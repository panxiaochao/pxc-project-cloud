package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysRole;

/**
 * <p>
 * 角色表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysRoleService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 角色表 实体
	 */
	SysRole getById(String id);

	/**
	 * 保存
	 * @param sysRole 角色表 实体
	 * @return 角色表 实体
	 */
	SysRole save(SysRole sysRole);

	/**
	 * 根据主键更新
	 * @param sysRole 角色表 实体
	 */
	void update(SysRole sysRole);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);
}
