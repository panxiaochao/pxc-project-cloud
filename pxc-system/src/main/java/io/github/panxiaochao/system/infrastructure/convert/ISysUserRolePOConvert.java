package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.SysUserRoleQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysUserRole;
import io.github.panxiaochao.system.infrastructure.po.SysUserRolePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户角色表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysUserRolePOConvert {

	/**
	 * 用户角色表持久化对象结构映射实例
	 */
	ISysUserRolePOConvert INSTANCE = Mappers.getMapper(ISysUserRolePOConvert.class);

	/**
	 * 用户角色表实体 转 用户角色表持久化对象
	 * @param sysUserRole 用户角色表实体
	 * @return 用户角色表持久化对象
	 */
	SysUserRolePO fromEntity(SysUserRole sysUserRole);

	/**
	 * 用户角色表实体 转 用户角色表持久化对象
	 * @param sysUserRoleList 用户角色表实体
	 * @return 用户角色表持久化对象
	 */
	List<SysUserRolePO> fromEntity(List<SysUserRole> sysUserRoleList);

	/**
	 * 用户角色表持久化对象 转 用户角色表实体
	 * @param sysUserRolePO 用户角色表持久化对象
	 * @return 用户角色表实体
	 */
	SysUserRole toEntity(SysUserRolePO sysUserRolePO);

	/**
	 * 用户角色表持久化对象 转 用户角色表实体
	 * @param sysUserRolePOList 用户角色表持久化对象
	 * @return 用户角色表实体
	 */
	List<SysUserRole> toEntity(List<SysUserRolePO> sysUserRolePOList);

	/**
	 * 用户角色表持久化对象 转 用户角色表查询响应数据传输对象
	 * @param sysUserRolePO 用户角色表持久化对象
	 * @return 用户角色表查询响应数据传输对象
	 */
	SysUserRoleQueryResponse toQueryResponse(SysUserRolePO sysUserRolePO);

	/**
	 * 用户角色表持久化对象列表 转 用户角色表查询响应数据传输对象列表
	 * @param sysUserRolePOList 用户角色表持久化对象列表
	 * @return 用户角色表查询响应数据传输对象列表
	 */
	List<SysUserRoleQueryResponse> toQueryResponse(List<SysUserRolePO> sysUserRolePOList);

}
