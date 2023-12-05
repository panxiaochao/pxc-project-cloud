package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysLogLogin;

/**
 * <p>
 * 系统日志登录/登出表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysLogLoginService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 系统日志登录/登出表 实体
	 */
	SysLogLogin getById(String id);

	/**
	 * 保存
	 * @param sysLogLogin 角色表 实体
	 * @return 系统日志登录/登出表 实体
	 */
	SysLogLogin save(SysLogLogin sysLogLogin);

	/**
	 * 根据主键更新
	 * @param sysLogLogin 系统日志登录/登出表 实体
	 */
	void update(SysLogLogin sysLogLogin);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
