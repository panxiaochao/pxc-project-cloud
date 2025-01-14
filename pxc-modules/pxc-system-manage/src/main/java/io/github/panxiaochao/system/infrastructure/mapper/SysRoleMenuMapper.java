package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysRoleMenuPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色菜单表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuPO> {

}
