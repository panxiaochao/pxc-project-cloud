package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent.Oauth2AuthorizationCreateRequest;
import io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent.Oauth2AuthorizationQueryRequest;
import io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent.Oauth2AuthorizationUpdateRequest;
import io.github.panxiaochao.system.application.api.response.oauth2authorizationconsent.Oauth2AuthorizationQueryResponse;
import io.github.panxiaochao.system.application.api.response.oauth2authorizationconsent.Oauth2AuthorizationResponse;
import io.github.panxiaochao.system.domain.entity.Oauth2Authorization;
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
public interface IOauth2AuthorizationDTOConvert {

	/**
	 * 数据传输对象结构映射实例
	 */
	IOauth2AuthorizationDTOConvert INSTANCE = Mappers.getMapper(IOauth2AuthorizationDTOConvert.class);

	/**
	 * 创建请求数据传输对象 转 实体
	 * @param createRequest 创建请求数据传输对象
	 * @return 实体
	 */
	Oauth2Authorization fromCreateRequest(Oauth2AuthorizationCreateRequest createRequest);

	/**
	 * 更新请求数据传输对象 转 实体
	 * @param updateRequest 更新请求数据传输对象
	 * @return 实体
	 */
	Oauth2Authorization fromUpdateRequest(Oauth2AuthorizationUpdateRequest updateRequest);

	/**
	 * 查询请求数据传输对象 转 实体
	 * @param queryRequest 查询请求数据传输对象
	 * @return 实体
	 */
	Oauth2Authorization fromQueryRequest(Oauth2AuthorizationQueryRequest queryRequest);

	/**
	 * 实体 转 响应数据传输对象
	 * @param oauth2Authorization 实体
	 * @return 响应数据传输对象
	 */
	Oauth2AuthorizationResponse toResponse(Oauth2Authorization oauth2Authorization);

	/**
	 * 实体 转 查询响应数据传输对象
	 * @param oauth2Authorization 实体
	 * @return 查询响应数据传输对象
	 */
	Oauth2AuthorizationQueryResponse toQueryResponse(Oauth2Authorization oauth2Authorization);

	/**
	 * 实体列表 转 查询响应数据传输对象列表
	 * @param oauth2AuthorizationList 实体列表
	 * @return 查询响应数据传输对象列表
	 */
	List<Oauth2AuthorizationQueryResponse> toQueryResponse(List<Oauth2Authorization> oauth2AuthorizationList);

}
