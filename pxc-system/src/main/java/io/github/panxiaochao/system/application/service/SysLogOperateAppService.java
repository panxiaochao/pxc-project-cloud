package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.system.domain.service.SysLogOperateDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志操作表 服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysLogOperateAppService {

	/**
	 * 系统日志操作表 服务类
	 */
	private final SysLogOperateDomainService sysLogOperateDomainService;

}
