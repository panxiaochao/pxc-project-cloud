package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.system.domain.service.SysUserAuthsDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户授权信息表 服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysUserAuthsAppService {

	/**
	 * 用户授权信息表 服务类
	 */
	private final SysUserAuthsDomainService sysUserAuthsDomainService;

}
