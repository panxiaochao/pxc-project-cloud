package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenantuser.SysTenantUserQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenantuser.SysTenantUserResponse;
import io.github.panxiaochao.system.domain.entity.SysTenantUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户用户表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Mapper
public interface ISysTenantUserDTOConvert {

	/**
	 * 租户用户表数据传输对象结构映射实例
	 */
	ISysTenantUserDTOConvert INSTANCE = Mappers.getMapper(ISysTenantUserDTOConvert.class);

	/**
	 * 租户用户表创建请求数据传输对象 转 租户用户表实体
	 * @param createRequest 租户用户表创建请求数据传输对象
	 * @return 租户用户表实体
	 */
	SysTenantUser fromCreateRequest(SysTenantUserCreateRequest createRequest);

	/**
	 * 租户用户表更新请求数据传输对象 转 租户用户表实体
	 * @param updateRequest 租户用户表更新请求数据传输对象
	 * @return 租户用户表实体
	 */
	SysTenantUser fromUpdateRequest(SysTenantUserUpdateRequest updateRequest);

	/**
	 * 租户用户表查询请求数据传输对象 转 租户用户表实体
	 * @param queryRequest 租户用户表查询请求数据传输对象
	 * @return 租户用户表实体
	 */
	SysTenantUser fromQueryRequest(SysTenantUserQueryRequest queryRequest);

	/**
	 * 租户用户表实体 转 租户用户表响应数据传输对象
	 * @param sysTenantUser 租户用户表实体
	 * @return 租户用户表响应数据传输对象
	 */
	SysTenantUserResponse toResponse(SysTenantUser sysTenantUser);

	/**
	 * 租户用户表实体 转 租户用户表查询响应数据传输对象
	 * @param sysTenantUser 租户用户表实体
	 * @return 租户用户表查询响应数据传输对象
	 */
	SysTenantUserQueryResponse toQueryResponse(SysTenantUser sysTenantUser);

	/**
	 * 租户用户表实体列表 转 租户用户表查询响应数据传输对象列表
	 * @param sysTenantUserList 租户用户表实体列表
	 * @return 租户用户表查询响应数据传输对象列表
	 */
	List<SysTenantUserQueryResponse> toQueryResponse(List<SysTenantUser> sysTenantUserList);

}
