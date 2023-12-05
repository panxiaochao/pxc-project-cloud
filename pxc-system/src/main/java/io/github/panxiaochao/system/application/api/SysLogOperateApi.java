package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.syslogoperate.SysLogOperateCreateRequest;
import io.github.panxiaochao.system.application.api.request.syslogoperate.SysLogOperateQueryRequest;
import io.github.panxiaochao.system.application.api.request.syslogoperate.SysLogOperateUpdateRequest;
import io.github.panxiaochao.system.application.api.response.syslogoperate.SysLogOperateQueryResponse;
import io.github.panxiaochao.system.application.api.response.syslogoperate.SysLogOperateResponse;
import io.github.panxiaochao.system.application.service.SysLogOperateAppService;
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
 * <p> 系统日志操作表 接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "系统日志操作表 接口", description = "系统日志操作表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/syslogoperate")
public class SysLogOperateApi {

    /**
     * 系统日志操作表 服务
     */
    private final SysLogOperateAppService sysLogOperateAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysLogOperateQueryResponse>> page(RequestPage pageRequest, SysLogOperateQueryRequest queryRequest) {
        return R.ok(sysLogOperateAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "系统日志操作表 ID")
    @GetMapping(value = "/{id}")
    public R<SysLogOperateResponse> getById(@PathVariable("id") String id) {
        return sysLogOperateAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysLogOperateResponse> save(@RequestBody SysLogOperateCreateRequest sysLogOperateCreateRequest) {
        return sysLogOperateAppService.save(sysLogOperateCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysLogOperateUpdateRequest sysLogOperateUpdateRequest) {
        return sysLogOperateAppService.update(sysLogOperateUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "系统日志操作表 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysLogOperateAppService.deleteById(id);
    }

}
