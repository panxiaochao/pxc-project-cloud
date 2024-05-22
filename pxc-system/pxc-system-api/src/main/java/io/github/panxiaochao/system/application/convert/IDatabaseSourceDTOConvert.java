package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.databasesource.DatabaseSourceCreateRequest;
import io.github.panxiaochao.system.application.api.request.databasesource.DatabaseSourceQueryRequest;
import io.github.panxiaochao.system.application.api.request.databasesource.DatabaseSourceUpdateRequest;
import io.github.panxiaochao.system.application.api.response.databasesource.DatabaseSourceQueryResponse;
import io.github.panxiaochao.system.application.api.response.databasesource.DatabaseSourceResponse;
import io.github.panxiaochao.system.domain.entity.DatabaseSource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据库-数据源管理数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Mapper
public interface IDatabaseSourceDTOConvert {

	/**
	 * 数据库-数据源管理数据传输对象结构映射实例
	 */
	IDatabaseSourceDTOConvert INSTANCE = Mappers.getMapper(IDatabaseSourceDTOConvert.class);

	/**
	 * 数据库-数据源管理创建请求数据传输对象 转 数据库-数据源管理实体
	 * @param createRequest 数据库-数据源管理创建请求数据传输对象
	 * @return 数据库-数据源管理实体
	 */
	DatabaseSource fromCreateRequest(DatabaseSourceCreateRequest createRequest);

	/**
	 * 数据库-数据源管理更新请求数据传输对象 转 数据库-数据源管理实体
	 * @param updateRequest 数据库-数据源管理更新请求数据传输对象
	 * @return 数据库-数据源管理实体
	 */
	DatabaseSource fromUpdateRequest(DatabaseSourceUpdateRequest updateRequest);

	/**
	 * 数据库-数据源管理查询请求数据传输对象 转 数据库-数据源管理实体
	 * @param queryRequest 数据库-数据源管理查询请求数据传输对象
	 * @return 数据库-数据源管理实体
	 */
	DatabaseSource fromQueryRequest(DatabaseSourceQueryRequest queryRequest);

	/**
	 * 数据库-数据源管理实体 转 数据库-数据源管理响应数据传输对象
	 * @param databaseSource 数据库-数据源管理实体
	 * @return 数据库-数据源管理响应数据传输对象
	 */
	DatabaseSourceResponse toResponse(DatabaseSource databaseSource);

	/**
	 * 数据库-数据源管理实体 转 数据库-数据源管理查询响应数据传输对象
	 * @param databaseSource 数据库-数据源管理实体
	 * @return 数据库-数据源管理查询响应数据传输对象
	 */
	DatabaseSourceQueryResponse toQueryResponse(DatabaseSource databaseSource);

	/**
	 * 数据库-数据源管理实体列表 转 数据库-数据源管理查询响应数据传输对象列表
	 * @param databaseSourceList 数据库-数据源管理实体列表
	 * @return 数据库-数据源管理查询响应数据传输对象列表
	 */
	List<DatabaseSourceQueryResponse> toQueryResponse(List<DatabaseSource> databaseSourceList);

}
