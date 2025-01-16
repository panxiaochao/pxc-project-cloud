package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.gentable.DsQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentable.GenTableCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentable.GenTableQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentable.GenTableUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentable.GenTableQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentable.GenTableResponse;
import io.github.panxiaochao.system.development.application.api.response.gentable.TableMetaQueryResponse;
import io.github.panxiaochao.system.development.application.service.GenTableAppService;
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
 * 代码生成表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Tag(name = "代码生成表 接口", description = "代码生成表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/gentable")
public class GenTableApi {

	/**
	 * 代码生成表 服务
	 */
	private final GenTableAppService genTableAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<GenTableQueryResponse>> page(RequestPage requestPage, GenTableQueryRequest queryRequest) {
		return R.ok(genTableAppService.page(requestPage, queryRequest));
	}

	@Operation(summary = "查询动态数据源下的元数据表分页", description = "查询动态数据源下的元数据表分页", method = "GET")
	@GetMapping(value = "/queryDsTablePage")
	public R<PageResponse<TableMetaQueryResponse>> queryDsTablePage(RequestPage requestPage,
			DsQueryRequest dsQueryRequest) {
		return R.ok(genTableAppService.queryDsTablePage(requestPage, dsQueryRequest));
	}

	@Operation(summary = "查询动态数据源下的元数据表", description = "查询动态数据源下的元数据表分", method = "GET")
	@GetMapping(value = "/queryDsTable")
	public R<List<TableMetaQueryResponse>> queryDsTable(DsQueryRequest dsQueryRequest) {
		return R.ok(genTableAppService.queryDsTable(dsQueryRequest));
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

	// @Operation(summary = "同步动态数据源状态", description = "同步动态数据源状态", method = "GET")
	// @GetMapping(value = "/syncDataSource")
	// public R<Void> syncDataSource(){
	// return genTableAppService.syncDataSource();
	// }

	@Operation(summary = "通过选择数据源导入需要生成代码的数据表", description = "通过选择数据源导入需要生成代码的数据表", method = "POST")
	@PostMapping(value = "/importTables/{databaseId}")
	public R<Void> importTables(@PathVariable("databaseId") String databaseId, @RequestBody List<String> tableNames) {
		genTableAppService.importTables(databaseId, tableNames);
		return R.ok();
	}

}
