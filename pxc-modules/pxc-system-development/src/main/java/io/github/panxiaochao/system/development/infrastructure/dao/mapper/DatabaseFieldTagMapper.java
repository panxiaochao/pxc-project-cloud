package io.github.panxiaochao.system.development.infrastructure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.development.infrastructure.dao.po.DatabaseFieldTagPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Mapper
public interface DatabaseFieldTagMapper extends BaseMapper<DatabaseFieldTagPO> {

}
