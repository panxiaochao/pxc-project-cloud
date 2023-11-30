package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysUserOrg;
import io.github.panxiaochao.system.domain.repository.ISysUserOrgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户机构/部门表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysUserOrgDomainService {

	/**
	 * SysUserOrg Domain接口服务类
	 */
	private final ISysUserOrgService sysUserOrgService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysUserOrg 实体
	 */
	public SysUserOrg getById(String id) {
		return sysUserOrgService.getById(id);
	}

	/**
	 * 保存
	 * @param sysUserOrg SysUserOrg 实体
	 * @return SysUserOrg 实体
	 */
	public SysUserOrg save(SysUserOrg sysUserOrg) {
		return sysUserOrgService.save(sysUserOrg);
	}

	/**
	 * 根据主键更新
	 * @param sysUserOrg SysUserOrg 实体
	 */
	public void update(SysUserOrg sysUserOrg) {
		sysUserOrgService.update(sysUserOrg);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysUserOrgService.deleteById(id);
	}

}
