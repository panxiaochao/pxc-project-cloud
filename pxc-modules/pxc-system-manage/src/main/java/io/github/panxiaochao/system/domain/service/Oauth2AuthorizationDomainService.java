package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.Oauth2Authorization;
import io.github.panxiaochao.system.domain.repository.IOauth2AuthorizationService;
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
public class Oauth2AuthorizationDomainService {

	/**
	 * Oauth2Authorization Domain接口服务类
	 */
	private final IOauth2AuthorizationService oauth2AuthorizationService;

	/**
	 * 详情
	 * @param id 主键
	 * @return Oauth2Authorization 实体
	 */
	public Oauth2Authorization getById(String id) {
		return oauth2AuthorizationService.getById(id);
	}

	/**
	 * 保存
	 * @param oauth2Authorization Oauth2Authorization 实体
	 * @return Oauth2Authorization 实体
	 */
	public Oauth2Authorization save(Oauth2Authorization oauth2Authorization) {
		return oauth2AuthorizationService.save(oauth2Authorization);
	}

	/**
	 * 根据主键更新
	 * @param oauth2Authorization Oauth2Authorization 实体
	 */
	public void update(Oauth2Authorization oauth2Authorization) {
		oauth2AuthorizationService.update(oauth2Authorization);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		oauth2AuthorizationService.deleteById(id);
	}

}
