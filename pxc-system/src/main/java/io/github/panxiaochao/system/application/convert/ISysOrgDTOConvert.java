package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysOrgCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysOrgQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysOrgUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysOrgQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysOrgResponse;
import io.github.panxiaochao.system.domain.entity.SysOrg;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 机构部门表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysOrgDTOConvert {

	/**
	 * 机构部门表数据传输对象结构映射实例
	 */
	ISysOrgDTOConvert INSTANCE = Mappers.getMapper(ISysOrgDTOConvert.class);

	/**
	 * 机构部门表创建请求数据传输对象 转 机构部门表实体
	 * @param createRequest 机构部门表创建请求数据传输对象
	 * @return 机构部门表实体
	 */
	SysOrg fromCreateRequest(SysOrgCreateRequest createRequest);

	/**
	 * 机构部门表更新请求数据传输对象 转 机构部门表实体
	 * @param updateRequest 机构部门表更新请求数据传输对象
	 * @return 机构部门表实体
	 */
	SysOrg fromUpdateRequest(SysOrgUpdateRequest updateRequest);

	/**
	 * 机构部门表查询请求数据传输对象 转 机构部门表实体
	 * @param queryRequest 机构部门表查询请求数据传输对象
	 * @return 机构部门表实体
	 */
	SysOrg fromQueryRequest(SysOrgQueryRequest queryRequest);

	/**
	 * 机构部门表实体 转 机构部门表响应数据传输对象
	 * @param sysOrg 机构部门表实体
	 * @return 机构部门表响应数据传输对象
	 */
	SysOrgResponse toResponse(SysOrg sysOrg);

	/**
	 * 机构部门表实体 转 机构部门表查询响应数据传输对象
	 * @param sysOrg 机构部门表实体
	 * @return 机构部门表查询响应数据传输对象
	 */
	SysOrgQueryResponse toQueryResponse(SysOrg sysOrg);

	/**
	 * 机构部门表实体列表 转 机构部门表查询响应数据传输对象列表
	 * @param sysOrgList 机构部门表实体列表
	 * @return 机构部门表查询响应数据传输对象列表
	 */
	List<SysOrgQueryResponse> toQueryResponse(List<SysOrg> sysOrgList);
}
