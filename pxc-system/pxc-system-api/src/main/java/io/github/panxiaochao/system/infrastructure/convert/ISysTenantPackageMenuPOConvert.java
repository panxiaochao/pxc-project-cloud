package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.systenantpackagemenu.SysTenantPackageMenuQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysTenantPackageMenu;
import io.github.panxiaochao.system.infrastructure.po.SysTenantPackageMenuPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 租户套餐菜单表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Mapper
public interface ISysTenantPackageMenuPOConvert {

	/**
	 * 租户套餐菜单表持久化对象结构映射实例
	 */
	ISysTenantPackageMenuPOConvert INSTANCE = Mappers.getMapper(ISysTenantPackageMenuPOConvert.class);

	/**
	 * 租户套餐菜单表实体 转 租户套餐菜单表持久化对象
	 * @param sysTenantPackageMenu 租户套餐菜单表实体
	 * @return 租户套餐菜单表持久化对象
	 */
	SysTenantPackageMenuPO fromEntity(SysTenantPackageMenu sysTenantPackageMenu);

	/**
	 * 租户套餐菜单表实体 转 租户套餐菜单表持久化对象
	 * @param sysTenantPackageMenuList 租户套餐菜单表实体
	 * @return 租户套餐菜单表持久化对象
	 */
	List<SysTenantPackageMenuPO> fromEntity(List<SysTenantPackageMenu> sysTenantPackageMenuList);

	/**
	 * 租户套餐菜单表持久化对象 转 租户套餐菜单表实体
	 * @param sysTenantPackageMenuPO 租户套餐菜单表持久化对象
	 * @return 租户套餐菜单表实体
	 */
	SysTenantPackageMenu toEntity(SysTenantPackageMenuPO sysTenantPackageMenuPO);

	/**
	 * 租户套餐菜单表持久化对象 转 租户套餐菜单表实体
	 * @param sysTenantPackageMenuPOList 租户套餐菜单表持久化对象
	 * @return 租户套餐菜单表实体
	 */
	List<SysTenantPackageMenu> toEntity(List<SysTenantPackageMenuPO> sysTenantPackageMenuPOList);

	/**
	 * 租户套餐菜单表持久化对象 转 租户套餐菜单表查询响应数据传输对象
	 * @param sysTenantPackageMenuPO 租户套餐菜单表持久化对象
	 * @return 租户套餐菜单表查询响应数据传输对象
	 */
	SysTenantPackageMenuQueryResponse toQueryResponse(SysTenantPackageMenuPO sysTenantPackageMenuPO);

	/**
	 * 租户套餐菜单表持久化对象列表 转 租户套餐菜单表查询响应数据传输对象列表
	 * @param sysTenantPackageMenuPOList 租户套餐菜单表持久化对象列表
	 * @return 租户套餐菜单表查询响应数据传输对象列表
	 */
	List<SysTenantPackageMenuQueryResponse> toQueryResponse(List<SysTenantPackageMenuPO> sysTenantPackageMenuPOList);

}
