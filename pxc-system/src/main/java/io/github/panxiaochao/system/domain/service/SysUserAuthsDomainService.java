package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysUserAuths;
import io.github.panxiaochao.system.domain.repository.ISysUserAuthsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户授权信息表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserAuthsDomainService {

	/**
	 * SysUserAuths Domain接口服务类
	 */
	private final ISysUserAuthsService sysUserAuthsService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysUserAuths 实体
	 */
	public SysUserAuths getById(String id) {
		return sysUserAuthsService.getById(id);
	}

	/**
	 * 保存
	 * @param sysUserAuths SysUserAuths 实体
	 * @return SysUserAuths 实体
	 */
	public SysUserAuths save(SysUserAuths sysUserAuths) {
		return sysUserAuthsService.save(sysUserAuths);
	}

	/**
	 * 根据主键更新
	 * @param sysUserAuths SysUserAuths 实体
	 */
	public void update(SysUserAuths sysUserAuths) {
		sysUserAuthsService.update(sysUserAuths);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysUserAuthsService.deleteById(id);
	}

	/**
	 * 根据用户ID和登录类型查询列表
	 * @param userId 用户主键
	 * @param identityType 登录类型
	 * @return SysUserAuths 实体列表
	 */
	public List<SysUserAuths> listIdentityType(String userId, String identityType) {
		return sysUserAuthsService.listIdentityType(userId, identityType);
	}

	/**
	 * 根据用户ID删除用户授权信息表所有信息
	 * @param userId 用户主键
	 */
    public void deleteByUserId(String userId) {
		sysUserAuthsService.deleteByUserId(userId);
    }
}
