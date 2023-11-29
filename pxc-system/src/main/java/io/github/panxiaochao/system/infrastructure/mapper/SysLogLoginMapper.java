package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysLogLoginPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统日志登录/登出表 持久化接口
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface SysLogLoginMapper extends BaseMapper<SysLogLoginPO> {

}
