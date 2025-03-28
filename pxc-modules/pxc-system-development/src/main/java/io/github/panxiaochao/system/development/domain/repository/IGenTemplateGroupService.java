package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.GenTemplateGroup;

import java.util.List;

/**
 * <p>
 * 模板分组关联表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
public interface IGenTemplateGroupService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 模板分组关联表 实体
	 */
	GenTemplateGroup getById(String id);

	/**
	 * 保存
	 * @param genTemplateGroup 角色表 实体
	 * @return 模板分组关联表 实体
	 */
	GenTemplateGroup save(GenTemplateGroup genTemplateGroup);

	/**
	 * 批量保存
	 * @param list GenTemplateGroup 数据实体
	 */
	void saveBatch(List<GenTemplateGroup> list);

	/**
	 * 根据主键更新
	 * @param genTemplateGroup 模板分组关联表 实体
	 */
	void update(GenTemplateGroup genTemplateGroup);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

	/**
	 * 根据模版分组主键批量删除
	 * @param groupId 模版分组主键
	 */
	void deleteByGroupId(String groupId);
}
