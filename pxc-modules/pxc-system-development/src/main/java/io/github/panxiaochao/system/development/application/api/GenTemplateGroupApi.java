package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.PageRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupResponse;
import io.github.panxiaochao.system.development.application.service.GenTemplateGroupAppService;
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
 * 模板分组关联表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Tag(name = "模板分组关联表 接口", description = "模板分组关联表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/gentemplategroup")
public class GenTemplateGroupApi {

	/**
	 * 模板分组关联表 服务
	 */
	private final GenTemplateGroupAppService genTemplateGroupAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<GenTemplateGroupQueryResponse>> page(PageRequest pageRequest,
			GenTemplateGroupQueryRequest queryRequest) {
		return R.ok(genTemplateGroupAppService.page(pageRequest, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "模板分组关联表 ID")
	@GetMapping(value = "/{id}")
	public R<GenTemplateGroupResponse> getById(@PathVariable("id") String id) {
		return genTemplateGroupAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<GenTemplateGroupResponse> save(@RequestBody GenTemplateGroupCreateRequest genTemplateGroupCreateRequest) {
		return genTemplateGroupAppService.save(genTemplateGroupCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody GenTemplateGroupUpdateRequest genTemplateGroupUpdateRequest) {
		return genTemplateGroupAppService.update(genTemplateGroupUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "模板分组关联表 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return genTemplateGroupAppService.deleteById(id);
	}

}
