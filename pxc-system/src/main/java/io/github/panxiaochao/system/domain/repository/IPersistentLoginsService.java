package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.PersistentLogins;

/**
 * <p>
 * Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface IPersistentLoginsService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 实体
	 */
	PersistentLogins getById(String id);

	/**
	 * 保存
	 * @param persistentLogins 角色表 实体
	 * @return 实体
	 */
	PersistentLogins save(PersistentLogins persistentLogins);

	/**
	 * 根据主键更新
	 * @param persistentLogins 实体
	 */
	void update(PersistentLogins persistentLogins);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
