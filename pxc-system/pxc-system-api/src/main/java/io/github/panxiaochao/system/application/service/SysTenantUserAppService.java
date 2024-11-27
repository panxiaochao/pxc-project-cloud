package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenantuser.SysTenantUserQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenantuser.SysTenantUserResponse;
import io.github.panxiaochao.system.application.convert.ISysTenantUserDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantUserReadModelService;
import io.github.panxiaochao.system.domain.entity.SysTenantUser;
import io.github.panxiaochao.system.domain.service.SysTenantUserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 租户用户表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Service
@RequiredArgsConstructor
public class SysTenantUserAppService {

	/**
	 * 租户用户表 Domain服务类
	 */
	private final SysTenantUserDomainService sysTenantUserDomainService;

	/**
	 * 租户用户表 读模型服务
	 */
	private final ISysTenantUserReadModelService sysTenantUserReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 租户用户表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysTenantUserQueryResponse> page(RequestPage pageRequest,
			SysTenantUserQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysTenantUserQueryResponse> list = sysTenantUserReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysTenantUserResponse> getById(String id) {
		SysTenantUser sysTenantUser = sysTenantUserDomainService.getById(id);
		SysTenantUserResponse sysTenantUserResponse = ISysTenantUserDTOConvert.INSTANCE.toResponse(sysTenantUser);
		return R.ok(sysTenantUserResponse);
	}

	/**
	 * 保存
	 * @param sysTenantUserCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysTenantUserResponse> save(SysTenantUserCreateRequest sysTenantUserCreateRequest) {
		SysTenantUser sysTenantUser = ISysTenantUserDTOConvert.INSTANCE.fromCreateRequest(sysTenantUserCreateRequest);
		sysTenantUser = sysTenantUserDomainService.save(sysTenantUser);
		SysTenantUserResponse sysTenantUserResponse = ISysTenantUserDTOConvert.INSTANCE.toResponse(sysTenantUser);
		return R.ok(sysTenantUserResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantUserUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysTenantUserUpdateRequest sysTenantUserUpdateRequest) {
		SysTenantUser sysTenantUser = ISysTenantUserDTOConvert.INSTANCE.fromUpdateRequest(sysTenantUserUpdateRequest);
		sysTenantUserDomainService.update(sysTenantUser);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysTenantUserDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 批量保存租户关联多用户
	 * @param sysTenantUserCreateRequest 创建请求对象
	 */
	public void saveTenantUsers(SysTenantUserCreateRequest sysTenantUserCreateRequest) {
		if (StringUtils.hasText(sysTenantUserCreateRequest.getUserId())) {
			// 分割用户ID
			String[] userIds = StringUtils.tokenizeToStringArray(sysTenantUserCreateRequest.getUserId(),
					StringPools.COMMA);
			List<SysTenantUser> list = Arrays.stream(userIds)
				.map(userId -> new SysTenantUser(sysTenantUserCreateRequest.getTenantId(), userId))
				.collect(Collectors.toList());
			// 在批量保存保存当前角色关联的菜单数据
			sysTenantUserDomainService.saveBath(list);
		}
	}

	/**
	 * 根据租户ID和用户ID删除
	 * @param sysTenantUserCreateRequest 创建请求对象
	 * @return 空返回
	 */
	public R<Void> deleteTenantUser(SysTenantUserCreateRequest sysTenantUserCreateRequest) {
		SysTenantUser sysTenantUser = ISysTenantUserDTOConvert.INSTANCE.fromCreateRequest(sysTenantUserCreateRequest);
		sysTenantUserDomainService.deleteTenantUser(sysTenantUser);
		return R.ok();
	}
}
