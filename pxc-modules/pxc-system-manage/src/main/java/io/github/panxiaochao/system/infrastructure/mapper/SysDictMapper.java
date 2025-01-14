package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysDictPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 数据字典表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface SysDictMapper extends BaseMapper<SysDictPO> {

}
