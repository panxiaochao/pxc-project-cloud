package io.github.panxiaochao.system.development.application.convert;

import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupResponse;
import io.github.panxiaochao.system.development.domain.entity.GenTemplateGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 模板分组关联表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Mapper
public interface IGenTemplateGroupDTOConvert {

	/**
	 * 模板分组关联表数据传输对象结构映射实例
	 */
	IGenTemplateGroupDTOConvert INSTANCE = Mappers.getMapper(IGenTemplateGroupDTOConvert.class);

	/**
	 * 模板分组关联表创建请求数据传输对象 转 模板分组关联表实体
	 * @param createRequest 模板分组关联表创建请求数据传输对象
	 * @return 模板分组关联表实体
	 */
	GenTemplateGroup fromCreateRequest(GenTemplateGroupCreateRequest createRequest);

	/**
	 * 模板分组关联表更新请求数据传输对象 转 模板分组关联表实体
	 * @param updateRequest 模板分组关联表更新请求数据传输对象
	 * @return 模板分组关联表实体
	 */
	GenTemplateGroup fromUpdateRequest(GenTemplateGroupUpdateRequest updateRequest);

	/**
	 * 模板分组关联表查询请求数据传输对象 转 模板分组关联表实体
	 * @param queryRequest 模板分组关联表查询请求数据传输对象
	 * @return 模板分组关联表实体
	 */
	GenTemplateGroup fromQueryRequest(GenTemplateGroupQueryRequest queryRequest);

	/**
	 * 模板分组关联表实体 转 模板分组关联表响应数据传输对象
	 * @param genTemplateGroup 模板分组关联表实体
	 * @return 模板分组关联表响应数据传输对象
	 */
	GenTemplateGroupResponse toResponse(GenTemplateGroup genTemplateGroup);

	/**
	 * 模板分组关联表实体 转 模板分组关联表查询响应数据传输对象
	 * @param genTemplateGroup 模板分组关联表实体
	 * @return 模板分组关联表查询响应数据传输对象
	 */
	GenTemplateGroupQueryResponse toQueryResponse(GenTemplateGroup genTemplateGroup);

	/**
	 * 模板分组关联表实体列表 转 模板分组关联表查询响应数据传输对象列表
	 * @param genTemplateGroupList 模板分组关联表实体列表
	 * @return 模板分组关联表查询响应数据传输对象列表
	 */
	List<GenTemplateGroupQueryResponse> toQueryResponse(List<GenTemplateGroup> genTemplateGroupList);

}
