package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysMenu;
import io.github.panxiaochao.system.infrastructure.po.SysMenuPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 菜单配置持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysMenuPOConvert {

	/**
	 * 菜单配置持久化对象结构映射实例
	 */
	ISysMenuPOConvert INSTANCE = Mappers.getMapper(ISysMenuPOConvert.class);

	/**
	 * 菜单配置实体 转 菜单配置持久化对象
	 * @param sysMenu 菜单配置实体
	 * @return 菜单配置持久化对象
	 */
	SysMenuPO fromEntity(SysMenu sysMenu);

	/**
	 * 菜单配置实体 转 菜单配置持久化对象
	 * @param sysMenuList 菜单配置实体
	 * @return 菜单配置持久化对象
	 */
	List<SysMenuPO> fromEntity(List<SysMenu> sysMenuList);

	/**
	 * 菜单配置持久化对象 转 菜单配置实体
	 * @param sysMenuPO 菜单配置持久化对象
	 * @return 菜单配置实体
	 */
	SysMenu toEntity(SysMenuPO sysMenuPO);

	/**
	 * 菜单配置持久化对象 转 菜单配置实体
	 * @param sysMenuPOList 菜单配置持久化对象
	 * @return 菜单配置实体
	 */
	List<SysMenu> toEntity(List<SysMenuPO> sysMenuPOList);

	/**
	 * 菜单配置持久化对象 转 菜单配置查询响应数据传输对象
	 * @param sysMenuPO 菜单配置持久化对象
	 * @return 菜单配置查询响应数据传输对象
	 */
	SysMenuQueryResponse toQueryResponse(SysMenuPO sysMenuPO);

	/**
	 * 菜单配置持久化对象列表 转 菜单配置查询响应数据传输对象列表
	 * @param sysMenuPOList 菜单配置持久化对象列表
	 * @return 菜单配置查询响应数据传输对象列表
	 */
	List<SysMenuQueryResponse> toQueryResponse(List<SysMenuPO> sysMenuPOList);

}
