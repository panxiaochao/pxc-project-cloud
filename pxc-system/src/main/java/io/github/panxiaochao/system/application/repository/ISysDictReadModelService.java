package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysdict.SysDictQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysdict.SysDictQueryResponse;

import java.util.List;

/**
 * <p>
 * 数据字典表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysDictReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 数据字典表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysDictQueryResponse> page(Pagination pagination, SysDictQueryRequest queryRequest);

	/**
	 * 查询列表
	 * @param queryRequest 数据字典表查询请求对象
	 * @return 结果数组
	 */
	List<SysDictQueryResponse> list(SysDictQueryRequest queryRequest);

}
