package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysUserAuthsService;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserAuthsMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserAuthsPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户授权信息表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysUserAuthsServiceImpl extends ServiceImpl<SysUserAuthsMapper, SysUserAuthsPO>
		implements ISysUserAuthsService {

	private final SysUserAuthsMapper sysUserAuthsMapper;

}
