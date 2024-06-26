package ${infrastructure}.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import ${application}.api.request.${entity?lower_case}.${entity}QueryRequest;
import ${application}.api.response.${entity?lower_case}.${entity}QueryResponse;
import ${application}.repository.I${entity}ReadModelService;
import ${domain}.entity.${entity};
import ${domain}.repository.I${entity}Service;
import ${infrastructure}.convert.I${entity}POConvert;
import ${infrastructure}.mapper.${entity}Mapper;
import ${infrastructure}.po.${entity}PO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p> ${table.comment!} Dao服务实现类. </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@RequiredArgsConstructor
public class ${table.serviceImplName} implements I${entity}Service, I${entity}ReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final ${table.mapperName} ${table.mapperName?uncap_first};

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest ${table.comment!}查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<${entity}QueryResponse> page(Pagination pagination, ${entity}QueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<${entity}PO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<${entity}PO> page = ${entity?uncap_first}Mapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return I${entity}POConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryRequest ${table.comment!}查询请求对象
     * @return 结果数组
     */
    @Override
    public List<${entity}QueryResponse> selectList(${entity}QueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<${entity}PO> lqw = lambdaQuery(queryRequest);
        return I${entity}POConvert.INSTANCE.toQueryResponse(${entity?uncap_first}Mapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryRequest ${table.comment!}查询请求对象
     * @return ${table.comment!}查询响应对象
     */
    @Override
    public ${entity}QueryResponse getOne(${entity}QueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<${entity}PO> lqw = lambdaQuery(queryRequest);
        try {
            ${entity}PO ${entity?uncap_first}PO = ${entity?uncap_first}Mapper.selectOne(lqw);
            return I${entity}POConvert.INSTANCE.toQueryResponse(${entity?uncap_first}PO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param queryRequest ${table.comment!}查询请求对象
     * @return ${table.comment!}Lambda表达式
     */
    private LambdaQueryWrapper<${entity}PO> lambdaQuery(${entity}QueryRequest queryRequest) {
        LambdaQueryWrapper<${entity}PO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            <#list table.fields as field>
            <#if field.keyFlag>
            // 默认按照主键倒序排序
            lqw.orderByDesc(${entity}PO::get${field.propertyName?cap_first});
            <#-- 普通字段 -->
            <#elseif field.propertyName != logicDeletePropertyName!''>
            // 如果 ${field.comment} 不为空
            <#if field.propertyType="Integer">
            if (StringUtils.isNotBlank(queryRequest.get${field.propertyName?cap_first}())) {
            <#elseif field.propertyType="LocalDateTime">
            if (queryRequest.get${field.propertyName?cap_first}() != null) {
            <#elseif field.propertyType="Long">
            if (queryRequest.get${field.propertyName?cap_first}() != null) {
            <#elseif field.propertyType="byte[]">
                if (queryRequest.get${field.propertyName?cap_first}() != null) {
            <#else>
            if (StringUtils.isNotBlank(queryRequest.get${field.propertyName?cap_first}())) {
            </#if>
                lqw.eq(${entity}PO::get${field.propertyName?cap_first}, queryRequest.get${field.propertyName?cap_first}());
            }
            </#if>
            </#list>
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return ${entity} 实体
     */
    @Override
    public ${entity} getById(String id) {
        ${entity}PO ${entity?uncap_first}PO = ${entity?uncap_first}Mapper.selectById(id);
        return I${entity}POConvert.INSTANCE.toEntity(${entity?uncap_first}PO);
    }

    /**
     * 保存
     * @param ${entity?uncap_first} ${entity} 实体
     * @return ${entity} 实体
     */
    @Override
    public ${entity} save(${entity} ${entity?uncap_first}) {
        ${entity}PO ${entity?uncap_first}PO = I${entity}POConvert.INSTANCE.fromEntity(${entity?uncap_first});
        ${entity?uncap_first}Mapper.insert(${entity?uncap_first}PO);
        return I${entity}POConvert.INSTANCE.toEntity(${entity?uncap_first}PO);
    }

    /**
     * 根据主键更新
     * @param ${entity?uncap_first} ${entity} 实体
     */
    @Override
    public void update(${entity} ${entity?uncap_first}) {
        ${entity}PO ${entity?uncap_first}PO = I${entity}POConvert.INSTANCE.fromEntity(${entity?uncap_first});
        ${entity?uncap_first}Mapper.updateById(${entity?uncap_first}PO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        ${entity?uncap_first}Mapper.deleteById(id);
    }

}
