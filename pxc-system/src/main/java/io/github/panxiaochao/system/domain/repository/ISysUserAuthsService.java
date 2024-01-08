package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysUserAuths;

import java.util.List;

/**
 * <p>
 * 用户授权信息表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
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

	/**
	 * 根据用户ID和登录类型查询列表
	 * @param userId 用户主键
	 * @param identityType 登录类型
	 * @return SysUserAuths 实体列表
	 */
	List<SysUserAuths> listIdentityType(String userId, String identityType);

	/**
	 * 根据用户ID删除用户授权信息表所有信息
	 * @param userId 用户主键
	 */
	void deleteByUserId(String userId);

}
