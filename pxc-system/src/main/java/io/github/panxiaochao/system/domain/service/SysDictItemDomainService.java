package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysDictItem;
import io.github.panxiaochao.system.domain.repository.ISysDictItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典配置表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysDictItemDomainService {

	/**
	 * SysDictItem Domain接口服务类
	 */
	private final ISysDictItemService sysDictItemService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysDictItem 实体
	 */
	public SysDictItem getById(String id) {
		return sysDictItemService.getById(id);
	}

	/**
	 * 保存
	 * @param sysDictItem SysDictItem 实体
	 * @return SysDictItem 实体
	 */
	public SysDictItem save(SysDictItem sysDictItem) {
		return sysDictItemService.save(sysDictItem);
	}

	/**
	 * 根据主键更新
	 * @param sysDictItem SysDictItem 实体
	 */
	public void update(SysDictItem sysDictItem) {
		sysDictItemService.update(sysDictItem);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysDictItemService.deleteById(id);
	}

}
