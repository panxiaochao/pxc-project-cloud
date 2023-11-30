package ${application}.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import ${application}.api.request.${entity}CreateRequest;
import ${application}.api.request.${entity}QueryRequest;
import ${application}.api.request.${entity}UpdateRequest;
import ${application}.api.response.${entity}QueryResponse;
import ${application}.api.response.${entity}Response;
import ${application}.convert.I${entity}DTOConvert;
import ${application}.repository.I${entity}ReadModelService;
import ${domain}.entity.${entity};
import ${domain}.service.${entity}DomainService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> ${table.comment!} App服务类. </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@RequiredArgsConstructor
public class ${entity}AppService {

    /**
     * ${table.comment!} Domain服务类
     */
    private final ${entity}DomainService ${entity?uncap_first}DomainService;

    /**
     * ${table.comment!} 读模型服务
     */
    private final I${entity}ReadModelService ${entity?uncap_first}ReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @return 分页数组响应实体
     */
    public PageResponse<${entity}QueryResponse> page(RequestPage<${entity}QueryRequest> pageRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<${entity}QueryResponse> list = ${entity?uncap_first}ReadModelService.page(pagination, pageRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<${entity}Response> getById(String id) {
        ${entity} ${entity?uncap_first} = ${entity?uncap_first}DomainService.getById(id);
        ${entity}Response ${entity?uncap_first}Response = I${entity}DTOConvert.INSTANCE.toResponse(${entity?uncap_first});
        return R.ok(${entity?uncap_first}Response);
    }
    
    /**
     * 保存
     * @param ${entity?uncap_first}CreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<${entity}Response> save(${entity}CreateRequest ${entity?uncap_first}CreateRequest) {
        ${entity} ${entity?uncap_first} = I${entity}DTOConvert.INSTANCE.fromCreateRequest(${entity?uncap_first}CreateRequest);
        ${entity?uncap_first} = ${entity?uncap_first}DomainService.save(${entity?uncap_first});
        ${entity}Response ${entity?uncap_first}Response = I${entity}DTOConvert.INSTANCE.toResponse(${entity?uncap_first});
        return R.ok(${entity?uncap_first}Response);
    }
    
    /**
     * 根据主键更新
     * @param ${entity?uncap_first}UpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(${entity}UpdateRequest ${entity?uncap_first}UpdateRequest) {
        ${entity} ${entity?uncap_first} = I${entity}DTOConvert.INSTANCE.fromUpdateRequest(${entity?uncap_first}UpdateRequest);
        ${entity?uncap_first}DomainService.update(${entity?uncap_first});
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        ${entity?uncap_first}DomainService.deleteById(id);
        return R.ok();
    }

}
