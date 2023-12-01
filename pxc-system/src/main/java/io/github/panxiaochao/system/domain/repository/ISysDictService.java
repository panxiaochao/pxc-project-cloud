package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysDict;

/**
 * <p>
 * 数据字典表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysDictService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 数据字典表 实体
	 */
	SysDict getById(String id);

	/**
	 * 保存
	 * @param sysDict 角色表 实体
	 * @return 数据字典表 实体
	 */
	SysDict save(SysDict sysDict);

	/**
	 * 根据主键更新
	 * @param sysDict 数据字典表 实体
	 */
	void update(SysDict sysDict);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);
}
