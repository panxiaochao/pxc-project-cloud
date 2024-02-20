package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.PersistentLogins;
import io.github.panxiaochao.system.domain.repository.IPersistentLoginsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class PersistentLoginsDomainService {

	/**
	 * PersistentLogins Domain接口服务类
	 */
	private final IPersistentLoginsService persistentLoginsService;

	/**
	 * 详情
	 * @param id 主键
	 * @return PersistentLogins 实体
	 */
	public PersistentLogins getById(String id) {
		return persistentLoginsService.getById(id);
	}

	/**
	 * 保存
	 * @param persistentLogins PersistentLogins 实体
	 * @return PersistentLogins 实体
	 */
	public PersistentLogins save(PersistentLogins persistentLogins) {
		return persistentLoginsService.save(persistentLogins);
	}

	/**
	 * 根据主键更新
	 * @param persistentLogins PersistentLogins 实体
	 */
	public void update(PersistentLogins persistentLogins) {
		persistentLoginsService.update(persistentLogins);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		persistentLoginsService.deleteById(id);
	}

}
