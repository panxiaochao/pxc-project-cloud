package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysRoleResponse;
import io.github.panxiaochao.system.application.convert.ISysRoleDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.SysRole;
import io.github.panxiaochao.system.domain.service.SysRoleDomainService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysRoleAppService {

	/**
	 * 角色表 服务类
	 */
	private final SysRoleDomainService sysRoleDomainService;

	/**
	 * 角色表 读模型服务
	 */
	private final ISysRoleReadModelService sysRoleReadModelService;

	public PageResponse<SysRoleQueryResponse> page(RequestPage<SysRoleQueryRequest> pageRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysRoleQueryResponse> list = sysRoleReadModelService.page(pagination, pageRequest);
		return new PageResponse<>(pagination, list);
	}

	public R<SysRoleResponse> getById(String id) {
		SysRole sysRole = sysRoleDomainService.getById(id);
		SysRoleResponse sysRoleResponse = ISysRoleDTOConvert.INSTANCE.toResponse(sysRole);
		return R.ok(sysRoleResponse);
	}

	public R<Void> save(SysRoleCreateRequest sysRoleCreateRequest) {
		SysRole sysRole = ISysRoleDTOConvert.INSTANCE.fromCreateRequest(sysRoleCreateRequest);
		if (StringUtils.isBlank(sysRole.getStatus())) {
			sysRole.setStatus("1");
		}
		sysRoleDomainService.save(sysRole);
		return R.ok();
	}

	public R<Void> update(SysRoleUpdateRequest sysRoleUpdateRequest) {
		SysRole sysRole = ISysRoleDTOConvert.INSTANCE.fromUpdateRequest(sysRoleUpdateRequest);
		sysRoleDomainService.update(sysRole);
		return R.ok();
	}

	public R<Void> deleteById(String id) {
		sysRoleDomainService.deleteById(id);
		return R.ok();
	}

}
