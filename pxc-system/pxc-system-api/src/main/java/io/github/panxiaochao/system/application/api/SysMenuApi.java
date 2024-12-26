package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.component.tree.Tree;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuResponse;
import io.github.panxiaochao.system.application.service.SysMenuAppService;
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

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单配置 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "菜单配置 接口", description = "菜单配置 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysmenu")
public class SysMenuApi {

	/**
	 * 菜单配置 服务
	 */
	private final SysMenuAppService sysMenuAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<SysMenuQueryResponse>> page(RequestPage requestPage, SysMenuQueryRequest queryRequest) {
		return R.ok(sysMenuAppService.page(requestPage, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "菜单配置 ID")
	@GetMapping(value = "/{id}")
	public R<SysMenuResponse> getById(@PathVariable("id") String id) {
		return sysMenuAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<SysMenuResponse> save(@RequestBody SysMenuCreateRequest sysMenuCreateRequest) {
		return sysMenuAppService.save(sysMenuCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody SysMenuUpdateRequest sysMenuUpdateRequest) {
		return sysMenuAppService.update(sysMenuUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "菜单配置 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return sysMenuAppService.deleteById(id);
	}

	@Operation(summary = "获取菜单表格树列表", description = "获取菜单表格树列表", method = "GET")
	@Parameter(name = "menuId", description = "菜单ID")
	@GetMapping(value = "/tableTree")
	public R<List<Tree<String>>> tableTree(String menuId) {
		return R.ok(sysMenuAppService.tableTree(menuId));
	}

	@Operation(summary = "获取菜单树下拉", description = "获取菜单树下拉", method = "GET")
	@Parameter(name = "menuId", description = "菜单ID")
	@Parameter(name = "isOnlyMenu", description = "是否只显示菜单，排除按钮")
	@GetMapping(value = "/listTree")
	public R<List<Tree<String>>> listTree(String menuId, boolean isOnlyMenu) {
		return R.ok(sysMenuAppService.listTree(menuId, isOnlyMenu));
	}

	@Operation(summary = "获取所有菜单树下拉", description = "获取所有菜单树下拉，用于下拉角色关联权限", method = "GET")
	@GetMapping(value = "/queryAllTree")
	public R<Map<String, Object>> queryAllTree() {
		return R.ok(sysMenuAppService.queryAllTree());
	}

}
