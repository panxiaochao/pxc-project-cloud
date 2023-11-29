package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysAreaService;
import io.github.panxiaochao.system.infrastructure.mapper.SysAreaMapper;
import io.github.panxiaochao.system.infrastructure.po.SysAreaPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 全国5级行政区划 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysAreaPO> implements ISysAreaService {

	private final SysAreaMapper sysAreaMapper;

}
