package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserAuthsPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户授权信息表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface SysUserAuthsMapper extends BaseMapper<SysUserAuthsPO> {

}
