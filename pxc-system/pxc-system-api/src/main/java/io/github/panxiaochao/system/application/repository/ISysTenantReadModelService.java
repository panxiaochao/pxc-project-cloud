package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantQueryRequest;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantQueryResponse;

import java.util.List;

/**
 * <p>
 * 租户表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
public interface ISysTenantReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 租户表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysTenantQueryResponse> page(Pagination pagination, SysTenantQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 租户表查询请求对象
	 * @return 结果数组
	 */
	List<SysTenantQueryResponse> selectList(SysTenantQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 租户表查询请求对象
	 * @return 租户表查询响应对象
	 */
	SysTenantQueryResponse getOne(SysTenantQueryRequest queryRequest);

}
