package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysOrg;
import io.github.panxiaochao.system.domain.repository.ISysOrgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构部门表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysOrgDomainService {

	/**
	 * SysOrg Domain接口服务类
	 */
	private final ISysOrgService sysOrgService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysOrg 实体
	 */
	public SysOrg getById(String id) {
		return sysOrgService.getById(id);
	}

	/**
	 * 保存
	 * @param sysOrg SysOrg 实体
	 * @return SysOrg 实体
	 */
	public SysOrg save(SysOrg sysOrg) {
		return sysOrgService.save(sysOrg);
	}

	/**
	 * 根据主键更新
	 * @param sysOrg SysOrg 实体
	 */
	public void update(SysOrg sysOrg) {
		sysOrgService.update(sysOrg);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysOrgService.deleteById(id);
	}

}
