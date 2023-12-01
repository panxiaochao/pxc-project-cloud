package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.Oauth2RegisteredClient;
import io.github.panxiaochao.system.domain.repository.IOauth2RegisteredClientService;
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
public class Oauth2RegisteredClientDomainService {

	/**
	 * Oauth2RegisteredClient Domain接口服务类
	 */
	private final IOauth2RegisteredClientService oauth2RegisteredClientService;

	/**
	 * 详情
	 * @param id 主键
	 * @return Oauth2RegisteredClient 实体
	 */
	public Oauth2RegisteredClient getById(String id) {
		return oauth2RegisteredClientService.getById(id);
	}

	/**
	 * 保存
	 * @param oauth2RegisteredClient Oauth2RegisteredClient 实体
	 * @return Oauth2RegisteredClient 实体
	 */
	public Oauth2RegisteredClient save(Oauth2RegisteredClient oauth2RegisteredClient) {
		return oauth2RegisteredClientService.save(oauth2RegisteredClient);
	}

	/**
	 * 根据主键更新
	 * @param oauth2RegisteredClient Oauth2RegisteredClient 实体
	 */
	public void update(Oauth2RegisteredClient oauth2RegisteredClient) {
		oauth2RegisteredClientService.update(oauth2RegisteredClient);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		oauth2RegisteredClientService.deleteById(id);
	}

}
