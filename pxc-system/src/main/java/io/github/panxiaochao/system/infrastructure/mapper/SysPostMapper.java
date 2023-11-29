package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysPostPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 岗位表 持久化接口
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface SysPostMapper extends BaseMapper<SysPostPO> {

}
