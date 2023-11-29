package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysDictItemService;
import io.github.panxiaochao.system.infrastructure.mapper.SysDictItemMapper;
import io.github.panxiaochao.system.infrastructure.po.SysDictItemPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典配置表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItemPO>
		implements ISysDictItemService {

	private final SysDictItemMapper sysDictItemMapper;

}
