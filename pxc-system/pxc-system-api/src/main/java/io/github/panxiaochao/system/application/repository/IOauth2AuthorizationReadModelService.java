package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent.Oauth2AuthorizationQueryRequest;
import io.github.panxiaochao.system.application.api.response.oauth2authorizationconsent.Oauth2AuthorizationQueryResponse;

import java.util.List;

/**
 * <p>
 * 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface IOauth2AuthorizationReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 查询请求对象
	 * @return 分页结果数组
	 */
	List<Oauth2AuthorizationQueryResponse> page(Pagination pagination, Oauth2AuthorizationQueryRequest queryRequest);

}
