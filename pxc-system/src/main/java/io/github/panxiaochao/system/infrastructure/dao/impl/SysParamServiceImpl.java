package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysParamService;
import io.github.panxiaochao.system.infrastructure.mapper.SysParamMapper;
import io.github.panxiaochao.system.infrastructure.po.SysParamPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统参数 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysParamServiceImpl extends ServiceImpl<SysParamMapper, SysParamPO> implements ISysParamService {

	private final SysParamMapper sysParamMapper;

}
