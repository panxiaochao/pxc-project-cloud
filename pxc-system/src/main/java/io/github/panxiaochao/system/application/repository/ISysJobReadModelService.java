package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysJobQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysJobQueryResponse;

import java.util.List;

/**
 * <p>
 * 定时任务调度表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysJobReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	List<SysJobQueryResponse> page(Pagination pagination, RequestPage<SysJobQueryRequest> pageRequest);

}
