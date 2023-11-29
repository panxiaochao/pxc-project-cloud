package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.SysDictItemQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysDictItem;
import io.github.panxiaochao.system.infrastructure.po.SysDictItemPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据字典配置表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysDictItemPOConvert {

	/**
	 * 数据字典配置表持久化对象结构映射实例
	 */
	ISysDictItemPOConvert INSTANCE = Mappers.getMapper(ISysDictItemPOConvert.class);

	/**
	 * 数据字典配置表实体 转 数据字典配置表持久化对象
	 * @param sysDictItem 数据字典配置表实体
	 * @return 数据字典配置表持久化对象
	 */
	SysDictItemPO fromEntity(SysDictItem sysDictItem);

	/**
	 * 数据字典配置表实体 转 数据字典配置表持久化对象
	 * @param sysDictItemList 数据字典配置表实体
	 * @return 数据字典配置表持久化对象
	 */
	List<SysDictItemPO> fromEntity(List<SysDictItem> sysDictItemList);

	/**
	 * 数据字典配置表持久化对象 转 数据字典配置表实体
	 * @param sysDictItemPO 数据字典配置表持久化对象
	 * @return 数据字典配置表实体
	 */
	SysDictItem toEntity(SysDictItemPO sysDictItemPO);

	/**
	 * 数据字典配置表持久化对象 转 数据字典配置表实体
	 * @param sysDictItemPOList 数据字典配置表持久化对象
	 * @return 数据字典配置表实体
	 */
	List<SysDictItem> toEntity(List<SysDictItemPO> sysDictItemPOList);

	/**
	 * 数据字典配置表持久化对象 转 数据字典配置表查询响应数据传输对象
	 * @param sysDictItemPO 数据字典配置表持久化对象
	 * @return 数据字典配置表查询响应数据传输对象
	 */
	SysDictItemQueryResponse toQueryResponse(SysDictItemPO sysDictItemPO);

	/**
	 * 数据字典配置表持久化对象列表 转 数据字典配置表查询响应数据传输对象列表
	 * @param sysDictItemPOList 数据字典配置表持久化对象列表
	 * @return 数据字典配置表查询响应数据传输对象列表
	 */
	List<SysDictItemQueryResponse> toQueryResponse(List<SysDictItemPO> sysDictItemPOList);

}
