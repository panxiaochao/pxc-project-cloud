package ${domain}.repository;

import ${domain}.entity.${entity};

/**
 * <p> ${table.comment!} Domain接口服务类. </p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface I${entity}Service {

    /**
     * 详情
     * @param id 主键
     * @return ${table.comment!} 实体
     */
    ${entity} getById(String id);
    
    /**
     * 保存
     * @param ${entity?uncap_first} 角色表 实体
     * @return ${table.comment!} 实体
     */
    ${entity} save(${entity} ${entity?uncap_first});
    
    /**
     * 根据主键更新
     * @param ${entity?uncap_first} ${table.comment!} 实体
     */
    void update(${entity} ${entity?uncap_first});

    /**
     * 根据主键删除
     * @param id 主键
     */
    void deleteById(String id);
}
