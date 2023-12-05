package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserResponse;
import io.github.panxiaochao.system.application.service.SysUserAppService;
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
 * <p> 用户表 接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "用户表 接口", description = "用户表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysuser")
public class SysUserApi {

    /**
     * 用户表 服务
     */
    private final SysUserAppService sysUserAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysUserQueryResponse>> page(RequestPage pageRequest, SysUserQueryRequest queryRequest) {
        return R.ok(sysUserAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "用户表 ID")
    @GetMapping(value = "/{id}")
    public R<SysUserResponse> getById(@PathVariable("id") String id) {
        return sysUserAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysUserResponse> save(@RequestBody SysUserCreateRequest sysUserCreateRequest) {
        return sysUserAppService.save(sysUserCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysUserUpdateRequest sysUserUpdateRequest) {
        return sysUserAppService.update(sysUserUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "用户表 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysUserAppService.deleteById(id);
    }

}
