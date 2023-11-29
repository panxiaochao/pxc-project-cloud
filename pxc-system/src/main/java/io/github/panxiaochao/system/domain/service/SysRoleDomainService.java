package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysRole;
import io.github.panxiaochao.system.domain.repository.ISysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysRoleDomainService {

	/**
	 * 角色表 服务类
	 */
	private final ISysRoleService sysRoleService;

	public SysRole getById(String id) {
		return sysRoleService.getById(id);
	}

	public void save(SysRole sysRole) {
		sysRoleService.save(sysRole);
	}

	public void update(SysRole sysRole) {
		sysRoleService.update(sysRole);
	}

	public void deleteById(String id) {
		sysRoleService.deleteById(id);
	}

}
