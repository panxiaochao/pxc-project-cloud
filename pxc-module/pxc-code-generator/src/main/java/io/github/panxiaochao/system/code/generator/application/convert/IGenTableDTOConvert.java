package io.github.panxiaochao.system.code.generator.application.convert;

import io.github.panxiaochao.system.code.generator.application.api.request.gentable.GenTableCreateRequest;
import io.github.panxiaochao.system.code.generator.application.api.request.gentable.GenTableQueryRequest;
import io.github.panxiaochao.system.code.generator.application.api.request.gentable.GenTableUpdateRequest;
import io.github.panxiaochao.system.code.generator.application.api.response.gentable.GenTableQueryResponse;
import io.github.panxiaochao.system.code.generator.application.api.response.gentable.GenTableResponse;
import io.github.panxiaochao.system.code.generator.domain.entity.GenTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 代码生成表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Mapper
public interface IGenTableDTOConvert {

	/**
	 * 代码生成表数据传输对象结构映射实例
	 */
	IGenTableDTOConvert INSTANCE = Mappers.getMapper(IGenTableDTOConvert.class);

	/**
	 * 代码生成表创建请求数据传输对象 转 代码生成表实体
	 * @param createRequest 代码生成表创建请求数据传输对象
	 * @return 代码生成表实体
	 */
	GenTable fromCreateRequest(GenTableCreateRequest createRequest);

	/**
	 * 代码生成表更新请求数据传输对象 转 代码生成表实体
	 * @param updateRequest 代码生成表更新请求数据传输对象
	 * @return 代码生成表实体
	 */
	GenTable fromUpdateRequest(GenTableUpdateRequest updateRequest);

	/**
	 * 代码生成表查询请求数据传输对象 转 代码生成表实体
	 * @param queryRequest 代码生成表查询请求数据传输对象
	 * @return 代码生成表实体
	 */
	GenTable fromQueryRequest(GenTableQueryRequest queryRequest);

	/**
	 * 代码生成表实体 转 代码生成表响应数据传输对象
	 * @param genTable 代码生成表实体
	 * @return 代码生成表响应数据传输对象
	 */
	GenTableResponse toResponse(GenTable genTable);

	/**
	 * 代码生成表实体 转 代码生成表查询响应数据传输对象
	 * @param genTable 代码生成表实体
	 * @return 代码生成表查询响应数据传输对象
	 */
	GenTableQueryResponse toQueryResponse(GenTable genTable);

	/**
	 * 代码生成表实体列表 转 代码生成表查询响应数据传输对象列表
	 * @param genTableList 代码生成表实体列表
	 * @return 代码生成表查询响应数据传输对象列表
	 */
	List<GenTableQueryResponse> toQueryResponse(List<GenTable> genTableList);

}
