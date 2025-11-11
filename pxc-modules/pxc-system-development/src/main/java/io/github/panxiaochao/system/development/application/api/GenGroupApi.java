package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.component.select.Select;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.PageRequest;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupResponse;
import io.github.panxiaochao.system.development.application.service.GenGroupAppService;
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
 * 模板分组 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Tag(name = "模板分组 接口", description = "模板分组 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/gengroup")
public class GenGroupApi {

	/**
	 * 模板分组 服务
	 */
	private final GenGroupAppService genGroupAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<GenGroupQueryResponse>> page(PageRequest pageRequest, GenGroupQueryRequest queryRequest) {
		return R.ok(genGroupAppService.page(pageRequest, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "模板分组 ID")
	@GetMapping(value = "/{id}")
	public R<GenGroupResponse> getById(@PathVariable("id") String id) {
		return genGroupAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<GenGroupResponse> save(@RequestBody GenGroupCreateRequest genGroupCreateRequest) {
		return genGroupAppService.save(genGroupCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody GenGroupUpdateRequest genGroupUpdateRequest) {
		return genGroupAppService.update(genGroupUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "模板分组 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return genGroupAppService.deleteById(id);
	}

	@Operation(summary = "获取所有模版组下拉菜单", description = "获取所有模版组下拉菜单", method = "GET")
	@GetMapping(value = "/selectGroupList")
	public R<List<Select<String>>> selectGroupList() {
		return R.ok(genGroupAppService.selectGroupList());
	}

}
