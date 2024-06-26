package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysUser;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
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

	/**
	 * 记录用户登录信息
	 * @param userId 用户ID
	 * @param loginTime 登录信息
	 */
	void updateUserLogin(String userId, LocalDateTime loginTime);

}
