package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.SysUserQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysUser;
import io.github.panxiaochao.system.infrastructure.po.SysUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysUserPOConvert {

	/**
	 * 用户表持久化对象结构映射实例
	 */
	ISysUserPOConvert INSTANCE = Mappers.getMapper(ISysUserPOConvert.class);

	/**
	 * 用户表实体 转 用户表持久化对象
	 * @param sysUser 用户表实体
	 * @return 用户表持久化对象
	 */
	SysUserPO fromEntity(SysUser sysUser);

	/**
	 * 用户表实体 转 用户表持久化对象
	 * @param sysUserList 用户表实体
	 * @return 用户表持久化对象
	 */
	List<SysUserPO> fromEntity(List<SysUser> sysUserList);

	/**
	 * 用户表持久化对象 转 用户表实体
	 * @param sysUserPO 用户表持久化对象
	 * @return 用户表实体
	 */
	SysUser toEntity(SysUserPO sysUserPO);

	/**
	 * 用户表持久化对象 转 用户表实体
	 * @param sysUserPOList 用户表持久化对象
	 * @return 用户表实体
	 */
	List<SysUser> toEntity(List<SysUserPO> sysUserPOList);

	/**
	 * 用户表持久化对象 转 用户表查询响应数据传输对象
	 * @param sysUserPO 用户表持久化对象
	 * @return 用户表查询响应数据传输对象
	 */
	SysUserQueryResponse toQueryResponse(SysUserPO sysUserPO);

	/**
	 * 用户表持久化对象列表 转 用户表查询响应数据传输对象列表
	 * @param sysUserPOList 用户表持久化对象列表
	 * @return 用户表查询响应数据传输对象列表
	 */
	List<SysUserQueryResponse> toQueryResponse(List<SysUserPO> sysUserPOList);

}
