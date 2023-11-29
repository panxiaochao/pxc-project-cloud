package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.SysUserOrgCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysUserOrgQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysUserOrgUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysUserOrgQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysUserOrgResponse;
import io.github.panxiaochao.system.domain.entity.SysUserOrg;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户机构/部门表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Mapper
public interface ISysUserOrgDTOConvert {

	/**
	 * 用户机构/部门表数据传输对象结构映射实例
	 */
	ISysUserOrgDTOConvert INSTANCE = Mappers.getMapper(ISysUserOrgDTOConvert.class);

	/**
	 * 用户机构/部门表创建请求数据传输对象 转 用户机构/部门表实体
	 * @param createRequest 用户机构/部门表创建请求数据传输对象
	 * @return 用户机构/部门表实体
	 */
	SysUserOrg fromCreateRequest(SysUserOrgCreateRequest createRequest);

	/**
	 * 用户机构/部门表更新请求数据传输对象 转 用户机构/部门表实体
	 * @param updateRequest 用户机构/部门表更新请求数据传输对象
	 * @return 用户机构/部门表实体
	 */
	SysUserOrg fromUpdateRequest(SysUserOrgUpdateRequest updateRequest);

	/**
	 * 用户机构/部门表查询请求数据传输对象 转 用户机构/部门表实体
	 * @param queryRequest 用户机构/部门表查询请求数据传输对象
	 * @return 用户机构/部门表实体
	 */
	SysUserOrg fromQueryRequest(SysUserOrgQueryRequest queryRequest);

	/**
	 * 用户机构/部门表实体 转 用户机构/部门表响应数据传输对象
	 * @param sysUserOrg 用户机构/部门表实体
	 * @return 用户机构/部门表响应数据传输对象
	 */
	SysUserOrgResponse toResponse(SysUserOrg sysUserOrg);

	/**
	 * 用户机构/部门表实体 转 用户机构/部门表查询响应数据传输对象
	 * @param sysUserOrg 用户机构/部门表实体
	 * @return 用户机构/部门表查询响应数据传输对象
	 */
	SysUserOrgQueryResponse toQueryResponse(SysUserOrg sysUserOrg);

	/**
	 * 用户机构/部门表实体列表 转 用户机构/部门表查询响应数据传输对象列表
	 * @param sysUserOrgList 用户机构/部门表实体列表
	 * @return 用户机构/部门表查询响应数据传输对象列表
	 */
	List<SysUserOrgQueryResponse> toQueryResponse(List<SysUserOrg> sysUserOrgList);

}
