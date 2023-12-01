package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysLogLoginCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysLogLoginQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysLogLoginUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysLogLoginQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysLogLoginResponse;
import io.github.panxiaochao.system.application.service.SysLogLoginAppService;
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
 * <p> 系统日志登录/登出表 接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "系统日志登录/登出表 接口", description = "系统日志登录/登出表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysloglogin")
public class SysLogLoginApi {

    /**
     * 系统日志登录/登出表 服务
     */
    private final SysLogLoginAppService sysLogLoginAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysLogLoginQueryResponse>> page(RequestPage pageRequest, SysLogLoginQueryRequest queryRequest) {
        return R.ok(sysLogLoginAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "系统日志登录/登出表 ID")
    @GetMapping(value = "/{id}")
    public R<SysLogLoginResponse> getById(@PathVariable("id") String id) {
        return sysLogLoginAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysLogLoginResponse> save(@RequestBody SysLogLoginCreateRequest sysLogLoginCreateRequest) {
        return sysLogLoginAppService.save(sysLogLoginCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysLogLoginUpdateRequest sysLogLoginUpdateRequest) {
        return sysLogLoginAppService.update(sysLogLoginUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "系统日志登录/登出表 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysLogLoginAppService.deleteById(id);
    }

}
