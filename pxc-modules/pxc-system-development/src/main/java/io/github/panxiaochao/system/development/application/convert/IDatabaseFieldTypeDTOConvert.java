package io.github.panxiaochao.system.development.application.convert;

import io.github.panxiaochao.system.development.application.api.request.databasefieldtype.DatabaseFieldTypeCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtype.DatabaseFieldTypeQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtype.DatabaseFieldTypeUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtype.DatabaseFieldTypeQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtype.DatabaseFieldTypeResponse;
import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据库字段类型码表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface IDatabaseFieldTypeDTOConvert {

	/**
	 * 数据库字段类型码表数据传输对象结构映射实例
	 */
	IDatabaseFieldTypeDTOConvert INSTANCE = Mappers.getMapper(IDatabaseFieldTypeDTOConvert.class);

	/**
	 * 数据库字段类型码表创建请求数据传输对象 转 数据库字段类型码表实体
	 * @param createRequest 数据库字段类型码表创建请求数据传输对象
	 * @return 数据库字段类型码表实体
	 */
	DatabaseFieldType fromCreateRequest(DatabaseFieldTypeCreateRequest createRequest);

	/**
	 * 数据库字段类型码表更新请求数据传输对象 转 数据库字段类型码表实体
	 * @param updateRequest 数据库字段类型码表更新请求数据传输对象
	 * @return 数据库字段类型码表实体
	 */
	DatabaseFieldType fromUpdateRequest(DatabaseFieldTypeUpdateRequest updateRequest);

	/**
	 * 数据库字段类型码表查询请求数据传输对象 转 数据库字段类型码表实体
	 * @param queryRequest 数据库字段类型码表查询请求数据传输对象
	 * @return 数据库字段类型码表实体
	 */
	DatabaseFieldType fromQueryRequest(DatabaseFieldTypeQueryRequest queryRequest);

	/**
	 * 数据库字段类型码表实体 转 数据库字段类型码表响应数据传输对象
	 * @param databaseFieldType 数据库字段类型码表实体
	 * @return 数据库字段类型码表响应数据传输对象
	 */
	DatabaseFieldTypeResponse toResponse(DatabaseFieldType databaseFieldType);

	/**
	 * 数据库字段类型码表实体 转 数据库字段类型码表查询响应数据传输对象
	 * @param databaseFieldType 数据库字段类型码表实体
	 * @return 数据库字段类型码表查询响应数据传输对象
	 */
	DatabaseFieldTypeQueryResponse toQueryResponse(DatabaseFieldType databaseFieldType);

	/**
	 * 数据库字段类型码表实体列表 转 数据库字段类型码表查询响应数据传输对象列表
	 * @param databaseFieldTypeList 数据库字段类型码表实体列表
	 * @return 数据库字段类型码表查询响应数据传输对象列表
	 */
	List<DatabaseFieldTypeQueryResponse> toQueryResponse(List<DatabaseFieldType> databaseFieldTypeList);

}
