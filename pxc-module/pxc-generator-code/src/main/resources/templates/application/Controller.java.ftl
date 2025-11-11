package ${application}.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.PageRequest;
import ${application}.api.dto.${entity?lower_case}.${entity}CreateDTO;
import ${application}.api.dto.${entity?lower_case}.${entity}QueryDTO;
import ${application}.api.dto.${entity?lower_case}.${entity}UpdateDTO;
import ${application}.api.vo.${entity?lower_case}.${entity}QueryVO;
import ${application}.api.vo.${entity?lower_case}.${entity}VO;
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
 * <p>${table.comment!} 接口.</p>
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

    @Operation(summary = "查询分页", description = "查询分页")
    @GetMapping(value = "/page")
    public R<PageResponse<${entity}QueryVO>> page(PageRequest pageRequest, ${entity}QueryDTO queryDto) {
        return R.ok(${entity?uncap_first}AppService.page(pageRequest, queryDto));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "${table.comment!} ID")
    @GetMapping(value = "/{id}")
    public R<${entity}VO> getById(@PathVariable("id") String id) {
        return ${entity?uncap_first}AppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<${entity}VO> save(@RequestBody ${entity}CreateDTO ${entity?uncap_first}CreateDTO) {
        return ${entity?uncap_first}AppService.save(${entity?uncap_first}CreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody ${entity}UpdateDTO ${entity?uncap_first}UpdateDTO) {
        return ${entity?uncap_first}AppService.update(${entity?uncap_first}UpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "${table.comment!} ID")
    @DeleteMapping(value = "/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        return ${entity?uncap_first}AppService.deleteById(id);
    }

}
