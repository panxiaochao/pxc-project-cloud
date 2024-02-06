package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.sysparam.SysParamQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysParam;
import io.github.panxiaochao.system.infrastructure.po.SysParamPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统参数持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface ISysParamPOConvert {

	/**
	 * 系统参数持久化对象结构映射实例
	 */
	ISysParamPOConvert INSTANCE = Mappers.getMapper(ISysParamPOConvert.class);

	/**
	 * 系统参数实体 转 系统参数持久化对象
	 * @param sysParam 系统参数实体
	 * @return 系统参数持久化对象
	 */
	SysParamPO fromEntity(SysParam sysParam);

	/**
	 * 系统参数实体 转 系统参数持久化对象
	 * @param sysParamList 系统参数实体
	 * @return 系统参数持久化对象
	 */
	List<SysParamPO> fromEntity(List<SysParam> sysParamList);

	/**
	 * 系统参数持久化对象 转 系统参数实体
	 * @param sysParamPO 系统参数持久化对象
	 * @return 系统参数实体
	 */
	SysParam toEntity(SysParamPO sysParamPO);

	/**
	 * 系统参数持久化对象 转 系统参数实体
	 * @param sysParamPOList 系统参数持久化对象
	 * @return 系统参数实体
	 */
	List<SysParam> toEntity(List<SysParamPO> sysParamPOList);

	/**
	 * 系统参数持久化对象 转 系统参数查询响应数据传输对象
	 * @param sysParamPO 系统参数持久化对象
	 * @return 系统参数查询响应数据传输对象
	 */
	SysParamQueryResponse toQueryResponse(SysParamPO sysParamPO);

	/**
	 * 系统参数持久化对象列表 转 系统参数查询响应数据传输对象列表
	 * @param sysParamPOList 系统参数持久化对象列表
	 * @return 系统参数查询响应数据传输对象列表
	 */
	List<SysParamQueryResponse> toQueryResponse(List<SysParamPO> sysParamPOList);

}
