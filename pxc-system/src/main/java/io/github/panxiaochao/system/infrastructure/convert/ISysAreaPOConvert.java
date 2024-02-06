package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.sysarea.SysAreaQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysArea;
import io.github.panxiaochao.system.infrastructure.po.SysAreaPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 全国5级行政区划持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface ISysAreaPOConvert {

	/**
	 * 全国5级行政区划持久化对象结构映射实例
	 */
	ISysAreaPOConvert INSTANCE = Mappers.getMapper(ISysAreaPOConvert.class);

	/**
	 * 全国5级行政区划实体 转 全国5级行政区划持久化对象
	 * @param sysArea 全国5级行政区划实体
	 * @return 全国5级行政区划持久化对象
	 */
	SysAreaPO fromEntity(SysArea sysArea);

	/**
	 * 全国5级行政区划实体 转 全国5级行政区划持久化对象
	 * @param sysAreaList 全国5级行政区划实体
	 * @return 全国5级行政区划持久化对象
	 */
	List<SysAreaPO> fromEntity(List<SysArea> sysAreaList);

	/**
	 * 全国5级行政区划持久化对象 转 全国5级行政区划实体
	 * @param sysAreaPO 全国5级行政区划持久化对象
	 * @return 全国5级行政区划实体
	 */
	SysArea toEntity(SysAreaPO sysAreaPO);

	/**
	 * 全国5级行政区划持久化对象 转 全国5级行政区划实体
	 * @param sysAreaPOList 全国5级行政区划持久化对象
	 * @return 全国5级行政区划实体
	 */
	List<SysArea> toEntity(List<SysAreaPO> sysAreaPOList);

	/**
	 * 全国5级行政区划持久化对象 转 全国5级行政区划查询响应数据传输对象
	 * @param sysAreaPO 全国5级行政区划持久化对象
	 * @return 全国5级行政区划查询响应数据传输对象
	 */
	SysAreaQueryResponse toQueryResponse(SysAreaPO sysAreaPO);

	/**
	 * 全国5级行政区划持久化对象列表 转 全国5级行政区划查询响应数据传输对象列表
	 * @param sysAreaPOList 全国5级行政区划持久化对象列表
	 * @return 全国5级行政区划查询响应数据传输对象列表
	 */
	List<SysAreaQueryResponse> toQueryResponse(List<SysAreaPO> sysAreaPOList);

}
