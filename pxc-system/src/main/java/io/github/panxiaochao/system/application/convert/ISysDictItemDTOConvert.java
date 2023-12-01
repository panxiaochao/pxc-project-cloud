package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysDictItemCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysDictItemQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysDictItemUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysDictItemResponse;
import io.github.panxiaochao.system.domain.entity.SysDictItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据字典配置表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysDictItemDTOConvert {

	/**
	 * 数据字典配置表数据传输对象结构映射实例
	 */
	ISysDictItemDTOConvert INSTANCE = Mappers.getMapper(ISysDictItemDTOConvert.class);

	/**
	 * 数据字典配置表创建请求数据传输对象 转 数据字典配置表实体
	 * @param createRequest 数据字典配置表创建请求数据传输对象
	 * @return 数据字典配置表实体
	 */
	SysDictItem fromCreateRequest(SysDictItemCreateRequest createRequest);

	/**
	 * 数据字典配置表更新请求数据传输对象 转 数据字典配置表实体
	 * @param updateRequest 数据字典配置表更新请求数据传输对象
	 * @return 数据字典配置表实体
	 */
	SysDictItem fromUpdateRequest(SysDictItemUpdateRequest updateRequest);

	/**
	 * 数据字典配置表查询请求数据传输对象 转 数据字典配置表实体
	 * @param queryRequest 数据字典配置表查询请求数据传输对象
	 * @return 数据字典配置表实体
	 */
	SysDictItem fromQueryRequest(SysDictItemQueryRequest queryRequest);

	/**
	 * 数据字典配置表实体 转 数据字典配置表响应数据传输对象
	 * @param sysDictItem 数据字典配置表实体
	 * @return 数据字典配置表响应数据传输对象
	 */
	SysDictItemResponse toResponse(SysDictItem sysDictItem);

	/**
	 * 数据字典配置表实体 转 数据字典配置表查询响应数据传输对象
	 * @param sysDictItem 数据字典配置表实体
	 * @return 数据字典配置表查询响应数据传输对象
	 */
	SysDictItemQueryResponse toQueryResponse(SysDictItem sysDictItem);

	/**
	 * 数据字典配置表实体列表 转 数据字典配置表查询响应数据传输对象列表
	 * @param sysDictItemList 数据字典配置表实体列表
	 * @return 数据字典配置表查询响应数据传输对象列表
	 */
	List<SysDictItemQueryResponse> toQueryResponse(List<SysDictItem> sysDictItemList);
}
