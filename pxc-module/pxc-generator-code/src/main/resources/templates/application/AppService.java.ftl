package ${application}.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.PageRequest;
import ${application}.api.dto.${entity?lower_case}.${entity}CreateDTO;
import ${application}.api.dto.${entity?lower_case}.${entity}QueryDTO;
import ${application}.api.dto.${entity?lower_case}.${entity}UpdateDTO;
import ${application}.api.vo.${entity?lower_case}.${entity}QueryVO;
import ${application}.api.vo.${entity?lower_case}.${entity}VO;
import ${application}.convert.I${entity}DTOConvert;
import ${application}.repository.I${entity}ReadModelService;
import ${domain}.entity.${entity?lower_case}.${entity}BO;
import ${domain}.service.${entity}DomainService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>${table.comment!} App服务类.</p>
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
     * @param queryDto ${table.comment!}查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<${entity}QueryVO> page(PageRequest pageRequest, ${entity}QueryDTO queryDto) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<${entity}QueryVO> list = ${entity?uncap_first}ReadModelService.page(pagination, queryDto);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<${entity}VO> getById(String id) {
        ${entity}BO ${entity?uncap_first} = ${entity?uncap_first}DomainService.getById(id);
        ${entity}VO ${entity?uncap_first}VO = I${entity}DTOConvert.INSTANCE.toVO(${entity?uncap_first});
        return R.ok(${entity?uncap_first}VO);
    }
    
    /**
     * 保存
     * @param ${entity?uncap_first}CreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<${entity}VO> save(${entity}CreateDTO ${entity?uncap_first}CreateDTO) {
        ${entity}BO ${entity?uncap_first} = I${entity}DTOConvert.INSTANCE.fromCreateDTO(${entity?uncap_first}CreateDTO);
        ${entity?uncap_first} = ${entity?uncap_first}DomainService.save(${entity?uncap_first});
        ${entity}VO ${entity?uncap_first}VO = I${entity}DTOConvert.INSTANCE.toVO(${entity?uncap_first});
        return R.ok(${entity?uncap_first}VO);
    }
    
    /**
     * 根据主键更新
     * @param ${entity?uncap_first}UpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(${entity}UpdateDTO ${entity?uncap_first}UpdateDTO) {
        ${entity}BO ${entity?uncap_first} = I${entity}DTOConvert.INSTANCE.fromUpdateDTO(${entity?uncap_first}UpdateDTO);
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
