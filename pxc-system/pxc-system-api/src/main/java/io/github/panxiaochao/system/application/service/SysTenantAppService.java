package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantResponse;
import io.github.panxiaochao.system.application.convert.ISysTenantDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantReadModelService;
import io.github.panxiaochao.system.domain.entity.SysTenant;
import io.github.panxiaochao.system.domain.service.SysTenantDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租户表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantAppService {

	/**
	 * 租户表 Domain服务类
	 */
	private final SysTenantDomainService sysTenantDomainService;

	/**
	 * 租户表 读模型服务
	 */
	private final ISysTenantReadModelService sysTenantReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 租户表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysTenantQueryResponse> page(RequestPage pageRequest, SysTenantQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysTenantQueryResponse> list = sysTenantReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysTenantResponse> getById(String id) {
		SysTenant sysTenant = sysTenantDomainService.getById(id);
		SysTenantResponse sysTenantResponse = ISysTenantDTOConvert.INSTANCE.toResponse(sysTenant);
		return R.ok(sysTenantResponse);
	}

	/**
	 * 保存
	 * @param sysTenantCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysTenantResponse> save(SysTenantCreateRequest sysTenantCreateRequest) {
		SysTenant sysTenant = ISysTenantDTOConvert.INSTANCE.fromCreateRequest(sysTenantCreateRequest);
		sysTenant = sysTenantDomainService.save(sysTenant);
		SysTenantResponse sysTenantResponse = ISysTenantDTOConvert.INSTANCE.toResponse(sysTenant);
		return R.ok(sysTenantResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysTenantUpdateRequest sysTenantUpdateRequest) {
		SysTenant sysTenant = ISysTenantDTOConvert.INSTANCE.fromUpdateRequest(sysTenantUpdateRequest);
		sysTenantDomainService.update(sysTenant);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysTenantDomainService.deleteById(id);
		return R.ok();
	}

}
