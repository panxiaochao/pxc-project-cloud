package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysJobCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysJobQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysJobUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysJobQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysJobResponse;
import io.github.panxiaochao.system.application.service.SysJobAppService;
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
 * <p> 定时任务调度表 接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "定时任务调度表 接口", description = "定时任务调度表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysjob")
public class SysJobApi {

    /**
     * 定时任务调度表 服务
     */
    private final SysJobAppService sysJobAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysJobQueryResponse>> page(RequestPage pageRequest, SysJobQueryRequest queryRequest) {
        return R.ok(sysJobAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "定时任务调度表 ID")
    @GetMapping(value = "/{id}")
    public R<SysJobResponse> getById(@PathVariable("id") String id) {
        return sysJobAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysJobResponse> save(@RequestBody SysJobCreateRequest sysJobCreateRequest) {
        return sysJobAppService.save(sysJobCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysJobUpdateRequest sysJobUpdateRequest) {
        return sysJobAppService.update(sysJobUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "定时任务调度表 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysJobAppService.deleteById(id);
    }

}
