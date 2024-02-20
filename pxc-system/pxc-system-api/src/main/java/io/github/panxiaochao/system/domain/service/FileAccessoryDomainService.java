package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.FileAccessory;
import io.github.panxiaochao.system.domain.repository.IFileAccessoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 附件表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class FileAccessoryDomainService {

	/**
	 * FileAccessory Domain接口服务类
	 */
	private final IFileAccessoryService fileAccessoryService;

	/**
	 * 详情
	 * @param id 主键
	 * @return FileAccessory 实体
	 */
	public FileAccessory getById(String id) {
		return fileAccessoryService.getById(id);
	}

	/**
	 * 保存
	 * @param fileAccessory FileAccessory 实体
	 * @return FileAccessory 实体
	 */
	public FileAccessory save(FileAccessory fileAccessory) {
		return fileAccessoryService.save(fileAccessory);
	}

	/**
	 * 根据主键更新
	 * @param fileAccessory FileAccessory 实体
	 */
	public void update(FileAccessory fileAccessory) {
		fileAccessoryService.update(fileAccessory);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		fileAccessoryService.deleteById(id);
	}

}
