package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysUserOrg;

/**
 * <p>
 * 用户机构/部门表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysUserOrgService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 用户机构/部门表 实体
	 */
	SysUserOrg getById(String id);

	/**
	 * 保存
	 * @param sysUserOrg 角色表 实体
	 * @return 用户机构/部门表 实体
	 */
	SysUserOrg save(SysUserOrg sysUserOrg);

	/**
	 * 根据主键更新
	 * @param sysUserOrg 用户机构/部门表 实体
	 */
	void update(SysUserOrg sysUserOrg);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);
}
