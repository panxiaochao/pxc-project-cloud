package io.github.panxiaochao.system.application.web;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.repeatsubmit.annotation.RepeatSubmitLimiter;
import io.github.panxiaochao.system.application.web.request.LoginRequest;
import io.github.panxiaochao.system.application.web.service.LoginWebService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
public class LoginWebController {

	private final LoginWebService loginWebService;

	/**
	 * 登录接口，3秒内请勿重复登录
	 * @param loginRequest 登录 请求对象
	 * @return 成功: token
	 */
	@PostMapping
	@RepeatSubmitLimiter(interval = 3000, message = "请勿重复登录")
	public R<Object> login(@RequestBody @Validated LoginRequest loginRequest) {
		Map<String, Object> loginMap = loginWebService.login(loginRequest);
		return R.ok(loginMap);
	}

}
