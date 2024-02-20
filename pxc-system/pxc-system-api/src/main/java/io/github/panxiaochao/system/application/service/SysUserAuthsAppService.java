package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.component.select.SelectBuilder;
import io.github.panxiaochao.core.component.select.SelectOption;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuserauths.SysUserAuthsQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuserauths.SysUserAuthsResponse;
import io.github.panxiaochao.system.application.convert.ISysUserAuthsDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserAuthsReadModelService;
import io.github.panxiaochao.system.application.runner.helper.CacheHelper;
import io.github.panxiaochao.system.domain.entity.SysUserAuths;
import io.github.panxiaochao.system.domain.service.SysUserAuthsDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户授权信息表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserAuthsAppService {

	/**
	 * 用户授权信息表 Domain服务类
	 */
	private final SysUserAuthsDomainService sysUserAuthsDomainService;

	/**
	 * 用户授权信息表 读模型服务
	 */
	private final ISysUserAuthsReadModelService sysUserAuthsReadModelService;

	/**
	 * 登录类型 常量名
	 */
	private static final String IDENTITY_TYPE = "IDENTITY_TYPE";

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 用户授权信息表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysUserAuthsQueryResponse> page(RequestPage pageRequest,
			SysUserAuthsQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysUserAuthsQueryResponse> list = sysUserAuthsReadModelService.page(pagination, queryRequest);
		list.forEach(s -> {
			SysDictItemQueryResponse sysDictItemQueryResponse = CacheHelper.getSysDictItemByValue(IDENTITY_TYPE,
					s.getIdentityType());
			if (Objects.isNull(sysDictItemQueryResponse)) {
				s.setIdentityTypeStr(StringPools.EMPTY);
			}
			else {
				s.setIdentityTypeStr(sysDictItemQueryResponse.getDictItemText());
			}
		});
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysUserAuthsResponse> getById(String id) {
		SysUserAuths sysUserAuths = sysUserAuthsDomainService.getById(id);
		SysUserAuthsResponse sysUserAuthsResponse = ISysUserAuthsDTOConvert.INSTANCE.toResponse(sysUserAuths);
		return R.ok(sysUserAuthsResponse);
	}

	/**
	 * 保存
	 * @param sysUserAuthsCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysUserAuthsResponse> save(SysUserAuthsCreateRequest sysUserAuthsCreateRequest) {
		SysUserAuths sysUserAuths = ISysUserAuthsDTOConvert.INSTANCE.fromCreateRequest(sysUserAuthsCreateRequest);
		SysUserAuthsQueryRequest queryRequest = new SysUserAuthsQueryRequest();
		List<SysUserAuthsQueryResponse> list = sysUserAuthsReadModelService.list(queryRequest);
		if (!CollectionUtils.isEmpty(list)) {
			// 1.先判断登录类型有没有创建过
			final SysUserAuths finalSysUserAuths = sysUserAuths;
			boolean hasData = list.stream()
				.anyMatch(f -> f.getIdentityType().equals(finalSysUserAuths.getIdentityType())
						&& f.getUserId().equals(finalSysUserAuths.getUserId()));
			if (hasData) {
				SysDictItemQueryResponse sysDictItemQueryResponse = CacheHelper.getSysDictItemByValue(IDENTITY_TYPE,
						sysUserAuths.getIdentityType());
				return R.fail("登录类型[" + sysDictItemQueryResponse.getDictItemText() + "]已存在");
			}
			// 2.再判断登录类型和登录账号，其他用户有没有新建过
			hasData = list.stream()
				.anyMatch(f -> f.getIdentityType().equals(finalSysUserAuths.getIdentityType())
						&& f.getIdentifier().equals(finalSysUserAuths.getIdentifier()));
			if (hasData) {
				SysDictItemQueryResponse sysDictItemQueryResponse = CacheHelper.getSysDictItemByValue(IDENTITY_TYPE,
						sysUserAuths.getIdentityType());
				return R.fail("在登录类型[" + sysDictItemQueryResponse.getDictItemText() + "]下，登录账号["
						+ finalSysUserAuths.getIdentifier() + "]已存在");
			}
		}
		sysUserAuths = sysUserAuthsDomainService.save(sysUserAuths);
		SysUserAuthsResponse sysUserAuthsResponse = ISysUserAuthsDTOConvert.INSTANCE.toResponse(sysUserAuths);
		return R.ok(sysUserAuthsResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysUserAuthsUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysUserAuthsUpdateRequest sysUserAuthsUpdateRequest) {
		SysUserAuths sysUserAuths = ISysUserAuthsDTOConvert.INSTANCE.fromUpdateRequest(sysUserAuthsUpdateRequest);
		// 既然要更新，用户下查询必定有数据，至少一条
		SysUserAuthsQueryRequest queryRequest = new SysUserAuthsQueryRequest();
		queryRequest.setUserId(sysUserAuths.getUserId());
		List<SysUserAuthsQueryResponse> list = sysUserAuthsReadModelService.list(queryRequest);
		Optional<SysUserAuthsQueryResponse> optionalSysUserAuths = list.stream()
			.filter(f -> f.getId().equals(sysUserAuths.getId())
					&& f.getIdentityType().equals(sysUserAuths.getIdentityType()))
			.findFirst();
		// 1.有数据说明是更新的是同一个登录类型
		// 2.没有数据说明换登录类型了，需要判断这个人，其他登录类型是否有重复
		if (!optionalSysUserAuths.isPresent()) {
			optionalSysUserAuths = list.stream()
				.filter(f -> f.getIdentityType().equals(sysUserAuths.getIdentityType()))
				.findFirst();
			// 有数据了
			if (optionalSysUserAuths.isPresent()) {
				SysDictItemQueryResponse sysDictItemQueryResponse = CacheHelper.getSysDictItemByValue(IDENTITY_TYPE,
						sysUserAuths.getIdentityType());
				return R.fail("登录类型[" + sysDictItemQueryResponse.getDictItemText() + "]已存在");
			}
		}
		sysUserAuthsDomainService.update(sysUserAuths);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysUserAuthsDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 获取登录类型下拉菜单
	 * @return 返回通用下拉菜单
	 */
	public List<Select<String>> selectIdentityTypes() {
		List<SysDictItemQueryResponse> list = CacheHelper.getSysDictItemListByCode(IDENTITY_TYPE);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(false, m.getId(), m.getDictItemText(), m.getDictItemValue(), m.getSort(), null))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

}
