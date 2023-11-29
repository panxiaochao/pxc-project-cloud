package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysDictItemPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 数据字典配置表 持久化接口
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface SysDictItemMapper extends BaseMapper<SysDictItemPO> {

}
