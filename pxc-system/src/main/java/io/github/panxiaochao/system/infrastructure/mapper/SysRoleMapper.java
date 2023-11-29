package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysRolePO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色表 持久化接口
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRolePO> {

}
