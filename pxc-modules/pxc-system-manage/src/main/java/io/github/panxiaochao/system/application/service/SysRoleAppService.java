package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.component.select.SelectBuilder;
import io.github.panxiaochao.core.component.select.SelectOption;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysrole.SysRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysrole.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysrole.SysRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysrole.SysRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysrole.SysRoleResponse;
import io.github.panxiaochao.system.application.convert.ISysRoleDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysRoleReadModelService;
import io.github.panxiaochao.system.common.cache.CacheHelper;
import io.github.panxiaochao.system.domain.entity.SysRole;
import io.github.panxiaochao.system.domain.service.SysRoleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysRoleAppService {

	/**
	 * 角色表 Domain服务类
	 */
	private final SysRoleDomainService sysRoleDomainService;

	/**
	 * 角色表 读模型服务
	 */
	private final ISysRoleReadModelService sysRoleReadModelService;

	/**
	 * 数据权限 常量名
	 */
	private static final String DATA_SCOPE = "DATA_SCOPE";

	/**
	 * 查询分页
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 角色表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysRoleQueryResponse> page(RequestPage requestPage, SysRoleQueryRequest queryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<SysRoleQueryResponse> list = sysRoleReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 查询列表
	 * @param queryRequest 角色表查询请求对象
	 * @return 结果数组
	 */
	public List<Select<String>> listRole(SysRoleQueryRequest queryRequest) {
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		List<SysRoleQueryResponse> list = sysRoleReadModelService.list(queryRequest);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(m.getId(), m.getRoleName(), m.getSort(), (extraMap) -> {
				extraMap.put("label", m.getRoleName());
			}))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysRoleResponse> getById(String id) {
		SysRole sysRole = sysRoleDomainService.getById(id);
		SysRoleResponse sysRoleResponse = ISysRoleDTOConvert.INSTANCE.toResponse(sysRole);
		return R.ok(sysRoleResponse);
	}

	/**
	 * 保存
	 * @param sysRoleCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysRoleResponse> save(SysRoleCreateRequest sysRoleCreateRequest) {
		SysRole sysRole = ISysRoleDTOConvert.INSTANCE.fromCreateRequest(sysRoleCreateRequest);
		SysRoleQueryRequest queryRequest = new SysRoleQueryRequest();
		queryRequest.setRoleCode(sysRole.getRoleCode());
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		SysRoleQueryResponse one = sysRoleReadModelService.getOne(queryRequest);
		if (Objects.nonNull(one)) {
			return R.fail("角色编码[" + sysRole.getRoleCode() + "]已存在");
		}
		sysRole = sysRoleDomainService.save(sysRole);
		SysRoleResponse sysRoleResponse = ISysRoleDTOConvert.INSTANCE.toResponse(sysRole);
		return R.ok(sysRoleResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysRoleUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysRoleUpdateRequest sysRoleUpdateRequest) {
		SysRole sysRole = ISysRoleDTOConvert.INSTANCE.fromUpdateRequest(sysRoleUpdateRequest);
		sysRoleDomainService.update(sysRole);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysRoleDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 获取数据权限下拉菜单
	 * @return 返回通用下拉菜单
	 */
	public List<Select<String>> selectDataScopes() {
		List<CacheHelper.SysDictItem> list = CacheHelper.getSysDictItemListByCode(DATA_SCOPE);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(m.getDictItemValue(), m.getDictItemText(), m.getSort(), (extraMap) -> {
				extraMap.put("label", m.getDictItemText());
			}))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

}
