package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysRoleMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.SysRoleMenu;
import io.github.panxiaochao.system.domain.service.SysRoleMenuDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 角色菜单表查询请求对象
	 * @return 分页数组响应实体
	 */
	// public PageResponse<SysRoleMenuQueryResponse> page(RequestPage requestPage,
	// SysRoleMenuQueryRequest queryRequest) {
	// Pagination pagination = new Pagination(requestPage.getPageNo(),
	// requestPage.getPageSize());
	// List<SysRoleMenuQueryResponse> list = sysRoleMenuReadModelService.page(pagination,
	// queryRequest);
	// return new PageResponse<>(pagination, list);
	// }

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	// public R<SysRoleMenuResponse> getById(String id) {
	// SysRoleMenu sysRoleMenu = sysRoleMenuDomainService.getById(id);
	// SysRoleMenuResponse sysRoleMenuResponse =
	// ISysRoleMenuDTOConvert.INSTANCE.toResponse(sysRoleMenu);
	// return R.ok(sysRoleMenuResponse);
	// }

	/**
	 * 保存
	 * @param sysRoleMenuCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	// public R<SysRoleMenuResponse> save(SysRoleMenuCreateRequest
	// sysRoleMenuCreateRequest) {
	// SysRoleMenu sysRoleMenu =
	// ISysRoleMenuDTOConvert.INSTANCE.fromCreateRequest(sysRoleMenuCreateRequest);
	// sysRoleMenu = sysRoleMenuDomainService.save(sysRoleMenu);
	// SysRoleMenuResponse sysRoleMenuResponse =
	// ISysRoleMenuDTOConvert.INSTANCE.toResponse(sysRoleMenu);
	// return R.ok(sysRoleMenuResponse);
	// }

	/**
	 * 保存, 先删后增，批量保存
	 * @param sysRoleMenuCreateRequest 创建请求对象
	 */
	public void saveRoleMenus(SysRoleMenuCreateRequest sysRoleMenuCreateRequest) {
		if (StringUtils.hasText(sysRoleMenuCreateRequest.getMenuId())) {
			// 分割菜单ID
			String[] menuIds = StringUtils.tokenizeToStringArray(sysRoleMenuCreateRequest.getMenuId(),
					StringPools.COMMA);
			List<SysRoleMenu> list = Arrays.stream(menuIds)
				.map(menuId -> new SysRoleMenu(sysRoleMenuCreateRequest.getRoleId(), menuId))
				.collect(Collectors.toList());
			// 先删除当前角色相关的菜单数据
			sysRoleMenuDomainService.deleteByRoleId(sysRoleMenuCreateRequest.getRoleId());
			// 在批量保存保存当前角色关联的菜单数据
			sysRoleMenuDomainService.saveBath(list);
		}
		else {
			// 菜单ID为空，说明是删除全部
			sysRoleMenuDomainService.deleteByRoleId(sysRoleMenuCreateRequest.getRoleId());
		}
	}

	/**
	 * 根据主键更新
	 * @param sysRoleMenuUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	// public R<Void> update(SysRoleMenuUpdateRequest sysRoleMenuUpdateRequest) {
	// SysRoleMenu sysRoleMenu =
	// ISysRoleMenuDTOConvert.INSTANCE.fromUpdateRequest(sysRoleMenuUpdateRequest);
	// sysRoleMenuDomainService.update(sysRoleMenu);
	// return R.ok();
	// }

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	// public R<Void> deleteById(String id) {
	// sysRoleMenuDomainService.deleteById(id);
	// return R.ok();
	// }

	/**
	 * 查询角色下的菜单权限
	 * @param roleId 角色ID
	 * @return 权限菜单集合
	 */
	public R<List<String>> queryRoleMenus(String roleId) {
		SysRoleMenuQueryRequest queryRequest = new SysRoleMenuQueryRequest();
		queryRequest.setRoleId(roleId);
		List<SysRoleMenuQueryResponse> list = sysRoleMenuReadModelService.selectList(queryRequest);
		List<String> ids = list.stream().map(SysRoleMenuQueryResponse::getMenuId).collect(Collectors.toList());
		return R.ok(CollectionUtils.isEmpty(ids) ? new ArrayList<>() : ids);
	}

}
