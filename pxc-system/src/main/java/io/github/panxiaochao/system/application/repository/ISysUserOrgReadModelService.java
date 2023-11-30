package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysUserOrgQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysUserOrgQueryResponse;

import java.util.List;

/**
 * <p>
 * 用户机构/部门表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysUserOrgReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	List<SysUserOrgQueryResponse> page(Pagination pagination, RequestPage<SysUserOrgQueryRequest> pageRequest);

}
