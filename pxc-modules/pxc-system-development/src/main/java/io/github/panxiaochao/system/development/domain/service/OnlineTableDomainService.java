package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.OnlineTable;
import io.github.panxiaochao.system.development.domain.repository.IOnlineTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【在线数据表】 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class OnlineTableDomainService {

	/**
	 * OnlineTable Domain接口服务类
	 */
	private final IOnlineTableService onlineTableService;

	/**
	 * 详情
	 * @param id 主键
	 * @return OnlineTable 实体
	 */
	public OnlineTable getById(String id) {
		return onlineTableService.getById(id);
	}

	/**
	 * 保存
	 * @param onlineTable OnlineTable 实体
	 * @return OnlineTable 实体
	 */
	public OnlineTable save(OnlineTable onlineTable) {
		return onlineTableService.save(onlineTable);
	}

	/**
	 * 批量保存
	 * @param list 批量数据
	 * @return OnlineTable 实体数组
	 */
	public List<OnlineTable> saveBatch(List<OnlineTable> list) {
		return onlineTableService.saveBatch(list);
	}

	/**
	 * 根据主键更新
	 * @param onlineTable OnlineTable 实体
	 */
	public void update(OnlineTable onlineTable) {
		onlineTableService.update(onlineTable);
	}

	/**
	 * 根据主键 批量更新
	 * @param list 批量数据
	 */
	public void updateBatch(List<OnlineTable> list) {
		onlineTableService.updateBatch(list);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		onlineTableService.deleteById(id);
	}

	/**
	 * 根据主键 批量删除
	 * @param list 批量数据
	 */
	public void deleteBatch(List<OnlineTable> list) {
		onlineTableService.deleteBatch(list);
	}

}
