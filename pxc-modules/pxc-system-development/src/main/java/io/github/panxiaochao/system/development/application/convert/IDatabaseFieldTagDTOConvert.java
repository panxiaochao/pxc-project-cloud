package io.github.panxiaochao.system.development.application.convert;

import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagResponse;
import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldTag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Mapper
public interface IDatabaseFieldTagDTOConvert {

	/**
	 * 数据库字段类型-数据库标签表数据传输对象结构映射实例
	 */
	IDatabaseFieldTagDTOConvert INSTANCE = Mappers.getMapper(IDatabaseFieldTagDTOConvert.class);

	/**
	 * 数据库字段类型-数据库标签表创建请求数据传输对象 转 数据库字段类型-数据库标签表实体
	 * @param createRequest 数据库字段类型-数据库标签表创建请求数据传输对象
	 * @return 数据库字段类型-数据库标签表实体
	 */
	DatabaseFieldTag fromCreateRequest(DatabaseFieldTagCreateRequest createRequest);

	/**
	 * 数据库字段类型-数据库标签表创建请求数据传输对象列表 转 数据库字段类型-数据库标签表实体列表
	 * @param createRequestList 数据库字段类型-数据库标签表创建请求数据传输对象列表
	 * @return 数据库字段类型-数据库标签表实体列表
	 */
	List<DatabaseFieldTag> fromCreateRequest(List<DatabaseFieldTagCreateRequest> createRequestList);

	/**
	 * 数据库字段类型-数据库标签表更新请求数据传输对象 转 数据库字段类型-数据库标签表实体
	 * @param updateRequest 数据库字段类型-数据库标签表更新请求数据传输对象
	 * @return 数据库字段类型-数据库标签表实体
	 */
	DatabaseFieldTag fromUpdateRequest(DatabaseFieldTagUpdateRequest updateRequest);

	/**
	 * 数据库字段类型-数据库标签表更新请求数据传输对象列表 转 数据库字段类型-数据库标签表实体列表
	 * @param updateRequestList 数据库字段类型-数据库标签表更新请求数据传输对象列表
	 * @return 数据库字段类型-数据库标签表实体列表
	 */
	List<DatabaseFieldTag> fromUpdateRequest(List<DatabaseFieldTagUpdateRequest> updateRequestList);

	/**
	 * 数据库字段类型-数据库标签表查询请求数据传输对象 转 数据库字段类型-数据库标签表实体
	 * @param queryRequest 数据库字段类型-数据库标签表查询请求数据传输对象
	 * @return 数据库字段类型-数据库标签表实体
	 */
	DatabaseFieldTag fromQueryRequest(DatabaseFieldTagQueryRequest queryRequest);

	/**
	 * 数据库字段类型-数据库标签表实体 转 数据库字段类型-数据库标签表响应数据传输对象
	 * @param databaseFieldTag 数据库字段类型-数据库标签表实体
	 * @return 数据库字段类型-数据库标签表响应数据传输对象
	 */
	DatabaseFieldTagResponse toResponse(DatabaseFieldTag databaseFieldTag);

	/**
	 * 数据库字段类型-数据库标签表实体 转 数据库字段类型-数据库标签表查询响应数据传输对象
	 * @param databaseFieldTag 数据库字段类型-数据库标签表实体
	 * @return 数据库字段类型-数据库标签表查询响应数据传输对象
	 */
	DatabaseFieldTagQueryResponse toQueryResponse(DatabaseFieldTag databaseFieldTag);

	/**
	 * 数据库字段类型-数据库标签表实体列表 转 数据库字段类型-数据库标签表查询响应数据传输对象列表
	 * @param databaseFieldTagList 数据库字段类型-数据库标签表实体列表
	 * @return 数据库字段类型-数据库标签表查询响应数据传输对象列表
	 */
	List<DatabaseFieldTagQueryResponse> toQueryResponse(List<DatabaseFieldTag> databaseFieldTagList);

}
