package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.response.gentable.GenTableQueryResponse;
import io.github.panxiaochao.system.development.domain.entity.GenTable;
import io.github.panxiaochao.system.development.infrastructure.po.GenTablePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 代码生成表持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Mapper
public interface IGenTablePOConvert {

	/**
	 * 代码生成表持久化对象结构映射实例
	 */
	IGenTablePOConvert INSTANCE = Mappers.getMapper(IGenTablePOConvert.class);

	/**
	 * 代码生成表实体 转 代码生成表持久化对象
	 * @param genTable 代码生成表实体
	 * @return 代码生成表持久化对象
	 */
	GenTablePO fromEntity(GenTable genTable);

	/**
	 * 代码生成表实体 转 代码生成表持久化对象
	 * @param genTableList 代码生成表实体
	 * @return 代码生成表持久化对象
	 */
	List<GenTablePO> fromEntity(List<GenTable> genTableList);

	/**
	 * 代码生成表持久化对象 转 代码生成表实体
	 * @param genTablePO 代码生成表持久化对象
	 * @return 代码生成表实体
	 */
	GenTable toEntity(GenTablePO genTablePO);

	/**
	 * 代码生成表持久化对象 转 代码生成表实体
	 * @param genTablePOList 代码生成表持久化对象
	 * @return 代码生成表实体
	 */
	List<GenTable> toEntity(List<GenTablePO> genTablePOList);

	/**
	 * 代码生成表持久化对象 转 代码生成表查询响应数据传输对象
	 * @param genTablePO 代码生成表持久化对象
	 * @return 代码生成表查询响应数据传输对象
	 */
	GenTableQueryResponse toQueryResponse(GenTablePO genTablePO);

	/**
	 * 代码生成表持久化对象列表 转 代码生成表查询响应数据传输对象列表
	 * @param genTablePOList 代码生成表持久化对象列表
	 * @return 代码生成表查询响应数据传输对象列表
	 */
	List<GenTableQueryResponse> toQueryResponse(List<GenTablePO> genTablePOList);

}
