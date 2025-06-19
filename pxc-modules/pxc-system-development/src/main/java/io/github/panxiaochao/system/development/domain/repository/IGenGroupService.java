package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.GenGroup;

/**
 * <p>
 * 模板分组 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
public interface IGenGroupService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 模板分组 实体
	 */
	GenGroup getById(String id);

	/**
	 * 保存
	 * @param genGroup 角色表 实体
	 * @return 模板分组 实体
	 */
	GenGroup save(GenGroup genGroup);

	/**
	 * 根据主键更新
	 * @param genGroup 模板分组 实体
	 */
	void update(GenGroup genGroup);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
