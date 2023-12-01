package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.FileAccessoryCreateRequest;
import io.github.panxiaochao.system.application.api.request.FileAccessoryQueryRequest;
import io.github.panxiaochao.system.application.api.request.FileAccessoryUpdateRequest;
import io.github.panxiaochao.system.application.api.response.FileAccessoryQueryResponse;
import io.github.panxiaochao.system.application.api.response.FileAccessoryResponse;
import io.github.panxiaochao.system.application.convert.IFileAccessoryDTOConvert;
import io.github.panxiaochao.system.application.repository.IFileAccessoryReadModelService;
import io.github.panxiaochao.system.domain.entity.FileAccessory;
import io.github.panxiaochao.system.domain.service.FileAccessoryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 附件表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class FileAccessoryAppService {

	/**
	 * 附件表 Domain服务类
	 */
	private final FileAccessoryDomainService fileAccessoryDomainService;

	/**
	 * 附件表 读模型服务
	 */
	private final IFileAccessoryReadModelService fileAccessoryReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<FileAccessoryQueryResponse> page(RequestPage<FileAccessoryQueryRequest> pageRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<FileAccessoryQueryResponse> list = fileAccessoryReadModelService.page(pagination, pageRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<FileAccessoryResponse> getById(String id) {
		FileAccessory fileAccessory = fileAccessoryDomainService.getById(id);
		FileAccessoryResponse fileAccessoryResponse = IFileAccessoryDTOConvert.INSTANCE.toResponse(fileAccessory);
		return R.ok(fileAccessoryResponse);
	}

	/**
	 * 保存
	 * @param fileAccessoryCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<FileAccessoryResponse> save(FileAccessoryCreateRequest fileAccessoryCreateRequest) {
		FileAccessory fileAccessory = IFileAccessoryDTOConvert.INSTANCE.fromCreateRequest(fileAccessoryCreateRequest);
		fileAccessory = fileAccessoryDomainService.save(fileAccessory);
		FileAccessoryResponse fileAccessoryResponse = IFileAccessoryDTOConvert.INSTANCE.toResponse(fileAccessory);
		return R.ok(fileAccessoryResponse);
	}

	/**
	 * 根据主键更新
	 * @param fileAccessoryUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(FileAccessoryUpdateRequest fileAccessoryUpdateRequest) {
		FileAccessory fileAccessory = IFileAccessoryDTOConvert.INSTANCE.fromUpdateRequest(fileAccessoryUpdateRequest);
		fileAccessoryDomainService.update(fileAccessory);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		fileAccessoryDomainService.deleteById(id);
		return R.ok();
	}

}
