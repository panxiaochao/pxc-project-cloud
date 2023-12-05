package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysdictitem.SysDictItemCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysdictitem.SysDictItemQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysdictitem.SysDictItemUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemResponse;
import io.github.panxiaochao.system.application.service.SysDictItemAppService;
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
 * <p> 数据字典配置表 接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "数据字典配置表 接口", description = "数据字典配置表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysdictitem")
public class SysDictItemApi {

    /**
     * 数据字典配置表 服务
     */
    private final SysDictItemAppService sysDictItemAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<SysDictItemQueryResponse>> page(RequestPage pageRequest, SysDictItemQueryRequest queryRequest) {
        return R.ok(sysDictItemAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "数据字典配置表 ID")
    @GetMapping(value = "/{id}")
    public R<SysDictItemResponse> getById(@PathVariable("id") String id) {
        return sysDictItemAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<SysDictItemResponse> save(@RequestBody SysDictItemCreateRequest sysDictItemCreateRequest) {
        return sysDictItemAppService.save(sysDictItemCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody SysDictItemUpdateRequest sysDictItemUpdateRequest) {
        return sysDictItemAppService.update(sysDictItemUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "数据字典配置表 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return sysDictItemAppService.deleteById(id);
    }

}
