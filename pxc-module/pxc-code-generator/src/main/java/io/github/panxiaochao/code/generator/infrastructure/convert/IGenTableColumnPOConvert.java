package io.github.panxiaochao.code.generator.infrastructure.convert;

import io.github.panxiaochao.code.generator.application.api.response.gentablecolumn.GenTableColumnQueryResponse;
import io.github.panxiaochao.code.generator.domain.entity.GenTableColumn;
import io.github.panxiaochao.code.generator.infrastructure.po.GenTableColumnPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 代码生成表字段持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Mapper
public interface IGenTableColumnPOConvert {

	/**
	 * 代码生成表字段持久化对象结构映射实例
	 */
	IGenTableColumnPOConvert INSTANCE = Mappers.getMapper(IGenTableColumnPOConvert.class);

	/**
	 * 代码生成表字段实体 转 代码生成表字段持久化对象
	 * @param genTableColumn 代码生成表字段实体
	 * @return 代码生成表字段持久化对象
	 */
	GenTableColumnPO fromEntity(GenTableColumn genTableColumn);

	/**
	 * 代码生成表字段实体 转 代码生成表字段持久化对象
	 * @param genTableColumnList 代码生成表字段实体
	 * @return 代码生成表字段持久化对象
	 */
	List<GenTableColumnPO> fromEntity(List<GenTableColumn> genTableColumnList);

	/**
	 * 代码生成表字段持久化对象 转 代码生成表字段实体
	 * @param genTableColumnPO 代码生成表字段持久化对象
	 * @return 代码生成表字段实体
	 */
	GenTableColumn toEntity(GenTableColumnPO genTableColumnPO);

	/**
	 * 代码生成表字段持久化对象 转 代码生成表字段实体
	 * @param genTableColumnPOList 代码生成表字段持久化对象
	 * @return 代码生成表字段实体
	 */
	List<GenTableColumn> toEntity(List<GenTableColumnPO> genTableColumnPOList);

	/**
	 * 代码生成表字段持久化对象 转 代码生成表字段查询响应数据传输对象
	 * @param genTableColumnPO 代码生成表字段持久化对象
	 * @return 代码生成表字段查询响应数据传输对象
	 */
	GenTableColumnQueryResponse toQueryResponse(GenTableColumnPO genTableColumnPO);

	/**
	 * 代码生成表字段持久化对象列表 转 代码生成表字段查询响应数据传输对象列表
	 * @param genTableColumnPOList 代码生成表字段持久化对象列表
	 * @return 代码生成表字段查询响应数据传输对象列表
	 */
	List<GenTableColumnQueryResponse> toQueryResponse(List<GenTableColumnPO> genTableColumnPOList);

}
