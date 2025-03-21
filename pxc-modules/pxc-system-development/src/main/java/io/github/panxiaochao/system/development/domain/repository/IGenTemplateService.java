package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.GenTemplate;

/**
 * <p>
 * 模板 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
public interface IGenTemplateService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 模板 实体
	 */
	GenTemplate getById(String id);

	/**
	 * 保存
	 * @param genTemplate 角色表 实体
	 * @return 模板 实体
	 */
	GenTemplate save(GenTemplate genTemplate);

	/**
	 * 根据主键更新
	 * @param genTemplate 模板 实体
	 */
	void update(GenTemplate genTemplate);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
