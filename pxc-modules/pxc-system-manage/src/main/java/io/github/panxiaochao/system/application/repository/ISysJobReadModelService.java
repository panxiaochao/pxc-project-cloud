package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysjob.SysJobQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysjob.SysJobQueryResponse;

import java.util.List;

/**
 * <p>
 * 定时任务调度表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysJobReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 定时任务调度表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysJobQueryResponse> page(Pagination pagination, SysJobQueryRequest queryRequest);

}
