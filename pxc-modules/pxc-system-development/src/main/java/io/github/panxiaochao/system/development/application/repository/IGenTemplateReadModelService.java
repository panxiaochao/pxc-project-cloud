package io.github.panxiaochao.system.development.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateQueryResponse;

import java.util.List;

/**
 * <p>
 * 模板 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
public interface IGenTemplateReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 模板查询请求对象
	 * @return 分页结果数组
	 */
	List<GenTemplateQueryResponse> page(Pagination pagination, GenTemplateQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 模板查询请求对象
	 * @return 结果数组
	 */
	List<GenTemplateQueryResponse> selectList(GenTemplateQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 模板查询请求对象
	 * @return 模板查询响应对象
	 */
	GenTemplateQueryResponse getOne(GenTemplateQueryRequest queryRequest);

}
