package ${domain}.service;

import ${domain}.entity.${entity};
import ${domain}.repository.I${entity}Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p> ${table.comment!} Domain服务类. </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@RequiredArgsConstructor
public class ${entity}DomainService {

    /**
     * ${entity} Domain接口服务类
     */
    private final I${entity}Service ${entity?uncap_first}Service;
    
    /**
     * 详情
     * @param id 主键
     * @return ${entity} 实体
     */
    public ${entity} getById(String id) {
        return ${entity?uncap_first}Service.getById(id);
    }
    
    /**
     * 保存
     * @param ${entity?uncap_first} ${entity} 实体
     * @return ${entity} 实体
     */
    public ${entity} save(${entity} ${entity?uncap_first}) {
        return ${entity?uncap_first}Service.save(${entity?uncap_first});
    }
    
    /**
     * 根据主键更新
     * @param ${entity?uncap_first} ${entity} 实体
     */
    public void update(${entity} ${entity?uncap_first}) {
        ${entity?uncap_first}Service.update(${entity?uncap_first});
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     */
    public void deleteById(String id) {
        ${entity?uncap_first}Service.deleteById(id);
    }

}
