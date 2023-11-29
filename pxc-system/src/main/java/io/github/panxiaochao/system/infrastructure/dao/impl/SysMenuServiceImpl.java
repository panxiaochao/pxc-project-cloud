package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysMenuService;
import io.github.panxiaochao.system.infrastructure.mapper.SysMenuMapper;
import io.github.panxiaochao.system.infrastructure.po.SysMenuPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单配置 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuPO> implements ISysMenuService {

	private final SysMenuMapper sysMenuMapper;

}
