package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserCreateRequest;
import io.github.panxiaochao.system.application.service.SysTenantUserAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 租户用户表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Tag(name = "租户用户表 接口", description = "租户用户表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/systenantuser")
public class SysTenantUserApi {

	/**
	 * 租户用户表 服务
	 */
	private final SysTenantUserAppService sysTenantUserAppService;

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping("/saveTenantUsers")
	public R<Void> saveTenantUsers(@RequestBody SysTenantUserCreateRequest sysTenantUserCreateRequest) {
		sysTenantUserAppService.saveTenantUsers(sysTenantUserCreateRequest);
		return R.ok();
	}

	@Operation(summary = "删除", description = "根据租户ID和用户ID删除", method = "POST")
	@PostMapping("/deleteTenantUser")
	public R<Void> deleteTenantUser(@RequestBody SysTenantUserCreateRequest sysTenantUserCreateRequest) {
		return sysTenantUserAppService.deleteTenantUser(sysTenantUserCreateRequest);
	}
}
