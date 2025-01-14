package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysAreaPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 全国5级行政区划 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface SysAreaMapper extends BaseMapper<SysAreaPO> {

}
