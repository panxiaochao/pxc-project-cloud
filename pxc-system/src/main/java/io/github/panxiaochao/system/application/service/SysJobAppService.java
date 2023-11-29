package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.system.domain.service.SysJobDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysJobAppService {

	/**
	 * 定时任务调度表 服务类
	 */
	private final SysJobDomainService sysJobDomainService;

}
