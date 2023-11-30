package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysLogOperateQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysLogOperateQueryResponse;

import java.util.List;

/**
 * <p>
 * 系统日志操作表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysLogOperateReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	List<SysLogOperateQueryResponse> page(Pagination pagination, RequestPage<SysLogOperateQueryRequest> pageRequest);

}
