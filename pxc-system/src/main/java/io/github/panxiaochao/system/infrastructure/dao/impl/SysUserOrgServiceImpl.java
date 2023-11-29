package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysUserOrgService;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserOrgMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserOrgPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户机构/部门表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysUserOrgServiceImpl extends ServiceImpl<SysUserOrgMapper, SysUserOrgPO> implements ISysUserOrgService {

	private final SysUserOrgMapper sysUserOrgMapper;

}
