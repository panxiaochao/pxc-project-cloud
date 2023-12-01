package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.Oauth2RegisteredClientCreateRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2RegisteredClientQueryRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2RegisteredClientUpdateRequest;
import io.github.panxiaochao.system.application.api.response.Oauth2RegisteredClientQueryResponse;
import io.github.panxiaochao.system.application.api.response.Oauth2RegisteredClientResponse;
import io.github.panxiaochao.system.application.convert.IOauth2RegisteredClientDTOConvert;
import io.github.panxiaochao.system.application.repository.IOauth2RegisteredClientReadModelService;
import io.github.panxiaochao.system.domain.entity.Oauth2RegisteredClient;
import io.github.panxiaochao.system.domain.service.Oauth2RegisteredClientDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class Oauth2RegisteredClientAppService {

	/**
	 * Domain服务类
	 */
	private final Oauth2RegisteredClientDomainService oauth2RegisteredClientDomainService;

	/**
	 * 读模型服务
	 */
	private final IOauth2RegisteredClientReadModelService oauth2RegisteredClientReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<Oauth2RegisteredClientQueryResponse> page(
			RequestPage<Oauth2RegisteredClientQueryRequest> pageRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<Oauth2RegisteredClientQueryResponse> list = oauth2RegisteredClientReadModelService.page(pagination,
				pageRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<Oauth2RegisteredClientResponse> getById(String id) {
		Oauth2RegisteredClient oauth2RegisteredClient = oauth2RegisteredClientDomainService.getById(id);
		Oauth2RegisteredClientResponse oauth2RegisteredClientResponse = IOauth2RegisteredClientDTOConvert.INSTANCE
			.toResponse(oauth2RegisteredClient);
		return R.ok(oauth2RegisteredClientResponse);
	}

	/**
	 * 保存
	 * @param oauth2RegisteredClientCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<Oauth2RegisteredClientResponse> save(
			Oauth2RegisteredClientCreateRequest oauth2RegisteredClientCreateRequest) {
		Oauth2RegisteredClient oauth2RegisteredClient = IOauth2RegisteredClientDTOConvert.INSTANCE
			.fromCreateRequest(oauth2RegisteredClientCreateRequest);
		oauth2RegisteredClient = oauth2RegisteredClientDomainService.save(oauth2RegisteredClient);
		Oauth2RegisteredClientResponse oauth2RegisteredClientResponse = IOauth2RegisteredClientDTOConvert.INSTANCE
			.toResponse(oauth2RegisteredClient);
		return R.ok(oauth2RegisteredClientResponse);
	}

	/**
	 * 根据主键更新
	 * @param oauth2RegisteredClientUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(Oauth2RegisteredClientUpdateRequest oauth2RegisteredClientUpdateRequest) {
		Oauth2RegisteredClient oauth2RegisteredClient = IOauth2RegisteredClientDTOConvert.INSTANCE
			.fromUpdateRequest(oauth2RegisteredClientUpdateRequest);
		oauth2RegisteredClientDomainService.update(oauth2RegisteredClient);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		oauth2RegisteredClientDomainService.deleteById(id);
		return R.ok();
	}

}
