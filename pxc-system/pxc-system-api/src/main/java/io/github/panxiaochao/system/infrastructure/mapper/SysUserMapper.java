package io.github.panxiaochao.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.panxiaochao.system.domain.entity.SysUserLogin;
import io.github.panxiaochao.system.infrastructure.po.SysUserPO;
import org.apache.ibatis.annotations.Mapper;

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
	List<SysUserLogin> loadUserByIdentityType(String username, String identityType);

}
