package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysMenuResponse;
import io.github.panxiaochao.system.application.service.SysMenuAppService;
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
 * <p> 菜单配置 接口.</p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Tag(name = "菜单配置 接口", description = "菜单配置 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysmenu")
public class SysMenuApi {

    /**
     * 菜单配置 服务
     */
    private final SysMenuAppService sysMenuAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysMenuQueryResponse>> page(@RequestBody RequestPage<SysMenuQueryRequest> pageRequest) {
        return R.ok(sysMenuAppService.page(pageRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "菜单配置 ID")
    @GetMapping(value = "/{id}")
    public R<SysMenuResponse> getById(@PathVariable("id") String id) {
        return sysMenuAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysMenuResponse> save(@RequestBody SysMenuCreateRequest sysMenuCreateRequest) {
        return sysMenuAppService.save(sysMenuCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysMenuUpdateRequest sysMenuUpdateRequest) {
        return sysMenuAppService.update(sysMenuUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "菜单配置 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysMenuAppService.deleteById(id);
    }

}
