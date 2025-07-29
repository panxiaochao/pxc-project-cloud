package io.github.panxiaochao.system.development.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnQueryResponse;

import java.util.List;

/**
 * <p>
 * 【在线数据表字段】读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
public interface IOnlineTableColumnReadModelService {

	/**
	 * 查询 在线数据表字段分页数据
	 * @param pagination 分页属性对象
	 * @param queryRequest 在线数据表字段 查询请求对象
	 * @return 分页结果数组
	 */
	List<OnlineTableColumnQueryResponse> page(Pagination pagination, OnlineTableColumnQueryRequest queryRequest);

	/**
	 * 查询 在线数据表字段对象数组
	 * @param queryRequest 在线数据表字段 查询请求对象
	 * @return 结果数组
	 */
	List<OnlineTableColumnQueryResponse> selectList(OnlineTableColumnQueryRequest queryRequest);

	/**
	 * 查询 在线数据表字段对象单条记录
	 * @param queryRequest 在线数据表字段 查询请求对象
	 * @param throwEx boolean 参数，为true如果存在多个结果直接抛出异常
	 * @return 在线数据表字段查询响应对象
	 */
	OnlineTableColumnQueryResponse getOne(OnlineTableColumnQueryRequest queryRequest, boolean throwEx);

}
