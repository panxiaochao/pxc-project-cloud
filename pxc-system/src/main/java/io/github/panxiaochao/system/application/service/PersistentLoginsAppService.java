package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.persistentlogins.PersistentLoginsCreateRequest;
import io.github.panxiaochao.system.application.api.request.persistentlogins.PersistentLoginsQueryRequest;
import io.github.panxiaochao.system.application.api.request.persistentlogins.PersistentLoginsUpdateRequest;
import io.github.panxiaochao.system.application.api.response.persistentlogins.PersistentLoginsQueryResponse;
import io.github.panxiaochao.system.application.api.response.persistentlogins.PersistentLoginsResponse;
import io.github.panxiaochao.system.application.convert.IPersistentLoginsDTOConvert;
import io.github.panxiaochao.system.application.repository.IPersistentLoginsReadModelService;
import io.github.panxiaochao.system.domain.entity.PersistentLogins;
import io.github.panxiaochao.system.domain.service.PersistentLoginsDomainService;
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
public class PersistentLoginsAppService {

	/**
	 * Domain服务类
	 */
	private final PersistentLoginsDomainService persistentLoginsDomainService;

	/**
	 * 读模型服务
	 */
	private final IPersistentLoginsReadModelService persistentLoginsReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<PersistentLoginsQueryResponse> page(RequestPage pageRequest,
			PersistentLoginsQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<PersistentLoginsQueryResponse> list = persistentLoginsReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<PersistentLoginsResponse> getById(String id) {
		PersistentLogins persistentLogins = persistentLoginsDomainService.getById(id);
		PersistentLoginsResponse persistentLoginsResponse = IPersistentLoginsDTOConvert.INSTANCE
			.toResponse(persistentLogins);
		return R.ok(persistentLoginsResponse);
	}

	/**
	 * 保存
	 * @param persistentLoginsCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<PersistentLoginsResponse> save(PersistentLoginsCreateRequest persistentLoginsCreateRequest) {
		PersistentLogins persistentLogins = IPersistentLoginsDTOConvert.INSTANCE
			.fromCreateRequest(persistentLoginsCreateRequest);
		persistentLogins = persistentLoginsDomainService.save(persistentLogins);
		PersistentLoginsResponse persistentLoginsResponse = IPersistentLoginsDTOConvert.INSTANCE
			.toResponse(persistentLogins);
		return R.ok(persistentLoginsResponse);
	}

	/**
	 * 根据主键更新
	 * @param persistentLoginsUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(PersistentLoginsUpdateRequest persistentLoginsUpdateRequest) {
		PersistentLogins persistentLogins = IPersistentLoginsDTOConvert.INSTANCE
			.fromUpdateRequest(persistentLoginsUpdateRequest);
		persistentLoginsDomainService.update(persistentLogins);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		persistentLoginsDomainService.deleteById(id);
		return R.ok();
	}

}
