package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysRolePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRolePO> {

	/**
	 * 根据用户ID查询所有角色
	 * @param userId 用户ID
	 * @return 角色数组
	 */
	List<SysRolePO> selectRolesByUserId(String userId);

}
