package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysUserCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysUserQueryRequest;
import io.github.panxiaochao.system.application.service.SysUserAppService;
import io.github.panxiaochao.system.domain.entity.SysUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "用户表", description = "用户表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysuser")
public class SysUserApi {

	/**
	 * 用户表 服务
	 */
	private final SysUserAppService sysUserAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse> page(@RequestBody RequestPage<SysUserQueryRequest> pageRequest) {
		return R.ok();
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "用户ID")
	@GetMapping(value = "/{id}")
	public R<SysUser> getById(@PathVariable("id") String id) {
		return R.ok();
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<String> save(@RequestBody SysUserCreateRequest sysUserCreateRequest) {
		return R.ok();
	}

	@Operation(summary = "更新", description = "更新", method = "PUT")
	@PutMapping
	public R<String> update(@RequestBody SysUser sysUser) {
		return R.ok();
	}

	@Operation(summary = "删除", description = "删除", method = "DELETE")
	@Parameter(name = "id", description = "用户ID")
	@DeleteMapping(value = "/{id}")
	public R<String> deleteById(@PathVariable("id") String id) {
		return R.ok();
	}

}
