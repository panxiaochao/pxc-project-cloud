package io.github.panxiaochao.system.development.application.convert;

import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.onlinetable.OnlineTableQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.onlinetable.OnlineTableResponse;
import io.github.panxiaochao.system.development.domain.entity.OnlineTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 【在线数据表】数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Mapper
public interface IOnlineTableDTOConvert {

	/**
	 * 在线数据表数据传输对象结构映射实例
	 */
	IOnlineTableDTOConvert INSTANCE = Mappers.getMapper(IOnlineTableDTOConvert.class);

	/**
	 * 在线数据表创建请求数据传输对象 转 在线数据表实体
	 * @param createRequest 在线数据表创建请求数据传输对象
	 * @return 在线数据表实体
	 */
	OnlineTable fromCreateRequest(OnlineTableCreateRequest createRequest);

	/**
	 * 在线数据表创建请求数据传输对象列表 转 在线数据表实体列表
	 * @param createRequestList 在线数据表创建请求数据传输对象列表
	 * @return 在线数据表实体列表
	 */
	List<OnlineTable> fromCreateRequest(List<OnlineTableCreateRequest> createRequestList);

	/**
	 * 在线数据表更新请求数据传输对象 转 在线数据表实体
	 * @param updateRequest 在线数据表更新请求数据传输对象
	 * @return 在线数据表实体
	 */
	OnlineTable fromUpdateRequest(OnlineTableUpdateRequest updateRequest);

	/**
	 * 在线数据表更新请求数据传输对象列表 转 在线数据表实体列表
	 * @param updateRequestList 在线数据表更新请求数据传输对象列表
	 * @return 在线数据表实体列表
	 */
	List<OnlineTable> fromUpdateRequest(List<OnlineTableUpdateRequest> updateRequestList);

	/**
	 * 在线数据表查询请求数据传输对象 转 在线数据表实体
	 * @param queryRequest 在线数据表查询请求数据传输对象
	 * @return 在线数据表实体
	 */
	OnlineTable fromQueryRequest(OnlineTableQueryRequest queryRequest);

	/**
	 * 在线数据表实体 转 在线数据表响应数据传输对象
	 * @param onlineTable 在线数据表实体
	 * @return 在线数据表响应数据传输对象
	 */
	OnlineTableResponse toResponse(OnlineTable onlineTable);

	/**
	 * 在线数据表实体 转 在线数据表查询响应数据传输对象
	 * @param onlineTable 在线数据表实体
	 * @return 在线数据表查询响应数据传输对象
	 */
	OnlineTableQueryResponse toQueryResponse(OnlineTable onlineTable);

	/**
	 * 在线数据表实体列表 转 在线数据表查询响应数据传输对象列表
	 * @param onlineTableList 在线数据表实体列表
	 * @return 在线数据表查询响应数据传输对象列表
	 */
	List<OnlineTableQueryResponse> toQueryResponse(List<OnlineTable> onlineTableList);

}
