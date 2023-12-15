package io.github.panxiaochao.system.application.event;

import io.github.panxiaochao.operate.log.core.annotation.OperateLog;
import io.github.panxiaochao.operate.log.core.domain.OperateLogDomain;
import io.github.panxiaochao.operate.log.core.handler.AbstractOperateLogHandler;
import io.github.panxiaochao.system.application.api.request.sysloglogin.SysLogLoginCreateRequest;
import io.github.panxiaochao.system.application.service.SysLogLoginAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 自定义日志输出
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-05
 */
@Component
@RequiredArgsConstructor
public class OperateLogEventHandler extends AbstractOperateLogHandler {

	/**
	 * 系统日志登录/登出表 App服务类.
	 */
	private final SysLogLoginAppService sysLogLoginAppService;

	/**
	 * 处理日志输出
	 * @param operateLogDomain 存储对象
	 */
	@Override
	public void saveOperateLog(OperateLogDomain operateLogDomain) {
		logger.error(operateLogDomain.toString());
		// 登录日志或者登出日志
		if (operateLogDomain.getBusinessType() == OperateLog.BusinessType.LOGIN.ordinal()
				|| operateLogDomain.getBusinessType() == OperateLog.BusinessType.LOGOUT.ordinal()) {
			SysLogLoginCreateRequest sysLogLoginCreateRequest = new SysLogLoginCreateRequest();
			// 登录账号
			sysLogLoginCreateRequest.setLoginName(operateLogDomain.getValue().toString());
			if (operateLogDomain.getBusinessType() == OperateLog.BusinessType.LOGIN.ordinal()) {
				sysLogLoginCreateRequest.setLoginType(1);
			}
			else {
				sysLogLoginCreateRequest.setLoginType(2);
			}
			sysLogLoginCreateRequest.setIp(operateLogDomain.getIp());
			sysLogLoginCreateRequest.setAddress(operateLogDomain.getAddress());
			sysLogLoginCreateRequest.setBrowser(operateLogDomain.getBrowser());
			sysLogLoginCreateRequest.setOs(operateLogDomain.getOs());
			sysLogLoginCreateRequest.setState(operateLogDomain.getCode().toString());
			// 失败的情况
			if (operateLogDomain.getCode() == 0) {
				sysLogLoginCreateRequest.setRemark(operateLogDomain.getErrorMessage());
			}
			sysLogLoginAppService.save(sysLogLoginCreateRequest);
		}
	}

}
