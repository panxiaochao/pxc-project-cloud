package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysPostQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysPostQueryResponse;

import java.util.List;

/**
 * <p>
 * 岗位表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysPostReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	List<SysPostQueryResponse> page(Pagination pagination, RequestPage<SysPostQueryRequest> pageRequest);

}
