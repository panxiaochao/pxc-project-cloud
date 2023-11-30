package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysPostCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysPostQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysPostUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysPostQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysPostResponse;
import io.github.panxiaochao.system.application.convert.ISysPostDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysPostReadModelService;
import io.github.panxiaochao.system.domain.entity.SysPost;
import io.github.panxiaochao.system.domain.service.SysPostDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 岗位表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysPostAppService {

	/**
	 * 岗位表 Domain服务类
	 */
	private final SysPostDomainService sysPostDomainService;

	/**
	 * 岗位表 读模型服务
	 */
	private final ISysPostReadModelService sysPostReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysPostQueryResponse> page(RequestPage<SysPostQueryRequest> pageRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysPostQueryResponse> list = sysPostReadModelService.page(pagination, pageRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysPostResponse> getById(String id) {
		SysPost sysPost = sysPostDomainService.getById(id);
		SysPostResponse sysPostResponse = ISysPostDTOConvert.INSTANCE.toResponse(sysPost);
		return R.ok(sysPostResponse);
	}

	/**
	 * 保存
	 * @param sysPostCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysPostResponse> save(SysPostCreateRequest sysPostCreateRequest) {
		SysPost sysPost = ISysPostDTOConvert.INSTANCE.fromCreateRequest(sysPostCreateRequest);
		sysPost = sysPostDomainService.save(sysPost);
		SysPostResponse sysPostResponse = ISysPostDTOConvert.INSTANCE.toResponse(sysPost);
		return R.ok(sysPostResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysPostUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysPostUpdateRequest sysPostUpdateRequest) {
		SysPost sysPost = ISysPostDTOConvert.INSTANCE.fromUpdateRequest(sysPostUpdateRequest);
		sysPostDomainService.update(sysPost);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysPostDomainService.deleteById(id);
		return R.ok();
	}

}
