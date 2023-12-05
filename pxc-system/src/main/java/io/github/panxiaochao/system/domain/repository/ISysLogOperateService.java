package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysLogOperate;

/**
 * <p>
 * 系统日志操作表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysLogOperateService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 系统日志操作表 实体
	 */
	SysLogOperate getById(String id);

	/**
	 * 保存
	 * @param sysLogOperate 角色表 实体
	 * @return 系统日志操作表 实体
	 */
	SysLogOperate save(SysLogOperate sysLogOperate);

	/**
	 * 根据主键更新
	 * @param sysLogOperate 系统日志操作表 实体
	 */
	void update(SysLogOperate sysLogOperate);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
