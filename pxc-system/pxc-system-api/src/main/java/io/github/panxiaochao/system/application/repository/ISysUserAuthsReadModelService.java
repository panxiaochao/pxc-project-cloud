package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysuserauths.SysUserAuthsQueryResponse;

import java.util.List;

/**
 * <p>
 * 用户授权信息表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysUserAuthsReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 用户授权信息表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysUserAuthsQueryResponse> page(Pagination pagination, SysUserAuthsQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 用户授权信息表查询请求对象
	 * @return 结果数组
	 */
	List<SysUserAuthsQueryResponse> list(SysUserAuthsQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 用户授权信息表查询请求对象
	 * @param throwEx 参数，为true如果存在多个结果直接抛出异常
	 * @return 结果记录
	 */
	SysUserAuthsQueryResponse geOne(SysUserAuthsQueryRequest queryRequest, boolean throwEx);

}
