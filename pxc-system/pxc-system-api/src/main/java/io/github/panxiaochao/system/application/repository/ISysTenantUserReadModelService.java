package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserQueryRequest;
import io.github.panxiaochao.system.application.api.response.systenantuser.SysTenantUserQueryResponse;

import java.util.List;

/**
 * <p>
 * 租户用户表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
public interface ISysTenantUserReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 租户用户表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysTenantUserQueryResponse> page(Pagination pagination, SysTenantUserQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 租户用户表查询请求对象
	 * @return 结果数组
	 */
	List<SysTenantUserQueryResponse> selectList(SysTenantUserQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 租户用户表查询请求对象
	 * @return 租户用户表查询响应对象
	 */
	SysTenantUserQueryResponse getOne(SysTenantUserQueryRequest queryRequest);

}
