package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysLogOperateCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysLogOperateQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysLogOperateUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysLogOperateQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysLogOperateResponse;
import io.github.panxiaochao.system.domain.entity.SysLogOperate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统日志操作表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysLogOperateDTOConvert {

	/**
	 * 系统日志操作表数据传输对象结构映射实例
	 */
	ISysLogOperateDTOConvert INSTANCE = Mappers.getMapper(ISysLogOperateDTOConvert.class);

	/**
	 * 系统日志操作表创建请求数据传输对象 转 系统日志操作表实体
	 * @param createRequest 系统日志操作表创建请求数据传输对象
	 * @return 系统日志操作表实体
	 */
	SysLogOperate fromCreateRequest(SysLogOperateCreateRequest createRequest);

	/**
	 * 系统日志操作表更新请求数据传输对象 转 系统日志操作表实体
	 * @param updateRequest 系统日志操作表更新请求数据传输对象
	 * @return 系统日志操作表实体
	 */
	SysLogOperate fromUpdateRequest(SysLogOperateUpdateRequest updateRequest);

	/**
	 * 系统日志操作表查询请求数据传输对象 转 系统日志操作表实体
	 * @param queryRequest 系统日志操作表查询请求数据传输对象
	 * @return 系统日志操作表实体
	 */
	SysLogOperate fromQueryRequest(SysLogOperateQueryRequest queryRequest);

	/**
	 * 系统日志操作表实体 转 系统日志操作表响应数据传输对象
	 * @param sysLogOperate 系统日志操作表实体
	 * @return 系统日志操作表响应数据传输对象
	 */
	SysLogOperateResponse toResponse(SysLogOperate sysLogOperate);

	/**
	 * 系统日志操作表实体 转 系统日志操作表查询响应数据传输对象
	 * @param sysLogOperate 系统日志操作表实体
	 * @return 系统日志操作表查询响应数据传输对象
	 */
	SysLogOperateQueryResponse toQueryResponse(SysLogOperate sysLogOperate);

	/**
	 * 系统日志操作表实体列表 转 系统日志操作表查询响应数据传输对象列表
	 * @param sysLogOperateList 系统日志操作表实体列表
	 * @return 系统日志操作表查询响应数据传输对象列表
	 */
	List<SysLogOperateQueryResponse> toQueryResponse(List<SysLogOperate> sysLogOperateList);
}
