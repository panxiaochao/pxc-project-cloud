package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.syspost.SysPostQueryRequest;
import io.github.panxiaochao.system.application.api.response.syspost.SysPostQueryResponse;

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
	 * @param queryRequest 岗位表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysPostQueryResponse> page(Pagination pagination, SysPostQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 岗位表查询请求对象
	 * @return 结果数组
	 */
	List<SysPostQueryResponse> list(SysPostQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 岗位表查询请求对象
	 * @return 岗位表查询响应对象
	 */
	SysPostQueryResponse getOne(SysPostQueryRequest queryRequest);

}
