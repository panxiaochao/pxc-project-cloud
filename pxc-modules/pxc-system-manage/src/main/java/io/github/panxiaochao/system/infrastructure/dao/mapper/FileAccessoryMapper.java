package io.github.panxiaochao.system.infrastructure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.FileAccessoryPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 附件表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface FileAccessoryMapper extends BaseMapper<FileAccessoryPO> {

}
