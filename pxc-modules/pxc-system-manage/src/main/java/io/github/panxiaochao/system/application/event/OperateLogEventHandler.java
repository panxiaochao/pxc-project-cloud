package io.github.panxiaochao.system.application.event;

import io.github.panxiaochao.core.utils.ObjectUtil;
import io.github.panxiaochao.operate.log.core.annotation.OperateLog;
import io.github.panxiaochao.operate.log.core.domain.OperateLogDomain;
import io.github.panxiaochao.operate.log.core.handler.AbstractOperateLogHandler;
import io.github.panxiaochao.system.application.api.request.sysloglogin.SysLogLoginCreateRequest;
import io.github.panxiaochao.system.application.api.request.syslogoperate.SysLogOperateCreateRequest;
import io.github.panxiaochao.system.application.service.SysLogLoginAppService;
import io.github.panxiaochao.system.application.service.SysLogOperateAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
	 * 系统日志操作表 App服务类.
	 */
	private final SysLogOperateAppService sysLogOperateAppService;

	/**
	 * 处理日志输出
	 * @param operateLogDomain 存储对象
	 */
	@Override
	public void saveOperateLog(OperateLogDomain operateLogDomain) {
		// TODO
		logger.info(operateLogDomain.toString());
		// 登录日志或者登出日志
		if (operateLogDomain.getBusinessType() == OperateLog.BusinessType.LOGIN.ordinal()
				|| operateLogDomain.getBusinessType() == OperateLog.BusinessType.LOGOUT.ordinal()) {
			SysLogLoginCreateRequest sysLogLoginCreateRequest = new SysLogLoginCreateRequest();
			Object opValue = operateLogDomain.getValue();
			if (operateLogDomain.getBusinessType() == OperateLog.BusinessType.LOGIN.ordinal()) {
				// 登录账号
				String loginName = ObjectUtil.isEmpty(opValue) ? null : operateLogDomain.getValue().toString();
				sysLogLoginCreateRequest.setLoginName(loginName);
				sysLogLoginCreateRequest.setLoginType(1);
				sysLogLoginCreateRequest.setRemark(String.format("%s登录成功！", sysLogLoginCreateRequest.getLoginName()));
			}
			else {
				// if (ObjectUtil.isNotEmpty(opValue)
				// &&
				// opValue.toString().startsWith(PAccessToken.TokenType.BEARER.getValue()))
				// {
				// String tokenValue = opValue.toString()
				// .replace(PAccessToken.TokenType.BEARER.getValue(), StringPools.EMPTY)
				// .trim();
				// LoginUser loginUser =
				// RedissonUtil.get(GlobalConstant.LOGIN_TOKEN_PREFIX + tokenValue);
				// if (ObjectUtil.isNotEmpty(loginUser)) {
				// sysLogLoginCreateRequest.setLoginName(loginUser.getUserName());
				// sysLogLoginCreateRequest.setRemark(String.format("%s登出成功！",
				// loginUser.getUserName()));
				// }
				// }
				// else {
				// sysLogLoginCreateRequest.setLoginName(ObjectUtil.isEmpty(opValue) ?
				// null : opValue.toString());
				// }
				sysLogLoginCreateRequest.setLoginType(2);
				sysLogLoginCreateRequest.setRemark("Token失效登出！");
			}
			sysLogLoginCreateRequest.setIp(operateLogDomain.getIp());
			sysLogLoginCreateRequest.setAddress(operateLogDomain.getAddress());
			sysLogLoginCreateRequest.setBrowser(operateLogDomain.getBrowser());
			sysLogLoginCreateRequest.setOs(operateLogDomain.getOs());
			sysLogLoginCreateRequest.setState(operateLogDomain.getCode().toString());
			// 失败的情况
			if (operateLogDomain.getCode() == 0) {
				sysLogLoginCreateRequest.setRemark(operateLogDomain.getErrorSimpleMessage());
			}
			sysLogLoginAppService.save(sysLogLoginCreateRequest);
		}
		// 操作日志
		else {
			SysLogOperateCreateRequest createRequest = new SysLogOperateCreateRequest();
			// 失败的情况
			if (operateLogDomain.getCode() == 0) {
				createRequest.setLogContent(operateLogDomain.getErrorMessage());
			}
			else {
				createRequest.setLogContent(operateLogDomain.getResponseData().toString());
			}
			createRequest.setOpTitle(operateLogDomain.getTitle());
			createRequest.setOperateType(operateLogDomain.getOperateUsertype());
			createRequest.setIp(operateLogDomain.getIp());
			createRequest.setAddress(operateLogDomain.getAddress());
			createRequest.setMethod(operateLogDomain.getClassMethod());
			createRequest.setRequestUrl(operateLogDomain.getRequestUrl());
			if (StringUtils.hasText(operateLogDomain.getRequestParam())) {
				StringBuilder sb = new StringBuilder();
				sb.append(operateLogDomain.getRequestParam());
				// 考虑到在GET的情况下，会有body数据的情况，特殊情况
				if (StringUtils.hasText(operateLogDomain.getRequestBody())) {
					sb.append("\n").append(operateLogDomain.getRequestBody());
				}
				createRequest.setRequestParams(sb.toString());
			}
			else {
				createRequest.setRequestParams(operateLogDomain.getRequestBody());
			}
			createRequest.setRequestMethod(operateLogDomain.getRequestMethod());
			createRequest.setCostTime(operateLogDomain.getCostTime());
			createRequest.setState(operateLogDomain.getCode().toString());
			createRequest.setBrowser(operateLogDomain.getBrowser());
			createRequest.setOs(operateLogDomain.getOs());
			// LoginUser loginUser = LoginContextHelper.getLoginUser();
			// if (null != loginUser) {
			// createRequest.setOpUser(loginUser.getUserName());
			// }
			sysLogOperateAppService.save(createRequest);
		}
	}

}
