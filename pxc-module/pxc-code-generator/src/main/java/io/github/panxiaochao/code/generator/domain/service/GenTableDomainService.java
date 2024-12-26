package io.github.panxiaochao.code.generator.domain.service;

import io.github.panxiaochao.code.generator.domain.entity.GenTable;
import io.github.panxiaochao.code.generator.domain.repository.IGenTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 代码生成表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Service
@RequiredArgsConstructor
public class GenTableDomainService {

	/**
	 * GenTable Domain接口服务类
	 */
	private final IGenTableService genTableService;

	/**
	 * 详情
	 * @param id 主键
	 * @return GenTable 实体
	 */
	public GenTable getById(String id) {
		return genTableService.getById(id);
	}

	/**
	 * 保存
	 * @param genTable GenTable 实体
	 * @return GenTable 实体
	 */
	public GenTable save(GenTable genTable) {
		return genTableService.save(genTable);
	}

	/**
	 * 根据主键更新
	 * @param genTable GenTable 实体
	 */
	public void update(GenTable genTable) {
		genTableService.update(genTable);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		genTableService.deleteById(id);
	}

}
