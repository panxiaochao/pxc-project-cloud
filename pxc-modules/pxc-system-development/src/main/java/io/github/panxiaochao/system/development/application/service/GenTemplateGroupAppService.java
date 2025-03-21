package io.github.panxiaochao.system.development.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupResponse;
import io.github.panxiaochao.system.development.application.convert.IGenTemplateGroupDTOConvert;
import io.github.panxiaochao.system.development.application.repository.IGenTemplateGroupReadModelService;
import io.github.panxiaochao.system.development.domain.entity.GenTemplateGroup;
import io.github.panxiaochao.system.development.domain.service.GenTemplateGroupDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 模板分组关联表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Service
@RequiredArgsConstructor
public class GenTemplateGroupAppService {

	/**
	 * 模板分组关联表 Domain服务类
	 */
	private final GenTemplateGroupDomainService genTemplateGroupDomainService;

	/**
	 * 模板分组关联表 读模型服务
	 */
	private final IGenTemplateGroupReadModelService genTemplateGroupReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 模板分组关联表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<GenTemplateGroupQueryResponse> page(RequestPage pageRequest,
			GenTemplateGroupQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<GenTemplateGroupQueryResponse> list = genTemplateGroupReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<GenTemplateGroupResponse> getById(String id) {
		GenTemplateGroup genTemplateGroup = genTemplateGroupDomainService.getById(id);
		GenTemplateGroupResponse genTemplateGroupResponse = IGenTemplateGroupDTOConvert.INSTANCE
			.toResponse(genTemplateGroup);
		return R.ok(genTemplateGroupResponse);
	}

	/**
	 * 保存
	 * @param genTemplateGroupCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<GenTemplateGroupResponse> save(GenTemplateGroupCreateRequest genTemplateGroupCreateRequest) {
		GenTemplateGroup genTemplateGroup = IGenTemplateGroupDTOConvert.INSTANCE
			.fromCreateRequest(genTemplateGroupCreateRequest);
		genTemplateGroup = genTemplateGroupDomainService.save(genTemplateGroup);
		GenTemplateGroupResponse genTemplateGroupResponse = IGenTemplateGroupDTOConvert.INSTANCE
			.toResponse(genTemplateGroup);
		return R.ok(genTemplateGroupResponse);
	}

	/**
	 * 根据主键更新
	 * @param genTemplateGroupUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(GenTemplateGroupUpdateRequest genTemplateGroupUpdateRequest) {
		GenTemplateGroup genTemplateGroup = IGenTemplateGroupDTOConvert.INSTANCE
			.fromUpdateRequest(genTemplateGroupUpdateRequest);
		genTemplateGroupDomainService.update(genTemplateGroup);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		genTemplateGroupDomainService.deleteById(id);
		return R.ok();
	}

}
