package io.github.panxiaochao.system.auth.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.operate.log.core.annotation.OperateLog;
import io.github.panxiaochao.ratelimiter.annotation.RateLimiter;
import io.github.panxiaochao.system.auth.request.LoginRequest;
import io.github.panxiaochao.system.auth.service.WebLoginService;
import io.github.panxiaochao.system.common.model.AuthUserToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 登录管理.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Tag(name = "登录管理 接口", description = "登录管理 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/web/v1/login")
public class WebLoginApi {

	private final WebLoginService loginWebService;

	/**
	 * 登录接口，用户3秒内请勿重复登录
	 * @param loginRequest 登录 请求对象
	 * @return 成功: token
	 */
	@PostMapping
	@RateLimiter(key = "#loginRequest.username", maxCount = 1, limitTime = 3000, message = "请勿重复登录")
	@OperateLog(key = "#loginRequest.username", description = "登录", businessType = OperateLog.BusinessType.LOGIN)
	@Operation(summary = "登录接口", description = "登录接口", method = "POST")
	public R<AuthUserToken> login(@RequestBody @Validated LoginRequest loginRequest) {
		return loginWebService.login(loginRequest);
	}

	/**
	 * 登出
	 */
	@PostMapping("/logout")
	@OperateLog(key = "#username", description = "登出", businessType = OperateLog.BusinessType.LOGOUT)
	@Operation(summary = "登出接口", description = "登出接口", method = "POST")
	public R<Void> logout(String username) {
		return R.ok();
	}

}
