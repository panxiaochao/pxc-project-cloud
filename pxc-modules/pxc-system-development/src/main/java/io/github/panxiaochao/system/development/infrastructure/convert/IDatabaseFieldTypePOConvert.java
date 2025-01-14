package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.databasefieldtype.DatabaseFieldTypeQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldType;
import io.github.panxiaochao.system.development.infrastructure.po.DatabaseFieldTypePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 数据库字段类型码表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface IDatabaseFieldTypePOConvert {

	/**
	 * 数据库字段类型码表持久化对象结构映射实例
	 */
	IDatabaseFieldTypePOConvert INSTANCE = Mappers.getMapper(IDatabaseFieldTypePOConvert.class);

	/**
	 * 数据库字段类型码表实体 转 数据库字段类型码表持久化对象
	 * @param databaseFieldType 数据库字段类型码表实体
	 * @return 数据库字段类型码表持久化对象
	 */
	DatabaseFieldTypePO fromEntity(DatabaseFieldType databaseFieldType);

	/**
	 * 数据库字段类型码表实体 转 数据库字段类型码表持久化对象
	 * @param databaseFieldTypeList 数据库字段类型码表实体
	 * @return 数据库字段类型码表持久化对象
	 */
	List<DatabaseFieldTypePO> fromEntity(List<DatabaseFieldType> databaseFieldTypeList);

	/**
	 * 数据库字段类型码表持久化对象 转 数据库字段类型码表实体
	 * @param databaseFieldTypePO 数据库字段类型码表持久化对象
	 * @return 数据库字段类型码表实体
	 */
	DatabaseFieldType toEntity(DatabaseFieldTypePO databaseFieldTypePO);

	/**
	 * 数据库字段类型码表持久化对象 转 数据库字段类型码表实体
	 * @param databaseFieldTypePOList 数据库字段类型码表持久化对象
	 * @return 数据库字段类型码表实体
	 */
	List<DatabaseFieldType> toEntity(List<DatabaseFieldTypePO> databaseFieldTypePOList);

	/**
	 * 数据库字段类型码表持久化对象 转 数据库字段类型码表查询响应数据传输对象
	 * @param databaseFieldTypePO 数据库字段类型码表持久化对象
	 * @return 数据库字段类型码表查询响应数据传输对象
	 */
	DatabaseFieldTypeQueryResponse toQueryResponse(DatabaseFieldTypePO databaseFieldTypePO);

	/**
	 * 数据库字段类型码表持久化对象列表 转 数据库字段类型码表查询响应数据传输对象列表
	 * @param databaseFieldTypePOList 数据库字段类型码表持久化对象列表
	 * @return 数据库字段类型码表查询响应数据传输对象列表
	 */
	List<DatabaseFieldTypeQueryResponse> toQueryResponse(List<DatabaseFieldTypePO> databaseFieldTypePOList);

}
