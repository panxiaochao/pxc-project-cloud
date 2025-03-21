package io.github.panxiaochao.system.development.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.development.infrastructure.po.GenTemplatePO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 模板 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Mapper
public interface GenTemplateMapper extends BaseMapper<GenTemplatePO> {

}
