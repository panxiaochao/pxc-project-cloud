package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysArea;

/**
 * <p>
 * 全国5级行政区划 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysAreaService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 全国5级行政区划 实体
	 */
	SysArea getById(String id);

	/**
	 * 保存
	 * @param sysArea 角色表 实体
	 * @return 全国5级行政区划 实体
	 */
	SysArea save(SysArea sysArea);

	/**
	 * 根据主键更新
	 * @param sysArea 全国5级行政区划 实体
	 */
	void update(SysArea sysArea);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
