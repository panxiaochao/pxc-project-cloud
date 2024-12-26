package io.github.panxiaochao.code.generator.application.service;

import io.github.panxiaochao.code.generator.application.api.request.gentable.GenTableCreateRequest;
import io.github.panxiaochao.code.generator.application.api.request.gentable.GenTableQueryRequest;
import io.github.panxiaochao.code.generator.application.api.request.gentable.GenTableUpdateRequest;
import io.github.panxiaochao.code.generator.application.api.response.gentable.GenTableQueryResponse;
import io.github.panxiaochao.code.generator.application.api.response.gentable.GenTableResponse;
import io.github.panxiaochao.code.generator.application.convert.IGenTableDTOConvert;
import io.github.panxiaochao.code.generator.application.repository.IGenTableReadModelService;
import io.github.panxiaochao.code.generator.domain.entity.GenTable;
import io.github.panxiaochao.code.generator.domain.service.GenTableDomainService;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 代码生成表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Service
@RequiredArgsConstructor
public class GenTableAppService {

	/**
	 * 代码生成表 Domain服务类
	 */
	private final GenTableDomainService genTableDomainService;

	/**
	 * 代码生成表 读模型服务
	 */
	private final IGenTableReadModelService genTableReadModelService;

	/**
	 * 查询分页
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<GenTableQueryResponse> page(RequestPage requestPage, GenTableQueryRequest queryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<GenTableQueryResponse> list = genTableReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}


	public Object queryDsTablePage(RequestPage requestPage) {
		// DbMetaUtil.getTableMeta()
		return null;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<GenTableResponse> getById(String id) {
		GenTable genTable = genTableDomainService.getById(id);
		GenTableResponse genTableResponse = IGenTableDTOConvert.INSTANCE.toResponse(genTable);
		return R.ok(genTableResponse);
	}

	/**
	 * 保存
	 * @param genTableCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<GenTableResponse> save(GenTableCreateRequest genTableCreateRequest) {
		GenTable genTable = IGenTableDTOConvert.INSTANCE.fromCreateRequest(genTableCreateRequest);
		genTable = genTableDomainService.save(genTable);
		GenTableResponse genTableResponse = IGenTableDTOConvert.INSTANCE.toResponse(genTable);
		return R.ok(genTableResponse);
	}

	/**
	 * 根据主键更新
	 * @param genTableUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(GenTableUpdateRequest genTableUpdateRequest) {
		GenTable genTable = IGenTableDTOConvert.INSTANCE.fromUpdateRequest(genTableUpdateRequest);
		genTableDomainService.update(genTable);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		genTableDomainService.deleteById(id);
		return R.ok();
	}


}
