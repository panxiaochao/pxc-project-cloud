package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.sysuser.SysUserCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserResponse;
import io.github.panxiaochao.system.domain.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysUserDTOConvert {

	/**
	 * 用户表数据传输对象结构映射实例
	 */
	ISysUserDTOConvert INSTANCE = Mappers.getMapper(ISysUserDTOConvert.class);

	/**
	 * 用户表创建请求数据传输对象 转 用户表实体
	 * @param createRequest 用户表创建请求数据传输对象
	 * @return 用户表实体
	 */
	SysUser fromCreateRequest(SysUserCreateRequest createRequest);

	/**
	 * 用户表更新请求数据传输对象 转 用户表实体
	 * @param updateRequest 用户表更新请求数据传输对象
	 * @return 用户表实体
	 */
	SysUser fromUpdateRequest(SysUserUpdateRequest updateRequest);

	/**
	 * 用户表查询请求数据传输对象 转 用户表实体
	 * @param queryRequest 用户表查询请求数据传输对象
	 * @return 用户表实体
	 */
	SysUser fromQueryRequest(SysUserQueryRequest queryRequest);

	/**
	 * 用户表实体 转 用户表响应数据传输对象
	 * @param sysUser 用户表实体
	 * @return 用户表响应数据传输对象
	 */
	SysUserResponse toResponse(SysUser sysUser);

	/**
	 * 用户表实体 转 用户表查询响应数据传输对象
	 * @param sysUser 用户表实体
	 * @return 用户表查询响应数据传输对象
	 */
	SysUserQueryResponse toQueryResponse(SysUser sysUser);

	/**
	 * 用户表实体列表 转 用户表查询响应数据传输对象列表
	 * @param sysUserList 用户表实体列表
	 * @return 用户表查询响应数据传输对象列表
	 */
	List<SysUserQueryResponse> toQueryResponse(List<SysUser> sysUserList);

}
