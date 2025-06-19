package io.github.panxiaochao.system.development.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupQueryResponse;

import java.util.List;

/**
 * <p>
 * 模板分组 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
public interface IGenGroupReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 模板分组查询请求对象
	 * @return 分页结果数组
	 */
	List<GenGroupQueryResponse> page(Pagination pagination, GenGroupQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 模板分组查询请求对象
	 * @return 结果数组
	 */
	List<GenGroupQueryResponse> selectList(GenGroupQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 模板分组查询请求对象
	 * @return 模板分组查询响应对象
	 */
	GenGroupQueryResponse getOne(GenGroupQueryRequest queryRequest);

}
