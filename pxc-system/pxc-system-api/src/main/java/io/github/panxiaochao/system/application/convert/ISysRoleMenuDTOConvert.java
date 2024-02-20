package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuResponse;
import io.github.panxiaochao.system.domain.entity.SysRoleMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 角色菜单表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface ISysRoleMenuDTOConvert {

	/**
	 * 角色菜单表数据传输对象结构映射实例
	 */
	ISysRoleMenuDTOConvert INSTANCE = Mappers.getMapper(ISysRoleMenuDTOConvert.class);

	/**
	 * 角色菜单表创建请求数据传输对象 转 角色菜单表实体
	 * @param createRequest 角色菜单表创建请求数据传输对象
	 * @return 角色菜单表实体
	 */
	SysRoleMenu fromCreateRequest(SysRoleMenuCreateRequest createRequest);

	/**
	 * 角色菜单表更新请求数据传输对象 转 角色菜单表实体
	 * @param updateRequest 角色菜单表更新请求数据传输对象
	 * @return 角色菜单表实体
	 */
	SysRoleMenu fromUpdateRequest(SysRoleMenuUpdateRequest updateRequest);

	/**
	 * 角色菜单表查询请求数据传输对象 转 角色菜单表实体
	 * @param queryRequest 角色菜单表查询请求数据传输对象
	 * @return 角色菜单表实体
	 */
	SysRoleMenu fromQueryRequest(SysRoleMenuQueryRequest queryRequest);

	/**
	 * 角色菜单表实体 转 角色菜单表响应数据传输对象
	 * @param sysRoleMenu 角色菜单表实体
	 * @return 角色菜单表响应数据传输对象
	 */
	SysRoleMenuResponse toResponse(SysRoleMenu sysRoleMenu);

	/**
	 * 角色菜单表实体 转 角色菜单表查询响应数据传输对象
	 * @param sysRoleMenu 角色菜单表实体
	 * @return 角色菜单表查询响应数据传输对象
	 */
	SysRoleMenuQueryResponse toQueryResponse(SysRoleMenu sysRoleMenu);

	/**
	 * 角色菜单表实体列表 转 角色菜单表查询响应数据传输对象列表
	 * @param sysRoleMenuList 角色菜单表实体列表
	 * @return 角色菜单表查询响应数据传输对象列表
	 */
	List<SysRoleMenuQueryResponse> toQueryResponse(List<SysRoleMenu> sysRoleMenuList);

}
