package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysuserauths.SysUserAuthsQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuserauths.SysUserAuthsResponse;
import io.github.panxiaochao.system.application.convert.ISysUserAuthsDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserAuthsReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUserAuths;
import io.github.panxiaochao.system.domain.service.SysUserAuthsDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户授权信息表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserAuthsAppService {

	/**
	 * 用户授权信息表 Domain服务类
	 */
	private final SysUserAuthsDomainService sysUserAuthsDomainService;

	/**
	 * 用户授权信息表 读模型服务
	 */
	private final ISysUserAuthsReadModelService sysUserAuthsReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 用户授权信息表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysUserAuthsQueryResponse> page(RequestPage pageRequest,
			SysUserAuthsQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysUserAuthsQueryResponse> list = sysUserAuthsReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysUserAuthsResponse> getById(String id) {
		SysUserAuths sysUserAuths = sysUserAuthsDomainService.getById(id);
		SysUserAuthsResponse sysUserAuthsResponse = ISysUserAuthsDTOConvert.INSTANCE.toResponse(sysUserAuths);
		return R.ok(sysUserAuthsResponse);
	}

	/**
	 * 保存
	 * @param sysUserAuthsCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysUserAuthsResponse> save(SysUserAuthsCreateRequest sysUserAuthsCreateRequest) {
		SysUserAuths sysUserAuths = ISysUserAuthsDTOConvert.INSTANCE.fromCreateRequest(sysUserAuthsCreateRequest);
		sysUserAuths = sysUserAuthsDomainService.save(sysUserAuths);
		SysUserAuthsResponse sysUserAuthsResponse = ISysUserAuthsDTOConvert.INSTANCE.toResponse(sysUserAuths);
		return R.ok(sysUserAuthsResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysUserAuthsUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysUserAuthsUpdateRequest sysUserAuthsUpdateRequest) {
		SysUserAuths sysUserAuths = ISysUserAuthsDTOConvert.INSTANCE.fromUpdateRequest(sysUserAuthsUpdateRequest);
		sysUserAuthsDomainService.update(sysUserAuths);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysUserAuthsDomainService.deleteById(id);
		return R.ok();
	}

}
