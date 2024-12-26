package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.oauth2authorization.Oauth2AuthorizationConsentCreateRequest;
import io.github.panxiaochao.system.application.api.request.oauth2authorization.Oauth2AuthorizationConsentQueryRequest;
import io.github.panxiaochao.system.application.api.request.oauth2authorization.Oauth2AuthorizationConsentUpdateRequest;
import io.github.panxiaochao.system.application.api.response.oauth2authorization.Oauth2AuthorizationConsentQueryResponse;
import io.github.panxiaochao.system.application.api.response.oauth2authorization.Oauth2AuthorizationConsentResponse;
import io.github.panxiaochao.system.application.service.Oauth2AuthorizationConsentAppService;
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
 * 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = " 接口", description = " Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/oauth2authorizationconsent")
public class Oauth2AuthorizationConsentApi {

	/**
	 * 服务
	 */
	private final Oauth2AuthorizationConsentAppService oauth2AuthorizationConsentAppService;

	@Operation(summary = "查询分页", description = "查询分页", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<Oauth2AuthorizationConsentQueryResponse>> page(RequestPage requestPage,
			Oauth2AuthorizationConsentQueryRequest queryRequest) {
		return R.ok(oauth2AuthorizationConsentAppService.page(requestPage, queryRequest));
	}

	@Operation(summary = "获取详情", description = "获取详情", method = "GET")
	@Parameter(name = "id", description = " ID")
	@GetMapping(value = "/{id}")
	public R<Oauth2AuthorizationConsentResponse> getById(@PathVariable("id") String id) {
		return oauth2AuthorizationConsentAppService.getById(id);
	}

	@Operation(summary = "保存", description = "保存", method = "POST")
	@PostMapping
	public R<Oauth2AuthorizationConsentResponse> save(
			@RequestBody Oauth2AuthorizationConsentCreateRequest oauth2AuthorizationConsentCreateRequest) {
		return oauth2AuthorizationConsentAppService.save(oauth2AuthorizationConsentCreateRequest);
	}

	@Operation(summary = "更新", description = "根据主键更新", method = "PUT")
	@PutMapping
	public R<Void> update(
			@RequestBody Oauth2AuthorizationConsentUpdateRequest oauth2AuthorizationConsentUpdateRequest) {
		return oauth2AuthorizationConsentAppService.update(oauth2AuthorizationConsentUpdateRequest);
	}

	@Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
	@Parameter(name = "id", description = " ID")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return oauth2AuthorizationConsentAppService.deleteById(id);
	}

}
