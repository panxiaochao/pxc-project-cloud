package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserPO> {

}
