package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserQueryRequest;
import io.github.panxiaochao.system.domain.entity.SysUserLogin;
import io.github.panxiaochao.system.infrastructure.po.SysUserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 持久化接口.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserPO> {

	/**
	 * 根据用户名的登录类型查找用户
	 * @param username 登录名
	 * @param identityType 登录类型
	 * @return 用户综合信息
	 */
	List<SysUserLogin> loadUserByIdentityType(@Param("username") String username,
			@Param("identityType") String identityType);

	/**
	 * 根据租户ID查询所有关联用户
	 * @param page 分页
	 * @param queryRequest 角色表查询请求对象
	 * @return 用户数组
	 */
	IPage<SysUserPO> selectTenantUserPage(IPage<SysUserPO> page, @Param("ew") SysUserQueryRequest queryRequest);

	/**
	 * 根据租户ID查询无关联用户分页
	 * @param page 分页
	 * @param queryRequest 角色表查询请求对象
	 * @return 用户数组
	 */
	IPage<SysUserPO> selectNoExistsTenantUserPage(IPage<SysUserPO> page, @Param("ew") SysUserQueryRequest queryRequest);

}
