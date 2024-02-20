package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.DatabaseFieldType;
import io.github.panxiaochao.system.domain.repository.IDatabaseFieldTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库字段类型码表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Service
@RequiredArgsConstructor
public class DatabaseFieldTypeDomainService {

	/**
	 * DatabaseFieldType Domain接口服务类
	 */
	private final IDatabaseFieldTypeService databaseFieldTypeService;

	/**
	 * 详情
	 * @param id 主键
	 * @return DatabaseFieldType 实体
	 */
	public DatabaseFieldType getById(String id) {
		return databaseFieldTypeService.getById(id);
	}

	/**
	 * 保存
	 * @param databaseFieldType DatabaseFieldType 实体
	 * @return DatabaseFieldType 实体
	 */
	public DatabaseFieldType save(DatabaseFieldType databaseFieldType) {
		return databaseFieldTypeService.save(databaseFieldType);
	}

	/**
	 * 根据主键更新
	 * @param databaseFieldType DatabaseFieldType 实体
	 */
	public void update(DatabaseFieldType databaseFieldType) {
		databaseFieldTypeService.update(databaseFieldType);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		databaseFieldTypeService.deleteById(id);
	}

}
