package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.panxiaochao.system.domain.repository.IFileAccessoryService;
import io.github.panxiaochao.system.infrastructure.mapper.FileAccessoryMapper;
import io.github.panxiaochao.system.infrastructure.po.FileAccessoryPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 附件表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class FileAccessoryServiceImpl extends ServiceImpl<FileAccessoryMapper, FileAccessoryPO>
		implements IFileAccessoryService {

	private final FileAccessoryMapper fileAccessoryMapper;

}
