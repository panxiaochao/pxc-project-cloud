package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysRoleResponse;
import io.github.panxiaochao.system.domain.entity.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 角色表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysRoleDTOConvert {

	/**
	 * 角色表数据传输对象结构映射实例
	 */
	ISysRoleDTOConvert INSTANCE = Mappers.getMapper(ISysRoleDTOConvert.class);

	/**
	 * 角色表创建请求数据传输对象 转 角色表实体
	 * @param createRequest 角色表创建请求数据传输对象
	 * @return 角色表实体
	 */
	SysRole fromCreateRequest(SysRoleCreateRequest createRequest);

	/**
	 * 角色表更新请求数据传输对象 转 角色表实体
	 * @param updateRequest 角色表更新请求数据传输对象
	 * @return 角色表实体
	 */
	SysRole fromUpdateRequest(SysRoleUpdateRequest updateRequest);

	/**
	 * 角色表查询请求数据传输对象 转 角色表实体
	 * @param queryRequest 角色表查询请求数据传输对象
	 * @return 角色表实体
	 */
	SysRole fromQueryRequest(SysRoleQueryRequest queryRequest);

	/**
	 * 角色表实体 转 角色表响应数据传输对象
	 * @param sysRole 角色表实体
	 * @return 角色表响应数据传输对象
	 */
	SysRoleResponse toResponse(SysRole sysRole);

	/**
	 * 角色表实体 转 角色表查询响应数据传输对象
	 * @param sysRole 角色表实体
	 * @return 角色表查询响应数据传输对象
	 */
	SysRoleQueryResponse toQueryResponse(SysRole sysRole);

	/**
	 * 角色表实体列表 转 角色表查询响应数据传输对象列表
	 * @param sysRoleList 角色表实体列表
	 * @return 角色表查询响应数据传输对象列表
	 */
	List<SysRoleQueryResponse> toQueryResponse(List<SysRole> sysRoleList);

}
