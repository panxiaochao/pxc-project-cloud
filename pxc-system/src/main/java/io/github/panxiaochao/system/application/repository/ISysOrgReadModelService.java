package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysOrgQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysOrgQueryResponse;

import java.util.List;

/**
 * <p>
 * 机构部门表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysOrgReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	List<SysOrgQueryResponse> page(Pagination pagination, RequestPage<SysOrgQueryRequest> pageRequest);

}
