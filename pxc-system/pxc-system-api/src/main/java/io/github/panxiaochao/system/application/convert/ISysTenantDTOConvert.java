package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.systenant.SysTenantCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantResponse;
import io.github.panxiaochao.system.domain.entity.SysTenant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Mapper
public interface ISysTenantDTOConvert {

	/**
	 * 租户表数据传输对象结构映射实例
	 */
	ISysTenantDTOConvert INSTANCE = Mappers.getMapper(ISysTenantDTOConvert.class);

	/**
	 * 租户表创建请求数据传输对象 转 租户表实体
	 * @param createRequest 租户表创建请求数据传输对象
	 * @return 租户表实体
	 */
	SysTenant fromCreateRequest(SysTenantCreateRequest createRequest);

	/**
	 * 租户表更新请求数据传输对象 转 租户表实体
	 * @param updateRequest 租户表更新请求数据传输对象
	 * @return 租户表实体
	 */
	SysTenant fromUpdateRequest(SysTenantUpdateRequest updateRequest);

	/**
	 * 租户表查询请求数据传输对象 转 租户表实体
	 * @param queryRequest 租户表查询请求数据传输对象
	 * @return 租户表实体
	 */
	SysTenant fromQueryRequest(SysTenantQueryRequest queryRequest);

	/**
	 * 租户表实体 转 租户表响应数据传输对象
	 * @param sysTenant 租户表实体
	 * @return 租户表响应数据传输对象
	 */
	SysTenantResponse toResponse(SysTenant sysTenant);

	/**
	 * 租户表实体 转 租户表查询响应数据传输对象
	 * @param sysTenant 租户表实体
	 * @return 租户表查询响应数据传输对象
	 */
	SysTenantQueryResponse toQueryResponse(SysTenant sysTenant);

	/**
	 * 租户表实体列表 转 租户表查询响应数据传输对象列表
	 * @param sysTenantList 租户表实体列表
	 * @return 租户表查询响应数据传输对象列表
	 */
	List<SysTenantQueryResponse> toQueryResponse(List<SysTenant> sysTenantList);

}
