package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuCreateRequest;
import io.github.panxiaochao.system.application.service.SysRoleMenuAppService;
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
 * 角色菜单表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Tag(name = "角色菜单表 接口", description = "角色菜单表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysrolemenu")
public class SysRoleMenuApi {

	/**
	 * 角色菜单表 服务
	 */
	private final SysRoleMenuAppService sysRoleMenuAppService;

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping("/saveRoleMenus")
	public R<Void> saveRoleMenus(@RequestBody SysRoleMenuCreateRequest sysRoleMenuCreateRequest) {
		sysRoleMenuAppService.saveRoleMenus(sysRoleMenuCreateRequest);
		return R.ok();
	}

	@Operation(summary = "查询角色下的菜单权限", description = "查询角色下的菜单权限", method = "GET")
	@Parameter(name = "roleId", description = "角色ID")
	@GetMapping("/queryRoleMenus")
	public R<List<String>> queryRoleMenus(@RequestParam String roleId) {
		return sysRoleMenuAppService.queryRoleMenus(roleId);
	}

}
