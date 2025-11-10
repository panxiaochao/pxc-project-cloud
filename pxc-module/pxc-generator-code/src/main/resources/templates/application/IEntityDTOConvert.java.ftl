package ${application}.convert;

import ${application}.api.dto.${entity?lower_case}.${entity}CreateDTO;
import ${application}.api.dto.${entity?lower_case}.${entity}QueryDTO;
import ${application}.api.dto.${entity?lower_case}.${entity}UpdateDTO;
import ${application}.api.vo.${entity?lower_case}.${entity}QueryVO;
import ${application}.api.vo.${entity?lower_case}.${entity}VO;
import ${domain}.entity.${entity?lower_case}.${entity}BO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>${table.comment!} 数据传输对象结构映射.</p>
 *
 * @author ${author}
 * @since ${date}
 */
@Mapper
public interface I${entity}DTOConvert {

    /**
     * ${table.comment!}数据传输对象结构映射实例
     */
    I${entity}DTOConvert INSTANCE = Mappers.getMapper(I${entity}DTOConvert.class);

    /**
     * ${table.comment!}创建请求数据传输对象 转 ${table.comment!}实体
     *
     * @param createDto ${table.comment!}创建请求数据传输对象
     * @return ${table.comment!}实体
     */
    ${entity}BO fromCreateDTO(${entity}CreateDTO createDto);

    /**
     * ${table.comment!}更新请求数据传输对象 转 ${table.comment!}实体
     *
     * @param updateDto ${table.comment!}更新请求数据传输对象
     * @return ${table.comment!}实体
     */
    ${entity}BO fromUpdateDTO(${entity}UpdateDTO updateDto);

    /**
     * ${table.comment!}查询请求数据传输对象 转 ${table.comment!}实体
     *
     * @param queryDto ${table.comment!}查询请求数据传输对象
     * @return ${table.comment!}实体
     */
    ${entity}BO fromQueryRequest(${entity}QueryDTO queryDto);

    /**
     * ${table.comment!}实体 转 ${table.comment!}响应数据传输对象
     *
     * @param ${entity?uncap_first} ${table.comment!}实体
     * @return ${table.comment!}响应数据传输对象
     */
    ${entity}VO toVO(${entity}BO ${entity?uncap_first});

    /**
     * ${table.comment!}实体 转 ${table.comment!}查询响应数据传输对象
     *
     * @param ${entity?uncap_first} ${table.comment!}实体
     * @return ${table.comment!}查询响应数据传输对象
     */
    ${entity}QueryVO toQueryVO(${entity}BO ${entity?uncap_first});

    /**
     * ${table.comment!}实体列表 转 ${table.comment!}查询响应数据传输对象列表
     *
     * @param ${entity?uncap_first}List ${table.comment!}实体列表
     * @return ${table.comment!}查询响应数据传输对象列表
     */
    List<${entity}QueryVO> toQueryVO(List<${entity}BO> ${entity?uncap_first}List);
}
