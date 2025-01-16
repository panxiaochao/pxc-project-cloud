package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.databasesource.DatabaseSourceCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.databasesource.DatabaseSourceQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.databasesource.DatabaseSourceUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.databasesource.DatabaseSourceQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.databasesource.DatabaseSourceResponse;
import io.github.panxiaochao.system.development.application.service.DatabaseSourceAppService;
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
 * 数据库-数据源管理 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Tag(name = "数据库-数据源管理 接口", description = "数据库-数据源管理 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/databasesource")
public class DatabaseSourceApi {

	/**
	 * 数据库-数据源管理 服务
	 */
	private final DatabaseSourceAppService databaseSourceAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<DatabaseSourceQueryResponse>> page(RequestPage requestPage,
			DatabaseSourceQueryRequest queryRequest) {
		return R.ok(databaseSourceAppService.page(requestPage, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "数据库-数据源管理 ID")
	@GetMapping(value = "/{id}")
	public R<DatabaseSourceResponse> getById(@PathVariable("id") String id) {
		return databaseSourceAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<DatabaseSourceResponse> save(@RequestBody DatabaseSourceCreateRequest databaseSourceCreateRequest) {
		return databaseSourceAppService.save(databaseSourceCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody DatabaseSourceUpdateRequest databaseSourceUpdateRequest) {
		return databaseSourceAppService.update(databaseSourceUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "数据库-数据源管理 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return databaseSourceAppService.deleteById(id);
	}

	@Operation(summary = "获取所有数据源管理下拉菜单", description = "获取所有数据源管理下拉菜单", method = "GET")
	@GetMapping(value = "/selectDataSourceList")
	public R<List<Select<String>>> selectDataSourceList() {
		return R.ok(databaseSourceAppService.selectDataSourceList());
	}

	@Operation(summary = "获取数据源类型下拉菜单", description = "获取数据源类型下拉菜单", method = "GET")
	@GetMapping(value = "/selectDbSources")
	public R<List<Select<String>>> selectDbTypes() {
		return R.ok(databaseSourceAppService.selectDbSources());
	}

	@Operation(summary = "测试连接", description = "测试连接", method = "POST")
	@PostMapping("/testConn")
	public R<DatabaseSourceResponse> testConn(@RequestBody DatabaseSourceCreateRequest databaseSourceCreateRequest) {
		return databaseSourceAppService.testConn(databaseSourceCreateRequest);
	}

}
