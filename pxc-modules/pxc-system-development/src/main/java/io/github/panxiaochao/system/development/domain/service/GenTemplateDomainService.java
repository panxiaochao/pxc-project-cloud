package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.GenTemplate;
import io.github.panxiaochao.system.development.domain.repository.IGenTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模板 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Service
@RequiredArgsConstructor
public class GenTemplateDomainService {

	/**
	 * GenTemplate Domain接口服务类
	 */
	private final IGenTemplateService genTemplateService;

	/**
	 * 详情
	 * @param id 主键
	 * @return GenTemplate 实体
	 */
	public GenTemplate getById(String id) {
		return genTemplateService.getById(id);
	}

	/**
	 * 保存
	 * @param genTemplate GenTemplate 实体
	 * @return GenTemplate 实体
	 */
	public GenTemplate save(GenTemplate genTemplate) {
		return genTemplateService.save(genTemplate);
	}

	/**
	 * 根据主键更新
	 * @param genTemplate GenTemplate 实体
	 */
	public void update(GenTemplate genTemplate) {
		genTemplateService.update(genTemplate);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		genTemplateService.deleteById(id);
	}

}
