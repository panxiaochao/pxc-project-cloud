package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysMenuPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单配置 持久化接口
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuPO> {

}
