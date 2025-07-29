package io.github.panxiaochao.system.development.application.convert;

import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnResponse;
import io.github.panxiaochao.system.development.domain.entity.OnlineTableColumn;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 【在线数据表字段】数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Mapper
public interface IOnlineTableColumnDTOConvert {

	/**
	 * 在线数据表字段数据传输对象结构映射实例
	 */
	IOnlineTableColumnDTOConvert INSTANCE = Mappers.getMapper(IOnlineTableColumnDTOConvert.class);

	/**
	 * 在线数据表字段创建请求数据传输对象 转 在线数据表字段实体
	 * @param createRequest 在线数据表字段创建请求数据传输对象
	 * @return 在线数据表字段实体
	 */
	OnlineTableColumn fromCreateRequest(OnlineTableColumnCreateRequest createRequest);

	/**
	 * 在线数据表字段创建请求数据传输对象列表 转 在线数据表字段实体列表
	 * @param createRequestList 在线数据表字段创建请求数据传输对象列表
	 * @return 在线数据表字段实体列表
	 */
	List<OnlineTableColumn> fromCreateRequest(List<OnlineTableColumnCreateRequest> createRequestList);

	/**
	 * 在线数据表字段更新请求数据传输对象 转 在线数据表字段实体
	 * @param updateRequest 在线数据表字段更新请求数据传输对象
	 * @return 在线数据表字段实体
	 */
	OnlineTableColumn fromUpdateRequest(OnlineTableColumnUpdateRequest updateRequest);

	/**
	 * 在线数据表字段更新请求数据传输对象列表 转 在线数据表字段实体列表
	 * @param updateRequestList 在线数据表字段更新请求数据传输对象列表
	 * @return 在线数据表字段实体列表
	 */
	List<OnlineTableColumn> fromUpdateRequest(List<OnlineTableColumnUpdateRequest> updateRequestList);

	/**
	 * 在线数据表字段查询请求数据传输对象 转 在线数据表字段实体
	 * @param queryRequest 在线数据表字段查询请求数据传输对象
	 * @return 在线数据表字段实体
	 */
	OnlineTableColumn fromQueryRequest(OnlineTableColumnQueryRequest queryRequest);

	/**
	 * 在线数据表字段实体 转 在线数据表字段响应数据传输对象
	 * @param onlineTableColumn 在线数据表字段实体
	 * @return 在线数据表字段响应数据传输对象
	 */
	OnlineTableColumnResponse toResponse(OnlineTableColumn onlineTableColumn);

	/**
	 * 在线数据表字段实体 转 在线数据表字段查询响应数据传输对象
	 * @param onlineTableColumn 在线数据表字段实体
	 * @return 在线数据表字段查询响应数据传输对象
	 */
	OnlineTableColumnQueryResponse toQueryResponse(OnlineTableColumn onlineTableColumn);

	/**
	 * 在线数据表字段实体列表 转 在线数据表字段查询响应数据传输对象列表
	 * @param onlineTableColumnList 在线数据表字段实体列表
	 * @return 在线数据表字段查询响应数据传输对象列表
	 */
	List<OnlineTableColumnQueryResponse> toQueryResponse(List<OnlineTableColumn> onlineTableColumnList);

}
