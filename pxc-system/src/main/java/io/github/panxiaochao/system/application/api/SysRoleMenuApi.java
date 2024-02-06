package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuResponse;
import io.github.panxiaochao.system.application.service.SysRoleMenuAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<SysRoleMenuQueryResponse>> page(RequestPage pageRequest,
			SysRoleMenuQueryRequest queryRequest) {
		return R.ok(sysRoleMenuAppService.page(pageRequest, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "角色菜单表 ID")
	@GetMapping(value = "/{id}")
	public R<SysRoleMenuResponse> getById(@PathVariable("id") String id) {
		return sysRoleMenuAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<SysRoleMenuResponse> save(@RequestBody SysRoleMenuCreateRequest sysRoleMenuCreateRequest) {
		return sysRoleMenuAppService.save(sysRoleMenuCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody SysRoleMenuUpdateRequest sysRoleMenuUpdateRequest) {
		return sysRoleMenuAppService.update(sysRoleMenuUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "角色菜单表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return sysRoleMenuAppService.deleteById(id);
	}

}
