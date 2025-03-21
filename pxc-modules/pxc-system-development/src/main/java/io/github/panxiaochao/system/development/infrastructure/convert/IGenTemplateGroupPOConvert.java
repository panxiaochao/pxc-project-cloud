package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.GenTemplateGroup;
import io.github.panxiaochao.system.development.infrastructure.po.GenTemplateGroupPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 模板分组关联表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Mapper
public interface IGenTemplateGroupPOConvert {

	/**
	 * 模板分组关联表持久化对象结构映射实例
	 */
	IGenTemplateGroupPOConvert INSTANCE = Mappers.getMapper(IGenTemplateGroupPOConvert.class);

	/**
	 * 模板分组关联表实体 转 模板分组关联表持久化对象
	 * @param genTemplateGroup 模板分组关联表实体
	 * @return 模板分组关联表持久化对象
	 */
	GenTemplateGroupPO fromEntity(GenTemplateGroup genTemplateGroup);

	/**
	 * 模板分组关联表实体 转 模板分组关联表持久化对象
	 * @param genTemplateGroupList 模板分组关联表实体
	 * @return 模板分组关联表持久化对象
	 */
	List<GenTemplateGroupPO> fromEntity(List<GenTemplateGroup> genTemplateGroupList);

	/**
	 * 模板分组关联表持久化对象 转 模板分组关联表实体
	 * @param genTemplateGroupPO 模板分组关联表持久化对象
	 * @return 模板分组关联表实体
	 */
	GenTemplateGroup toEntity(GenTemplateGroupPO genTemplateGroupPO);

	/**
	 * 模板分组关联表持久化对象 转 模板分组关联表实体
	 * @param genTemplateGroupPOList 模板分组关联表持久化对象
	 * @return 模板分组关联表实体
	 */
	List<GenTemplateGroup> toEntity(List<GenTemplateGroupPO> genTemplateGroupPOList);

	/**
	 * 模板分组关联表持久化对象 转 模板分组关联表查询响应数据传输对象
	 * @param genTemplateGroupPO 模板分组关联表持久化对象
	 * @return 模板分组关联表查询响应数据传输对象
	 */
	GenTemplateGroupQueryResponse toQueryResponse(GenTemplateGroupPO genTemplateGroupPO);

	/**
	 * 模板分组关联表持久化对象列表 转 模板分组关联表查询响应数据传输对象列表
	 * @param genTemplateGroupPOList 模板分组关联表持久化对象列表
	 * @return 模板分组关联表查询响应数据传输对象列表
	 */
	List<GenTemplateGroupQueryResponse> toQueryResponse(List<GenTemplateGroupPO> genTemplateGroupPOList);

}
