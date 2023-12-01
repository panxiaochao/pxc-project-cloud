package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationCreateRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationQueryRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationUpdateRequest;
import io.github.panxiaochao.system.application.api.response.Oauth2AuthorizationQueryResponse;
import io.github.panxiaochao.system.application.api.response.Oauth2AuthorizationResponse;
import io.github.panxiaochao.system.application.service.Oauth2AuthorizationAppService;
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
 * <p>  接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = " 接口", description = " Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/oauth2authorization")
public class Oauth2AuthorizationApi {

    /**
     *  服务
     */
    private final Oauth2AuthorizationAppService oauth2AuthorizationAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<Oauth2AuthorizationQueryResponse>> page(RequestPage pageRequest, Oauth2AuthorizationQueryRequest queryRequest) {
        return R.ok(oauth2AuthorizationAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = " ID")
    @GetMapping(value = "/{id}")
    public R<Oauth2AuthorizationResponse> getById(@PathVariable("id") String id) {
        return oauth2AuthorizationAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<Oauth2AuthorizationResponse> save(@RequestBody Oauth2AuthorizationCreateRequest oauth2AuthorizationCreateRequest) {
        return oauth2AuthorizationAppService.save(oauth2AuthorizationCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody Oauth2AuthorizationUpdateRequest oauth2AuthorizationUpdateRequest) {
        return oauth2AuthorizationAppService.update(oauth2AuthorizationUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = " ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return oauth2AuthorizationAppService.deleteById(id);
    }

}
