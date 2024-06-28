package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysTenantPackageMenu;
import io.github.panxiaochao.system.domain.repository.ISysTenantPackageMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户套餐菜单表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageMenuDomainService {

	/**
	 * SysTenantPackageMenu Domain接口服务类
	 */
	private final ISysTenantPackageMenuService sysTenantPackageMenuService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysTenantPackageMenu 实体
	 */
	public SysTenantPackageMenu getById(String id) {
		return sysTenantPackageMenuService.getById(id);
	}

	/**
	 * 保存
	 * @param sysTenantPackageMenu SysTenantPackageMenu 实体
	 * @return SysTenantPackageMenu 实体
	 */
	public SysTenantPackageMenu save(SysTenantPackageMenu sysTenantPackageMenu) {
		return sysTenantPackageMenuService.save(sysTenantPackageMenu);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantPackageMenu SysTenantPackageMenu 实体
	 */
	public void update(SysTenantPackageMenu sysTenantPackageMenu) {
		sysTenantPackageMenuService.update(sysTenantPackageMenu);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysTenantPackageMenuService.deleteById(id);
	}

}
