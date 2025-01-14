package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysTenant;
import io.github.panxiaochao.system.domain.repository.ISysTenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantDomainService {

	/**
	 * SysTenant Domain接口服务类
	 */
	private final ISysTenantService sysTenantService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysTenant 实体
	 */
	public SysTenant getById(String id) {
		return sysTenantService.getById(id);
	}

	/**
	 * 保存
	 * @param sysTenant SysTenant 实体
	 * @return SysTenant 实体
	 */
	public SysTenant save(SysTenant sysTenant) {
		return sysTenantService.save(sysTenant);
	}

	/**
	 * 根据主键更新
	 * @param sysTenant SysTenant 实体
	 */
	public void update(SysTenant sysTenant) {
		sysTenantService.update(sysTenant);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysTenantService.deleteById(id);
	}

}
