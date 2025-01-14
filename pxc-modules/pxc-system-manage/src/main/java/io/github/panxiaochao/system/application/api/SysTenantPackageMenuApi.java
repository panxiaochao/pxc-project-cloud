package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuCreateRequest;
import io.github.panxiaochao.system.application.service.SysTenantPackageMenuAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 租户套餐菜单表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Tag(name = "租户套餐菜单表 接口", description = "租户套餐菜单表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/systenantpackagemenu")
public class SysTenantPackageMenuApi {

	/**
	 * 租户套餐菜单表 服务
	 */
	private final SysTenantPackageMenuAppService sysTenantPackageMenuAppService;

	@Operation(summary = "保存套餐关联菜单", description = "保存套餐关联菜单", method = "POST")
	@PostMapping("/savePackageMenus")
	public R<Void> savePackageMenus(@RequestBody SysTenantPackageMenuCreateRequest sysTenantPackageMenuCreateRequest) {
		sysTenantPackageMenuAppService.savePackageMenus(sysTenantPackageMenuCreateRequest);
		return R.ok();
	}

	@Operation(summary = "查询租户套餐下的菜单权限", description = "查询租户套餐下的菜单权限", method = "GET")
	@Parameter(name = "packageId", description = "租户套餐ID")
	@GetMapping("/queryPackageMenus")
	public R<List<String>> queryPackageMenus(@RequestParam String packageId) {
		return sysTenantPackageMenuAppService.queryPackageMenus(packageId);
	}

}
