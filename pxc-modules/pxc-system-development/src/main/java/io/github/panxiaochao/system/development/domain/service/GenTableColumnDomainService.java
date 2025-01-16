package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.GenTableColumn;
import io.github.panxiaochao.system.development.domain.repository.IGenTableColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
	 * 批量保存
	 * @param list GenTableColumn 数据实体
	 */
	public void saveBatch(List<GenTableColumn> list) {
		genTableColumnService.saveBatch(list);
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

	/**
	 * 根据表ID删除
	 * @param tableId 表主键
	 */
	public void deleteByTableId(String tableId) {
		genTableColumnService.deleteByTableId(tableId);
	}

}
