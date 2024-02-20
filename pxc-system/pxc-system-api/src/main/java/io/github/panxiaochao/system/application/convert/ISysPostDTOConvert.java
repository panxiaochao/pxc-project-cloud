package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.syspost.SysPostCreateRequest;
import io.github.panxiaochao.system.application.api.request.syspost.SysPostQueryRequest;
import io.github.panxiaochao.system.application.api.request.syspost.SysPostUpdateRequest;
import io.github.panxiaochao.system.application.api.response.syspost.SysPostQueryResponse;
import io.github.panxiaochao.system.application.api.response.syspost.SysPostResponse;
import io.github.panxiaochao.system.domain.entity.SysPost;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 岗位表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysPostDTOConvert {

	/**
	 * 岗位表数据传输对象结构映射实例
	 */
	ISysPostDTOConvert INSTANCE = Mappers.getMapper(ISysPostDTOConvert.class);

	/**
	 * 岗位表创建请求数据传输对象 转 岗位表实体
	 * @param createRequest 岗位表创建请求数据传输对象
	 * @return 岗位表实体
	 */
	SysPost fromCreateRequest(SysPostCreateRequest createRequest);

	/**
	 * 岗位表更新请求数据传输对象 转 岗位表实体
	 * @param updateRequest 岗位表更新请求数据传输对象
	 * @return 岗位表实体
	 */
	SysPost fromUpdateRequest(SysPostUpdateRequest updateRequest);

	/**
	 * 岗位表查询请求数据传输对象 转 岗位表实体
	 * @param queryRequest 岗位表查询请求数据传输对象
	 * @return 岗位表实体
	 */
	SysPost fromQueryRequest(SysPostQueryRequest queryRequest);

	/**
	 * 岗位表实体 转 岗位表响应数据传输对象
	 * @param sysPost 岗位表实体
	 * @return 岗位表响应数据传输对象
	 */
	SysPostResponse toResponse(SysPost sysPost);

	/**
	 * 岗位表实体 转 岗位表查询响应数据传输对象
	 * @param sysPost 岗位表实体
	 * @return 岗位表查询响应数据传输对象
	 */
	SysPostQueryResponse toQueryResponse(SysPost sysPost);

	/**
	 * 岗位表实体列表 转 岗位表查询响应数据传输对象列表
	 * @param sysPostList 岗位表实体列表
	 * @return 岗位表查询响应数据传输对象列表
	 */
	List<SysPostQueryResponse> toQueryResponse(List<SysPost> sysPostList);

}
