package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackagemenu.SysTenantPackageMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenantpackagemenu.SysTenantPackageMenuResponse;
import io.github.panxiaochao.system.application.convert.ISysTenantPackageMenuDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.SysTenantPackageMenu;
import io.github.panxiaochao.system.domain.service.SysTenantPackageMenuDomainService;
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
 * 租户套餐菜单表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageMenuAppService {

	/**
	 * 租户套餐菜单表 Domain服务类
	 */
	private final SysTenantPackageMenuDomainService sysTenantPackageMenuDomainService;

	/**
	 * 租户套餐菜单表 读模型服务
	 */
	private final ISysTenantPackageMenuReadModelService sysTenantPackageMenuReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 租户套餐菜单表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysTenantPackageMenuQueryResponse> page(RequestPage pageRequest,
			SysTenantPackageMenuQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysTenantPackageMenuQueryResponse> list = sysTenantPackageMenuReadModelService.page(pagination,
				queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysTenantPackageMenuResponse> getById(String id) {
		SysTenantPackageMenu sysTenantPackageMenu = sysTenantPackageMenuDomainService.getById(id);
		SysTenantPackageMenuResponse sysTenantPackageMenuResponse = ISysTenantPackageMenuDTOConvert.INSTANCE
			.toResponse(sysTenantPackageMenu);
		return R.ok(sysTenantPackageMenuResponse);
	}

	/**
	 * 保存
	 * @param sysTenantPackageMenuCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysTenantPackageMenuResponse> save(SysTenantPackageMenuCreateRequest sysTenantPackageMenuCreateRequest) {
		SysTenantPackageMenu sysTenantPackageMenu = ISysTenantPackageMenuDTOConvert.INSTANCE
			.fromCreateRequest(sysTenantPackageMenuCreateRequest);
		sysTenantPackageMenu = sysTenantPackageMenuDomainService.save(sysTenantPackageMenu);
		SysTenantPackageMenuResponse sysTenantPackageMenuResponse = ISysTenantPackageMenuDTOConvert.INSTANCE
			.toResponse(sysTenantPackageMenu);
		return R.ok(sysTenantPackageMenuResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantPackageMenuUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysTenantPackageMenuUpdateRequest sysTenantPackageMenuUpdateRequest) {
		SysTenantPackageMenu sysTenantPackageMenu = ISysTenantPackageMenuDTOConvert.INSTANCE
			.fromUpdateRequest(sysTenantPackageMenuUpdateRequest);
		sysTenantPackageMenuDomainService.update(sysTenantPackageMenu);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysTenantPackageMenuDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 保存套餐关联菜单
	 */
	public void savePackageMenus(SysTenantPackageMenuCreateRequest sysTenantPackageMenuCreateRequest) {
		if (StringUtils.hasText(sysTenantPackageMenuCreateRequest.getMenuId())) {
			// 分割菜单ID
			String[] menuIds = StringUtils.tokenizeToStringArray(sysTenantPackageMenuCreateRequest.getMenuId(),
					StringPools.COMMA);
			List<SysTenantPackageMenu> list = Arrays.stream(menuIds)
				.map(menuId -> new SysTenantPackageMenu(sysTenantPackageMenuCreateRequest.getPackageId(), menuId))
				.collect(Collectors.toList());
			// 先删除当前租户套餐相关的菜单数据
			sysTenantPackageMenuDomainService.deleteByPackageId(sysTenantPackageMenuCreateRequest.getPackageId());
			// 在批量保存保存当前租户套餐关联的菜单数据
			sysTenantPackageMenuDomainService.saveBath(list);
		}
		else {
			// 菜单ID为空，说明是删除全部
			sysTenantPackageMenuDomainService.deleteByPackageId(sysTenantPackageMenuCreateRequest.getPackageId());
		}
	}

	/**
	 * 查询租户套餐下的菜单权限
	 * @param packageId 租户套餐ID
	 * @return 权限菜单集合
	 */
	public R<List<String>> queryPackageMenus(String packageId) {
		SysTenantPackageMenuQueryRequest queryRequest = new SysTenantPackageMenuQueryRequest();
		queryRequest.setPackageId(packageId);
		List<SysTenantPackageMenuQueryResponse> list = sysTenantPackageMenuReadModelService.selectList(queryRequest);
		List<String> ids = list.stream().map(SysTenantPackageMenuQueryResponse::getMenuId).collect(Collectors.toList());
		return R.ok(CollectionUtils.isEmpty(ids) ? new ArrayList<>() : ids);
	}

}
