package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysdict.SysDictCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysdict.SysDictQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysdict.SysDictUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysdict.SysDictQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysdict.SysDictResponse;
import io.github.panxiaochao.system.application.service.SysDictAppService;
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
 * 数据字典表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "数据字典表 接口", description = "数据字典表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysdict")
public class SysDictApi {

	/**
	 * 数据字典表 服务
	 */
	private final SysDictAppService sysDictAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<SysDictQueryResponse>> page(RequestPage pageRequest, SysDictQueryRequest queryRequest) {
		return R.ok(sysDictAppService.page(pageRequest, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "数据字典表 ID")
	@GetMapping(value = "/{id}")
	public R<SysDictResponse> getById(@PathVariable("id") String id) {
		return sysDictAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<SysDictResponse> save(@RequestBody SysDictCreateRequest sysDictCreateRequest) {
		return sysDictAppService.save(sysDictCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody SysDictUpdateRequest sysDictUpdateRequest) {
		return sysDictAppService.update(sysDictUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "数据字典表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return sysDictAppService.deleteById(id);
	}

}
