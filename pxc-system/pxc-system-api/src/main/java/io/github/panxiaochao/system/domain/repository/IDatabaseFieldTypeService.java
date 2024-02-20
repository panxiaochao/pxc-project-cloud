package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.DatabaseFieldType;

/**
 * <p>
 * 数据库字段类型码表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
public interface IDatabaseFieldTypeService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 数据库字段类型码表 实体
	 */
	DatabaseFieldType getById(String id);

	/**
	 * 保存
	 * @param databaseFieldType 角色表 实体
	 * @return 数据库字段类型码表 实体
	 */
	DatabaseFieldType save(DatabaseFieldType databaseFieldType);

	/**
	 * 根据主键更新
	 * @param databaseFieldType 数据库字段类型码表 实体
	 */
	void update(DatabaseFieldType databaseFieldType);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
