package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.systenant.SysTenantQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysTenant;
import io.github.panxiaochao.system.infrastructure.po.SysTenantPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 租户表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Mapper
public interface ISysTenantPOConvert {

	/**
	 * 租户表持久化对象结构映射实例
	 */
	ISysTenantPOConvert INSTANCE = Mappers.getMapper(ISysTenantPOConvert.class);

	/**
	 * 租户表实体 转 租户表持久化对象
	 * @param sysTenant 租户表实体
	 * @return 租户表持久化对象
	 */
	SysTenantPO fromEntity(SysTenant sysTenant);

	/**
	 * 租户表实体 转 租户表持久化对象
	 * @param sysTenantList 租户表实体
	 * @return 租户表持久化对象
	 */
	List<SysTenantPO> fromEntity(List<SysTenant> sysTenantList);

	/**
	 * 租户表持久化对象 转 租户表实体
	 * @param sysTenantPO 租户表持久化对象
	 * @return 租户表实体
	 */
	SysTenant toEntity(SysTenantPO sysTenantPO);

	/**
	 * 租户表持久化对象 转 租户表实体
	 * @param sysTenantPOList 租户表持久化对象
	 * @return 租户表实体
	 */
	List<SysTenant> toEntity(List<SysTenantPO> sysTenantPOList);

	/**
	 * 租户表持久化对象 转 租户表查询响应数据传输对象
	 * @param sysTenantPO 租户表持久化对象
	 * @return 租户表查询响应数据传输对象
	 */
	SysTenantQueryResponse toQueryResponse(SysTenantPO sysTenantPO);

	/**
	 * 租户表持久化对象列表 转 租户表查询响应数据传输对象列表
	 * @param sysTenantPOList 租户表持久化对象列表
	 * @return 租户表查询响应数据传输对象列表
	 */
	List<SysTenantQueryResponse> toQueryResponse(List<SysTenantPO> sysTenantPOList);

}
