package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.OnlineTableColumn;
import io.github.panxiaochao.system.development.infrastructure.dao.po.OnlineTableColumnPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 【在线数据表字段】持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Mapper
public interface IOnlineTableColumnPOConvert {

	/**
	 * 在线数据表字段持久化对象结构映射实例
	 */
	IOnlineTableColumnPOConvert INSTANCE = Mappers.getMapper(IOnlineTableColumnPOConvert.class);

	/**
	 * 在线数据表字段实体 转 在线数据表字段持久化对象
	 * @param onlineTableColumn 在线数据表字段实体
	 * @return 在线数据表字段持久化对象
	 */
	OnlineTableColumnPO fromEntity(OnlineTableColumn onlineTableColumn);

	/**
	 * 在线数据表字段实体 转 在线数据表字段持久化对象
	 * @param onlineTableColumnList 在线数据表字段实体
	 * @return 在线数据表字段持久化对象
	 */
	List<OnlineTableColumnPO> fromEntity(List<OnlineTableColumn> onlineTableColumnList);

	/**
	 * 在线数据表字段持久化对象 转 在线数据表字段实体
	 * @param onlineTableColumnPO 在线数据表字段持久化对象
	 * @return 在线数据表字段实体
	 */
	OnlineTableColumn toEntity(OnlineTableColumnPO onlineTableColumnPO);

	/**
	 * 在线数据表字段持久化对象 转 在线数据表字段实体
	 * @param onlineTableColumnPOList 在线数据表字段持久化对象
	 * @return 在线数据表字段实体
	 */
	List<OnlineTableColumn> toEntity(List<OnlineTableColumnPO> onlineTableColumnPOList);

	/**
	 * 在线数据表字段持久化对象 转 在线数据表字段查询响应数据传输对象
	 * @param onlineTableColumnPO 在线数据表字段持久化对象
	 * @return 在线数据表字段查询响应数据传输对象
	 */
	OnlineTableColumnQueryResponse toQueryResponse(OnlineTableColumnPO onlineTableColumnPO);

	/**
	 * 在线数据表字段持久化对象列表 转 在线数据表字段查询响应数据传输对象列表
	 * @param onlineTableColumnPOList 在线数据表字段持久化对象列表
	 * @return 在线数据表字段查询响应数据传输对象列表
	 */
	List<OnlineTableColumnQueryResponse> toQueryResponse(List<OnlineTableColumnPO> onlineTableColumnPOList);

}
