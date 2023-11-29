package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysUserRoleService;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserRoleMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserRolePO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRolePO>
		implements ISysUserRoleService {

	private final SysUserRoleMapper sysUserRoleMapper;

}
