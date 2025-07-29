package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.OnlineTableColumn;
import io.github.panxiaochao.system.development.domain.repository.IOnlineTableColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【在线数据表字段】 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class OnlineTableColumnDomainService {

	/**
	 * OnlineTableColumn Domain接口服务类
	 */
	private final IOnlineTableColumnService onlineTableColumnService;

	/**
	 * 详情
	 * @param id 主键
	 * @return OnlineTableColumn 实体
	 */
	public OnlineTableColumn getById(String id) {
		return onlineTableColumnService.getById(id);
	}

	/**
	 * 保存
	 * @param onlineTableColumn OnlineTableColumn 实体
	 * @return OnlineTableColumn 实体
	 */
	public OnlineTableColumn save(OnlineTableColumn onlineTableColumn) {
		return onlineTableColumnService.save(onlineTableColumn);
	}

	/**
	 * 批量保存
	 * @param list 批量数据
	 * @return OnlineTableColumn 实体数组
	 */
	public List<OnlineTableColumn> saveBatch(List<OnlineTableColumn> list) {
		return onlineTableColumnService.saveBatch(list);
	}

	/**
	 * 根据主键更新
	 * @param onlineTableColumn OnlineTableColumn 实体
	 */
	public void update(OnlineTableColumn onlineTableColumn) {
		onlineTableColumnService.update(onlineTableColumn);
	}

	/**
	 * 根据主键 批量更新
	 * @param list 批量数据
	 */
	public void updateBatch(List<OnlineTableColumn> list) {
		onlineTableColumnService.updateBatch(list);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		onlineTableColumnService.deleteById(id);
	}

	/**
	 * 根据主键 批量删除
	 * @param list 批量数据
	 */
	public void deleteBatch(List<OnlineTableColumn> list) {
		onlineTableColumnService.deleteBatch(list);
	}

	/**
	 * 根据表主键删除
	 * @param tableId 主键
	 */
	public void deleteByTableId(String tableId) {
		onlineTableColumnService.deleteByTableId(tableId);
	}

}
