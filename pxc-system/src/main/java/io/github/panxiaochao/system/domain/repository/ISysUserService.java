package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysUser;

/**
 * <p>
 * 用户表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysUserService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 用户表 实体
	 */
	SysUser getById(String id);

	/**
	 * 保存
	 * @param sysUser 角色表 实体
	 * @return 用户表 实体
	 */
	SysUser save(SysUser sysUser);

	/**
	 * 根据主键更新
	 * @param sysUser 用户表 实体
	 */
	void update(SysUser sysUser);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
