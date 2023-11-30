package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysUserAuths;

/**
 * <p>
 * 用户授权信息表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysUserAuthsService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 用户授权信息表 实体
	 */
	SysUserAuths getById(String id);

	/**
	 * 保存
	 * @param sysUserAuths 角色表 实体
	 * @return 用户授权信息表 实体
	 */
	SysUserAuths save(SysUserAuths sysUserAuths);

	/**
	 * 根据主键更新
	 * @param sysUserAuths 用户授权信息表 实体
	 */
	void update(SysUserAuths sysUserAuths);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
