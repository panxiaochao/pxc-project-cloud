package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.Oauth2RegisteredClientCreateRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2RegisteredClientQueryRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2RegisteredClientUpdateRequest;
import io.github.panxiaochao.system.application.api.response.Oauth2RegisteredClientQueryResponse;
import io.github.panxiaochao.system.application.api.response.Oauth2RegisteredClientResponse;
import io.github.panxiaochao.system.domain.entity.Oauth2RegisteredClient;
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
public interface IOauth2RegisteredClientDTOConvert {

	/**
	 * 数据传输对象结构映射实例
	 */
	IOauth2RegisteredClientDTOConvert INSTANCE = Mappers.getMapper(IOauth2RegisteredClientDTOConvert.class);

	/**
	 * 创建请求数据传输对象 转 实体
	 * @param createRequest 创建请求数据传输对象
	 * @return 实体
	 */
	Oauth2RegisteredClient fromCreateRequest(Oauth2RegisteredClientCreateRequest createRequest);

	/**
	 * 更新请求数据传输对象 转 实体
	 * @param updateRequest 更新请求数据传输对象
	 * @return 实体
	 */
	Oauth2RegisteredClient fromUpdateRequest(Oauth2RegisteredClientUpdateRequest updateRequest);

	/**
	 * 查询请求数据传输对象 转 实体
	 * @param queryRequest 查询请求数据传输对象
	 * @return 实体
	 */
	Oauth2RegisteredClient fromQueryRequest(Oauth2RegisteredClientQueryRequest queryRequest);

	/**
	 * 实体 转 响应数据传输对象
	 * @param oauth2RegisteredClient 实体
	 * @return 响应数据传输对象
	 */
	Oauth2RegisteredClientResponse toResponse(Oauth2RegisteredClient oauth2RegisteredClient);

	/**
	 * 实体 转 查询响应数据传输对象
	 * @param oauth2RegisteredClient 实体
	 * @return 查询响应数据传输对象
	 */
	Oauth2RegisteredClientQueryResponse toQueryResponse(Oauth2RegisteredClient oauth2RegisteredClient);

	/**
	 * 实体列表 转 查询响应数据传输对象列表
	 * @param oauth2RegisteredClientList 实体列表
	 * @return 查询响应数据传输对象列表
	 */
	List<Oauth2RegisteredClientQueryResponse> toQueryResponse(List<Oauth2RegisteredClient> oauth2RegisteredClientList);

}
