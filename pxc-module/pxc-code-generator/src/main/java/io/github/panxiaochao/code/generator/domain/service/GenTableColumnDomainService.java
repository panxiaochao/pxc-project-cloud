package io.github.panxiaochao.code.generator.domain.service;

import io.github.panxiaochao.code.generator.domain.entity.GenTableColumn;
import io.github.panxiaochao.code.generator.domain.repository.IGenTableColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 代码生成表字段 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Service
@RequiredArgsConstructor
public class GenTableColumnDomainService {

	/**
	 * GenTableColumn Domain接口服务类
	 */
	private final IGenTableColumnService genTableColumnService;

	/**
	 * 详情
	 * @param id 主键
	 * @return GenTableColumn 实体
	 */
	public GenTableColumn getById(String id) {
		return genTableColumnService.getById(id);
	}

	/**
	 * 保存
	 * @param genTableColumn GenTableColumn 实体
	 * @return GenTableColumn 实体
	 */
	public GenTableColumn save(GenTableColumn genTableColumn) {
		return genTableColumnService.save(genTableColumn);
	}

	/**
	 * 根据主键更新
	 * @param genTableColumn GenTableColumn 实体
	 */
	public void update(GenTableColumn genTableColumn) {
		genTableColumnService.update(genTableColumn);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		genTableColumnService.deleteById(id);
	}

}
