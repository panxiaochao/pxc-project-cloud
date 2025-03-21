package io.github.panxiaochao.system.development.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupQueryResponse;

import java.util.List;

/**
 * <p>
 * 模板分组关联表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
public interface IGenTemplateGroupReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 模板分组关联表查询请求对象
	 * @return 分页结果数组
	 */
	List<GenTemplateGroupQueryResponse> page(Pagination pagination, GenTemplateGroupQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 模板分组关联表查询请求对象
	 * @return 结果数组
	 */
	List<GenTemplateGroupQueryResponse> selectList(GenTemplateGroupQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 模板分组关联表查询请求对象
	 * @return 模板分组关联表查询响应对象
	 */
	GenTemplateGroupQueryResponse getOne(GenTemplateGroupQueryRequest queryRequest);

}
