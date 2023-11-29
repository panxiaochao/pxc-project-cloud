package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysRoleService;
import io.github.panxiaochao.system.infrastructure.mapper.SysRoleMapper;
import io.github.panxiaochao.system.infrastructure.po.SysRolePO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRolePO> implements ISysRoleService {

	private final SysRoleMapper sysRoleMapper;

}
