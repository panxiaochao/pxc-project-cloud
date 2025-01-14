package io.github.panxiaochao.system.development.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.databasesource.DatabaseSourceQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.databasesource.DatabaseSourceQueryResponse;

import java.util.List;

/**
 * <p>
 * 数据库-数据源管理 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
public interface IDatabaseSourceReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 数据库-数据源管理查询请求对象
	 * @return 分页结果数组
	 */
	List<DatabaseSourceQueryResponse> page(Pagination pagination, DatabaseSourceQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 数据库-数据源管理查询请求对象
	 * @return 结果数组
	 */
	List<DatabaseSourceQueryResponse> selectList(DatabaseSourceQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 数据库-数据源管理查询请求对象
	 * @return 数据库-数据源管理查询响应对象
	 */
	DatabaseSourceQueryResponse getOne(DatabaseSourceQueryRequest queryRequest);

}
