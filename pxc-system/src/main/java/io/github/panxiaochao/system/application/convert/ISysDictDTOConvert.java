package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysDictCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysDictQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysDictUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysDictQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysDictResponse;
import io.github.panxiaochao.system.domain.entity.SysDict;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据字典表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysDictDTOConvert {

	/**
	 * 数据字典表数据传输对象结构映射实例
	 */
	ISysDictDTOConvert INSTANCE = Mappers.getMapper(ISysDictDTOConvert.class);

	/**
	 * 数据字典表创建请求数据传输对象 转 数据字典表实体
	 * @param createRequest 数据字典表创建请求数据传输对象
	 * @return 数据字典表实体
	 */
	SysDict fromCreateRequest(SysDictCreateRequest createRequest);

	/**
	 * 数据字典表更新请求数据传输对象 转 数据字典表实体
	 * @param updateRequest 数据字典表更新请求数据传输对象
	 * @return 数据字典表实体
	 */
	SysDict fromUpdateRequest(SysDictUpdateRequest updateRequest);

	/**
	 * 数据字典表查询请求数据传输对象 转 数据字典表实体
	 * @param queryRequest 数据字典表查询请求数据传输对象
	 * @return 数据字典表实体
	 */
	SysDict fromQueryRequest(SysDictQueryRequest queryRequest);

	/**
	 * 数据字典表实体 转 数据字典表响应数据传输对象
	 * @param sysDict 数据字典表实体
	 * @return 数据字典表响应数据传输对象
	 */
	SysDictResponse toResponse(SysDict sysDict);

	/**
	 * 数据字典表实体 转 数据字典表查询响应数据传输对象
	 * @param sysDict 数据字典表实体
	 * @return 数据字典表查询响应数据传输对象
	 */
	SysDictQueryResponse toQueryResponse(SysDict sysDict);

	/**
	 * 数据字典表实体列表 转 数据字典表查询响应数据传输对象列表
	 * @param sysDictList 数据字典表实体列表
	 * @return 数据字典表查询响应数据传输对象列表
	 */
	List<SysDictQueryResponse> toQueryResponse(List<SysDict> sysDictList);

}
