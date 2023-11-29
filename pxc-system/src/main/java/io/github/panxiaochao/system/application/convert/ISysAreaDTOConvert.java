package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysAreaCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysAreaQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysAreaUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysAreaQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysAreaResponse;
import io.github.panxiaochao.system.domain.entity.SysArea;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 全国5级行政区划数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysAreaDTOConvert {

	/**
	 * 全国5级行政区划数据传输对象结构映射实例
	 */
	ISysAreaDTOConvert INSTANCE = Mappers.getMapper(ISysAreaDTOConvert.class);

	/**
	 * 全国5级行政区划创建请求数据传输对象 转 全国5级行政区划实体
	 * @param createRequest 全国5级行政区划创建请求数据传输对象
	 * @return 全国5级行政区划实体
	 */
	SysArea fromCreateRequest(SysAreaCreateRequest createRequest);

	/**
	 * 全国5级行政区划更新请求数据传输对象 转 全国5级行政区划实体
	 * @param updateRequest 全国5级行政区划更新请求数据传输对象
	 * @return 全国5级行政区划实体
	 */
	SysArea fromUpdateRequest(SysAreaUpdateRequest updateRequest);

	/**
	 * 全国5级行政区划查询请求数据传输对象 转 全国5级行政区划实体
	 * @param queryRequest 全国5级行政区划查询请求数据传输对象
	 * @return 全国5级行政区划实体
	 */
	SysArea fromQueryRequest(SysAreaQueryRequest queryRequest);

	/**
	 * 全国5级行政区划实体 转 全国5级行政区划响应数据传输对象
	 * @param sysArea 全国5级行政区划实体
	 * @return 全国5级行政区划响应数据传输对象
	 */
	SysAreaResponse toResponse(SysArea sysArea);

	/**
	 * 全国5级行政区划实体 转 全国5级行政区划查询响应数据传输对象
	 * @param sysArea 全国5级行政区划实体
	 * @return 全国5级行政区划查询响应数据传输对象
	 */
	SysAreaQueryResponse toQueryResponse(SysArea sysArea);

	/**
	 * 全国5级行政区划实体列表 转 全国5级行政区划查询响应数据传输对象列表
	 * @param sysAreaList 全国5级行政区划实体列表
	 * @return 全国5级行政区划查询响应数据传输对象列表
	 */
	List<SysAreaQueryResponse> toQueryResponse(List<SysArea> sysAreaList);

}
