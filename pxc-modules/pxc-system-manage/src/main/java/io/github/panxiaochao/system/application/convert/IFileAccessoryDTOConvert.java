package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.fileaccessory.FileAccessoryCreateRequest;
import io.github.panxiaochao.system.application.api.request.fileaccessory.FileAccessoryQueryRequest;
import io.github.panxiaochao.system.application.api.request.fileaccessory.FileAccessoryUpdateRequest;
import io.github.panxiaochao.system.application.api.response.fileaccessory.FileAccessoryQueryResponse;
import io.github.panxiaochao.system.application.api.response.fileaccessory.FileAccessoryResponse;
import io.github.panxiaochao.system.domain.entity.FileAccessory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 附件表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface IFileAccessoryDTOConvert {

	/**
	 * 附件表数据传输对象结构映射实例
	 */
	IFileAccessoryDTOConvert INSTANCE = Mappers.getMapper(IFileAccessoryDTOConvert.class);

	/**
	 * 附件表创建请求数据传输对象 转 附件表实体
	 * @param createRequest 附件表创建请求数据传输对象
	 * @return 附件表实体
	 */
	FileAccessory fromCreateRequest(FileAccessoryCreateRequest createRequest);

	/**
	 * 附件表更新请求数据传输对象 转 附件表实体
	 * @param updateRequest 附件表更新请求数据传输对象
	 * @return 附件表实体
	 */
	FileAccessory fromUpdateRequest(FileAccessoryUpdateRequest updateRequest);

	/**
	 * 附件表查询请求数据传输对象 转 附件表实体
	 * @param queryRequest 附件表查询请求数据传输对象
	 * @return 附件表实体
	 */
	FileAccessory fromQueryRequest(FileAccessoryQueryRequest queryRequest);

	/**
	 * 附件表实体 转 附件表响应数据传输对象
	 * @param fileAccessory 附件表实体
	 * @return 附件表响应数据传输对象
	 */
	FileAccessoryResponse toResponse(FileAccessory fileAccessory);

	/**
	 * 附件表实体 转 附件表查询响应数据传输对象
	 * @param fileAccessory 附件表实体
	 * @return 附件表查询响应数据传输对象
	 */
	FileAccessoryQueryResponse toQueryResponse(FileAccessory fileAccessory);

	/**
	 * 附件表实体列表 转 附件表查询响应数据传输对象列表
	 * @param fileAccessoryList 附件表实体列表
	 * @return 附件表查询响应数据传输对象列表
	 */
	List<FileAccessoryQueryResponse> toQueryResponse(List<FileAccessory> fileAccessoryList);

}
