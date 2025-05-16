package io.github.panxiaochao.system.infrastructure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.Oauth2RegisteredClientPO;
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
public interface Oauth2RegisteredClientMapper extends BaseMapper<Oauth2RegisteredClientPO> {

}
