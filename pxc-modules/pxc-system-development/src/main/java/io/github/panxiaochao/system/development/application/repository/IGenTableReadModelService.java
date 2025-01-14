package io.github.panxiaochao.system.development.application.repository;

import io.github.panxiaochao.system.development.application.api.request.gentable.GenTableQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gentable.GenTableQueryResponse;
import io.github.panxiaochao.core.response.page.Pagination;

import java.util.List;

/**
 * <p>
 * 代码生成表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
public interface IGenTableReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 分页结果数组
	 */
	List<GenTableQueryResponse> page(Pagination pagination, GenTableQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 结果数组
	 */
	List<GenTableQueryResponse> selectList(GenTableQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 代码生成表查询响应对象
	 */
	GenTableQueryResponse getOne(GenTableQueryRequest queryRequest);

}
