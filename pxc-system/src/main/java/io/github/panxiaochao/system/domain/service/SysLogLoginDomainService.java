package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysLogLogin;
import io.github.panxiaochao.system.domain.repository.ISysLogLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志登录/登出表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysLogLoginDomainService {

	/**
	 * SysLogLogin Domain接口服务类
	 */
	private final ISysLogLoginService sysLogLoginService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysLogLogin 实体
	 */
	public SysLogLogin getById(String id) {
		return sysLogLoginService.getById(id);
	}

	/**
	 * 保存
	 * @param sysLogLogin SysLogLogin 实体
	 * @return SysLogLogin 实体
	 */
	public SysLogLogin save(SysLogLogin sysLogLogin) {
		return sysLogLoginService.save(sysLogLogin);
	}

	/**
	 * 根据主键更新
	 * @param sysLogLogin SysLogLogin 实体
	 */
	public void update(SysLogLogin sysLogLogin) {
		sysLogLoginService.update(sysLogLogin);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysLogLoginService.deleteById(id);
	}

}
