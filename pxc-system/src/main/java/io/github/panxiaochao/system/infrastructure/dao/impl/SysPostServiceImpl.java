package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysPostService;
import io.github.panxiaochao.system.infrastructure.mapper.SysPostMapper;
import io.github.panxiaochao.system.infrastructure.po.SysPostPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPostPO> implements ISysPostService {

	private final SysPostMapper sysPostMapper;

}
