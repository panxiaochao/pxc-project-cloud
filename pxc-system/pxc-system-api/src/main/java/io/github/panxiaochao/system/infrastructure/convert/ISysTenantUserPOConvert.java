package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.systenantuser.SysTenantUserQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysTenantUser;
import io.github.panxiaochao.system.infrastructure.po.SysTenantUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 租户用户表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Mapper
public interface ISysTenantUserPOConvert {

	/**
	 * 租户用户表持久化对象结构映射实例
	 */
	ISysTenantUserPOConvert INSTANCE = Mappers.getMapper(ISysTenantUserPOConvert.class);

	/**
	 * 租户用户表实体 转 租户用户表持久化对象
	 * @param sysTenantUser 租户用户表实体
	 * @return 租户用户表持久化对象
	 */
	SysTenantUserPO fromEntity(SysTenantUser sysTenantUser);

	/**
	 * 租户用户表实体 转 租户用户表持久化对象
	 * @param sysTenantUserList 租户用户表实体
	 * @return 租户用户表持久化对象
	 */
	List<SysTenantUserPO> fromEntity(List<SysTenantUser> sysTenantUserList);

	/**
	 * 租户用户表持久化对象 转 租户用户表实体
	 * @param sysTenantUserPO 租户用户表持久化对象
	 * @return 租户用户表实体
	 */
	SysTenantUser toEntity(SysTenantUserPO sysTenantUserPO);

	/**
	 * 租户用户表持久化对象 转 租户用户表实体
	 * @param sysTenantUserPOList 租户用户表持久化对象
	 * @return 租户用户表实体
	 */
	List<SysTenantUser> toEntity(List<SysTenantUserPO> sysTenantUserPOList);

	/**
	 * 租户用户表持久化对象 转 租户用户表查询响应数据传输对象
	 * @param sysTenantUserPO 租户用户表持久化对象
	 * @return 租户用户表查询响应数据传输对象
	 */
	SysTenantUserQueryResponse toQueryResponse(SysTenantUserPO sysTenantUserPO);

	/**
	 * 租户用户表持久化对象列表 转 租户用户表查询响应数据传输对象列表
	 * @param sysTenantUserPOList 租户用户表持久化对象列表
	 * @return 租户用户表查询响应数据传输对象列表
	 */
	List<SysTenantUserQueryResponse> toQueryResponse(List<SysTenantUserPO> sysTenantUserPOList);

}
