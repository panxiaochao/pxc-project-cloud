package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysDictCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysDictItemQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysDictQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysDictUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysDictQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysDictResponse;
import io.github.panxiaochao.system.application.convert.ISysDictDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysDictItemReadModelService;
import io.github.panxiaochao.system.application.repository.ISysDictReadModelService;
import io.github.panxiaochao.system.domain.entity.SysDict;
import io.github.panxiaochao.system.domain.service.SysDictDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 数据字典表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysDictAppService {

	/**
	 * 数据字典表 Domain服务类
	 */
	private final SysDictDomainService sysDictDomainService;

	/**
	 * 数据字典表 读模型服务
	 */
	private final ISysDictReadModelService sysDictReadModelService;

	/**
	 * 数据字典配置表 读模型服务
	 */
	private final ISysDictItemReadModelService sysDictItemReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 数据字典表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysDictQueryResponse> page(RequestPage pageRequest, SysDictQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysDictQueryResponse> list = sysDictReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysDictResponse> getById(String id) {
		SysDict sysDict = sysDictDomainService.getById(id);
		SysDictResponse sysDictResponse = ISysDictDTOConvert.INSTANCE.toResponse(sysDict);
		return R.ok(sysDictResponse);
	}

	/**
	 * 保存
	 * @param sysDictCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysDictResponse> save(SysDictCreateRequest sysDictCreateRequest) {
		SysDict sysDict = ISysDictDTOConvert.INSTANCE.fromCreateRequest(sysDictCreateRequest);
		sysDict = sysDictDomainService.save(sysDict);
		SysDictResponse sysDictResponse = ISysDictDTOConvert.INSTANCE.toResponse(sysDict);
		return R.ok(sysDictResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysDictUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysDictUpdateRequest sysDictUpdateRequest) {
		SysDict sysDict = ISysDictDTOConvert.INSTANCE.fromUpdateRequest(sysDictUpdateRequest);
		sysDictDomainService.update(sysDict);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		SysDictItemQueryRequest queryRequest = new SysDictItemQueryRequest();
		queryRequest.setDictId(id);
		List<SysDictItemQueryResponse> list = sysDictItemReadModelService.selectList(queryRequest);
		if (CollectionUtils.isEmpty(list)) {
			sysDictDomainService.deleteById(id);
		}
		else {
			return R.fail("存在关联数据，请删除完全！");
		}
		return R.ok();
	}

}
