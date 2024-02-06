package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuQueryResponse;

import java.util.List;

/**
 * <p>
 * 角色菜单表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
public interface ISysRoleMenuReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 角色菜单表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysRoleMenuQueryResponse> page(Pagination pagination, SysRoleMenuQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 角色菜单表查询请求对象
	 * @return 结果数组
	 */
	List<SysRoleMenuQueryResponse> selectList(SysRoleMenuQueryRequest queryRequest);

}
