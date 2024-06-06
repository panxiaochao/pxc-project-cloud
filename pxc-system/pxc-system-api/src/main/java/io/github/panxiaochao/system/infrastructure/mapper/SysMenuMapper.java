package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.infrastructure.po.SysMenuPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单配置 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuPO> {

	/**
	 * 根据用户ID查询菜单列表（用户权限下的菜单）
	 * @param userId 用户ID
	 * @return 菜单列表
	 */
	List<SysMenuPO> selectMenuByUserId(String userId);

	/**
	 * 根据用户ID查询权限
	 * @param userId 用户ID
	 * @return 权限列表
	 */
	List<String> selectMenuPermissionCodeByUserId(String userId);

	/**
	 * 根据角色ID查询权限
	 * @param roleId 角色ID
	 * @return 权限列表
	 */
	List<String> selectMenuPermissionCodeByRoleId(String roleId);

}
