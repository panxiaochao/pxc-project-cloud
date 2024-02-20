package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.databasefieldtype.DatabaseFieldTypeQueryRequest;
import io.github.panxiaochao.system.application.api.response.databasefieldtype.DatabaseFieldTypeQueryResponse;

import java.util.List;

/**
 * <p>
 * 数据库字段类型码表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
public interface IDatabaseFieldTypeReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 数据库字段类型码表查询请求对象
	 * @return 分页结果数组
	 */
	List<DatabaseFieldTypeQueryResponse> page(Pagination pagination, DatabaseFieldTypeQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 数据库字段类型码表查询请求对象
	 * @return 结果数组
	 */
	List<DatabaseFieldTypeQueryResponse> selectList(DatabaseFieldTypeQueryRequest queryRequest);

}
