package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysuserauths.SysUserAuthsQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuserauths.SysUserAuthsResponse;
import io.github.panxiaochao.system.domain.entity.SysUserAuths;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户授权信息表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysUserAuthsDTOConvert {

	/**
	 * 用户授权信息表数据传输对象结构映射实例
	 */
	ISysUserAuthsDTOConvert INSTANCE = Mappers.getMapper(ISysUserAuthsDTOConvert.class);

	/**
	 * 用户授权信息表创建请求数据传输对象 转 用户授权信息表实体
	 * @param createRequest 用户授权信息表创建请求数据传输对象
	 * @return 用户授权信息表实体
	 */
	SysUserAuths fromCreateRequest(SysUserAuthsCreateRequest createRequest);

	/**
	 * 用户授权信息表更新请求数据传输对象 转 用户授权信息表实体
	 * @param updateRequest 用户授权信息表更新请求数据传输对象
	 * @return 用户授权信息表实体
	 */
	SysUserAuths fromUpdateRequest(SysUserAuthsUpdateRequest updateRequest);

	/**
	 * 用户授权信息表查询请求数据传输对象 转 用户授权信息表实体
	 * @param queryRequest 用户授权信息表查询请求数据传输对象
	 * @return 用户授权信息表实体
	 */
	SysUserAuths fromQueryRequest(SysUserAuthsQueryRequest queryRequest);

	/**
	 * 用户授权信息表实体 转 用户授权信息表响应数据传输对象
	 * @param sysUserAuths 用户授权信息表实体
	 * @return 用户授权信息表响应数据传输对象
	 */
	SysUserAuthsResponse toResponse(SysUserAuths sysUserAuths);

	/**
	 * 用户授权信息表实体 转 用户授权信息表查询响应数据传输对象
	 * @param sysUserAuths 用户授权信息表实体
	 * @return 用户授权信息表查询响应数据传输对象
	 */
	SysUserAuthsQueryResponse toQueryResponse(SysUserAuths sysUserAuths);

	/**
	 * 用户授权信息表实体列表 转 用户授权信息表查询响应数据传输对象列表
	 * @param sysUserAuthsList 用户授权信息表实体列表
	 * @return 用户授权信息表查询响应数据传输对象列表
	 */
	List<SysUserAuthsQueryResponse> toQueryResponse(List<SysUserAuths> sysUserAuthsList);

}
