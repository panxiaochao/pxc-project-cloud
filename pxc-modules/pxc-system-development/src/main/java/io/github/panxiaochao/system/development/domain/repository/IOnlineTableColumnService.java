package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.OnlineTableColumn;

import java.util.List;

/**
 * <p>
 * 【在线数据表字段】Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
public interface IOnlineTableColumnService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 在线数据表字段 实体
	 */
	OnlineTableColumn getById(String id);

	/**
	 * 保存
	 * @param onlineTableColumn 角色表 实体
	 * @return 在线数据表字段 实体
	 */
	OnlineTableColumn save(OnlineTableColumn onlineTableColumn);

	/**
	 * 批量保存
	 * @param list 批量数据
	 */
	List<OnlineTableColumn> saveBatch(List<OnlineTableColumn> list);

	/**
	 * 根据主键更新
	 * @param onlineTableColumn 在线数据表字段 实体
	 */
	void update(OnlineTableColumn onlineTableColumn);

	/**
	 * 根据主键 批量更新
	 * @param list 批量数据
	 */
	void updateBatch(List<OnlineTableColumn> list);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

	/**
	 * 根据主键 批量删除
	 * @param list 批量数据
	 */
	void deleteBatch(List<OnlineTableColumn> list);

}
