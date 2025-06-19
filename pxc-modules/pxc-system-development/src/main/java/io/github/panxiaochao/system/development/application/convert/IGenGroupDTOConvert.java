package io.github.panxiaochao.system.development.application.convert;

import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupResponse;
import io.github.panxiaochao.system.development.domain.entity.GenGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 模板分组数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Mapper
public interface IGenGroupDTOConvert {

	/**
	 * 模板分组数据传输对象结构映射实例
	 */
	IGenGroupDTOConvert INSTANCE = Mappers.getMapper(IGenGroupDTOConvert.class);

	/**
	 * 模板分组创建请求数据传输对象 转 模板分组实体
	 * @param createRequest 模板分组创建请求数据传输对象
	 * @return 模板分组实体
	 */
	GenGroup fromCreateRequest(GenGroupCreateRequest createRequest);

	/**
	 * 模板分组更新请求数据传输对象 转 模板分组实体
	 * @param updateRequest 模板分组更新请求数据传输对象
	 * @return 模板分组实体
	 */
	GenGroup fromUpdateRequest(GenGroupUpdateRequest updateRequest);

	/**
	 * 模板分组查询请求数据传输对象 转 模板分组实体
	 * @param queryRequest 模板分组查询请求数据传输对象
	 * @return 模板分组实体
	 */
	GenGroup fromQueryRequest(GenGroupQueryRequest queryRequest);

	/**
	 * 模板分组实体 转 模板分组响应数据传输对象
	 * @param genGroup 模板分组实体
	 * @return 模板分组响应数据传输对象
	 */
	GenGroupResponse toResponse(GenGroup genGroup);

	/**
	 * 模板分组实体 转 模板分组查询响应数据传输对象
	 * @param genGroup 模板分组实体
	 * @return 模板分组查询响应数据传输对象
	 */
	GenGroupQueryResponse toQueryResponse(GenGroup genGroup);

	/**
	 * 模板分组实体列表 转 模板分组查询响应数据传输对象列表
	 * @param genGroupList 模板分组实体列表
	 * @return 模板分组查询响应数据传输对象列表
	 */
	List<GenGroupQueryResponse> toQueryResponse(List<GenGroup> genGroupList);

}
