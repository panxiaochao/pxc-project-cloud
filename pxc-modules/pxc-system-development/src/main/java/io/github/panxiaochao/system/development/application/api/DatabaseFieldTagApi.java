package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.component.select.Select;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagResponse;
import io.github.panxiaochao.system.development.application.service.DatabaseFieldTagAppService;
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
 * 【数据库字段类型-数据库标签表】接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Tag(name = "数据库字段类型-数据库标签表 接口", description = "数据库字段类型-数据库标签表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/database-field-tag")
public class DatabaseFieldTagApi {

	/**
	 * 数据库字段类型-数据库标签表 服务
	 */
	private final DatabaseFieldTagAppService databaseFieldTagAppService;

	/**
	 * 查询数据库字段类型-数据库标签表分页数据
	 * @param requestPage 分页请求参数
	 * @param queryRequest 数据库字段类型-数据库标签表查询请求参数
	 * @return 封装分页查询结果统一响应对象
	 */
	@Operation(summary = "查询分页", description = "查询分页数据库字段类型-数据库标签表列表", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<DatabaseFieldTagQueryResponse>> page(RequestPage requestPage,
			DatabaseFieldTagQueryRequest queryRequest) {
		return R.ok(databaseFieldTagAppService.page(requestPage, queryRequest));
	}

	/**
	 * 根据主键获取数据库字段类型-数据库标签表详情
	 * @param id 数据库字段类型-数据库标签表 主键
	 * @return 数据库字段类型-数据库标签表响应对象
	 */
	@Operation(summary = "获取详情", description = "根据主键获取数据库字段类型-数据库标签表详情", method = "GET")
	@Parameter(name = "id", description = "数据库字段类型-数据库标签表 主键")
	@GetMapping(value = "/{id}")
	public R<DatabaseFieldTagResponse> getById(@PathVariable("id") String id) {
		return databaseFieldTagAppService.getById(id);
	}

	/**
	 * 保存数据库字段类型-数据库标签表对象
	 * @param createRequest 数据库字段类型-数据库标签表请求参数
	 * @return 数据库字段类型-数据库标签表响应对象
	 */
	@Operation(summary = "保存", description = "保存数据库字段类型-数据库标签表", method = "POST")
	@PostMapping
	public R<DatabaseFieldTagResponse> save(@RequestBody DatabaseFieldTagCreateRequest createRequest) {
		return databaseFieldTagAppService.save(createRequest);
	}

	/**
	 * 根据主键更新数据库字段类型-数据库标签表
	 * @param updateRequest 数据库字段类型-数据库标签表请求参数
	 * @return 空返回
	 */
	@Operation(summary = "更新", description = "根据主键更新数据库字段类型-数据库标签表", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody DatabaseFieldTagUpdateRequest updateRequest) {
		return databaseFieldTagAppService.update(updateRequest);
	}

	/**
	 * 根据主键删除数据库字段类型-数据库标签表
	 * @param id 数据库字段类型-数据库标签表 主键
	 * @return 空返回
	 */
	@Operation(summary = "删除", description = "根据主键删除数据库字段类型-数据库标签表", method = "DELETE")
	@Parameter(name = "id", description = "数据库字段类型-数据库标签表 主键")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return databaseFieldTagAppService.deleteById(id);
	}

	/**
	 * 根据数据库字段类型码表ID获取列表
	 * @param fieldId 数据库字段类型码表ID
	 * @return 数据库字段类型-数据库标签表响应数组
	 */
	@Operation(summary = "根据数据库字段类型码表ID获取列表", description = "根据数据库字段类型码表ID获取列表", method = "GET")
	@Parameter(name = "fieldId", description = "数据库字段类型码表ID")
	@GetMapping(value = "/getListByFieldId")
	public R<List<DatabaseFieldTagQueryResponse>> getListByFieldId(String fieldId) {
		return databaseFieldTagAppService.getListByFieldId(fieldId);
	}

	@Operation(summary = "根据数据库ID获取对应数据库字段类型下拉列表", description = "根据数据库ID获取对应数据库字段类型下拉列表", method = "GET")
	@Parameter(name = "dataSourceId", description = "数据库ID")
	@GetMapping(value = "/selectFieldTypeByDataSourceId")
	public R<List<Select<String>>> selectFieldTypeByDataSourceId(String dataSourceId) {
		return R.ok(databaseFieldTagAppService.selectFieldTypeByDataSourceId(dataSourceId));
	}

}
