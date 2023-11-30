package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysAreaCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysAreaQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysAreaUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysAreaQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysAreaResponse;
import io.github.panxiaochao.system.application.convert.ISysAreaDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysAreaReadModelService;
import io.github.panxiaochao.system.domain.entity.SysArea;
import io.github.panxiaochao.system.domain.service.SysAreaDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 全国5级行政区划 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysAreaAppService {

	/**
	 * 全国5级行政区划 Domain服务类
	 */
	private final SysAreaDomainService sysAreaDomainService;

	/**
	 * 全国5级行政区划 读模型服务
	 */
	private final ISysAreaReadModelService sysAreaReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysAreaQueryResponse> page(RequestPage<SysAreaQueryRequest> pageRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysAreaQueryResponse> list = sysAreaReadModelService.page(pagination, pageRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysAreaResponse> getById(String id) {
		SysArea sysArea = sysAreaDomainService.getById(id);
		SysAreaResponse sysAreaResponse = ISysAreaDTOConvert.INSTANCE.toResponse(sysArea);
		return R.ok(sysAreaResponse);
	}

	/**
	 * 保存
	 * @param sysAreaCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysAreaResponse> save(SysAreaCreateRequest sysAreaCreateRequest) {
		SysArea sysArea = ISysAreaDTOConvert.INSTANCE.fromCreateRequest(sysAreaCreateRequest);
		sysArea = sysAreaDomainService.save(sysArea);
		SysAreaResponse sysAreaResponse = ISysAreaDTOConvert.INSTANCE.toResponse(sysArea);
		return R.ok(sysAreaResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysAreaUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysAreaUpdateRequest sysAreaUpdateRequest) {
		SysArea sysArea = ISysAreaDTOConvert.INSTANCE.fromUpdateRequest(sysAreaUpdateRequest);
		sysAreaDomainService.update(sysArea);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysAreaDomainService.deleteById(id);
		return R.ok();
	}

}
