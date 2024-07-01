package io.github.panxiaochao.system.auth.api;

import cn.hutool.core.util.StrUtil;
import io.github.panxiaochao.core.component.tree.Tree;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.operate.log.core.annotation.OperateLog;
import io.github.panxiaochao.ratelimiter.annotation.RateLimiter;
import io.github.panxiaochao.system.auth.api.response.LoginUserResponse;
import io.github.panxiaochao.system.auth.api.response.TokenOnlineQueryResponse;
import io.github.panxiaochao.system.auth.request.LoginRequest;
import io.github.panxiaochao.system.auth.service.WebLoginService;
import io.github.panxiaochao.system.common.core.token.PAccessToken;
import io.github.panxiaochao.system.common.model.PAuthUserToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/web/v1")
public class WebLoginApi {

	private final WebLoginService loginWebService;

	/**
	 * 登录接口，用户3秒内请勿重复登录
	 * @param loginRequest 登录 请求对象
	 * @return 成功: token
	 */
	@PostMapping("/login")
	@RateLimiter(key = "#loginRequest.username", maxCount = 1, limitTime = 3000, message = "请勿重复登录")
	@OperateLog(key = "#loginRequest.username", description = "登录", businessType = OperateLog.BusinessType.LOGIN)
	@Operation(summary = "登录接口", description = "登录接口", method = "POST")
	public R<PAuthUserToken> login(@RequestBody @Validated LoginRequest loginRequest) {
		return R.ok(loginWebService.login(loginRequest));
	}

	/**
	 * 登出
	 */
	@PostMapping("/logout")
	@Operation(summary = "登出接口", description = "登出接口", method = "POST")
	public R<Boolean> logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
		if (StrUtil.isBlank(authHeader)) {
			return R.ok();
		}
		String tokenValue = authHeader.replace(PAccessToken.TokenType.BEARER.getValue(), StringPools.EMPTY).trim();
		return removeToken(tokenValue);
	}

	/**
	 * 移除令牌
	 * @param token token
	 */
	@DeleteMapping("/remove/{token}")
	@Operation(summary = "移除令牌", description = "移除令牌", method = "DELETE")
	public R<Boolean> removeToken(@PathVariable("token") String token) {
		return R.ok(loginWebService.removeToken(token));
	}

	/**
	 * 在线用户分页令牌管理
	 */
	@GetMapping("/token/page")
	@Operation(summary = "在线用户分页令牌管理", description = "在线用户分页令牌管理", method = "GET")
	public R<PageResponse<TokenOnlineQueryResponse>> tokenPage(RequestPage pageRequest, String username) {
		return R.ok(loginWebService.tokenPage(pageRequest, username));
	}

	/**
	 * 获取当前登录用户信息
	 */
	@GetMapping("/userinfo")
	@Operation(summary = "获取当前登录用户信息", description = "获取当前登录用户信息", method = "GET")
	public R<LoginUserResponse> userinfo() {
		return R.ok(loginWebService.userinfo());
	}

	/**
	 * 根据当前用户查询菜单列表（用户权限下的菜单）
	 */
	@GetMapping("/currentUserRouters")
	@Operation(summary = "根据当前用户查询菜单列表", description = "根据当前用户查询菜单列表（用户权限下的菜单）", method = "GET")
	public R<List<Tree<String>>> currentUserRouters() {
		return R.ok(loginWebService.currentUserRouters());
	}

}
