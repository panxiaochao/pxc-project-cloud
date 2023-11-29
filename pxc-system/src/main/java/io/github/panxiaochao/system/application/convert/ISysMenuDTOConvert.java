package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysMenuResponse;
import io.github.panxiaochao.system.domain.entity.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 菜单配置数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysMenuDTOConvert {

	/**
	 * 菜单配置数据传输对象结构映射实例
	 */
	ISysMenuDTOConvert INSTANCE = Mappers.getMapper(ISysMenuDTOConvert.class);

	/**
	 * 菜单配置创建请求数据传输对象 转 菜单配置实体
	 * @param createRequest 菜单配置创建请求数据传输对象
	 * @return 菜单配置实体
	 */
	SysMenu fromCreateRequest(SysMenuCreateRequest createRequest);

	/**
	 * 菜单配置更新请求数据传输对象 转 菜单配置实体
	 * @param updateRequest 菜单配置更新请求数据传输对象
	 * @return 菜单配置实体
	 */
	SysMenu fromUpdateRequest(SysMenuUpdateRequest updateRequest);

	/**
	 * 菜单配置查询请求数据传输对象 转 菜单配置实体
	 * @param queryRequest 菜单配置查询请求数据传输对象
	 * @return 菜单配置实体
	 */
	SysMenu fromQueryRequest(SysMenuQueryRequest queryRequest);

	/**
	 * 菜单配置实体 转 菜单配置响应数据传输对象
	 * @param sysMenu 菜单配置实体
	 * @return 菜单配置响应数据传输对象
	 */
	SysMenuResponse toResponse(SysMenu sysMenu);

	/**
	 * 菜单配置实体 转 菜单配置查询响应数据传输对象
	 * @param sysMenu 菜单配置实体
	 * @return 菜单配置查询响应数据传输对象
	 */
	SysMenuQueryResponse toQueryResponse(SysMenu sysMenu);

	/**
	 * 菜单配置实体列表 转 菜单配置查询响应数据传输对象列表
	 * @param sysMenuList 菜单配置实体列表
	 * @return 菜单配置查询响应数据传输对象列表
	 */
	List<SysMenuQueryResponse> toQueryResponse(List<SysMenu> sysMenuList);

}
