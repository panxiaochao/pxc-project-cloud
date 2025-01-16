package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.GenTableColumn;

import java.util.List;

/**
 * <p>
 * 代码生成表字段 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
public interface IGenTableColumnService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 代码生成表字段 实体
	 */
	GenTableColumn getById(String id);

	/**
	 * 保存
	 * @param genTableColumn 角色表 实体
	 * @return 代码生成表字段 实体
	 */
	GenTableColumn save(GenTableColumn genTableColumn);

	/**
	 * 批量保存
	 * @param list GenTableColumn 数据实体
	 */
	void saveBatch(List<GenTableColumn> list);

	/**
	 * 根据主键更新
	 * @param genTableColumn 代码生成表字段 实体
	 */
	void update(GenTableColumn genTableColumn);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

	/**
	 * 根据表ID删除
	 * @param tableId 表主键
	 */
	void deleteByTableId(String tableId);

}
