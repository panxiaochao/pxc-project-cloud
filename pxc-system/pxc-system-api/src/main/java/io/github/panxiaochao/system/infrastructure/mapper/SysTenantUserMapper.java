package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysTenantUserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 租户用户表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Mapper
public interface SysTenantUserMapper extends BaseMapper<SysTenantUserPO> {

}
