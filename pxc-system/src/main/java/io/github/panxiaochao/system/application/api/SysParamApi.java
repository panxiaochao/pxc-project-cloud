package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamResponse;
import io.github.panxiaochao.system.application.service.SysParamAppService;
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
 * <p> 系统参数 接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "系统参数 接口", description = "系统参数 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysparam")
public class SysParamApi {

    /**
     * 系统参数 服务
     */
    private final SysParamAppService sysParamAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysParamQueryResponse>> page(RequestPage pageRequest, SysParamQueryRequest queryRequest) {
        return R.ok(sysParamAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "系统参数 ID")
    @GetMapping(value = "/{id}")
    public R<SysParamResponse> getById(@PathVariable("id") String id) {
        return sysParamAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysParamResponse> save(@RequestBody SysParamCreateRequest sysParamCreateRequest) {
        return sysParamAppService.save(sysParamCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysParamUpdateRequest sysParamUpdateRequest) {
        return sysParamAppService.update(sysParamUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "系统参数 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysParamAppService.deleteById(id);
    }

}
