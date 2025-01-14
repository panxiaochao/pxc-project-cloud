package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.sysloglogin.SysLogLoginCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysloglogin.SysLogLoginQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysloglogin.SysLogLoginUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysloglogin.SysLogLoginQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysloglogin.SysLogLoginResponse;
import io.github.panxiaochao.system.domain.entity.SysLogLogin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统日志登录/登出表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysLogLoginDTOConvert {

	/**
	 * 系统日志登录/登出表数据传输对象结构映射实例
	 */
	ISysLogLoginDTOConvert INSTANCE = Mappers.getMapper(ISysLogLoginDTOConvert.class);

	/**
	 * 系统日志登录/登出表创建请求数据传输对象 转 系统日志登录/登出表实体
	 * @param createRequest 系统日志登录/登出表创建请求数据传输对象
	 * @return 系统日志登录/登出表实体
	 */
	SysLogLogin fromCreateRequest(SysLogLoginCreateRequest createRequest);

	/**
	 * 系统日志登录/登出表更新请求数据传输对象 转 系统日志登录/登出表实体
	 * @param updateRequest 系统日志登录/登出表更新请求数据传输对象
	 * @return 系统日志登录/登出表实体
	 */
	SysLogLogin fromUpdateRequest(SysLogLoginUpdateRequest updateRequest);

	/**
	 * 系统日志登录/登出表查询请求数据传输对象 转 系统日志登录/登出表实体
	 * @param queryRequest 系统日志登录/登出表查询请求数据传输对象
	 * @return 系统日志登录/登出表实体
	 */
	SysLogLogin fromQueryRequest(SysLogLoginQueryRequest queryRequest);

	/**
	 * 系统日志登录/登出表实体 转 系统日志登录/登出表响应数据传输对象
	 * @param sysLogLogin 系统日志登录/登出表实体
	 * @return 系统日志登录/登出表响应数据传输对象
	 */
	SysLogLoginResponse toResponse(SysLogLogin sysLogLogin);

	/**
	 * 系统日志登录/登出表实体 转 系统日志登录/登出表查询响应数据传输对象
	 * @param sysLogLogin 系统日志登录/登出表实体
	 * @return 系统日志登录/登出表查询响应数据传输对象
	 */
	SysLogLoginQueryResponse toQueryResponse(SysLogLogin sysLogLogin);

	/**
	 * 系统日志登录/登出表实体列表 转 系统日志登录/登出表查询响应数据传输对象列表
	 * @param sysLogLoginList 系统日志登录/登出表实体列表
	 * @return 系统日志登录/登出表查询响应数据传输对象列表
	 */
	List<SysLogLoginQueryResponse> toQueryResponse(List<SysLogLogin> sysLogLoginList);

}
