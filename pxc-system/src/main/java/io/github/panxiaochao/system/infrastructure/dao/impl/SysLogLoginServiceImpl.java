package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysLogLoginService;
import io.github.panxiaochao.system.infrastructure.mapper.SysLogLoginMapper;
import io.github.panxiaochao.system.infrastructure.po.SysLogLoginPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志登录/登出表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysLogLoginServiceImpl extends ServiceImpl<SysLogLoginMapper, SysLogLoginPO>
		implements ISysLogLoginService {

	private final SysLogLoginMapper sysLogLoginMapper;

}
