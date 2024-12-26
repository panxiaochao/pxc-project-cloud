package io.github.panxiaochao.code.generator.application.service;

import io.github.panxiaochao.code.generator.application.api.request.gentablecolumn.GenTableColumnCreateRequest;
import io.github.panxiaochao.code.generator.application.api.request.gentablecolumn.GenTableColumnQueryRequest;
import io.github.panxiaochao.code.generator.application.api.request.gentablecolumn.GenTableColumnUpdateRequest;
import io.github.panxiaochao.code.generator.application.api.response.gentablecolumn.GenTableColumnQueryResponse;
import io.github.panxiaochao.code.generator.application.api.response.gentablecolumn.GenTableColumnResponse;
import io.github.panxiaochao.code.generator.application.convert.IGenTableColumnDTOConvert;
import io.github.panxiaochao.code.generator.application.repository.IGenTableColumnReadModelService;
import io.github.panxiaochao.code.generator.domain.entity.GenTableColumn;
import io.github.panxiaochao.code.generator.domain.service.GenTableColumnDomainService;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 代码生成表字段 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Service
@RequiredArgsConstructor
public class GenTableColumnAppService {

	/**
	 * 代码生成表字段 Domain服务类
	 */
	private final GenTableColumnDomainService genTableColumnDomainService;

	/**
	 * 代码生成表字段 读模型服务
	 */
	private final IGenTableColumnReadModelService genTableColumnReadModelService;

	/**
	 * 查询分页
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 代码生成表字段查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<GenTableColumnQueryResponse> page(RequestPage requestPage,
			GenTableColumnQueryRequest queryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<GenTableColumnQueryResponse> list = genTableColumnReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<GenTableColumnResponse> getById(String id) {
		GenTableColumn genTableColumn = genTableColumnDomainService.getById(id);
		GenTableColumnResponse genTableColumnResponse = IGenTableColumnDTOConvert.INSTANCE.toResponse(genTableColumn);
		return R.ok(genTableColumnResponse);
	}

	/**
	 * 保存
	 * @param genTableColumnCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<GenTableColumnResponse> save(GenTableColumnCreateRequest genTableColumnCreateRequest) {
		GenTableColumn genTableColumn = IGenTableColumnDTOConvert.INSTANCE
			.fromCreateRequest(genTableColumnCreateRequest);
		genTableColumn = genTableColumnDomainService.save(genTableColumn);
		GenTableColumnResponse genTableColumnResponse = IGenTableColumnDTOConvert.INSTANCE.toResponse(genTableColumn);
		return R.ok(genTableColumnResponse);
	}

	/**
	 * 根据主键更新
	 * @param genTableColumnUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(GenTableColumnUpdateRequest genTableColumnUpdateRequest) {
		GenTableColumn genTableColumn = IGenTableColumnDTOConvert.INSTANCE
			.fromUpdateRequest(genTableColumnUpdateRequest);
		genTableColumnDomainService.update(genTableColumn);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		genTableColumnDomainService.deleteById(id);
		return R.ok();
	}

}
