package io.github.panxiaochao.system.development.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.development.infrastructure.po.GenTemplateGroupPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 模板分组关联表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Mapper
public interface GenTemplateGroupMapper extends BaseMapper<GenTemplateGroupPO> {

}
