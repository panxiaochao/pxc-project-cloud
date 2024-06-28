package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageQueryRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageQueryResponse;

import java.util.List;

/**
 * <p>
 * 租户套餐表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
public interface ISysTenantPackageReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 租户套餐表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysTenantPackageQueryResponse> page(Pagination pagination, SysTenantPackageQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 租户套餐表查询请求对象
	 * @return 结果数组
	 */
	List<SysTenantPackageQueryResponse> selectList(SysTenantPackageQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 租户套餐表查询请求对象
	 * @return 租户套餐表查询响应对象
	 */
	SysTenantPackageQueryResponse getOne(SysTenantPackageQueryRequest queryRequest);

}
