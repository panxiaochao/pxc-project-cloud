package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.GenTemplateGroup;
import io.github.panxiaochao.system.development.domain.repository.IGenTemplateGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模板分组关联表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Service
@RequiredArgsConstructor
public class GenTemplateGroupDomainService {

	/**
	 * GenTemplateGroup Domain接口服务类
	 */
	private final IGenTemplateGroupService genTemplateGroupService;

	/**
	 * 详情
	 * @param id 主键
	 * @return GenTemplateGroup 实体
	 */
	public GenTemplateGroup getById(String id) {
		return genTemplateGroupService.getById(id);
	}

	/**
	 * 保存
	 * @param genTemplateGroup GenTemplateGroup 实体
	 * @return GenTemplateGroup 实体
	 */
	public GenTemplateGroup save(GenTemplateGroup genTemplateGroup) {
		return genTemplateGroupService.save(genTemplateGroup);
	}

	/**
	 * 根据主键更新
	 * @param genTemplateGroup GenTemplateGroup 实体
	 */
	public void update(GenTemplateGroup genTemplateGroup) {
		genTemplateGroupService.update(genTemplateGroup);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		genTemplateGroupService.deleteById(id);
	}

}
