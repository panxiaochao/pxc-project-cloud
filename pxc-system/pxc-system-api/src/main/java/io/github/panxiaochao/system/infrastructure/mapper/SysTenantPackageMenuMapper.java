package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysTenantPackageMenuPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 租户套餐菜单表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Mapper
public interface SysTenantPackageMenuMapper extends BaseMapper<SysTenantPackageMenuPO> {

}
