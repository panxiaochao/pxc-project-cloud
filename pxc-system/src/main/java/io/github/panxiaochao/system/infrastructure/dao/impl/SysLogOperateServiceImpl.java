package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysLogOperateService;
import io.github.panxiaochao.system.infrastructure.mapper.SysLogOperateMapper;
import io.github.panxiaochao.system.infrastructure.po.SysLogOperatePO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志操作表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysLogOperateServiceImpl extends ServiceImpl<SysLogOperateMapper, SysLogOperatePO>
		implements ISysLogOperateService {

	private final SysLogOperateMapper sysLogOperateMapper;

}
