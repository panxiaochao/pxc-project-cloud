package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysJobService;
import io.github.panxiaochao.system.infrastructure.mapper.SysJobMapper;
import io.github.panxiaochao.system.infrastructure.po.SysJobPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJobPO> implements ISysJobService {

	private final SysJobMapper sysJobMapper;

}
