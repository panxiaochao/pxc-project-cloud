package io.github.panxiaochao.system.development.application.convert;

import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateResponse;
import io.github.panxiaochao.system.development.domain.entity.GenTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 模板数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Mapper
public interface IGenTemplateDTOConvert {

	/**
	 * 模板数据传输对象结构映射实例
	 */
	IGenTemplateDTOConvert INSTANCE = Mappers.getMapper(IGenTemplateDTOConvert.class);

	/**
	 * 模板创建请求数据传输对象 转 模板实体
	 * @param createRequest 模板创建请求数据传输对象
	 * @return 模板实体
	 */
	GenTemplate fromCreateRequest(GenTemplateCreateRequest createRequest);

	/**
	 * 模板更新请求数据传输对象 转 模板实体
	 * @param updateRequest 模板更新请求数据传输对象
	 * @return 模板实体
	 */
	GenTemplate fromUpdateRequest(GenTemplateUpdateRequest updateRequest);

	/**
	 * 模板查询请求数据传输对象 转 模板实体
	 * @param queryRequest 模板查询请求数据传输对象
	 * @return 模板实体
	 */
	GenTemplate fromQueryRequest(GenTemplateQueryRequest queryRequest);

	/**
	 * 模板实体 转 模板响应数据传输对象
	 * @param genTemplate 模板实体
	 * @return 模板响应数据传输对象
	 */
	GenTemplateResponse toResponse(GenTemplate genTemplate);

	/**
	 * 模板实体 转 模板查询响应数据传输对象
	 * @param genTemplate 模板实体
	 * @return 模板查询响应数据传输对象
	 */
	GenTemplateQueryResponse toQueryResponse(GenTemplate genTemplate);

	/**
	 * 模板实体列表 转 模板查询响应数据传输对象列表
	 * @param genTemplateList 模板实体列表
	 * @return 模板查询响应数据传输对象列表
	 */
	List<GenTemplateQueryResponse> toQueryResponse(List<GenTemplate> genTemplateList);

}
