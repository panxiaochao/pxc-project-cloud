package io.github.panxiaochao.system.code.generator.application.convert;

import io.github.panxiaochao.system.code.generator.application.api.request.gentablecolumn.GenTableColumnCreateRequest;
import io.github.panxiaochao.system.code.generator.application.api.request.gentablecolumn.GenTableColumnQueryRequest;
import io.github.panxiaochao.system.code.generator.application.api.request.gentablecolumn.GenTableColumnUpdateRequest;
import io.github.panxiaochao.system.code.generator.application.api.response.gentablecolumn.GenTableColumnQueryResponse;
import io.github.panxiaochao.system.code.generator.application.api.response.gentablecolumn.GenTableColumnResponse;
import io.github.panxiaochao.system.code.generator.domain.entity.GenTableColumn;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 代码生成表字段数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Mapper
public interface IGenTableColumnDTOConvert {

	/**
	 * 代码生成表字段数据传输对象结构映射实例
	 */
	IGenTableColumnDTOConvert INSTANCE = Mappers.getMapper(IGenTableColumnDTOConvert.class);

	/**
	 * 代码生成表字段创建请求数据传输对象 转 代码生成表字段实体
	 * @param createRequest 代码生成表字段创建请求数据传输对象
	 * @return 代码生成表字段实体
	 */
	GenTableColumn fromCreateRequest(GenTableColumnCreateRequest createRequest);

	/**
	 * 代码生成表字段更新请求数据传输对象 转 代码生成表字段实体
	 * @param updateRequest 代码生成表字段更新请求数据传输对象
	 * @return 代码生成表字段实体
	 */
	GenTableColumn fromUpdateRequest(GenTableColumnUpdateRequest updateRequest);

	/**
	 * 代码生成表字段查询请求数据传输对象 转 代码生成表字段实体
	 * @param queryRequest 代码生成表字段查询请求数据传输对象
	 * @return 代码生成表字段实体
	 */
	GenTableColumn fromQueryRequest(GenTableColumnQueryRequest queryRequest);

	/**
	 * 代码生成表字段实体 转 代码生成表字段响应数据传输对象
	 * @param genTableColumn 代码生成表字段实体
	 * @return 代码生成表字段响应数据传输对象
	 */
	GenTableColumnResponse toResponse(GenTableColumn genTableColumn);

	/**
	 * 代码生成表字段实体 转 代码生成表字段查询响应数据传输对象
	 * @param genTableColumn 代码生成表字段实体
	 * @return 代码生成表字段查询响应数据传输对象
	 */
	GenTableColumnQueryResponse toQueryResponse(GenTableColumn genTableColumn);

	/**
	 * 代码生成表字段实体列表 转 代码生成表字段查询响应数据传输对象列表
	 * @param genTableColumnList 代码生成表字段实体列表
	 * @return 代码生成表字段查询响应数据传输对象列表
	 */
	List<GenTableColumnQueryResponse> toQueryResponse(List<GenTableColumn> genTableColumnList);

}
