package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysTenantPackage;
import io.github.panxiaochao.system.infrastructure.po.SysTenantPackagePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 租户套餐表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Mapper
public interface ISysTenantPackagePOConvert {

	/**
	 * 租户套餐表持久化对象结构映射实例
	 */
	ISysTenantPackagePOConvert INSTANCE = Mappers.getMapper(ISysTenantPackagePOConvert.class);

	/**
	 * 租户套餐表实体 转 租户套餐表持久化对象
	 * @param sysTenantPackage 租户套餐表实体
	 * @return 租户套餐表持久化对象
	 */
	SysTenantPackagePO fromEntity(SysTenantPackage sysTenantPackage);

	/**
	 * 租户套餐表实体 转 租户套餐表持久化对象
	 * @param sysTenantPackageList 租户套餐表实体
	 * @return 租户套餐表持久化对象
	 */
	List<SysTenantPackagePO> fromEntity(List<SysTenantPackage> sysTenantPackageList);

	/**
	 * 租户套餐表持久化对象 转 租户套餐表实体
	 * @param sysTenantPackagePO 租户套餐表持久化对象
	 * @return 租户套餐表实体
	 */
	SysTenantPackage toEntity(SysTenantPackagePO sysTenantPackagePO);

	/**
	 * 租户套餐表持久化对象 转 租户套餐表实体
	 * @param sysTenantPackagePOList 租户套餐表持久化对象
	 * @return 租户套餐表实体
	 */
	List<SysTenantPackage> toEntity(List<SysTenantPackagePO> sysTenantPackagePOList);

	/**
	 * 租户套餐表持久化对象 转 租户套餐表查询响应数据传输对象
	 * @param sysTenantPackagePO 租户套餐表持久化对象
	 * @return 租户套餐表查询响应数据传输对象
	 */
	SysTenantPackageQueryResponse toQueryResponse(SysTenantPackagePO sysTenantPackagePO);

	/**
	 * 租户套餐表持久化对象列表 转 租户套餐表查询响应数据传输对象列表
	 * @param sysTenantPackagePOList 租户套餐表持久化对象列表
	 * @return 租户套餐表查询响应数据传输对象列表
	 */
	List<SysTenantPackageQueryResponse> toQueryResponse(List<SysTenantPackagePO> sysTenantPackagePOList);

}
