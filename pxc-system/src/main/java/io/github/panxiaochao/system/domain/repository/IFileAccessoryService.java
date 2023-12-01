package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.FileAccessory;

/**
 * <p>
 * 附件表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface IFileAccessoryService {

	/**
	 * 详情
	 * @param id 主键
	 * @return 附件表 实体
	 */
	FileAccessory getById(String id);

	/**
	 * 保存
	 * @param fileAccessory 角色表 实体
	 * @return 附件表 实体
	 */
	FileAccessory save(FileAccessory fileAccessory);

	/**
	 * 根据主键更新
	 * @param fileAccessory 附件表 实体
	 */
	void update(FileAccessory fileAccessory);

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void deleteById(String id);
}
