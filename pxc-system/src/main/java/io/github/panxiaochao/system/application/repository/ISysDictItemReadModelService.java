package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.SysDictItemQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysDictItemQueryResponse;

import java.util.List;

/**
 * <p>
 * 数据字典配置表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysDictItemReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 数据字典配置表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysDictItemQueryResponse> page(Pagination pagination, SysDictItemQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 数据字典配置表查询请求对象
	 * @return 结果数组
	 */
	List<SysDictItemQueryResponse> selectList(SysDictItemQueryRequest queryRequest);

}
