package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.component.select.SelectBuilder;
import io.github.panxiaochao.core.component.select.SelectOption;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantUpdateRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantResponse;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageQueryResponse;
import io.github.panxiaochao.system.application.convert.ISysTenantDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageReadModelService;
import io.github.panxiaochao.system.application.repository.ISysTenantReadModelService;
import io.github.panxiaochao.system.application.runner.helper.CacheHelper;
import io.github.panxiaochao.system.domain.entity.SysTenant;
import io.github.panxiaochao.system.domain.service.SysTenantDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 租户表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantAppService {

	/**
	 * 租户表 Domain服务类
	 */
	private final SysTenantDomainService sysTenantDomainService;

	/**
	 * 租户表 读模型服务
	 */
	private final ISysTenantReadModelService sysTenantReadModelService;

	/**
	 * 租户套餐表 读模型服务
	 */
	private final ISysTenantPackageReadModelService sysTenantPackageReadModelService;

	/**
	 * 租户模式 常量名
	 */
	private static final String TENANT_MODE = "TENANT_MODE";

	/**
	 * 查询分页
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 租户表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysTenantQueryResponse> page(RequestPage requestPage, SysTenantQueryRequest queryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<SysTenantQueryResponse> list = sysTenantReadModelService.page(pagination, queryRequest);
		// 字典翻译
		SysTenantPackageQueryRequest sysTenantPackageQueryRequest = new SysTenantPackageQueryRequest();
		sysTenantPackageQueryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		List<SysTenantPackageQueryResponse> sysTenantPackageQueryResponseList = sysTenantPackageReadModelService
			.selectList(sysTenantPackageQueryRequest);
		// 数据翻译
		list.forEach(s -> {
			if (StringUtils.hasText(s.getMode())) {
				SysDictItemQueryResponse sysDictItemQueryResponse = CacheHelper.getSysDictItemByValue(TENANT_MODE,
						s.getMode());
				if (Objects.nonNull(sysDictItemQueryResponse)) {
					s.setModeStr(sysDictItemQueryResponse.getDictItemText());
				}
			}
			if (StringUtils.hasText(s.getPackageId())) {
				String packageName = sysTenantPackageQueryResponseList.stream()
					.filter(packageQueryResponse -> s.getPackageId().equals(packageQueryResponse.getPackageId()))
					.map(SysTenantPackageQueryResponse::getPackageName)
					.findFirst()
					.orElse(StringPools.EMPTY);
				s.setPackageName(packageName);
			}
		});
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysTenantResponse> getById(String id) {
		SysTenant sysTenant = sysTenantDomainService.getById(id);
		SysTenantResponse sysTenantResponse = ISysTenantDTOConvert.INSTANCE.toResponse(sysTenant);
		return R.ok(sysTenantResponse);
	}

	/**
	 * 保存
	 * @param sysTenantCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysTenantResponse> save(SysTenantCreateRequest sysTenantCreateRequest) {
		SysTenant sysTenant = ISysTenantDTOConvert.INSTANCE.fromCreateRequest(sysTenantCreateRequest);
		SysTenantQueryRequest queryRequest = new SysTenantQueryRequest();
		queryRequest.setTenantId(sysTenant.getTenantId());
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		SysTenantQueryResponse one = sysTenantReadModelService.getOne(queryRequest);
		if (Objects.nonNull(one)) {
			return R.fail("租户编码[" + sysTenant.getTenantId() + "]已存在");
		}
		sysTenant = sysTenantDomainService.save(sysTenant);
		SysTenantResponse sysTenantResponse = ISysTenantDTOConvert.INSTANCE.toResponse(sysTenant);
		return R.ok(sysTenantResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysTenantUpdateRequest sysTenantUpdateRequest) {
		SysTenant sysTenant = ISysTenantDTOConvert.INSTANCE.fromUpdateRequest(sysTenantUpdateRequest);
		sysTenantDomainService.update(sysTenant);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysTenantDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 获取租户模式下拉菜单
	 * @return List<Select<String>>
	 */
	public List<Select<String>> selectModes() {
		List<SysDictItemQueryResponse> list = CacheHelper.getSysDictItemListByCode(TENANT_MODE);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(false, m.getId(), m.getDictItemText(), m.getDictItemValue(), m.getSort(),
					(extraMap) -> extraMap.put("label", m.getDictItemText())))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

}
