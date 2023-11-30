package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysPost;

/**
 * <p>
 * 岗位表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
public interface ISysPostService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 岗位表 实体
	 */
	SysPost getById(String id);

	/**
	 * 保存
	 * @param sysPost 角色表 实体
	 * @return 岗位表 实体
	 */
	SysPost save(SysPost sysPost);

	/**
	 * 根据主键更新
	 * @param sysPost 岗位表 实体
	 */
	void update(SysPost sysPost);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);

}
