package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.SysOrgQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysOrg;
import io.github.panxiaochao.system.infrastructure.po.SysOrgPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 机构部门表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysOrgPOConvert {

	/**
	 * 机构部门表持久化对象结构映射实例
	 */
	ISysOrgPOConvert INSTANCE = Mappers.getMapper(ISysOrgPOConvert.class);

	/**
	 * 机构部门表实体 转 机构部门表持久化对象
	 * @param sysOrg 机构部门表实体
	 * @return 机构部门表持久化对象
	 */
	SysOrgPO fromEntity(SysOrg sysOrg);

	/**
	 * 机构部门表实体 转 机构部门表持久化对象
	 * @param sysOrgList 机构部门表实体
	 * @return 机构部门表持久化对象
	 */
	List<SysOrgPO> fromEntity(List<SysOrg> sysOrgList);

	/**
	 * 机构部门表持久化对象 转 机构部门表实体
	 * @param sysOrgPO 机构部门表持久化对象
	 * @return 机构部门表实体
	 */
	SysOrg toEntity(SysOrgPO sysOrgPO);

	/**
	 * 机构部门表持久化对象 转 机构部门表实体
	 * @param sysOrgPOList 机构部门表持久化对象
	 * @return 机构部门表实体
	 */
	List<SysOrg> toEntity(List<SysOrgPO> sysOrgPOList);

	/**
	 * 机构部门表持久化对象 转 机构部门表查询响应数据传输对象
	 * @param sysOrgPO 机构部门表持久化对象
	 * @return 机构部门表查询响应数据传输对象
	 */
	SysOrgQueryResponse toQueryResponse(SysOrgPO sysOrgPO);

	/**
	 * 机构部门表持久化对象列表 转 机构部门表查询响应数据传输对象列表
	 * @param sysOrgPOList 机构部门表持久化对象列表
	 * @return 机构部门表查询响应数据传输对象列表
	 */
	List<SysOrgQueryResponse> toQueryResponse(List<SysOrgPO> sysOrgPOList);
}
