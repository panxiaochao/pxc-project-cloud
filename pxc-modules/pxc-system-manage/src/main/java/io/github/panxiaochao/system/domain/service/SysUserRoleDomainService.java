package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysUserRole;
import io.github.panxiaochao.system.domain.repository.ISysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleDomainService {

	/**
	 * SysUserRole Domain接口服务类
	 */
	private final ISysUserRoleService sysUserRoleService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysUserRole 实体
	 */
	public SysUserRole getById(String id) {
		return sysUserRoleService.getById(id);
	}

	/**
	 * 保存
	 * @param sysUserRole SysUserRole 实体
	 * @return SysUserRole 实体
	 */
	public SysUserRole save(SysUserRole sysUserRole) {
		return sysUserRoleService.save(sysUserRole);
	}

	/**
	 * 根据主键更新
	 * @param sysUserRole SysUserRole 实体
	 */
	public void update(SysUserRole sysUserRole) {
		sysUserRoleService.update(sysUserRole);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysUserRoleService.deleteById(id);
	}

	/**
	 * 批量保存
	 * @param list SysUserRole 数据实体
	 */
	public void saveBatch(List<SysUserRole> list) {
		sysUserRoleService.saveBatch(list);
	}

	/**
	 * 先删除当前用户的所有关联数据
	 * @param userId 用户Id
	 */
	public void deleteByUserId(String userId) {
		sysUserRoleService.deleteByUserId(userId);
	}

}
