package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysuserorg.SysUserOrgQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysuserorg.SysUserOrgQueryResponse;

import java.util.List;

/**
 * <p>
 * 用户机构/部门表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysUserOrgReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 用户机构/部门表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysUserOrgQueryResponse> page(Pagination pagination, SysUserOrgQueryRequest queryRequest);

}
