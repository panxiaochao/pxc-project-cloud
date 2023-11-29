package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.SysLogOperateQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysLogOperate;
import io.github.panxiaochao.system.infrastructure.po.SysLogOperatePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统日志操作表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysLogOperatePOConvert {

	/**
	 * 系统日志操作表持久化对象结构映射实例
	 */
	ISysLogOperatePOConvert INSTANCE = Mappers.getMapper(ISysLogOperatePOConvert.class);

	/**
	 * 系统日志操作表实体 转 系统日志操作表持久化对象
	 * @param sysLogOperate 系统日志操作表实体
	 * @return 系统日志操作表持久化对象
	 */
	SysLogOperatePO fromEntity(SysLogOperate sysLogOperate);

	/**
	 * 系统日志操作表实体 转 系统日志操作表持久化对象
	 * @param sysLogOperateList 系统日志操作表实体
	 * @return 系统日志操作表持久化对象
	 */
	List<SysLogOperatePO> fromEntity(List<SysLogOperate> sysLogOperateList);

	/**
	 * 系统日志操作表持久化对象 转 系统日志操作表实体
	 * @param sysLogOperatePO 系统日志操作表持久化对象
	 * @return 系统日志操作表实体
	 */
	SysLogOperate toEntity(SysLogOperatePO sysLogOperatePO);

	/**
	 * 系统日志操作表持久化对象 转 系统日志操作表实体
	 * @param sysLogOperatePOList 系统日志操作表持久化对象
	 * @return 系统日志操作表实体
	 */
	List<SysLogOperate> toEntity(List<SysLogOperatePO> sysLogOperatePOList);

	/**
	 * 系统日志操作表持久化对象 转 系统日志操作表查询响应数据传输对象
	 * @param sysLogOperatePO 系统日志操作表持久化对象
	 * @return 系统日志操作表查询响应数据传输对象
	 */
	SysLogOperateQueryResponse toQueryResponse(SysLogOperatePO sysLogOperatePO);

	/**
	 * 系统日志操作表持久化对象列表 转 系统日志操作表查询响应数据传输对象列表
	 * @param sysLogOperatePOList 系统日志操作表持久化对象列表
	 * @return 系统日志操作表查询响应数据传输对象列表
	 */
	List<SysLogOperateQueryResponse> toQueryResponse(List<SysLogOperatePO> sysLogOperatePOList);

}
