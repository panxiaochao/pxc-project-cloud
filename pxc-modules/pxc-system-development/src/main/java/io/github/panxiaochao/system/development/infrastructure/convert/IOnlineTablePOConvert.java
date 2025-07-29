package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.onlinetable.OnlineTableQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.OnlineTable;
import io.github.panxiaochao.system.development.infrastructure.dao.po.OnlineTablePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 【在线数据表】持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Mapper
public interface IOnlineTablePOConvert {

	/**
	 * 在线数据表持久化对象结构映射实例
	 */
	IOnlineTablePOConvert INSTANCE = Mappers.getMapper(IOnlineTablePOConvert.class);

	/**
	 * 在线数据表实体 转 在线数据表持久化对象
	 * @param onlineTable 在线数据表实体
	 * @return 在线数据表持久化对象
	 */
	OnlineTablePO fromEntity(OnlineTable onlineTable);

	/**
	 * 在线数据表实体 转 在线数据表持久化对象
	 * @param onlineTableList 在线数据表实体
	 * @return 在线数据表持久化对象
	 */
	List<OnlineTablePO> fromEntity(List<OnlineTable> onlineTableList);

	/**
	 * 在线数据表持久化对象 转 在线数据表实体
	 * @param onlineTablePO 在线数据表持久化对象
	 * @return 在线数据表实体
	 */
	OnlineTable toEntity(OnlineTablePO onlineTablePO);

	/**
	 * 在线数据表持久化对象 转 在线数据表实体
	 * @param onlineTablePOList 在线数据表持久化对象
	 * @return 在线数据表实体
	 */
	List<OnlineTable> toEntity(List<OnlineTablePO> onlineTablePOList);

	/**
	 * 在线数据表持久化对象 转 在线数据表查询响应数据传输对象
	 * @param onlineTablePO 在线数据表持久化对象
	 * @return 在线数据表查询响应数据传输对象
	 */
	OnlineTableQueryResponse toQueryResponse(OnlineTablePO onlineTablePO);

	/**
	 * 在线数据表持久化对象列表 转 在线数据表查询响应数据传输对象列表
	 * @param onlineTablePOList 在线数据表持久化对象列表
	 * @return 在线数据表查询响应数据传输对象列表
	 */
	List<OnlineTableQueryResponse> toQueryResponse(List<OnlineTablePO> onlineTablePOList);

}
