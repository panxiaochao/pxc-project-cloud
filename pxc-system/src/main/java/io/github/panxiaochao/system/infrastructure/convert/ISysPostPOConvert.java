package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.syspost.SysPostQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysPost;
import io.github.panxiaochao.system.infrastructure.po.SysPostPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 岗位表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysPostPOConvert {

	/**
	 * 岗位表持久化对象结构映射实例
	 */
	ISysPostPOConvert INSTANCE = Mappers.getMapper(ISysPostPOConvert.class);

	/**
	 * 岗位表实体 转 岗位表持久化对象
	 * @param sysPost 岗位表实体
	 * @return 岗位表持久化对象
	 */
	SysPostPO fromEntity(SysPost sysPost);

	/**
	 * 岗位表实体 转 岗位表持久化对象
	 * @param sysPostList 岗位表实体
	 * @return 岗位表持久化对象
	 */
	List<SysPostPO> fromEntity(List<SysPost> sysPostList);

	/**
	 * 岗位表持久化对象 转 岗位表实体
	 * @param sysPostPO 岗位表持久化对象
	 * @return 岗位表实体
	 */
	SysPost toEntity(SysPostPO sysPostPO);

	/**
	 * 岗位表持久化对象 转 岗位表实体
	 * @param sysPostPOList 岗位表持久化对象
	 * @return 岗位表实体
	 */
	List<SysPost> toEntity(List<SysPostPO> sysPostPOList);

	/**
	 * 岗位表持久化对象 转 岗位表查询响应数据传输对象
	 * @param sysPostPO 岗位表持久化对象
	 * @return 岗位表查询响应数据传输对象
	 */
	SysPostQueryResponse toQueryResponse(SysPostPO sysPostPO);

	/**
	 * 岗位表持久化对象列表 转 岗位表查询响应数据传输对象列表
	 * @param sysPostPOList 岗位表持久化对象列表
	 * @return 岗位表查询响应数据传输对象列表
	 */
	List<SysPostQueryResponse> toQueryResponse(List<SysPostPO> sysPostPOList);

}
