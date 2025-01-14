package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.sysrole.SysRoleQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysRole;
import io.github.panxiaochao.system.infrastructure.po.SysRolePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 角色表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface ISysRolePOConvert {

	/**
	 * 角色表持久化对象结构映射实例
	 */
	ISysRolePOConvert INSTANCE = Mappers.getMapper(ISysRolePOConvert.class);

	/**
	 * 角色表实体 转 角色表持久化对象
	 * @param sysRole 角色表实体
	 * @return 角色表持久化对象
	 */
	SysRolePO fromEntity(SysRole sysRole);

	/**
	 * 角色表实体 转 角色表持久化对象
	 * @param sysRoleList 角色表实体
	 * @return 角色表持久化对象
	 */
	List<SysRolePO> fromEntity(List<SysRole> sysRoleList);

	/**
	 * 角色表持久化对象 转 角色表实体
	 * @param sysRolePO 角色表持久化对象
	 * @return 角色表实体
	 */
	SysRole toEntity(SysRolePO sysRolePO);

	/**
	 * 角色表持久化对象 转 角色表实体
	 * @param sysRolePOList 角色表持久化对象
	 * @return 角色表实体
	 */
	List<SysRole> toEntity(List<SysRolePO> sysRolePOList);

	/**
	 * 角色表持久化对象 转 角色表查询响应数据传输对象
	 * @param sysRolePO 角色表持久化对象
	 * @return 角色表查询响应数据传输对象
	 */
	SysRoleQueryResponse toQueryResponse(SysRolePO sysRolePO);

	/**
	 * 角色表持久化对象列表 转 角色表查询响应数据传输对象列表
	 * @param sysRolePOList 角色表持久化对象列表
	 * @return 角色表查询响应数据传输对象列表
	 */
	List<SysRoleQueryResponse> toQueryResponse(List<SysRolePO> sysRolePOList);

}
