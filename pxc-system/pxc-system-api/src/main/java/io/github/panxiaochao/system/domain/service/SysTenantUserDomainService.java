package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysTenantUser;
import io.github.panxiaochao.system.domain.repository.ISysTenantUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租户用户表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Service
@RequiredArgsConstructor
public class SysTenantUserDomainService {

	/**
	 * SysTenantUser Domain接口服务类
	 */
	private final ISysTenantUserService sysTenantUserService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysTenantUser 实体
	 */
	public SysTenantUser getById(String id) {
		return sysTenantUserService.getById(id);
	}

	/**
	 * 保存
	 * @param sysTenantUser SysTenantUser 实体
	 * @return SysTenantUser 实体
	 */
	public SysTenantUser save(SysTenantUser sysTenantUser) {
		return sysTenantUserService.save(sysTenantUser);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantUser SysTenantUser 实体
	 */
	public void update(SysTenantUser sysTenantUser) {
		sysTenantUserService.update(sysTenantUser);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysTenantUserService.deleteById(id);
	}

	/**
	 * 批量保存
	 * @param list 批量数据
	 */
	public void saveBath(List<SysTenantUser> list) {
		sysTenantUserService.saveBath(list);
	}

	/**
	 * 根据租户ID和用户ID删除
	 * @param sysTenantUser 实体
	 */
	public void deleteTenantUser(SysTenantUser sysTenantUser) {
		sysTenantUserService.deleteTenantUser(sysTenantUser);
	}

}
