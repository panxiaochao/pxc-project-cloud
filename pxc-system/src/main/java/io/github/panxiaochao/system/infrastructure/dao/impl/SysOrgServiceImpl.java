package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysOrgService;
import io.github.panxiaochao.system.infrastructure.mapper.SysOrgMapper;
import io.github.panxiaochao.system.infrastructure.po.SysOrgPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构部门表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrgPO> implements ISysOrgService {

	private final SysOrgMapper sysOrgMapper;

}
