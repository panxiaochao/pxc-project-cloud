package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuQueryResponse;

import java.util.List;

/**
 * <p>
 * 菜单配置 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysMenuReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 菜单配置查询请求对象
	 * @return 分页结果数组
	 */
	List<SysMenuQueryResponse> page(Pagination pagination, SysMenuQueryRequest queryRequest);

	/**
	 * 查询列表
	 * @param queryRequest 菜单配置查询请求对象
	 * @return 结果数组
	 */
	List<SysMenuQueryResponse> list(SysMenuQueryRequest queryRequest);

}
