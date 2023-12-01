package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysMenu;

/**
 * <p>
 * 菜单配置 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysMenuService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 菜单配置 实体
	 */
	SysMenu getById(String id);

	/**
	 * 保存
	 * @param sysMenu 角色表 实体
	 * @return 菜单配置 实体
	 */
	SysMenu save(SysMenu sysMenu);

	/**
	 * 根据主键更新
	 * @param sysMenu 菜单配置 实体
	 */
	void update(SysMenu sysMenu);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);
}
