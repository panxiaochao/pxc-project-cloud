package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.FileAccessoryCreateRequest;
import io.github.panxiaochao.system.application.api.request.FileAccessoryQueryRequest;
import io.github.panxiaochao.system.application.api.request.FileAccessoryUpdateRequest;
import io.github.panxiaochao.system.application.api.response.FileAccessoryQueryResponse;
import io.github.panxiaochao.system.application.api.response.FileAccessoryResponse;
import io.github.panxiaochao.system.application.service.FileAccessoryAppService;
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
 * <p> 附件表 接口.</p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Tag(name = "附件表 接口", description = "附件表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/fileaccessory")
public class FileAccessoryApi {

    /**
     * 附件表 服务
     */
    private final FileAccessoryAppService fileAccessoryAppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<FileAccessoryQueryResponse>> page(RequestPage pageRequest, FileAccessoryQueryRequest queryRequest) {
        return R.ok(fileAccessoryAppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "附件表 ID")
    @GetMapping(value = "/{id}")
    public R<FileAccessoryResponse> getById(@PathVariable("id") String id) {
        return fileAccessoryAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<FileAccessoryResponse> save(@RequestBody FileAccessoryCreateRequest fileAccessoryCreateRequest) {
        return fileAccessoryAppService.save(fileAccessoryCreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody FileAccessoryUpdateRequest fileAccessoryUpdateRequest) {
        return fileAccessoryAppService.update(fileAccessoryUpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "附件表 ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return fileAccessoryAppService.deleteById(id);
    }

}
