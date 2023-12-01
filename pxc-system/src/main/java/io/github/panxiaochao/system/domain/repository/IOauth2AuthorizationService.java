package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.Oauth2Authorization;

/**
 * <p>
 * Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface IOauth2AuthorizationService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 实体
	 */
	Oauth2Authorization getById(String id);

	/**
	 * 保存
	 * @param oauth2Authorization 角色表 实体
	 * @return 实体
	 */
	Oauth2Authorization save(Oauth2Authorization oauth2Authorization);

	/**
	 * 根据主键更新
	 * @param oauth2Authorization 实体
	 */
	void update(Oauth2Authorization oauth2Authorization);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
