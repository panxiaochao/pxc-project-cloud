package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysUser;
import io.github.panxiaochao.system.domain.repository.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysUserDomainService {

	/**
	 * SysUser Domain接口服务类
	 */
	private final ISysUserService sysUserService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysUser 实体
	 */
	public SysUser getById(String id) {
		return sysUserService.getById(id);
	}

	/**
	 * 保存
	 * @param sysUser SysUser 实体
	 * @return SysUser 实体
	 */
	public SysUser save(SysUser sysUser) {
		return sysUserService.save(sysUser);
	}

	/**
	 * 根据主键更新
	 * @param sysUser SysUser 实体
	 */
	public void update(SysUser sysUser) {
		sysUserService.update(sysUser);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysUserService.deleteById(id);
	}

}
