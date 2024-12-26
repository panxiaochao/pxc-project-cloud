package io.github.panxiaochao.code.generator.application.api;

import io.github.panxiaochao.code.generator.application.api.request.gentable.GenTableCreateRequest;
import io.github.panxiaochao.code.generator.application.api.request.gentable.GenTableUpdateRequest;
import io.github.panxiaochao.code.generator.application.api.response.gentable.GenTableResponse;
import io.github.panxiaochao.code.generator.application.service.GenTableAppService;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.RequestPage;
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
 * 代码生成表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Tag(name = "代码生成表 接口", description = "代码生成表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/codegen/v1/gentable")
public class GenTableApi {

	/**
	 * 代码生成表 服务
	 */
	private final GenTableAppService genTableAppService;

	// @Operation(summary = "查询分页", description = "查询分页", method = "GET")
	// @GetMapping(value = "/page")
	// public R<PageResponse<GenTableQueryResponse>> page(RequestPage requestPage, GenTableQueryRequest queryRequest) {
	// 	return R.ok(genTableAppService.page(requestPage, queryRequest));
	// }
	@Operation(summary = "查询数据源下的元数据表分页", description = "查询数据源下的元数据表分页", method = "GET")
	@GetMapping(value = "/dsTablePage")
	public R queryDsTablePage(RequestPage requestPage){
		return  R.ok(genTableAppService.queryDsTablePage(requestPage));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "代码生成表 ID")
	@GetMapping(value = "/{id}")
	public R<GenTableResponse> getById(@PathVariable("id") String id) {
		return genTableAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<GenTableResponse> save(@RequestBody GenTableCreateRequest genTableCreateRequest) {
		return genTableAppService.save(genTableCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody GenTableUpdateRequest genTableUpdateRequest) {
		return genTableAppService.update(genTableUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "代码生成表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return genTableAppService.deleteById(id);
	}

}
