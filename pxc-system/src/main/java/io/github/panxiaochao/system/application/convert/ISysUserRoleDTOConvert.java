package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysUserRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysUserRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysUserRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysUserRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysUserRoleResponse;
import io.github.panxiaochao.system.domain.entity.SysUserRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户角色表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysUserRoleDTOConvert {

	/**
	 * 用户角色表数据传输对象结构映射实例
	 */
	ISysUserRoleDTOConvert INSTANCE = Mappers.getMapper(ISysUserRoleDTOConvert.class);

	/**
	 * 用户角色表创建请求数据传输对象 转 用户角色表实体
	 * @param createRequest 用户角色表创建请求数据传输对象
	 * @return 用户角色表实体
	 */
	SysUserRole fromCreateRequest(SysUserRoleCreateRequest createRequest);

	/**
	 * 用户角色表更新请求数据传输对象 转 用户角色表实体
	 * @param updateRequest 用户角色表更新请求数据传输对象
	 * @return 用户角色表实体
	 */
	SysUserRole fromUpdateRequest(SysUserRoleUpdateRequest updateRequest);

	/**
	 * 用户角色表查询请求数据传输对象 转 用户角色表实体
	 * @param queryRequest 用户角色表查询请求数据传输对象
	 * @return 用户角色表实体
	 */
	SysUserRole fromQueryRequest(SysUserRoleQueryRequest queryRequest);

	/**
	 * 用户角色表实体 转 用户角色表响应数据传输对象
	 * @param sysUserRole 用户角色表实体
	 * @return 用户角色表响应数据传输对象
	 */
	SysUserRoleResponse toResponse(SysUserRole sysUserRole);

	/**
	 * 用户角色表实体 转 用户角色表查询响应数据传输对象
	 * @param sysUserRole 用户角色表实体
	 * @return 用户角色表查询响应数据传输对象
	 */
	SysUserRoleQueryResponse toQueryResponse(SysUserRole sysUserRole);

	/**
	 * 用户角色表实体列表 转 用户角色表查询响应数据传输对象列表
	 * @param sysUserRoleList 用户角色表实体列表
	 * @return 用户角色表查询响应数据传输对象列表
	 */
	List<SysUserRoleQueryResponse> toQueryResponse(List<SysUserRole> sysUserRoleList);

}
