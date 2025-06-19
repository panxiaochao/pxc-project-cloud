package io.github.panxiaochao.system.development.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagQueryResponse;

import java.util.List;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
public interface IDatabaseFieldTagReadModelService {

	/**
	 * 查询 数据库字段类型-数据库标签表分页数据
	 * @param pagination 分页属性对象
	 * @param queryRequest 数据库字段类型-数据库标签表 查询请求对象
	 * @return 分页结果数组
	 */
	List<DatabaseFieldTagQueryResponse> page(Pagination pagination, DatabaseFieldTagQueryRequest queryRequest);

	/**
	 * 查询 数据库字段类型-数据库标签表对象数组
	 * @param queryRequest 数据库字段类型-数据库标签表 查询请求对象
	 * @return 结果数组
	 */
	List<DatabaseFieldTagQueryResponse> selectList(DatabaseFieldTagQueryRequest queryRequest);

	/**
	 * 查询 数据库字段类型-数据库标签表对象单条记录
	 * @param queryRequest 数据库字段类型-数据库标签表 查询请求对象
	 * @param throwEx boolean 参数，为true如果存在多个结果直接抛出异常
	 * @return 数据库字段类型-数据库标签表查询响应对象
	 */
	DatabaseFieldTagQueryResponse getOne(DatabaseFieldTagQueryRequest queryRequest, boolean throwEx);

}
