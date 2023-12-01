package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.Oauth2AuthorizationConsentQueryResponse;
import io.github.panxiaochao.system.domain.entity.Oauth2AuthorizationConsent;
import io.github.panxiaochao.system.infrastructure.po.Oauth2AuthorizationConsentPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface IOauth2AuthorizationConsentPOConvert {

	/**
	 * 持久化对象结构映射实例
	 */
	IOauth2AuthorizationConsentPOConvert INSTANCE = Mappers.getMapper(IOauth2AuthorizationConsentPOConvert.class);

	/**
	 * 实体 转 持久化对象
	 * @param oauth2AuthorizationConsent 实体
	 * @return 持久化对象
	 */
	Oauth2AuthorizationConsentPO fromEntity(Oauth2AuthorizationConsent oauth2AuthorizationConsent);

	/**
	 * 实体 转 持久化对象
	 * @param oauth2AuthorizationConsentList 实体
	 * @return 持久化对象
	 */
	List<Oauth2AuthorizationConsentPO> fromEntity(List<Oauth2AuthorizationConsent> oauth2AuthorizationConsentList);

	/**
	 * 持久化对象 转 实体
	 * @param oauth2AuthorizationConsentPO 持久化对象
	 * @return 实体
	 */
	Oauth2AuthorizationConsent toEntity(Oauth2AuthorizationConsentPO oauth2AuthorizationConsentPO);

	/**
	 * 持久化对象 转 实体
	 * @param oauth2AuthorizationConsentPOList 持久化对象
	 * @return 实体
	 */
	List<Oauth2AuthorizationConsent> toEntity(List<Oauth2AuthorizationConsentPO> oauth2AuthorizationConsentPOList);

	/**
	 * 持久化对象 转 查询响应数据传输对象
	 * @param oauth2AuthorizationConsentPO 持久化对象
	 * @return 查询响应数据传输对象
	 */
	Oauth2AuthorizationConsentQueryResponse toQueryResponse(Oauth2AuthorizationConsentPO oauth2AuthorizationConsentPO);

	/**
	 * 持久化对象列表 转 查询响应数据传输对象列表
	 * @param oauth2AuthorizationConsentPOList 持久化对象列表
	 * @return 查询响应数据传输对象列表
	 */
	List<Oauth2AuthorizationConsentQueryResponse> toQueryResponse(
			List<Oauth2AuthorizationConsentPO> oauth2AuthorizationConsentPOList);

}
