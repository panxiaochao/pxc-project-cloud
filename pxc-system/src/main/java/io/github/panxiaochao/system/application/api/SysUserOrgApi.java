package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysUserOrgCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysUserOrgQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysUserOrgUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysUserOrgQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysUserOrgResponse;
import io.github.panxiaochao.system.application.service.SysUserOrgAppService;
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
 * <p> 用户机构/部门表 接口.</p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Tag(name = "用户机构/部门表 接口", description = "用户机构/部门表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysuserorg")
public class SysUserOrgApi {

    /**
     * 用户机构/部门表 服务
     */
    private final SysUserOrgAppService sysUserOrgAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysUserOrgQueryResponse>> page(@RequestBody RequestPage<SysUserOrgQueryRequest> pageRequest) {
        return R.ok(sysUserOrgAppService.page(pageRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "用户机构/部门表 ID")
    @GetMapping(value = "/{id}")
    public R<SysUserOrgResponse> getById(@PathVariable("id") String id) {
        return sysUserOrgAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysUserOrgResponse> save(@RequestBody SysUserOrgCreateRequest sysUserOrgCreateRequest) {
        return sysUserOrgAppService.save(sysUserOrgCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysUserOrgUpdateRequest sysUserOrgUpdateRequest) {
        return sysUserOrgAppService.update(sysUserOrgUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "用户机构/部门表 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysUserOrgAppService.deleteById(id);
    }

}
