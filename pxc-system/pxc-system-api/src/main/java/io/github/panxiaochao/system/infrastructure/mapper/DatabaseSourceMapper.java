package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.DatabaseSourcePO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 数据库-数据源管理 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Mapper
public interface DatabaseSourceMapper extends BaseMapper<DatabaseSourcePO> {

}
