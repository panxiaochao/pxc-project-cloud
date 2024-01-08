package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamQueryResponse;

import java.util.List;

/**
 * <p>
 * 系统参数 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysParamReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 系统参数查询请求对象
	 * @return 分页结果数组
	 */
	List<SysParamQueryResponse> page(Pagination pagination, SysParamQueryRequest queryRequest);

	/**
	 * 查询数组
	 * @param queryRequest 系统参数查询请求对象
	 * @return 结果数组
	 */
	List<SysParamQueryResponse> list(SysParamQueryRequest queryRequest);

}
