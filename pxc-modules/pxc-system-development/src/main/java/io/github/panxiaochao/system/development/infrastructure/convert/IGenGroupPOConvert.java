package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.GenGroup;
import io.github.panxiaochao.system.development.infrastructure.po.GenGroupPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p> 模板分组持久化对象结构映射. </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Mapper
public interface IGenGroupPOConvert {

    /**
     * 模板分组持久化对象结构映射实例
     */
    IGenGroupPOConvert INSTANCE = Mappers.getMapper(IGenGroupPOConvert.class);

    /**
     * 模板分组实体 转 模板分组持久化对象
     *
     * @param genGroup 模板分组实体
     * @return 模板分组持久化对象
     */
    GenGroupPO fromEntity(GenGroup genGroup);

    /**
     * 模板分组实体 转 模板分组持久化对象
     *
     * @param genGroupList 模板分组实体
     * @return 模板分组持久化对象
     */
    List<GenGroupPO> fromEntity(List<GenGroup> genGroupList);

    /**
     * 模板分组持久化对象 转 模板分组实体
     *
     * @param genGroupPO 模板分组持久化对象
     * @return 模板分组实体
     */
    GenGroup toEntity(GenGroupPO genGroupPO);

    /**
     * 模板分组持久化对象 转 模板分组实体
     *
     * @param genGroupPOList 模板分组持久化对象
     * @return 模板分组实体
     */
    List<GenGroup> toEntity(List<GenGroupPO> genGroupPOList);

    /**
     * 模板分组持久化对象 转 模板分组查询响应数据传输对象
     *
     * @param genGroupPO 模板分组持久化对象
     * @return 模板分组查询响应数据传输对象
     */
    GenGroupQueryResponse toQueryResponse(GenGroupPO genGroupPO);

    /**
     * 模板分组持久化对象列表 转 模板分组查询响应数据传输对象列表
     *
     * @param genGroupPOList 模板分组持久化对象列表
     * @return 模板分组查询响应数据传输对象列表
     */
    List<GenGroupQueryResponse> toQueryResponse(List<GenGroupPO> genGroupPOList);
}
