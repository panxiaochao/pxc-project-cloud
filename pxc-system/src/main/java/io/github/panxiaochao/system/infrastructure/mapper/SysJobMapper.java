package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysJobPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 定时任务调度表 持久化接口
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface SysJobMapper extends BaseMapper<SysJobPO> {

}
