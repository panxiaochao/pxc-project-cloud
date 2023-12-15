package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysrole.SysRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysrole.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysrole.SysRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysrole.SysRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysrole.SysRoleResponse;
import io.github.panxiaochao.system.application.service.SysRoleAppService;
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

/**
 * <p>
 * 角色表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "角色表 接口", description = "角色表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysrole")
public class SysRoleApi {

	/**
	 * 角色表 服务
	 */
	private final SysRoleAppService sysRoleAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<SysRoleQueryResponse>> page(RequestPage pageRequest, SysRoleQueryRequest queryRequest) {
		return R.ok(sysRoleAppService.page(pageRequest, queryRequest));
	}

	@Operation(summary = "角色数组", description = "角色数组", method = "GET")
	@GetMapping(value = "/listRole")
	public R<List<SysRoleQueryResponse>> listRole(SysRoleQueryRequest queryRequest) {
		return R.ok(sysRoleAppService.listRole(queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "角色表 ID")
	@GetMapping(value = "/{id}")
	public R<SysRoleResponse> getById(@PathVariable("id") String id) {
		return sysRoleAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<SysRoleResponse> save(@RequestBody SysRoleCreateRequest sysRoleCreateRequest) {
		return sysRoleAppService.save(sysRoleCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody SysRoleUpdateRequest sysRoleUpdateRequest) {
		return sysRoleAppService.update(sysRoleUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "角色表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return sysRoleAppService.deleteById(id);
	}

}
