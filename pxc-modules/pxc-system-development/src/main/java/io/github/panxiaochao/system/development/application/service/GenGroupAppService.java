package io.github.panxiaochao.system.development.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupUpdateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupResponse;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupQueryResponse;
import io.github.panxiaochao.system.development.application.convert.IGenGroupDTOConvert;
import io.github.panxiaochao.system.development.application.repository.IGenGroupReadModelService;
import io.github.panxiaochao.system.development.application.repository.IGenTemplateGroupReadModelService;
import io.github.panxiaochao.system.development.domain.entity.GenGroup;
import io.github.panxiaochao.system.development.domain.entity.GenTemplateGroup;
import io.github.panxiaochao.system.development.domain.service.GenGroupDomainService;
import io.github.panxiaochao.system.development.domain.service.GenTemplateGroupDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 模板分组 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Service
@RequiredArgsConstructor
public class GenGroupAppService {

	/**
	 * 模板分组 Domain服务类
	 */
	private final GenGroupDomainService genGroupDomainService;

	/**
	 * 模板分组关联表 Domain服务类
	 */
	private final GenTemplateGroupDomainService genTemplateGroupDomainService;

	/**
	 * 模板分组 读模型服务
	 */
	private final IGenGroupReadModelService genGroupReadModelService;

	/**
	 * 模板分组关联表 读模型服务
	 */
	private final IGenTemplateGroupReadModelService genTemplateGroupReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 模板分组查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<GenGroupQueryResponse> page(RequestPage pageRequest, GenGroupQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<GenGroupQueryResponse> list = genGroupReadModelService.page(pagination, queryRequest);
		// 查询模版分组下的模版类型
		// 采用下面这种方法考虑是因为 并发会不发，所以采用每条查询的方式
		list.forEach(s -> {
			GenTemplateGroupQueryRequest genTemplateGroupQueryRequest = new GenTemplateGroupQueryRequest();
			genTemplateGroupQueryRequest.setGroupId(s.getId());
			List<GenTemplateGroupQueryResponse> genTemplateGroupQueryResponseList = genTemplateGroupReadModelService
				.selectList(genTemplateGroupQueryRequest);
			if (!CollectionUtils.isEmpty(genTemplateGroupQueryResponseList)) {
				s.setTemplateIds(genTemplateGroupQueryResponseList.stream()
					.map(GenTemplateGroupQueryResponse::getTemplateId)
					.collect(Collectors.toList()));
			}
			else {
				s.setTemplateIds(new ArrayList<>());
			}
		});
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<GenGroupResponse> getById(String id) {
		GenGroup genGroup = genGroupDomainService.getById(id);
		GenGroupResponse genGroupResponse = IGenGroupDTOConvert.INSTANCE.toResponse(genGroup);
		return R.ok(genGroupResponse);
	}

	/**
	 * 保存
	 * @param genGroupCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<GenGroupResponse> save(GenGroupCreateRequest genGroupCreateRequest) {
		// 判断集合是否为空
		if (CollectionUtils.isEmpty(genGroupCreateRequest.getTemplateIds())) {
			return R.fail("模板类不能为空");
		}
		GenGroup genGroup = IGenGroupDTOConvert.INSTANCE.fromCreateRequest(genGroupCreateRequest);
		// 验证是否重复
		GenGroupQueryRequest queryRequest = new GenGroupQueryRequest();
		queryRequest.setGroupName(genGroup.getGroupName());
		GenGroupQueryResponse one = genGroupReadModelService.getOne(queryRequest);
		if (Objects.nonNull(one)) {
			return R.fail("模版分组[" + one.getGroupName() + "]已存在");
		}
		genGroup = genGroupDomainService.save(genGroup);
		// 批量存储模板分组关联表
		final String groupId = genGroup.getId();
		List<GenTemplateGroup> genTemplateGroupList = genGroupCreateRequest.getTemplateIds()
			.stream()
			.map(templateId -> new GenTemplateGroup(groupId, templateId))
			.collect(Collectors.toList());
		genTemplateGroupDomainService.saveBatch(genTemplateGroupList);
		// 返回模版分组
		GenGroupResponse genGroupResponse = IGenGroupDTOConvert.INSTANCE.toResponse(genGroup);
		return R.ok(genGroupResponse);
	}

	/**
	 * 根据主键更新
	 * @param genGroupUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(GenGroupUpdateRequest genGroupUpdateRequest) {
		// 判断集合是否为空
		if (CollectionUtils.isEmpty(genGroupUpdateRequest.getTemplateIds())) {
			return R.fail("模板类不能为空");
		}
		GenGroup genGroup = IGenGroupDTOConvert.INSTANCE.fromUpdateRequest(genGroupUpdateRequest);
		genGroupDomainService.update(genGroup);
		final String groupId = genGroup.getId();
		List<GenTemplateGroup> genTemplateGroupList = genGroupUpdateRequest.getTemplateIds()
			.stream()
			.map(templateId -> new GenTemplateGroup(groupId, templateId))
			.collect(Collectors.toList());
		// 先删除当前分组关联下的模版类型
		genTemplateGroupDomainService.deleteByGroupId(groupId);
		// 批量存储模板分组关联表
		genTemplateGroupDomainService.saveBatch(genTemplateGroupList);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		genGroupDomainService.deleteById(id);
		// 删除当前分组关联下的模版类型
		genTemplateGroupDomainService.deleteByGroupId(id);
		return R.ok();
	}

}
