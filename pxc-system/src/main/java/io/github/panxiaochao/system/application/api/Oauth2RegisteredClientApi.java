package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.oauth2registeredclient.Oauth2RegisteredClientCreateRequest;
import io.github.panxiaochao.system.application.api.request.oauth2registeredclient.Oauth2RegisteredClientQueryRequest;
import io.github.panxiaochao.system.application.api.request.oauth2registeredclient.Oauth2RegisteredClientUpdateRequest;
import io.github.panxiaochao.system.application.api.response.oauth2registeredclient.Oauth2RegisteredClientQueryResponse;
import io.github.panxiaochao.system.application.api.response.oauth2registeredclient.Oauth2RegisteredClientResponse;
import io.github.panxiaochao.system.application.service.Oauth2RegisteredClientAppService;
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
@RequestMapping("/system/v1/oauth2registeredclient")
public class Oauth2RegisteredClientApi {

    /**
     *  服务
     */
    private final Oauth2RegisteredClientAppService oauth2RegisteredClientAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<Oauth2RegisteredClientQueryResponse>> page(RequestPage pageRequest, Oauth2RegisteredClientQueryRequest queryRequest) {
        return R.ok(oauth2RegisteredClientAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = " ID")
    @GetMapping(value = "/{id}")
    public R<Oauth2RegisteredClientResponse> getById(@PathVariable("id") String id) {
        return oauth2RegisteredClientAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<Oauth2RegisteredClientResponse> save(@RequestBody Oauth2RegisteredClientCreateRequest oauth2RegisteredClientCreateRequest) {
        return oauth2RegisteredClientAppService.save(oauth2RegisteredClientCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody Oauth2RegisteredClientUpdateRequest oauth2RegisteredClientUpdateRequest) {
        return oauth2RegisteredClientAppService.update(oauth2RegisteredClientUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = " ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return oauth2RegisteredClientAppService.deleteById(id);
    }

}
