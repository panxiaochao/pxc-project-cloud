package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysuserrole.SysUserRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuserrole.SysUserRoleResponse;
import io.github.panxiaochao.system.application.convert.ISysUserRoleDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUserRole;
import io.github.panxiaochao.system.domain.service.SysUserRoleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleAppService {

	/**
	 * 用户角色表 Domain服务类
	 */
	private final SysUserRoleDomainService sysUserRoleDomainService;

	/**
	 * 用户角色表 读模型服务
	 */
	private final ISysUserRoleReadModelService sysUserRoleReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 用户角色表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysUserRoleQueryResponse> page(RequestPage pageRequest, SysUserRoleQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysUserRoleQueryResponse> list = sysUserRoleReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 角色ID数组
	 * @param userId 用户ID
	 * @return 角色ID数组
	 */
	public List<String> rolesByUserId(String userId) {
		SysUserRoleQueryRequest queryRequest = new SysUserRoleQueryRequest();
		queryRequest.setUserId(userId);
		List<SysUserRoleQueryResponse> list = sysUserRoleReadModelService.list(queryRequest);
		if (!CollectionUtils.isEmpty(list)) {
			return list.stream().map(SysUserRoleQueryResponse::getRoleId).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysUserRoleResponse> getById(String id) {
		SysUserRole sysUserRole = sysUserRoleDomainService.getById(id);
		SysUserRoleResponse sysUserRoleResponse = ISysUserRoleDTOConvert.INSTANCE.toResponse(sysUserRole);
		return R.ok(sysUserRoleResponse);
	}

	/**
	 * 保存
	 * @param sysUserRoleCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<Void> save(SysUserRoleCreateRequest sysUserRoleCreateRequest) {
		if (StringUtils.hasText(sysUserRoleCreateRequest.getRoleId())) {
			// 以,分割roleId为字符串数组
			String[] roleIds = sysUserRoleCreateRequest.getRoleId().split(StringPools.COMMA);
			List<SysUserRole> list = Arrays.stream(roleIds)
				.map(roleId -> new SysUserRole(sysUserRoleCreateRequest.getUserId(), roleId))
				.collect(Collectors.toList());
			// 先删除当前用户的所有关联数据
			sysUserRoleDomainService.deleteByUserId(sysUserRoleCreateRequest.getUserId());
			// 批量保存当前用户的最新关联数据
			sysUserRoleDomainService.saveBatch(list);
		}
		return R.ok();
	}

	/**
	 * 根据主键更新
	 * @param sysUserRoleUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysUserRoleUpdateRequest sysUserRoleUpdateRequest) {
		SysUserRole sysUserRole = ISysUserRoleDTOConvert.INSTANCE.fromUpdateRequest(sysUserRoleUpdateRequest);
		sysUserRoleDomainService.update(sysUserRole);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysUserRoleDomainService.deleteById(id);
		return R.ok();
	}

}
