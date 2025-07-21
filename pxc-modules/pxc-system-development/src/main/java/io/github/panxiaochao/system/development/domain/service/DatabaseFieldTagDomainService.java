package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldTag;
import io.github.panxiaochao.system.development.domain.repository.IDatabaseFieldTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class DatabaseFieldTagDomainService {

	/**
	 * DatabaseFieldTag Domain接口服务类
	 */
	private final IDatabaseFieldTagService databaseFieldTagService;

	/**
	 * 详情
	 * @param id 主键
	 * @return DatabaseFieldTag 实体
	 */
	public DatabaseFieldTag getById(String id) {
		return databaseFieldTagService.getById(id);
	}

	/**
	 * 保存
	 * @param databaseFieldTag DatabaseFieldTag 实体
	 * @return DatabaseFieldTag 实体
	 */
	public DatabaseFieldTag save(DatabaseFieldTag databaseFieldTag) {
		return databaseFieldTagService.save(databaseFieldTag);
	}

	/**
	 * 批量保存
	 * @param list 批量数据
	 * @return DatabaseFieldTag 实体数组
	 */
	public List<DatabaseFieldTag> saveBatch(List<DatabaseFieldTag> list) {
		return databaseFieldTagService.saveBatch(list);
	}

	/**
	 * 根据主键更新
	 * @param databaseFieldTag DatabaseFieldTag 实体
	 */
	public void update(DatabaseFieldTag databaseFieldTag) {
		databaseFieldTagService.update(databaseFieldTag);
	}

	/**
	 * 根据主键 批量更新
	 * @param list 批量数据
	 */
	public void updateBatch(List<DatabaseFieldTag> list) {
		databaseFieldTagService.updateBatch(list);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		databaseFieldTagService.deleteById(id);
	}

	/**
	 * 根据主键 批量删除
	 * @param list 批量数据
	 */
	public void deleteBatch(List<DatabaseFieldTag> list) {
		databaseFieldTagService.deleteBatch(list);
	}

	/**
	 * 根据数据库字段类型ID删除
	 * @param fieldTypeId 数据库字段类型ID
	 */
	public void deleteByFieldTypeId(String fieldTypeId) {
		databaseFieldTagService.deleteByFieldTypeId(fieldTypeId);
	}

}
