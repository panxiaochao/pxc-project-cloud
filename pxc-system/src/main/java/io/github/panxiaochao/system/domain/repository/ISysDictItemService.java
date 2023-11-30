package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysDictItem;

/**
 * <p>
 * 数据字典配置表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysDictItemService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 数据字典配置表 实体
	 */
	SysDictItem getById(String id);

	/**
	 * 保存
	 * @param sysDictItem 角色表 实体
	 * @return 数据字典配置表 实体
	 */
	SysDictItem save(SysDictItem sysDictItem);

	/**
	 * 根据主键更新
	 * @param sysDictItem 数据字典配置表 实体
	 */
	void update(SysDictItem sysDictItem);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
