package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.Oauth2RegisteredClientQueryResponse;
import io.github.panxiaochao.system.domain.entity.Oauth2RegisteredClient;
import io.github.panxiaochao.system.infrastructure.po.Oauth2RegisteredClientPO;
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
public interface IOauth2RegisteredClientPOConvert {

	/**
	 * 持久化对象结构映射实例
	 */
	IOauth2RegisteredClientPOConvert INSTANCE = Mappers.getMapper(IOauth2RegisteredClientPOConvert.class);

	/**
	 * 实体 转 持久化对象
	 * @param oauth2RegisteredClient 实体
	 * @return 持久化对象
	 */
	Oauth2RegisteredClientPO fromEntity(Oauth2RegisteredClient oauth2RegisteredClient);

	/**
	 * 实体 转 持久化对象
	 * @param oauth2RegisteredClientList 实体
	 * @return 持久化对象
	 */
	List<Oauth2RegisteredClientPO> fromEntity(List<Oauth2RegisteredClient> oauth2RegisteredClientList);

	/**
	 * 持久化对象 转 实体
	 * @param oauth2RegisteredClientPO 持久化对象
	 * @return 实体
	 */
	Oauth2RegisteredClient toEntity(Oauth2RegisteredClientPO oauth2RegisteredClientPO);

	/**
	 * 持久化对象 转 实体
	 * @param oauth2RegisteredClientPOList 持久化对象
	 * @return 实体
	 */
	List<Oauth2RegisteredClient> toEntity(List<Oauth2RegisteredClientPO> oauth2RegisteredClientPOList);

	/**
	 * 持久化对象 转 查询响应数据传输对象
	 * @param oauth2RegisteredClientPO 持久化对象
	 * @return 查询响应数据传输对象
	 */
	Oauth2RegisteredClientQueryResponse toQueryResponse(Oauth2RegisteredClientPO oauth2RegisteredClientPO);

	/**
	 * 持久化对象列表 转 查询响应数据传输对象列表
	 * @param oauth2RegisteredClientPOList 持久化对象列表
	 * @return 查询响应数据传输对象列表
	 */
	List<Oauth2RegisteredClientQueryResponse> toQueryResponse(
			List<Oauth2RegisteredClientPO> oauth2RegisteredClientPOList);

}
