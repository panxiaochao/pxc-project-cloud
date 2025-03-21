package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.GenTemplate;
import io.github.panxiaochao.system.development.infrastructure.po.GenTemplatePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 模板持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Mapper
public interface IGenTemplatePOConvert {

	/**
	 * 模板持久化对象结构映射实例
	 */
	IGenTemplatePOConvert INSTANCE = Mappers.getMapper(IGenTemplatePOConvert.class);

	/**
	 * 模板实体 转 模板持久化对象
	 * @param genTemplate 模板实体
	 * @return 模板持久化对象
	 */
	GenTemplatePO fromEntity(GenTemplate genTemplate);

	/**
	 * 模板实体 转 模板持久化对象
	 * @param genTemplateList 模板实体
	 * @return 模板持久化对象
	 */
	List<GenTemplatePO> fromEntity(List<GenTemplate> genTemplateList);

	/**
	 * 模板持久化对象 转 模板实体
	 * @param genTemplatePO 模板持久化对象
	 * @return 模板实体
	 */
	GenTemplate toEntity(GenTemplatePO genTemplatePO);

	/**
	 * 模板持久化对象 转 模板实体
	 * @param genTemplatePOList 模板持久化对象
	 * @return 模板实体
	 */
	List<GenTemplate> toEntity(List<GenTemplatePO> genTemplatePOList);

	/**
	 * 模板持久化对象 转 模板查询响应数据传输对象
	 * @param genTemplatePO 模板持久化对象
	 * @return 模板查询响应数据传输对象
	 */
	GenTemplateQueryResponse toQueryResponse(GenTemplatePO genTemplatePO);

	/**
	 * 模板持久化对象列表 转 模板查询响应数据传输对象列表
	 * @param genTemplatePOList 模板持久化对象列表
	 * @return 模板查询响应数据传输对象列表
	 */
	List<GenTemplateQueryResponse> toQueryResponse(List<GenTemplatePO> genTemplatePOList);

}
