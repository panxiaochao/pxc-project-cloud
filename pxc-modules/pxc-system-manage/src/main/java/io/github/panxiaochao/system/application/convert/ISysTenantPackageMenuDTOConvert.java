package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackagemenu.SysTenantPackageMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenantpackagemenu.SysTenantPackageMenuResponse;
import io.github.panxiaochao.system.domain.entity.SysTenantPackageMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户套餐菜单表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Mapper
public interface ISysTenantPackageMenuDTOConvert {

	/**
	 * 租户套餐菜单表数据传输对象结构映射实例
	 */
	ISysTenantPackageMenuDTOConvert INSTANCE = Mappers.getMapper(ISysTenantPackageMenuDTOConvert.class);

	/**
	 * 租户套餐菜单表创建请求数据传输对象 转 租户套餐菜单表实体
	 * @param createRequest 租户套餐菜单表创建请求数据传输对象
	 * @return 租户套餐菜单表实体
	 */
	SysTenantPackageMenu fromCreateRequest(SysTenantPackageMenuCreateRequest createRequest);

	/**
	 * 租户套餐菜单表更新请求数据传输对象 转 租户套餐菜单表实体
	 * @param updateRequest 租户套餐菜单表更新请求数据传输对象
	 * @return 租户套餐菜单表实体
	 */
	SysTenantPackageMenu fromUpdateRequest(SysTenantPackageMenuUpdateRequest updateRequest);

	/**
	 * 租户套餐菜单表查询请求数据传输对象 转 租户套餐菜单表实体
	 * @param queryRequest 租户套餐菜单表查询请求数据传输对象
	 * @return 租户套餐菜单表实体
	 */
	SysTenantPackageMenu fromQueryRequest(SysTenantPackageMenuQueryRequest queryRequest);

	/**
	 * 租户套餐菜单表实体 转 租户套餐菜单表响应数据传输对象
	 * @param sysTenantPackageMenu 租户套餐菜单表实体
	 * @return 租户套餐菜单表响应数据传输对象
	 */
	SysTenantPackageMenuResponse toResponse(SysTenantPackageMenu sysTenantPackageMenu);

	/**
	 * 租户套餐菜单表实体 转 租户套餐菜单表查询响应数据传输对象
	 * @param sysTenantPackageMenu 租户套餐菜单表实体
	 * @return 租户套餐菜单表查询响应数据传输对象
	 */
	SysTenantPackageMenuQueryResponse toQueryResponse(SysTenantPackageMenu sysTenantPackageMenu);

	/**
	 * 租户套餐菜单表实体列表 转 租户套餐菜单表查询响应数据传输对象列表
	 * @param sysTenantPackageMenuList 租户套餐菜单表实体列表
	 * @return 租户套餐菜单表查询响应数据传输对象列表
	 */
	List<SysTenantPackageMenuQueryResponse> toQueryResponse(List<SysTenantPackageMenu> sysTenantPackageMenuList);

}
