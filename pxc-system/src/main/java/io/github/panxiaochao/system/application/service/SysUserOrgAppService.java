package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysUserOrgCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysUserOrgQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysUserOrgUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysUserOrgQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysUserOrgResponse;
import io.github.panxiaochao.system.application.convert.ISysUserOrgDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserOrgReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUserOrg;
import io.github.panxiaochao.system.domain.service.SysUserOrgDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户机构/部门表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysUserOrgAppService {

	/**
	 * 用户机构/部门表 Domain服务类
	 */
	private final SysUserOrgDomainService sysUserOrgDomainService;

	/**
	 * 用户机构/部门表 读模型服务
	 */
	private final ISysUserOrgReadModelService sysUserOrgReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysUserOrgQueryResponse> page(RequestPage<SysUserOrgQueryRequest> pageRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysUserOrgQueryResponse> list = sysUserOrgReadModelService.page(pagination, pageRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysUserOrgResponse> getById(String id) {
		SysUserOrg sysUserOrg = sysUserOrgDomainService.getById(id);
		SysUserOrgResponse sysUserOrgResponse = ISysUserOrgDTOConvert.INSTANCE.toResponse(sysUserOrg);
		return R.ok(sysUserOrgResponse);
	}

	/**
	 * 保存
	 * @param sysUserOrgCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysUserOrgResponse> save(SysUserOrgCreateRequest sysUserOrgCreateRequest) {
		SysUserOrg sysUserOrg = ISysUserOrgDTOConvert.INSTANCE.fromCreateRequest(sysUserOrgCreateRequest);
		sysUserOrg = sysUserOrgDomainService.save(sysUserOrg);
		SysUserOrgResponse sysUserOrgResponse = ISysUserOrgDTOConvert.INSTANCE.toResponse(sysUserOrg);
		return R.ok(sysUserOrgResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysUserOrgUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysUserOrgUpdateRequest sysUserOrgUpdateRequest) {
		SysUserOrg sysUserOrg = ISysUserOrgDTOConvert.INSTANCE.fromUpdateRequest(sysUserOrgUpdateRequest);
		sysUserOrgDomainService.update(sysUserOrg);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysUserOrgDomainService.deleteById(id);
		return R.ok();
	}

}
