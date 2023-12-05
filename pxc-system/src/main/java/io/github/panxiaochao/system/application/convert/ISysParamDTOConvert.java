package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.sysparam.SysParamCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamResponse;
import io.github.panxiaochao.system.domain.entity.SysParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统参数数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysParamDTOConvert {

	/**
	 * 系统参数数据传输对象结构映射实例
	 */
	ISysParamDTOConvert INSTANCE = Mappers.getMapper(ISysParamDTOConvert.class);

	/**
	 * 系统参数创建请求数据传输对象 转 系统参数实体
	 * @param createRequest 系统参数创建请求数据传输对象
	 * @return 系统参数实体
	 */
	SysParam fromCreateRequest(SysParamCreateRequest createRequest);

	/**
	 * 系统参数更新请求数据传输对象 转 系统参数实体
	 * @param updateRequest 系统参数更新请求数据传输对象
	 * @return 系统参数实体
	 */
	SysParam fromUpdateRequest(SysParamUpdateRequest updateRequest);

	/**
	 * 系统参数查询请求数据传输对象 转 系统参数实体
	 * @param queryRequest 系统参数查询请求数据传输对象
	 * @return 系统参数实体
	 */
	SysParam fromQueryRequest(SysParamQueryRequest queryRequest);

	/**
	 * 系统参数实体 转 系统参数响应数据传输对象
	 * @param sysParam 系统参数实体
	 * @return 系统参数响应数据传输对象
	 */
	SysParamResponse toResponse(SysParam sysParam);

	/**
	 * 系统参数实体 转 系统参数查询响应数据传输对象
	 * @param sysParam 系统参数实体
	 * @return 系统参数查询响应数据传输对象
	 */
	SysParamQueryResponse toQueryResponse(SysParam sysParam);

	/**
	 * 系统参数实体列表 转 系统参数查询响应数据传输对象列表
	 * @param sysParamList 系统参数实体列表
	 * @return 系统参数查询响应数据传输对象列表
	 */
	List<SysParamQueryResponse> toQueryResponse(List<SysParam> sysParamList);
}
