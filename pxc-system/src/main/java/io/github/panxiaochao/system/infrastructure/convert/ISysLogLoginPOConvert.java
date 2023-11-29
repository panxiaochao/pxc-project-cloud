package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.SysLogLoginQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysLogLogin;
import io.github.panxiaochao.system.infrastructure.po.SysLogLoginPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统日志登录/登出表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysLogLoginPOConvert {

	/**
	 * 系统日志登录/登出表持久化对象结构映射实例
	 */
	ISysLogLoginPOConvert INSTANCE = Mappers.getMapper(ISysLogLoginPOConvert.class);

	/**
	 * 系统日志登录/登出表实体 转 系统日志登录/登出表持久化对象
	 * @param sysLogLogin 系统日志登录/登出表实体
	 * @return 系统日志登录/登出表持久化对象
	 */
	SysLogLoginPO fromEntity(SysLogLogin sysLogLogin);

	/**
	 * 系统日志登录/登出表实体 转 系统日志登录/登出表持久化对象
	 * @param sysLogLoginList 系统日志登录/登出表实体
	 * @return 系统日志登录/登出表持久化对象
	 */
	List<SysLogLoginPO> fromEntity(List<SysLogLogin> sysLogLoginList);

	/**
	 * 系统日志登录/登出表持久化对象 转 系统日志登录/登出表实体
	 * @param sysLogLoginPO 系统日志登录/登出表持久化对象
	 * @return 系统日志登录/登出表实体
	 */
	SysLogLogin toEntity(SysLogLoginPO sysLogLoginPO);

	/**
	 * 系统日志登录/登出表持久化对象 转 系统日志登录/登出表实体
	 * @param sysLogLoginPOList 系统日志登录/登出表持久化对象
	 * @return 系统日志登录/登出表实体
	 */
	List<SysLogLogin> toEntity(List<SysLogLoginPO> sysLogLoginPOList);

	/**
	 * 系统日志登录/登出表持久化对象 转 系统日志登录/登出表查询响应数据传输对象
	 * @param sysLogLoginPO 系统日志登录/登出表持久化对象
	 * @return 系统日志登录/登出表查询响应数据传输对象
	 */
	SysLogLoginQueryResponse toQueryResponse(SysLogLoginPO sysLogLoginPO);

	/**
	 * 系统日志登录/登出表持久化对象列表 转 系统日志登录/登出表查询响应数据传输对象列表
	 * @param sysLogLoginPOList 系统日志登录/登出表持久化对象列表
	 * @return 系统日志登录/登出表查询响应数据传输对象列表
	 */
	List<SysLogLoginQueryResponse> toQueryResponse(List<SysLogLoginPO> sysLogLoginPOList);

}
