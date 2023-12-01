package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.PersistentLoginsCreateRequest;
import io.github.panxiaochao.system.application.api.request.PersistentLoginsQueryRequest;
import io.github.panxiaochao.system.application.api.request.PersistentLoginsUpdateRequest;
import io.github.panxiaochao.system.application.api.response.PersistentLoginsQueryResponse;
import io.github.panxiaochao.system.application.api.response.PersistentLoginsResponse;
import io.github.panxiaochao.system.application.service.PersistentLoginsAppService;
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
 * 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = " 接口", description = " Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/persistentlogins")
public class PersistentLoginsApi {

	/**
	 * 服务
	 */
	private final PersistentLoginsAppService persistentLoginsAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<PersistentLoginsQueryResponse>> page(
			@RequestBody RequestPage<PersistentLoginsQueryRequest> pageRequest) {
		return R.ok(persistentLoginsAppService.page(pageRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = " ID")
	@GetMapping(value = "/{id}")
	public R<PersistentLoginsResponse> getById(@PathVariable("id") String id) {
		return persistentLoginsAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<PersistentLoginsResponse> save(@RequestBody PersistentLoginsCreateRequest persistentLoginsCreateRequest) {
		return persistentLoginsAppService.save(persistentLoginsCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody PersistentLoginsUpdateRequest persistentLoginsUpdateRequest) {
		return persistentLoginsAppService.update(persistentLoginsUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = " ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return persistentLoginsAppService.deleteById(id);
	}

}
