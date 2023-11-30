package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysParam;

/**
 * <p>
 * 系统参数 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysParamService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 系统参数 实体
	 */
	SysParam getById(String id);

	/**
	 * 保存
	 * @param sysParam 角色表 实体
	 * @return 系统参数 实体
	 */
	SysParam save(SysParam sysParam);

	/**
	 * 根据主键更新
	 * @param sysParam 系统参数 实体
	 */
	void update(SysParam sysParam);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
