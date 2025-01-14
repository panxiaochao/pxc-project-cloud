package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.DatabaseSource;
import io.github.panxiaochao.system.development.domain.repository.IDatabaseSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库-数据源管理 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Service
@RequiredArgsConstructor
public class DatabaseSourceDomainService {

	/**
	 * DatabaseSource Domain接口服务类
	 */
	private final IDatabaseSourceService databaseSourceService;

	/**
	 * 详情
	 * @param id 主键
	 * @return DatabaseSource 实体
	 */
	public DatabaseSource getById(String id) {
		return databaseSourceService.getById(id);
	}

	/**
	 * 保存
	 * @param databaseSource DatabaseSource 实体
	 * @return DatabaseSource 实体
	 */
	public DatabaseSource save(DatabaseSource databaseSource) {
		return databaseSourceService.save(databaseSource);
	}

	/**
	 * 根据主键更新
	 * @param databaseSource DatabaseSource 实体
	 */
	public void update(DatabaseSource databaseSource) {
		databaseSourceService.update(databaseSource);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		databaseSourceService.deleteById(id);
	}

}
