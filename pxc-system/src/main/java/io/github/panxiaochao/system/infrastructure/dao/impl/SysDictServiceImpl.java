package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.ISysDictService;
import io.github.panxiaochao.system.infrastructure.mapper.SysDictMapper;
import io.github.panxiaochao.system.infrastructure.po.SysDictPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictPO> implements ISysDictService {

	private final SysDictMapper sysDictMapper;

}
