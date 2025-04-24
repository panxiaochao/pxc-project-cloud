package ${package.application}.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import ${package.application}.api.request.${className?lower_case}.${ClassName}CreateRequest;
import ${package.application}.api.request.${className?lower_case}.${ClassName}QueryRequest;
import ${package.application}.api.request.${className?lower_case}.${ClassName}UpdateRequest;
import ${package.application}.api.response.${className?lower_case}.${ClassName}QueryResponse;
import ${package.application}.api.response.${className?lower_case}.${ClassName}Response;
import ${package.application}.service.${ClassName}AppService;
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
* <p> ${tableComment!} 接口.</p>
*
* @author ${author}
* @since ${date}
*/
@Tag(name = "${tableComment!} 接口", description = "${tableComment!} Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("<#if moduleName?? && moduleName != "">/${moduleName}</#if>/v1/${className?lower_case}")
public class ${ClassName}Api {

/**
* ${tableComment!} 服务
*/
private final ${ClassName}AppService ${className}AppService;

    @Operation(summary = "查询分页", description = "查询分页${tableComment!}列表", method = "GET")
    @GetMapping(value = "/page")
    public R<PageResponse<${ClassName}QueryResponse>> page(RequestPage pageRequest, ${ClassName}QueryRequest queryRequest) {
        return R.ok(${className}AppService.page(pageRequest, queryRequest));
    }

    @Operation(summary = "获取详情", description = "根据主键获取${tableComment!}详情", method = "GET")
    @Parameter(name = "${pk.attrName}", description = "${tableComment!} 主键")
    @GetMapping(value = "/{${pk.attrName}}")
    public R<${ClassName}Response> getById(@PathVariable("${pk.attrName}") String ${pk.attrName}) {
        return ${className}AppService.getById(${pk.attrName});
    }

    @Operation(summary = "保存", description = "保存${tableComment!}", method = "POST")
    @PostMapping
    public R<${ClassName}Response> save(@RequestBody ${ClassName}CreateRequest ${className}CreateRequest) {
        return ${className}AppService.save(${className}CreateRequest);
    }

    @Operation(summary = "更新", description = "根据主键更新${tableComment!}", method = "PUT")
    @PutMapping
    public R<Void> update(@RequestBody ${ClassName}UpdateRequest ${className}UpdateRequest) {
        return ${className}AppService.update(${className}UpdateRequest);
    }

    @Operation(summary = "删除", description = "根据主键删除${tableComment!}", method = "DELETE")
    @Parameter(name = "${pk.attrName}", description = "${tableComment!} 主键")
    @DeleteMapping(value = "/{${pk.attrName}}")
    public R<Void> deleteById(@PathVariable("${pk.attrName}") String ${pk.attrName}) {
        return ${className}AppService.deleteById(${pk.attrName});
    }

}
