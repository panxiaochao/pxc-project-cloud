package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageResponse;
import io.github.panxiaochao.system.domain.entity.SysTenantPackage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户套餐表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Mapper
public interface ISysTenantPackageDTOConvert {

	/**
	 * 租户套餐表数据传输对象结构映射实例
	 */
	ISysTenantPackageDTOConvert INSTANCE = Mappers.getMapper(ISysTenantPackageDTOConvert.class);

	/**
	 * 租户套餐表创建请求数据传输对象 转 租户套餐表实体
	 * @param createRequest 租户套餐表创建请求数据传输对象
	 * @return 租户套餐表实体
	 */
	SysTenantPackage fromCreateRequest(SysTenantPackageCreateRequest createRequest);

	/**
	 * 租户套餐表更新请求数据传输对象 转 租户套餐表实体
	 * @param updateRequest 租户套餐表更新请求数据传输对象
	 * @return 租户套餐表实体
	 */
	SysTenantPackage fromUpdateRequest(SysTenantPackageUpdateRequest updateRequest);

	/**
	 * 租户套餐表查询请求数据传输对象 转 租户套餐表实体
	 * @param queryRequest 租户套餐表查询请求数据传输对象
	 * @return 租户套餐表实体
	 */
	SysTenantPackage fromQueryRequest(SysTenantPackageQueryRequest queryRequest);

	/**
	 * 租户套餐表实体 转 租户套餐表响应数据传输对象
	 * @param sysTenantPackage 租户套餐表实体
	 * @return 租户套餐表响应数据传输对象
	 */
	SysTenantPackageResponse toResponse(SysTenantPackage sysTenantPackage);

	/**
	 * 租户套餐表实体 转 租户套餐表查询响应数据传输对象
	 * @param sysTenantPackage 租户套餐表实体
	 * @return 租户套餐表查询响应数据传输对象
	 */
	SysTenantPackageQueryResponse toQueryResponse(SysTenantPackage sysTenantPackage);

	/**
	 * 租户套餐表实体列表 转 租户套餐表查询响应数据传输对象列表
	 * @param sysTenantPackageList 租户套餐表实体列表
	 * @return 租户套餐表查询响应数据传输对象列表
	 */
	List<SysTenantPackageQueryResponse> toQueryResponse(List<SysTenantPackage> sysTenantPackageList);

}
