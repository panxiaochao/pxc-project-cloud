package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysUserService;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserPO> implements ISysUserService {

	private final SysUserMapper sysUserMapper;

}
