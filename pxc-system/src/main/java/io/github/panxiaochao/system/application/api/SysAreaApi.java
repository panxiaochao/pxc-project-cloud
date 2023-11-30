package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysAreaCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysAreaQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysAreaUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysAreaQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysAreaResponse;
import io.github.panxiaochao.system.application.service.SysAreaAppService;
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
 * <p> 全国5级行政区划 接口.</p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Tag(name = "全国5级行政区划 接口", description = "全国5级行政区划 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysarea")
public class SysAreaApi {

    /**
     * 全国5级行政区划 服务
     */
    private final SysAreaAppService sysAreaAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysAreaQueryResponse>> page(@RequestBody RequestPage<SysAreaQueryRequest> pageRequest) {
        return R.ok(sysAreaAppService.page(pageRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "全国5级行政区划 ID")
    @GetMapping(value = "/{id}")
    public R<SysAreaResponse> getById(@PathVariable("id") String id) {
        return sysAreaAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysAreaResponse> save(@RequestBody SysAreaCreateRequest sysAreaCreateRequest) {
        return sysAreaAppService.save(sysAreaCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysAreaUpdateRequest sysAreaUpdateRequest) {
        return sysAreaAppService.update(sysAreaUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "全国5级行政区划 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysAreaAppService.deleteById(id);
    }

}
