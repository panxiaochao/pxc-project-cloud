package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysuserrole.SysUserRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuserrole.SysUserRoleResponse;
import io.github.panxiaochao.system.application.service.SysUserRoleAppService;
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
 * 用户角色表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "用户角色表 接口", description = "用户角色表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysuserrole")
public class SysUserRoleApi {

	/**
	 * 用户角色表 服务
	 */
	private final SysUserRoleAppService sysUserRoleAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<SysUserRoleQueryResponse>> page(RequestPage requestPage,
			SysUserRoleQueryRequest queryRequest) {
		return R.ok(sysUserRoleAppService.page(requestPage, queryRequest));
	}

	@Operation(summary = "角色ID数组", description = "根据用户ID查询角色ID数组", method = "GET")
	@GetMapping(value = "/rolesByUserId")
	public R<List<String>> rolesByUserId(String userId) {
		return R.ok(sysUserRoleAppService.rolesByUserId(userId));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "用户角色表 ID")
	@GetMapping(value = "/{id}")
	public R<SysUserRoleResponse> getById(@PathVariable("id") String id) {
		return sysUserRoleAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<Void> save(@RequestBody SysUserRoleCreateRequest sysUserRoleCreateRequest) {
		return sysUserRoleAppService.save(sysUserRoleCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody SysUserRoleUpdateRequest sysUserRoleUpdateRequest) {
		return sysUserRoleAppService.update(sysUserRoleUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "用户角色表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return sysUserRoleAppService.deleteById(id);
	}

}
