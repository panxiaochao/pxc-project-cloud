package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.component.select.SelectBuilder;
import io.github.panxiaochao.core.component.select.SelectOption;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageCreateRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageQueryRequest;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageUpdateRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageQueryResponse;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageResponse;
import io.github.panxiaochao.system.application.convert.ISysTenantPackageDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageReadModelService;
import io.github.panxiaochao.system.domain.entity.SysTenantPackage;
import io.github.panxiaochao.system.domain.service.SysTenantPackageDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 租户套餐表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageAppService {

	/**
	 * 租户套餐表 Domain服务类
	 */
	private final SysTenantPackageDomainService sysTenantPackageDomainService;

	/**
	 * 租户套餐表 读模型服务
	 */
	private final ISysTenantPackageReadModelService sysTenantPackageReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 租户套餐表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysTenantPackageQueryResponse> page(RequestPage pageRequest,
			SysTenantPackageQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysTenantPackageQueryResponse> list = sysTenantPackageReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysTenantPackageResponse> getById(String id) {
		SysTenantPackage sysTenantPackage = sysTenantPackageDomainService.getById(id);
		SysTenantPackageResponse sysTenantPackageResponse = ISysTenantPackageDTOConvert.INSTANCE
			.toResponse(sysTenantPackage);
		return R.ok(sysTenantPackageResponse);
	}

	/**
	 * 保存
	 * @param sysTenantPackageCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysTenantPackageResponse> save(SysTenantPackageCreateRequest sysTenantPackageCreateRequest) {
		SysTenantPackage sysTenantPackage = ISysTenantPackageDTOConvert.INSTANCE
			.fromCreateRequest(sysTenantPackageCreateRequest);
		SysTenantPackageQueryRequest queryRequest = new SysTenantPackageQueryRequest();
		queryRequest.setPackageId(sysTenantPackage.getPackageId());
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		SysTenantPackageQueryResponse one = sysTenantPackageReadModelService.getOne(queryRequest);
		if (Objects.nonNull(one)) {
			return R.fail("租户套餐编码[" + sysTenantPackage.getPackageId() + "]已存在");
		}
		sysTenantPackage = sysTenantPackageDomainService.save(sysTenantPackage);
		SysTenantPackageResponse sysTenantPackageResponse = ISysTenantPackageDTOConvert.INSTANCE
			.toResponse(sysTenantPackage);
		return R.ok(sysTenantPackageResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantPackageUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysTenantPackageUpdateRequest sysTenantPackageUpdateRequest) {
		SysTenantPackage sysTenantPackage = ISysTenantPackageDTOConvert.INSTANCE
			.fromUpdateRequest(sysTenantPackageUpdateRequest);
		sysTenantPackageDomainService.update(sysTenantPackage);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysTenantPackageDomainService.deleteById(id);
		// TODO: 删除相关资源
		return R.ok();
	}

	/**
	 * 获取租户套餐下拉菜单
	 * @return List<Select<String>>
	 */
	public List<Select<String>> selectPackages() {
		SysTenantPackageQueryRequest sysTenantPackageQueryRequest = new SysTenantPackageQueryRequest();
		sysTenantPackageQueryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		List<SysTenantPackageQueryResponse> list = sysTenantPackageReadModelService
			.selectList(sysTenantPackageQueryRequest);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(m.getPackageId(), m.getPackageName(), m.getSort(),
					(extraMap) -> extraMap.put("label", m.getPackageName())))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

}
