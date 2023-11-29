package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.system.domain.service.SysLogLoginDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志登录/登出表 服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysLogLoginAppService {

	/**
	 * 系统日志登录/登出表 服务类
	 */
	private final SysLogLoginDomainService sysLogLoginDomainService;

}
