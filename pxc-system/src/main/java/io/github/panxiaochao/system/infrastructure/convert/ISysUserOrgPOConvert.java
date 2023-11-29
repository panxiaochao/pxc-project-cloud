package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.SysUserOrgQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysUserOrg;
import io.github.panxiaochao.system.infrastructure.po.SysUserOrgPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户机构/部门表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysUserOrgPOConvert {

	/**
	 * 用户机构/部门表持久化对象结构映射实例
	 */
	ISysUserOrgPOConvert INSTANCE = Mappers.getMapper(ISysUserOrgPOConvert.class);

	/**
	 * 用户机构/部门表实体 转 用户机构/部门表持久化对象
	 * @param sysUserOrg 用户机构/部门表实体
	 * @return 用户机构/部门表持久化对象
	 */
	SysUserOrgPO fromEntity(SysUserOrg sysUserOrg);

	/**
	 * 用户机构/部门表实体 转 用户机构/部门表持久化对象
	 * @param sysUserOrgList 用户机构/部门表实体
	 * @return 用户机构/部门表持久化对象
	 */
	List<SysUserOrgPO> fromEntity(List<SysUserOrg> sysUserOrgList);

	/**
	 * 用户机构/部门表持久化对象 转 用户机构/部门表实体
	 * @param sysUserOrgPO 用户机构/部门表持久化对象
	 * @return 用户机构/部门表实体
	 */
	SysUserOrg toEntity(SysUserOrgPO sysUserOrgPO);

	/**
	 * 用户机构/部门表持久化对象 转 用户机构/部门表实体
	 * @param sysUserOrgPOList 用户机构/部门表持久化对象
	 * @return 用户机构/部门表实体
	 */
	List<SysUserOrg> toEntity(List<SysUserOrgPO> sysUserOrgPOList);

	/**
	 * 用户机构/部门表持久化对象 转 用户机构/部门表查询响应数据传输对象
	 * @param sysUserOrgPO 用户机构/部门表持久化对象
	 * @return 用户机构/部门表查询响应数据传输对象
	 */
	SysUserOrgQueryResponse toQueryResponse(SysUserOrgPO sysUserOrgPO);

	/**
	 * 用户机构/部门表持久化对象列表 转 用户机构/部门表查询响应数据传输对象列表
	 * @param sysUserOrgPOList 用户机构/部门表持久化对象列表
	 * @return 用户机构/部门表查询响应数据传输对象列表
	 */
	List<SysUserOrgQueryResponse> toQueryResponse(List<SysUserOrgPO> sysUserOrgPOList);

}
