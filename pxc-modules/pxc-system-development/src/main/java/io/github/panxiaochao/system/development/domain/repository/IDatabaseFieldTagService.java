package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldTag;

import java.util.List;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
public interface IDatabaseFieldTagService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 数据库字段类型-数据库标签表 实体
	 */
	DatabaseFieldTag getById(String id);

	/**
	 * 保存
	 * @param databaseFieldTag 角色表 实体
	 * @return 数据库字段类型-数据库标签表 实体
	 */
	DatabaseFieldTag save(DatabaseFieldTag databaseFieldTag);

	/**
	 * 批量保存
	 * @param list 批量数据
	 */
	List<DatabaseFieldTag> saveBatch(List<DatabaseFieldTag> list);

	/**
	 * 根据主键更新
	 * @param databaseFieldTag 数据库字段类型-数据库标签表 实体
	 */
	void update(DatabaseFieldTag databaseFieldTag);

	/**
	 * 根据主键 批量更新
	 * @param list 批量数据
	 */
	void updateBatch(List<DatabaseFieldTag> list);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

	/**
	 * 根据主键 批量删除
	 * @param list 批量数据
	 */
	void deleteBatch(List<DatabaseFieldTag> list);

	/**
	 * 根据数据库字段类型ID删除
	 * @param fieldTypeId 数据库字段类型ID
	 */
	void deleteByFieldTypeId(String fieldTypeId);

}
