package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysRoleMenu;
import io.github.panxiaochao.system.infrastructure.po.SysRoleMenuPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 角色菜单表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface ISysRoleMenuPOConvert {

	/**
	 * 角色菜单表持久化对象结构映射实例
	 */
	ISysRoleMenuPOConvert INSTANCE = Mappers.getMapper(ISysRoleMenuPOConvert.class);

	/**
	 * 角色菜单表实体 转 角色菜单表持久化对象
	 * @param sysRoleMenu 角色菜单表实体
	 * @return 角色菜单表持久化对象
	 */
	SysRoleMenuPO fromEntity(SysRoleMenu sysRoleMenu);

	/**
	 * 角色菜单表实体 转 角色菜单表持久化对象
	 * @param sysRoleMenuList 角色菜单表实体
	 * @return 角色菜单表持久化对象
	 */
	List<SysRoleMenuPO> fromEntity(List<SysRoleMenu> sysRoleMenuList);

	/**
	 * 角色菜单表持久化对象 转 角色菜单表实体
	 * @param sysRoleMenuPO 角色菜单表持久化对象
	 * @return 角色菜单表实体
	 */
	SysRoleMenu toEntity(SysRoleMenuPO sysRoleMenuPO);

	/**
	 * 角色菜单表持久化对象 转 角色菜单表实体
	 * @param sysRoleMenuPOList 角色菜单表持久化对象
	 * @return 角色菜单表实体
	 */
	List<SysRoleMenu> toEntity(List<SysRoleMenuPO> sysRoleMenuPOList);

	/**
	 * 角色菜单表持久化对象 转 角色菜单表查询响应数据传输对象
	 * @param sysRoleMenuPO 角色菜单表持久化对象
	 * @return 角色菜单表查询响应数据传输对象
	 */
	SysRoleMenuQueryResponse toQueryResponse(SysRoleMenuPO sysRoleMenuPO);

	/**
	 * 角色菜单表持久化对象列表 转 角色菜单表查询响应数据传输对象列表
	 * @param sysRoleMenuPOList 角色菜单表持久化对象列表
	 * @return 角色菜单表查询响应数据传输对象列表
	 */
	List<SysRoleMenuQueryResponse> toQueryResponse(List<SysRoleMenuPO> sysRoleMenuPOList);

}
