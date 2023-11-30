package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysOrg;

/**
 * <p>
 * 机构部门表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysOrgService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 机构部门表 实体
	 */
	SysOrg getById(String id);

	/**
	 * 保存
	 * @param sysOrg 角色表 实体
	 * @return 机构部门表 实体
	 */
	SysOrg save(SysOrg sysOrg);

	/**
	 * 根据主键更新
	 * @param sysOrg 机构部门表 实体
	 */
	void update(SysOrg sysOrg);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
