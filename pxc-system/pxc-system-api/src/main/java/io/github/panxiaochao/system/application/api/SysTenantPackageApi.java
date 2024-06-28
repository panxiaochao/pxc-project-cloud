package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageResponse;
import io.github.panxiaochao.system.application.service.SysTenantPackageAppService;
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
 * 租户套餐表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Tag(name = "租户套餐表 接口", description = "租户套餐表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/systenantpackage")
public class SysTenantPackageApi {

	/**
	 * 租户套餐表 服务
	 */
	private final SysTenantPackageAppService sysTenantPackageAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<SysTenantPackageQueryResponse>> page(RequestPage pageRequest,
			SysTenantPackageQueryRequest queryRequest) {
		return R.ok(sysTenantPackageAppService.page(pageRequest, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "租户套餐表 ID")
	@GetMapping(value = "/{id}")
	public R<SysTenantPackageResponse> getById(@PathVariable("id") String id) {
		return sysTenantPackageAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<SysTenantPackageResponse> save(@RequestBody SysTenantPackageCreateRequest sysTenantPackageCreateRequest) {
		return sysTenantPackageAppService.save(sysTenantPackageCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody SysTenantPackageUpdateRequest sysTenantPackageUpdateRequest) {
		return sysTenantPackageAppService.update(sysTenantPackageUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "租户套餐表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return sysTenantPackageAppService.deleteById(id);
	}

}
