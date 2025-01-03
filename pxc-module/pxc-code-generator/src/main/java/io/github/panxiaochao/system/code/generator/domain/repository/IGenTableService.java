package io.github.panxiaochao.system.code.generator.domain.repository;

import io.github.panxiaochao.system.code.generator.domain.entity.GenTable;

/**
 * <p>
 * 代码生成表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
public interface IGenTableService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 代码生成表 实体
	 */
	GenTable getById(String id);

	/**
	 * 保存
	 * @param genTable 角色表 实体
	 * @return 代码生成表 实体
	 */
	GenTable save(GenTable genTable);

	/**
	 * 根据主键更新
	 * @param genTable 代码生成表 实体
	 */
	void update(GenTable genTable);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
