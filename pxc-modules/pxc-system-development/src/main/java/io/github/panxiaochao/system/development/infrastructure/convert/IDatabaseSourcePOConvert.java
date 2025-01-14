package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.databasesource.DatabaseSourceQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.DatabaseSource;
import io.github.panxiaochao.system.development.infrastructure.po.DatabaseSourcePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 数据库-数据源管理持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Mapper
public interface IDatabaseSourcePOConvert {

	/**
	 * 数据库-数据源管理持久化对象结构映射实例
	 */
	IDatabaseSourcePOConvert INSTANCE = Mappers.getMapper(IDatabaseSourcePOConvert.class);

	/**
	 * 数据库-数据源管理实体 转 数据库-数据源管理持久化对象
	 * @param databaseSource 数据库-数据源管理实体
	 * @return 数据库-数据源管理持久化对象
	 */
	DatabaseSourcePO fromEntity(DatabaseSource databaseSource);

	/**
	 * 数据库-数据源管理实体 转 数据库-数据源管理持久化对象
	 * @param databaseSourceList 数据库-数据源管理实体
	 * @return 数据库-数据源管理持久化对象
	 */
	List<DatabaseSourcePO> fromEntity(List<DatabaseSource> databaseSourceList);

	/**
	 * 数据库-数据源管理持久化对象 转 数据库-数据源管理实体
	 * @param databaseSourcePO 数据库-数据源管理持久化对象
	 * @return 数据库-数据源管理实体
	 */
	DatabaseSource toEntity(DatabaseSourcePO databaseSourcePO);

	/**
	 * 数据库-数据源管理持久化对象 转 数据库-数据源管理实体
	 * @param databaseSourcePOList 数据库-数据源管理持久化对象
	 * @return 数据库-数据源管理实体
	 */
	List<DatabaseSource> toEntity(List<DatabaseSourcePO> databaseSourcePOList);

	/**
	 * 数据库-数据源管理持久化对象 转 数据库-数据源管理查询响应数据传输对象
	 * @param databaseSourcePO 数据库-数据源管理持久化对象
	 * @return 数据库-数据源管理查询响应数据传输对象
	 */
	DatabaseSourceQueryResponse toQueryResponse(DatabaseSourcePO databaseSourcePO);

	/**
	 * 数据库-数据源管理持久化对象列表 转 数据库-数据源管理查询响应数据传输对象列表
	 * @param databaseSourcePOList 数据库-数据源管理持久化对象列表
	 * @return 数据库-数据源管理查询响应数据传输对象列表
	 */
	List<DatabaseSourceQueryResponse> toQueryResponse(List<DatabaseSourcePO> databaseSourcePOList);

}
