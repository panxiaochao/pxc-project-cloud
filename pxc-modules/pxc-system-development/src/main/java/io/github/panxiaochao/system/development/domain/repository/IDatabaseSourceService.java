package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.DatabaseSource;

/**
 * <p>
 * 数据库-数据源管理 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
public interface IDatabaseSourceService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 数据库-数据源管理 实体
	 */
	DatabaseSource getById(String id);

	/**
	 * 保存
	 * @param databaseSource 角色表 实体
	 * @return 数据库-数据源管理 实体
	 */
	DatabaseSource save(DatabaseSource databaseSource);

	/**
	 * 根据主键更新
	 * @param databaseSource 数据库-数据源管理 实体
	 */
	void update(DatabaseSource databaseSource);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
