package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldTag;
import io.github.panxiaochao.system.development.infrastructure.dao.po.DatabaseFieldTagPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Mapper
public interface IDatabaseFieldTagPOConvert {

	/**
	 * 数据库字段类型-数据库标签表持久化对象结构映射实例
	 */
	IDatabaseFieldTagPOConvert INSTANCE = Mappers.getMapper(IDatabaseFieldTagPOConvert.class);

	/**
	 * 数据库字段类型-数据库标签表实体 转 数据库字段类型-数据库标签表持久化对象
	 * @param databaseFieldTag 数据库字段类型-数据库标签表实体
	 * @return 数据库字段类型-数据库标签表持久化对象
	 */
	DatabaseFieldTagPO fromEntity(DatabaseFieldTag databaseFieldTag);

	/**
	 * 数据库字段类型-数据库标签表实体 转 数据库字段类型-数据库标签表持久化对象
	 * @param databaseFieldTagList 数据库字段类型-数据库标签表实体
	 * @return 数据库字段类型-数据库标签表持久化对象
	 */
	List<DatabaseFieldTagPO> fromEntity(List<DatabaseFieldTag> databaseFieldTagList);

	/**
	 * 数据库字段类型-数据库标签表持久化对象 转 数据库字段类型-数据库标签表实体
	 * @param databaseFieldTagPO 数据库字段类型-数据库标签表持久化对象
	 * @return 数据库字段类型-数据库标签表实体
	 */
	DatabaseFieldTag toEntity(DatabaseFieldTagPO databaseFieldTagPO);

	/**
	 * 数据库字段类型-数据库标签表持久化对象 转 数据库字段类型-数据库标签表实体
	 * @param databaseFieldTagPOList 数据库字段类型-数据库标签表持久化对象
	 * @return 数据库字段类型-数据库标签表实体
	 */
	List<DatabaseFieldTag> toEntity(List<DatabaseFieldTagPO> databaseFieldTagPOList);

	/**
	 * 数据库字段类型-数据库标签表持久化对象 转 数据库字段类型-数据库标签表查询响应数据传输对象
	 * @param databaseFieldTagPO 数据库字段类型-数据库标签表持久化对象
	 * @return 数据库字段类型-数据库标签表查询响应数据传输对象
	 */
	DatabaseFieldTagQueryResponse toQueryResponse(DatabaseFieldTagPO databaseFieldTagPO);

	/**
	 * 数据库字段类型-数据库标签表持久化对象列表 转 数据库字段类型-数据库标签表查询响应数据传输对象列表
	 * @param databaseFieldTagPOList 数据库字段类型-数据库标签表持久化对象列表
	 * @return 数据库字段类型-数据库标签表查询响应数据传输对象列表
	 */
	List<DatabaseFieldTagQueryResponse> toQueryResponse(List<DatabaseFieldTagPO> databaseFieldTagPOList);

}
