package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysRole;
import io.github.panxiaochao.system.domain.repository.ISysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysRoleDomainService {

	/**
	 * SysRole Domain接口服务类
	 */
	private final ISysRoleService sysRoleService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysRole 实体
	 */
	public SysRole getById(String id) {
		return sysRoleService.getById(id);
	}

	/**
	 * 保存
	 * @param sysRole SysRole 实体
	 * @return SysRole 实体
	 */
	public SysRole save(SysRole sysRole) {
		return sysRoleService.save(sysRole);
	}

	/**
	 * 根据主键更新
	 * @param sysRole SysRole 实体
	 */
	public void update(SysRole sysRole) {
		sysRoleService.update(sysRole);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysRoleService.deleteById(id);
	}

}
