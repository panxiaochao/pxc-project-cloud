package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtype.DatabaseFieldTypeCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtype.DatabaseFieldTypeQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtype.DatabaseFieldTypeUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtype.DatabaseFieldTypeQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtype.DatabaseFieldTypeResponse;
import io.github.panxiaochao.system.development.application.service.DatabaseFieldTypeAppService;
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
 * 数据库字段类型码表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Tag(name = "数据库字段类型码表 接口", description = "数据库字段类型码表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/databasefieldtype")
public class DatabaseFieldTypeApi {

	/**
	 * 数据库字段类型码表 服务
	 */
	private final DatabaseFieldTypeAppService databaseFieldTypeAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<DatabaseFieldTypeQueryResponse>> page(RequestPage requestPage,
			DatabaseFieldTypeQueryRequest queryRequest) {
		return R.ok(databaseFieldTypeAppService.page(requestPage, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "数据库字段类型码表 ID")
	@GetMapping(value = "/{id}")
	public R<DatabaseFieldTypeResponse> getById(@PathVariable("id") String id) {
		return databaseFieldTypeAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<DatabaseFieldTypeResponse> save(
			@RequestBody DatabaseFieldTypeCreateRequest databaseFieldTypeCreateRequest) {
		return databaseFieldTypeAppService.save(databaseFieldTypeCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody DatabaseFieldTypeUpdateRequest databaseFieldTypeUpdateRequest) {
		return databaseFieldTypeAppService.update(databaseFieldTypeUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "数据库字段类型码表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return databaseFieldTypeAppService.deleteById(id);
	}

	@Operation(summary = "获取数据库类型下拉菜单", description = "获取数据库类型下拉菜单", method = "GET")
	@GetMapping(value = "/selectDbTypes")
	public R<List<Select<String>>> selectDbTypes() {
		return R.ok(databaseFieldTypeAppService.selectDbTypes());
	}

	@Operation(summary = "获取JavaType类型下拉菜单", description = "获取JavaType类型下拉菜单", method = "GET")
	@GetMapping(value = "/selectJavaTypes")
	public R<List<Select<String>>> selectJavaTypes() {
		return R.ok(databaseFieldTypeAppService.selectJavaTypes());
	}

}
