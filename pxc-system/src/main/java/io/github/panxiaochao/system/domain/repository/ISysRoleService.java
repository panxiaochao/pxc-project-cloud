package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.SysRole;

/**
 * <p>
 * 角色表 服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
public interface ISysRoleService {

	SysRole getById(String id);

	SysRole save(SysRole sysRole);

	void deleteById(String id);

	void update(SysRole sysRole);

}
