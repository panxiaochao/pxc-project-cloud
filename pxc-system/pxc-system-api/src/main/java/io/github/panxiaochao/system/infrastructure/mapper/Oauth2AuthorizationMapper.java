package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.Oauth2AuthorizationPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface Oauth2AuthorizationMapper extends BaseMapper<Oauth2AuthorizationPO> {

}
