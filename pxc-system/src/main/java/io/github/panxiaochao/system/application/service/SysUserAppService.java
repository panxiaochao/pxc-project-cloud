package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.system.domain.service.SysUserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysUserAppService {

	/**
	 * 用户表 服务类
	 */
	private final SysUserDomainService sysUserDomainService;

}
