package io.github.panxiaochao.system.development.application.service;

import io.github.panxiaochao.component.select.Select;
import io.github.panxiaochao.component.select.SelectBuilder;
import io.github.panxiaochao.component.select.SelectOption;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.common.cache.CacheHelper;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateResponse;
import io.github.panxiaochao.system.development.application.convert.IGenTemplateDTOConvert;
import io.github.panxiaochao.system.development.application.repository.IGenTemplateReadModelService;
import io.github.panxiaochao.system.development.domain.entity.GenTemplate;
import io.github.panxiaochao.system.development.domain.service.GenTemplateDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 模板 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Service
@RequiredArgsConstructor
public class GenTemplateAppService {

	/**
	 * 模板 Domain服务类
	 */
	private final GenTemplateDomainService genTemplateDomainService;

	/**
	 * 模板 读模型服务
	 */
	private final IGenTemplateReadModelService genTemplateReadModelService;

	/**
	 * 模版类型 常量名
	 */
	private static final String GEN_TEMPLATE_TYPE = "GEN_TEMPLATE_TYPE";

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 模板查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<GenTemplateQueryResponse> page(RequestPage pageRequest, GenTemplateQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<GenTemplateQueryResponse> list = genTemplateReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<GenTemplateResponse> getById(String id) {
		GenTemplate genTemplate = genTemplateDomainService.getById(id);
		GenTemplateResponse genTemplateResponse = IGenTemplateDTOConvert.INSTANCE.toResponse(genTemplate);
		return R.ok(genTemplateResponse);
	}

	/**
	 * 保存
	 * @param genTemplateCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<GenTemplateResponse> save(GenTemplateCreateRequest genTemplateCreateRequest) {
		GenTemplate genTemplate = IGenTemplateDTOConvert.INSTANCE.fromCreateRequest(genTemplateCreateRequest);
		genTemplate = genTemplateDomainService.save(genTemplate);
		GenTemplateResponse genTemplateResponse = IGenTemplateDTOConvert.INSTANCE.toResponse(genTemplate);
		return R.ok(genTemplateResponse);
	}

	/**
	 * 根据主键更新
	 * @param genTemplateUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(GenTemplateUpdateRequest genTemplateUpdateRequest) {
		GenTemplate genTemplate = IGenTemplateDTOConvert.INSTANCE.fromUpdateRequest(genTemplateUpdateRequest);
		genTemplateDomainService.update(genTemplate);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		genTemplateDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 获取模板类型下拉菜单
	 * @return 返回通用下拉菜单
	 */
	public List<Select<String>> selectTemplateTypes() {
		List<CacheHelper.SysDictItem> list = CacheHelper.getSysDictItemListByCode(GEN_TEMPLATE_TYPE);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(m.getDictItemValue(), m.getDictItemText(), m.getSort(),
					extraMap -> extraMap.put("label", m.getDictItemText())))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

}
