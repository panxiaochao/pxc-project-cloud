package io.github.panxiaochao.system.development.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.development.infrastructure.po.DatabaseFieldTypePO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 数据库字段类型码表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface DatabaseFieldTypeMapper extends BaseMapper<DatabaseFieldTypePO> {

}
