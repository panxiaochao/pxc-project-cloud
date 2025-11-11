package io.github.panxiaochao.system.development.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.PageRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnResponse;
import io.github.panxiaochao.system.development.application.convert.IOnlineTableColumnDTOConvert;
import io.github.panxiaochao.system.development.application.repository.IOnlineTableColumnReadModelService;
import io.github.panxiaochao.system.development.domain.entity.OnlineTableColumn;
import io.github.panxiaochao.system.development.domain.service.OnlineTableColumnDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【在线数据表字段】App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class OnlineTableColumnAppService {

	/**
	 * 在线数据表字段 Domain服务类
	 */
	private final OnlineTableColumnDomainService onlineTableColumnDomainService;

	/**
	 * 在线数据表字段 读模型服务
	 */
	private final IOnlineTableColumnReadModelService onlineTableColumnReadModelService;

	/**
	 * 查询在线数据表字段分页数据
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 在线数据表字段查询请求对象
	 * @return 分页对象
	 */
	public PageResponse<OnlineTableColumnQueryResponse> page(PageRequest pageRequest,
			OnlineTableColumnQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<OnlineTableColumnQueryResponse> list = onlineTableColumnReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 根据主键获取在线数据表字段详情
	 * @param id 主键
	 * @return 在线数据表字段响应对象
	 */
	public R<OnlineTableColumnResponse> getById(String id) {
		OnlineTableColumn onlineTableColumn = onlineTableColumnDomainService.getById(id);
		OnlineTableColumnResponse onlineTableColumnResponse = IOnlineTableColumnDTOConvert.INSTANCE
			.toResponse(onlineTableColumn);
		return R.ok(onlineTableColumnResponse);
	}

	/**
	 * 保存在线数据表字段
	 * @param onlineTableColumnCreateRequest 创建请求对象
	 * @return 在线数据表字段响应对象
	 */
	public R<OnlineTableColumnResponse> save(OnlineTableColumnCreateRequest onlineTableColumnCreateRequest) {
		OnlineTableColumn onlineTableColumn = IOnlineTableColumnDTOConvert.INSTANCE
			.fromCreateRequest(onlineTableColumnCreateRequest);
		onlineTableColumn = onlineTableColumnDomainService.save(onlineTableColumn);
		OnlineTableColumnResponse onlineTableColumnResponse = IOnlineTableColumnDTOConvert.INSTANCE
			.toResponse(onlineTableColumn);
		return R.ok(onlineTableColumnResponse);
	}

	/**
	 * 根据主键更新在线数据表字段
	 * @param onlineTableColumnUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(OnlineTableColumnUpdateRequest onlineTableColumnUpdateRequest) {
		OnlineTableColumn onlineTableColumn = IOnlineTableColumnDTOConvert.INSTANCE
			.fromUpdateRequest(onlineTableColumnUpdateRequest);
		onlineTableColumnDomainService.update(onlineTableColumn);
		return R.ok();
	}

	/**
	 * 根据主键删除在线数据表字段
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		onlineTableColumnDomainService.deleteById(id);
		return R.ok();
	}

}
