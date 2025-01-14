package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysTenantPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 租户表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Mapper
public interface SysTenantMapper extends BaseMapper<SysTenantPO> {

}
