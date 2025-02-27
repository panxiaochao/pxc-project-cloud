package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantResponse;
import io.github.panxiaochao.system.application.service.SysTenantAppService;
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
 * 租户表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Tag(name = "租户表 接口", description = "租户表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/systenant")
public class SysTenantApi {

	/**
	 * 租户表 服务
	 */
	private final SysTenantAppService sysTenantAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<SysTenantQueryResponse>> page(RequestPage pageRequest, SysTenantQueryRequest queryRequest) {
		return R.ok(sysTenantAppService.page(pageRequest, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "租户表 ID")
	@GetMapping(value = "/{id}")
	public R<SysTenantResponse> getById(@PathVariable("id") String id) {
		return sysTenantAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<SysTenantResponse> save(@RequestBody SysTenantCreateRequest sysTenantCreateRequest) {
		return sysTenantAppService.save(sysTenantCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody SysTenantUpdateRequest sysTenantUpdateRequest) {
		return sysTenantAppService.update(sysTenantUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "租户表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return sysTenantAppService.deleteById(id);
	}

	@Operation(summary = "获取租户模式下拉菜单", description = "获取租户模式下拉菜单", method = "GET")
	@GetMapping(value = "/selectModes")
	public R<List<Select<String>>> selectModes() {
		return R.ok(sysTenantAppService.selectModes());
	}

}
