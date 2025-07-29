package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.OnlineTable;

import java.util.List;

/**
 * <p>
 * 【在线数据表】Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
public interface IOnlineTableService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 在线数据表 实体
	 */
	OnlineTable getById(String id);

	/**
	 * 保存
	 * @param onlineTable 角色表 实体
	 * @return 在线数据表 实体
	 */
	OnlineTable save(OnlineTable onlineTable);

	/**
	 * 批量保存
	 * @param list 批量数据
	 */
	List<OnlineTable> saveBatch(List<OnlineTable> list);

	/**
	 * 根据主键更新
	 * @param onlineTable 在线数据表 实体
	 */
	void update(OnlineTable onlineTable);

	/**
	 * 根据主键 批量更新
	 * @param list 批量数据
	 */
	void updateBatch(List<OnlineTable> list);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

	/**
	 * 根据主键 批量删除
	 * @param list 批量数据
	 */
	void deleteBatch(List<OnlineTable> list);

}
