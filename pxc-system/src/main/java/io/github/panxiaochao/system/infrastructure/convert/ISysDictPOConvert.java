package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.sysdict.SysDictQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysDict;
import io.github.panxiaochao.system.infrastructure.po.SysDictPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据字典表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysDictPOConvert {

	/**
	 * 数据字典表持久化对象结构映射实例
	 */
	ISysDictPOConvert INSTANCE = Mappers.getMapper(ISysDictPOConvert.class);

	/**
	 * 数据字典表实体 转 数据字典表持久化对象
	 * @param sysDict 数据字典表实体
	 * @return 数据字典表持久化对象
	 */
	SysDictPO fromEntity(SysDict sysDict);

	/**
	 * 数据字典表实体 转 数据字典表持久化对象
	 * @param sysDictList 数据字典表实体
	 * @return 数据字典表持久化对象
	 */
	List<SysDictPO> fromEntity(List<SysDict> sysDictList);

	/**
	 * 数据字典表持久化对象 转 数据字典表实体
	 * @param sysDictPO 数据字典表持久化对象
	 * @return 数据字典表实体
	 */
	SysDict toEntity(SysDictPO sysDictPO);

	/**
	 * 数据字典表持久化对象 转 数据字典表实体
	 * @param sysDictPOList 数据字典表持久化对象
	 * @return 数据字典表实体
	 */
	List<SysDict> toEntity(List<SysDictPO> sysDictPOList);

	/**
	 * 数据字典表持久化对象 转 数据字典表查询响应数据传输对象
	 * @param sysDictPO 数据字典表持久化对象
	 * @return 数据字典表查询响应数据传输对象
	 */
	SysDictQueryResponse toQueryResponse(SysDictPO sysDictPO);

	/**
	 * 数据字典表持久化对象列表 转 数据字典表查询响应数据传输对象列表
	 * @param sysDictPOList 数据字典表持久化对象列表
	 * @return 数据字典表查询响应数据传输对象列表
	 */
	List<SysDictQueryResponse> toQueryResponse(List<SysDictPO> sysDictPOList);
}
