package io.github.panxiaochao.system.development.infrastructure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.development.infrastructure.dao.po.OnlineTableColumnPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 【在线数据表字段】持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Mapper
public interface OnlineTableColumnMapper extends BaseMapper<OnlineTableColumnPO> {

}
