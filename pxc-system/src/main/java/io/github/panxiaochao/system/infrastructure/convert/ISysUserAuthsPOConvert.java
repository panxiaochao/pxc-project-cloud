package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.SysUserAuthsQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysUserAuths;
import io.github.panxiaochao.system.infrastructure.po.SysUserAuthsPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户授权信息表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysUserAuthsPOConvert {

	/**
	 * 用户授权信息表持久化对象结构映射实例
	 */
	ISysUserAuthsPOConvert INSTANCE = Mappers.getMapper(ISysUserAuthsPOConvert.class);

	/**
	 * 用户授权信息表实体 转 用户授权信息表持久化对象
	 * @param sysUserAuths 用户授权信息表实体
	 * @return 用户授权信息表持久化对象
	 */
	SysUserAuthsPO fromEntity(SysUserAuths sysUserAuths);

	/**
	 * 用户授权信息表实体 转 用户授权信息表持久化对象
	 * @param sysUserAuthsList 用户授权信息表实体
	 * @return 用户授权信息表持久化对象
	 */
	List<SysUserAuthsPO> fromEntity(List<SysUserAuths> sysUserAuthsList);

	/**
	 * 用户授权信息表持久化对象 转 用户授权信息表实体
	 * @param sysUserAuthsPO 用户授权信息表持久化对象
	 * @return 用户授权信息表实体
	 */
	SysUserAuths toEntity(SysUserAuthsPO sysUserAuthsPO);

	/**
	 * 用户授权信息表持久化对象 转 用户授权信息表实体
	 * @param sysUserAuthsPOList 用户授权信息表持久化对象
	 * @return 用户授权信息表实体
	 */
	List<SysUserAuths> toEntity(List<SysUserAuthsPO> sysUserAuthsPOList);

	/**
	 * 用户授权信息表持久化对象 转 用户授权信息表查询响应数据传输对象
	 * @param sysUserAuthsPO 用户授权信息表持久化对象
	 * @return 用户授权信息表查询响应数据传输对象
	 */
	SysUserAuthsQueryResponse toQueryResponse(SysUserAuthsPO sysUserAuthsPO);

	/**
	 * 用户授权信息表持久化对象列表 转 用户授权信息表查询响应数据传输对象列表
	 * @param sysUserAuthsPOList 用户授权信息表持久化对象列表
	 * @return 用户授权信息表查询响应数据传输对象列表
	 */
	List<SysUserAuthsQueryResponse> toQueryResponse(List<SysUserAuthsPO> sysUserAuthsPOList);

}
