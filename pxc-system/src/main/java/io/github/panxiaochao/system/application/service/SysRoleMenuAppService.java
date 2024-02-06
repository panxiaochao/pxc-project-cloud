package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuResponse;
import io.github.panxiaochao.system.application.convert.ISysRoleMenuDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysRoleMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.SysRoleMenu;
import io.github.panxiaochao.system.domain.service.SysRoleMenuDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色菜单表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Service
@RequiredArgsConstructor
public class SysRoleMenuAppService {

	/**
	 * 角色菜单表 Domain服务类
	 */
	private final SysRoleMenuDomainService sysRoleMenuDomainService;

	/**
	 * 角色菜单表 读模型服务
	 */
	private final ISysRoleMenuReadModelService sysRoleMenuReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 角色菜单表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysRoleMenuQueryResponse> page(RequestPage pageRequest, SysRoleMenuQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysRoleMenuQueryResponse> list = sysRoleMenuReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysRoleMenuResponse> getById(String id) {
		SysRoleMenu sysRoleMenu = sysRoleMenuDomainService.getById(id);
		SysRoleMenuResponse sysRoleMenuResponse = ISysRoleMenuDTOConvert.INSTANCE.toResponse(sysRoleMenu);
		return R.ok(sysRoleMenuResponse);
	}

	/**
	 * 保存
	 * @param sysRoleMenuCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysRoleMenuResponse> save(SysRoleMenuCreateRequest sysRoleMenuCreateRequest) {
		SysRoleMenu sysRoleMenu = ISysRoleMenuDTOConvert.INSTANCE.fromCreateRequest(sysRoleMenuCreateRequest);
		sysRoleMenu = sysRoleMenuDomainService.save(sysRoleMenu);
		SysRoleMenuResponse sysRoleMenuResponse = ISysRoleMenuDTOConvert.INSTANCE.toResponse(sysRoleMenu);
		return R.ok(sysRoleMenuResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysRoleMenuUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysRoleMenuUpdateRequest sysRoleMenuUpdateRequest) {
		SysRoleMenu sysRoleMenu = ISysRoleMenuDTOConvert.INSTANCE.fromUpdateRequest(sysRoleMenuUpdateRequest);
		sysRoleMenuDomainService.update(sysRoleMenu);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysRoleMenuDomainService.deleteById(id);
		return R.ok();
	}

}
