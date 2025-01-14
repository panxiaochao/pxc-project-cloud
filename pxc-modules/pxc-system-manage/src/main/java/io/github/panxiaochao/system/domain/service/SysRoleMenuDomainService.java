package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysRoleMenu;
import io.github.panxiaochao.system.domain.repository.ISysRoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色菜单表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Service
@RequiredArgsConstructor
public class SysRoleMenuDomainService {

	/**
	 * SysRoleMenu Domain接口服务类
	 */
	private final ISysRoleMenuService sysRoleMenuService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysRoleMenu 实体
	 */
	public SysRoleMenu getById(String id) {
		return sysRoleMenuService.getById(id);
	}

	/**
	 * 保存
	 * @param sysRoleMenu SysRoleMenu 实体
	 * @return SysRoleMenu 实体
	 */
	public SysRoleMenu save(SysRoleMenu sysRoleMenu) {
		return sysRoleMenuService.save(sysRoleMenu);
	}

	/**
	 * 根据主键更新
	 * @param sysRoleMenu SysRoleMenu 实体
	 */
	public void update(SysRoleMenu sysRoleMenu) {
		sysRoleMenuService.update(sysRoleMenu);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysRoleMenuService.deleteById(id);
	}

	/**
	 * 删除当前角色的所有关联数据
	 * @param roleId 角色Id
	 */
	public void deleteByRoleId(String roleId) {
		sysRoleMenuService.deleteByRoleId(roleId);
	}

	/**
	 * 批量保存
	 * @param list SysRoleMenu 数据实体
	 */
	public void saveBath(List<SysRoleMenu> list) {
		sysRoleMenuService.saveBath(list);
	}

}
