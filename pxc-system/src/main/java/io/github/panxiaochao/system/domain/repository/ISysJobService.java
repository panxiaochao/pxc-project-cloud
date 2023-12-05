package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysJob;

/**
 * <p>
 * 定时任务调度表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysJobService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 定时任务调度表 实体
	 */
	SysJob getById(String id);

	/**
	 * 保存
	 * @param sysJob 角色表 实体
	 * @return 定时任务调度表 实体
	 */
	SysJob save(SysJob sysJob);

	/**
	 * 根据主键更新
	 * @param sysJob 定时任务调度表 实体
	 */
	void update(SysJob sysJob);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
