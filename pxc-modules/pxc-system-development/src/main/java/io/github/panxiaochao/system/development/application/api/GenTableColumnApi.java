package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.gentablecolumn.GenTableColumnCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentablecolumn.GenTableColumnQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentablecolumn.GenTableColumnUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentablecolumn.GenTableColumnQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentablecolumn.GenTableColumnResponse;
import io.github.panxiaochao.system.development.application.service.GenTableColumnAppService;
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
 * 代码生成表字段 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Tag(name = "代码生成表字段 接口", description = "代码生成表字段 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/gentablecolumn")
public class GenTableColumnApi {

	/**
	 * 代码生成表字段 服务
	 */
	private final GenTableColumnAppService genTableColumnAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<GenTableColumnQueryResponse>> page(RequestPage requestPage,
			GenTableColumnQueryRequest queryRequest) {
		return R.ok(genTableColumnAppService.page(requestPage, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "代码生成表字段 ID")
	@GetMapping(value = "/{id}")
	public R<GenTableColumnResponse> getById(@PathVariable("id") String id) {
		return genTableColumnAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<GenTableColumnResponse> save(@RequestBody GenTableColumnCreateRequest genTableColumnCreateRequest) {
		return genTableColumnAppService.save(genTableColumnCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody GenTableColumnUpdateRequest genTableColumnUpdateRequest) {
		return genTableColumnAppService.update(genTableColumnUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "代码生成表字段 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return genTableColumnAppService.deleteById(id);
	}

}
