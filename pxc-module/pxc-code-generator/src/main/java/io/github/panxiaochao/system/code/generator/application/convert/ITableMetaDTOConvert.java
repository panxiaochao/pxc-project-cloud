package io.github.panxiaochao.system.code.generator.application.convert;

import io.github.panxiaochao.system.code.generator.application.api.response.gentable.TableMetaQueryResponse;
import io.github.panxiaochao.core.utils.meta.db.TableMeta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据库表元数据数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Mapper
public interface ITableMetaDTOConvert {

	/**
	 * 数据库表元数据数据传输对象结构映射实例
	 */
	ITableMetaDTOConvert INSTANCE = Mappers.getMapper(ITableMetaDTOConvert.class);

	/**
	 * 数据库表元数据实体 转 数据库表元数据查询响应数据传输对象
	 * @param genTable 数据库表元数据实体
	 * @return 数据库表元数据查询响应数据传输对象
	 */
	TableMetaQueryResponse toQueryResponse(TableMeta genTable);

	/**
	 * 数据库表元数据实体列表 转 数据库表元数据查询响应数据传输对象列表
	 * @param genTableList 数据库表元数据实体列表
	 * @return 数据库表元数据查询响应数据传输对象列表
	 */
	List<TableMetaQueryResponse> toQueryResponse(List<TableMeta> genTableList);

}
