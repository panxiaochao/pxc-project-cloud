package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysMenu;
import io.github.panxiaochao.system.domain.repository.ISysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单配置 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysMenuDomainService {

	/**
	 * SysMenu Domain接口服务类
	 */
	private final ISysMenuService sysMenuService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysMenu 实体
	 */
	public SysMenu getById(String id) {
		return sysMenuService.getById(id);
	}

	/**
	 * 保存
	 * @param sysMenu SysMenu 实体
	 * @return SysMenu 实体
	 */
	public SysMenu save(SysMenu sysMenu) {
		return sysMenuService.save(sysMenu);
	}

	/**
	 * 根据主键更新
	 * @param sysMenu SysMenu 实体
	 */
	public void update(SysMenu sysMenu) {
		sysMenuService.update(sysMenu);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysMenuService.deleteById(id);
	}

}
