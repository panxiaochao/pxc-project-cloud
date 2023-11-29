package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.service.SysRoleAppService;
import io.github.panxiaochao.system.domain.entity.SysRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "角色表", description = "角色表Api")
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
	public R<PageResponse> listByPage(@RequestBody RequestPage<SysRoleQueryRequest> pageRequest) {
		return R.ok();
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "角色ID")
	@GetMapping(value = "/{id}")
	public R<SysRole> getById(@PathVariable("id") String id) {
		return R.ok();
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<String> save(@RequestBody SysRoleCreateRequest SysRoleCreateRequest) {
		return R.ok();
	}

	@Operation(summary = "更新", description = "更新", method = "PUT")
	@PutMapping
	public R<String> update(@RequestBody SysRole SysRole) {
		return R.ok();
	}

	@Operation(summary = "删除", description = "删除", method = "DELETE")
	@Parameter(name = "id", description = "角色ID")
	@DeleteMapping(value = "/{id}")
	public R<String> deleteById(@PathVariable("id") String id) {
		return R.ok();
	}

}
