package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.fileaccessory.FileAccessoryQueryResponse;
import io.github.panxiaochao.system.domain.entity.FileAccessory;
import io.github.panxiaochao.system.infrastructure.po.FileAccessoryPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 附件表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface IFileAccessoryPOConvert {

	/**
	 * 附件表持久化对象结构映射实例
	 */
	IFileAccessoryPOConvert INSTANCE = Mappers.getMapper(IFileAccessoryPOConvert.class);

	/**
	 * 附件表实体 转 附件表持久化对象
	 * @param fileAccessory 附件表实体
	 * @return 附件表持久化对象
	 */
	FileAccessoryPO fromEntity(FileAccessory fileAccessory);

	/**
	 * 附件表实体 转 附件表持久化对象
	 * @param fileAccessoryList 附件表实体
	 * @return 附件表持久化对象
	 */
	List<FileAccessoryPO> fromEntity(List<FileAccessory> fileAccessoryList);

	/**
	 * 附件表持久化对象 转 附件表实体
	 * @param fileAccessoryPO 附件表持久化对象
	 * @return 附件表实体
	 */
	FileAccessory toEntity(FileAccessoryPO fileAccessoryPO);

	/**
	 * 附件表持久化对象 转 附件表实体
	 * @param fileAccessoryPOList 附件表持久化对象
	 * @return 附件表实体
	 */
	List<FileAccessory> toEntity(List<FileAccessoryPO> fileAccessoryPOList);

	/**
	 * 附件表持久化对象 转 附件表查询响应数据传输对象
	 * @param fileAccessoryPO 附件表持久化对象
	 * @return 附件表查询响应数据传输对象
	 */
	FileAccessoryQueryResponse toQueryResponse(FileAccessoryPO fileAccessoryPO);

	/**
	 * 附件表持久化对象列表 转 附件表查询响应数据传输对象列表
	 * @param fileAccessoryPOList 附件表持久化对象列表
	 * @return 附件表查询响应数据传输对象列表
	 */
	List<FileAccessoryQueryResponse> toQueryResponse(List<FileAccessoryPO> fileAccessoryPOList);

}
