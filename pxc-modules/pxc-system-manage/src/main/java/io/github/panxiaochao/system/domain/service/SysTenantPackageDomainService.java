package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysTenantPackage;
import io.github.panxiaochao.system.domain.repository.ISysTenantPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户套餐表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageDomainService {

	/**
	 * SysTenantPackage Domain接口服务类
	 */
	private final ISysTenantPackageService sysTenantPackageService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysTenantPackage 实体
	 */
	public SysTenantPackage getById(String id) {
		return sysTenantPackageService.getById(id);
	}

	/**
	 * 保存
	 * @param sysTenantPackage SysTenantPackage 实体
	 * @return SysTenantPackage 实体
	 */
	public SysTenantPackage save(SysTenantPackage sysTenantPackage) {
		return sysTenantPackageService.save(sysTenantPackage);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantPackage SysTenantPackage 实体
	 */
	public void update(SysTenantPackage sysTenantPackage) {
		sysTenantPackageService.update(sysTenantPackage);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysTenantPackageService.deleteById(id);
	}

}
