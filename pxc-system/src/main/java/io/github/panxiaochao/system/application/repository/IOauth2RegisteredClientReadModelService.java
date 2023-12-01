package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.Oauth2RegisteredClientQueryRequest;
import io.github.panxiaochao.system.application.api.response.Oauth2RegisteredClientQueryResponse;

import java.util.List;

/**
 * <p>
 * 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface IOauth2RegisteredClientReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	List<Oauth2RegisteredClientQueryResponse> page(Pagination pagination,
			RequestPage<Oauth2RegisteredClientQueryRequest> pageRequest);

}
