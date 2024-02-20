package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.Oauth2AuthorizationConsent;
import io.github.panxiaochao.system.domain.repository.IOauth2AuthorizationConsentService;
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
public class Oauth2AuthorizationConsentDomainService {

	/**
	 * Oauth2AuthorizationConsent Domain接口服务类
	 */
	private final IOauth2AuthorizationConsentService oauth2AuthorizationConsentService;

	/**
	 * 详情
	 * @param id 主键
	 * @return Oauth2AuthorizationConsent 实体
	 */
	public Oauth2AuthorizationConsent getById(String id) {
		return oauth2AuthorizationConsentService.getById(id);
	}

	/**
	 * 保存
	 * @param oauth2AuthorizationConsent Oauth2AuthorizationConsent 实体
	 * @return Oauth2AuthorizationConsent 实体
	 */
	public Oauth2AuthorizationConsent save(Oauth2AuthorizationConsent oauth2AuthorizationConsent) {
		return oauth2AuthorizationConsentService.save(oauth2AuthorizationConsent);
	}

	/**
	 * 根据主键更新
	 * @param oauth2AuthorizationConsent Oauth2AuthorizationConsent 实体
	 */
	public void update(Oauth2AuthorizationConsent oauth2AuthorizationConsent) {
		oauth2AuthorizationConsentService.update(oauth2AuthorizationConsent);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		oauth2AuthorizationConsentService.deleteById(id);
	}

}
