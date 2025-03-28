package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.GenGroup;
import io.github.panxiaochao.system.development.domain.repository.IGenGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p> 模板分组 Domain服务类. </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Service
@RequiredArgsConstructor
public class GenGroupDomainService {

    /**
     * GenGroup Domain接口服务类
     */
    private final IGenGroupService genGroupService;
    
    /**
     * 详情
     * @param id 主键
     * @return GenGroup 实体
     */
    public GenGroup getById(String id) {
        return genGroupService.getById(id);
    }
    
    /**
     * 保存
     * @param genGroup GenGroup 实体
     * @return GenGroup 实体
     */
    public GenGroup save(GenGroup genGroup) {
        return genGroupService.save(genGroup);
    }
    
    /**
     * 根据主键更新
     * @param genGroup GenGroup 实体
     */
    public void update(GenGroup genGroup) {
        genGroupService.update(genGroup);
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     */
    public void deleteById(String id) {
        genGroupService.deleteById(id);
    }

}
