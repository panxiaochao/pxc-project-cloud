package io.github.panxiaochao.system.development.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagResponse;
import io.github.panxiaochao.system.development.application.convert.IDatabaseFieldTagDTOConvert;
import io.github.panxiaochao.system.development.application.repository.IDatabaseFieldTagReadModelService;
import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldTag;
import io.github.panxiaochao.system.development.domain.service.DatabaseFieldTagDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class DatabaseFieldTagAppService {

	/**
	 * 数据库字段类型-数据库标签表 Domain服务类
	 */
	private final DatabaseFieldTagDomainService databaseFieldTagDomainService;

	/**
	 * 数据库字段类型-数据库标签表 读模型服务
	 */
	private final IDatabaseFieldTagReadModelService databaseFieldTagReadModelService;

	/**
	 * 查询数据库字段类型-数据库标签表分页数据
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 数据库字段类型-数据库标签表查询请求对象
	 * @return 分页对象
	 */
	public PageResponse<DatabaseFieldTagQueryResponse> page(RequestPage pageRequest,
			DatabaseFieldTagQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<DatabaseFieldTagQueryResponse> list = databaseFieldTagReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 根据主键获取数据库字段类型-数据库标签表详情
	 * @param id 主键
	 * @return 数据库字段类型-数据库标签表响应对象
	 */
	public R<DatabaseFieldTagResponse> getById(String id) {
		DatabaseFieldTag databaseFieldTag = databaseFieldTagDomainService.getById(id);
		DatabaseFieldTagResponse databaseFieldTagResponse = IDatabaseFieldTagDTOConvert.INSTANCE
			.toResponse(databaseFieldTag);
		return R.ok(databaseFieldTagResponse);
	}

	/**
	 * 保存数据库字段类型-数据库标签表
	 * @param databaseFieldTagCreateRequest 创建请求对象
	 * @return 数据库字段类型-数据库标签表响应对象
	 */
	public R<DatabaseFieldTagResponse> save(DatabaseFieldTagCreateRequest databaseFieldTagCreateRequest) {
		DatabaseFieldTag databaseFieldTag = IDatabaseFieldTagDTOConvert.INSTANCE
			.fromCreateRequest(databaseFieldTagCreateRequest);
		databaseFieldTag = databaseFieldTagDomainService.save(databaseFieldTag);
		DatabaseFieldTagResponse databaseFieldTagResponse = IDatabaseFieldTagDTOConvert.INSTANCE
			.toResponse(databaseFieldTag);
		return R.ok(databaseFieldTagResponse);
	}

	/**
	 * 根据主键更新数据库字段类型-数据库标签表
	 * @param databaseFieldTagUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(DatabaseFieldTagUpdateRequest databaseFieldTagUpdateRequest) {
		DatabaseFieldTag databaseFieldTag = IDatabaseFieldTagDTOConvert.INSTANCE
			.fromUpdateRequest(databaseFieldTagUpdateRequest);
		databaseFieldTagDomainService.update(databaseFieldTag);
		return R.ok();
	}

	/**
	 * 根据主键删除数据库字段类型-数据库标签表
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		databaseFieldTagDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 根据数据库字段类型码表ID获取列表
	 * @param fieldId 数据库字段类型码表ID
	 * @return 数据库字段类型-数据库标签表响应对象列表
	 */
    public R<List<DatabaseFieldTagQueryResponse>> getListByFieldId(String fieldId) {
		DatabaseFieldTagQueryRequest queryRequest = new DatabaseFieldTagQueryRequest();
		queryRequest.setFieldTypeId(Integer.valueOf(fieldId));
		List<DatabaseFieldTagQueryResponse> list = databaseFieldTagReadModelService.selectList(queryRequest);
		return R.ok(list);
    }
}
