package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysorg.SysOrgCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysorg.SysOrgQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysorg.SysOrgUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysorg.SysOrgQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysorg.SysOrgResponse;
import io.github.panxiaochao.system.application.service.SysOrgAppService;
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
 * <p> 机构部门表 接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "机构部门表 接口", description = "机构部门表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysorg")
public class SysOrgApi {

    /**
     * 机构部门表 服务
     */
    private final SysOrgAppService sysOrgAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysOrgQueryResponse>> page(RequestPage pageRequest, SysOrgQueryRequest queryRequest) {
        return R.ok(sysOrgAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "机构部门表 ID")
    @GetMapping(value = "/{id}")
    public R<SysOrgResponse> getById(@PathVariable("id") String id) {
        return sysOrgAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysOrgResponse> save(@RequestBody SysOrgCreateRequest sysOrgCreateRequest) {
        return sysOrgAppService.save(sysOrgCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysOrgUpdateRequest sysOrgUpdateRequest) {
        return sysOrgAppService.update(sysOrgUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "机构部门表 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysOrgAppService.deleteById(id);
    }

}
