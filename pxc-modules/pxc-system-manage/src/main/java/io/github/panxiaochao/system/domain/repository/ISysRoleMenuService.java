package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
public interface ISysRoleMenuService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 角色菜单表 实体
	 */
	SysRoleMenu getById(String id);

	/**
	 * 保存
	 * @param sysRoleMenu 角色表 实体
	 * @return 角色菜单表 实体
	 */
	SysRoleMenu save(SysRoleMenu sysRoleMenu);

	/**
	 * 根据主键更新
	 * @param sysRoleMenu 角色菜单表 实体
	 */
	void update(SysRoleMenu sysRoleMenu);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

	/**
	 * 删除当前角色的所有关联数据
	 * @param roleId 角色Id
	 */
	void deleteByRoleId(String roleId);

	/**
	 * 批量保存
	 * @param list SysRoleMenu 数据实体
	 */
	void saveBath(List<SysRoleMenu> list);

}
