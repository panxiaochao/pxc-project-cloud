package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationConsentCreateRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationConsentQueryRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationConsentUpdateRequest;
import io.github.panxiaochao.system.application.api.response.Oauth2AuthorizationConsentQueryResponse;
import io.github.panxiaochao.system.application.api.response.Oauth2AuthorizationConsentResponse;
import io.github.panxiaochao.system.domain.entity.Oauth2AuthorizationConsent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface IOauth2AuthorizationConsentDTOConvert {

	/**
	 * 数据传输对象结构映射实例
	 */
	IOauth2AuthorizationConsentDTOConvert INSTANCE = Mappers.getMapper(IOauth2AuthorizationConsentDTOConvert.class);

	/**
	 * 创建请求数据传输对象 转 实体
	 * @param createRequest 创建请求数据传输对象
	 * @return 实体
	 */
	Oauth2AuthorizationConsent fromCreateRequest(Oauth2AuthorizationConsentCreateRequest createRequest);

	/**
	 * 更新请求数据传输对象 转 实体
	 * @param updateRequest 更新请求数据传输对象
	 * @return 实体
	 */
	Oauth2AuthorizationConsent fromUpdateRequest(Oauth2AuthorizationConsentUpdateRequest updateRequest);

	/**
	 * 查询请求数据传输对象 转 实体
	 * @param queryRequest 查询请求数据传输对象
	 * @return 实体
	 */
	Oauth2AuthorizationConsent fromQueryRequest(Oauth2AuthorizationConsentQueryRequest queryRequest);

	/**
	 * 实体 转 响应数据传输对象
	 * @param oauth2AuthorizationConsent 实体
	 * @return 响应数据传输对象
	 */
	Oauth2AuthorizationConsentResponse toResponse(Oauth2AuthorizationConsent oauth2AuthorizationConsent);

	/**
	 * 实体 转 查询响应数据传输对象
	 * @param oauth2AuthorizationConsent 实体
	 * @return 查询响应数据传输对象
	 */
	Oauth2AuthorizationConsentQueryResponse toQueryResponse(Oauth2AuthorizationConsent oauth2AuthorizationConsent);

	/**
	 * 实体列表 转 查询响应数据传输对象列表
	 * @param oauth2AuthorizationConsentList 实体列表
	 * @return 查询响应数据传输对象列表
	 */
	List<Oauth2AuthorizationConsentQueryResponse> toQueryResponse(
			List<Oauth2AuthorizationConsent> oauth2AuthorizationConsentList);

}
