package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysDictItemCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysDictItemQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysDictItemUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysDictItemResponse;
import io.github.panxiaochao.system.application.convert.ISysDictItemDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysDictItemReadModelService;
import io.github.panxiaochao.system.domain.entity.SysDictItem;
import io.github.panxiaochao.system.domain.service.SysDictItemDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据字典配置表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysDictItemAppService {

	/**
	 * 数据字典配置表 Domain服务类
	 */
	private final SysDictItemDomainService sysDictItemDomainService;

	/**
	 * 数据字典配置表 读模型服务
	 */
	private final ISysDictItemReadModelService sysDictItemReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysDictItemQueryResponse> page(RequestPage<SysDictItemQueryRequest> pageRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysDictItemQueryResponse> list = sysDictItemReadModelService.page(pagination, pageRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysDictItemResponse> getById(String id) {
		SysDictItem sysDictItem = sysDictItemDomainService.getById(id);
		SysDictItemResponse sysDictItemResponse = ISysDictItemDTOConvert.INSTANCE.toResponse(sysDictItem);
		return R.ok(sysDictItemResponse);
	}

	/**
	 * 保存
	 * @param sysDictItemCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysDictItemResponse> save(SysDictItemCreateRequest sysDictItemCreateRequest) {
		SysDictItem sysDictItem = ISysDictItemDTOConvert.INSTANCE.fromCreateRequest(sysDictItemCreateRequest);
		sysDictItem = sysDictItemDomainService.save(sysDictItem);
		SysDictItemResponse sysDictItemResponse = ISysDictItemDTOConvert.INSTANCE.toResponse(sysDictItem);
		return R.ok(sysDictItemResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysDictItemUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysDictItemUpdateRequest sysDictItemUpdateRequest) {
		SysDictItem sysDictItem = ISysDictItemDTOConvert.INSTANCE.fromUpdateRequest(sysDictItemUpdateRequest);
		sysDictItemDomainService.update(sysDictItem);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysDictItemDomainService.deleteById(id);
		return R.ok();
	}

}
