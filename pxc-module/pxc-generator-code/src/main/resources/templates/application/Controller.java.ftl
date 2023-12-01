package ${application}.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import ${application}.api.request.${entity}CreateRequest;
import ${application}.api.request.${entity}QueryRequest;
import ${application}.api.request.${entity}UpdateRequest;
import ${application}.api.response.${entity}QueryResponse;
import ${application}.api.response.${entity}Response;
import ${application}.service.${entity}AppService;
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
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>

/**
 * <p> ${table.comment!} 接口.</p>
 *
 * @author ${author}
 * @since ${date}
 */
@Tag(name = "${table.comment!} 接口", description = "${table.comment!} Api接口")
@RequiredArgsConstructor
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/v1/${entity?lower_case}")
public class ${table.controllerName} {

    /**
     * ${table.comment!} 服务
     */
    private final ${entity}AppService ${entity?uncap_first}AppService;

    @Operation(summary = "查询分页", description = "查询分页", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<${entity}QueryResponse>> page(RequestPage pageRequest, ${entity}QueryRequest queryRequest) {
        return R.ok(${entity?uncap_first}AppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "获取详情", method = "GET")
    @Parameter(name = "id", description = "${table.comment!} ID")
    @GetMapping(value = "/{id}")
    public R<${entity}Response> getById(@PathVariable("id") String id) {
        return ${entity?uncap_first}AppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存", method = "POST")
    @PostMapping
    public R<${entity}Response> save(@RequestBody ${entity}CreateRequest ${entity?uncap_first}CreateRequest) {
        return ${entity?uncap_first}AppService.save(${entity?uncap_first}CreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody ${entity}UpdateRequest ${entity?uncap_first}UpdateRequest) {
        return ${entity?uncap_first}AppService.update(${entity?uncap_first}UpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除", method = "DELETE")
    @Parameter(name = "id", description = "${table.comment!} ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return ${entity?uncap_first}AppService.deleteById(id);
    }

}
