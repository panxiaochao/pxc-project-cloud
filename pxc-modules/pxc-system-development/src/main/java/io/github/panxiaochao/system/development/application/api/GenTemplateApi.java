package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateResponse;
import io.github.panxiaochao.system.development.application.service.GenTemplateAppService;
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
 * 模板 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Tag(name = "模板 接口", description = "模板 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/gentemplate")
public class GenTemplateApi {

	/**
	 * 模板 服务
	 */
	private final GenTemplateAppService genTemplateAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<GenTemplateQueryResponse>> page(RequestPage pageRequest,
			GenTemplateQueryRequest queryRequest) {
		return R.ok(genTemplateAppService.page(pageRequest, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = "模板 ID")
	@GetMapping(value = "/{id}")
	public R<GenTemplateResponse> getById(@PathVariable("id") String id) {
		return genTemplateAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<GenTemplateResponse> save(@RequestBody GenTemplateCreateRequest genTemplateCreateRequest) {
		return genTemplateAppService.save(genTemplateCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody GenTemplateUpdateRequest genTemplateUpdateRequest) {
		return genTemplateAppService.update(genTemplateUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = "模板 ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return genTemplateAppService.deleteById(id);
	}

}
