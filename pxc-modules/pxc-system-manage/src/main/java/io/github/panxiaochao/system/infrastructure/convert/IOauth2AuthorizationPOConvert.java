package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.oauth2authorizationconsent.Oauth2AuthorizationQueryResponse;
import io.github.panxiaochao.system.domain.entity.Oauth2Authorization;
import io.github.panxiaochao.system.infrastructure.po.Oauth2AuthorizationPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface IOauth2AuthorizationPOConvert {

	/**
	 * 持久化对象结构映射实例
	 */
	IOauth2AuthorizationPOConvert INSTANCE = Mappers.getMapper(IOauth2AuthorizationPOConvert.class);

	/**
	 * 实体 转 持久化对象
	 * @param oauth2Authorization 实体
	 * @return 持久化对象
	 */
	Oauth2AuthorizationPO fromEntity(Oauth2Authorization oauth2Authorization);

	/**
	 * 实体 转 持久化对象
	 * @param oauth2AuthorizationList 实体
	 * @return 持久化对象
	 */
	List<Oauth2AuthorizationPO> fromEntity(List<Oauth2Authorization> oauth2AuthorizationList);

	/**
	 * 持久化对象 转 实体
	 * @param oauth2AuthorizationPO 持久化对象
	 * @return 实体
	 */
	Oauth2Authorization toEntity(Oauth2AuthorizationPO oauth2AuthorizationPO);

	/**
	 * 持久化对象 转 实体
	 * @param oauth2AuthorizationPOList 持久化对象
	 * @return 实体
	 */
	List<Oauth2Authorization> toEntity(List<Oauth2AuthorizationPO> oauth2AuthorizationPOList);

	/**
	 * 持久化对象 转 查询响应数据传输对象
	 * @param oauth2AuthorizationPO 持久化对象
	 * @return 查询响应数据传输对象
	 */
	Oauth2AuthorizationQueryResponse toQueryResponse(Oauth2AuthorizationPO oauth2AuthorizationPO);

	/**
	 * 持久化对象列表 转 查询响应数据传输对象列表
	 * @param oauth2AuthorizationPOList 持久化对象列表
	 * @return 查询响应数据传输对象列表
	 */
	List<Oauth2AuthorizationQueryResponse> toQueryResponse(List<Oauth2AuthorizationPO> oauth2AuthorizationPOList);

}
