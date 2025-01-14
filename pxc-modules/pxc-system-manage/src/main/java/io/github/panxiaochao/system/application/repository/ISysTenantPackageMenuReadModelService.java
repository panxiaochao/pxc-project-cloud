package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuQueryRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackagemenu.SysTenantPackageMenuQueryResponse;

import java.util.List;

/**
 * <p>
 * 租户套餐菜单表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
public interface ISysTenantPackageMenuReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 租户套餐菜单表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysTenantPackageMenuQueryResponse> page(Pagination pagination, SysTenantPackageMenuQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 租户套餐菜单表查询请求对象
	 * @return 结果数组
	 */
	List<SysTenantPackageMenuQueryResponse> selectList(SysTenantPackageMenuQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 租户套餐菜单表查询请求对象
	 * @return 租户套餐菜单表查询响应对象
	 */
	SysTenantPackageMenuQueryResponse getOne(SysTenantPackageMenuQueryRequest queryRequest);

}
