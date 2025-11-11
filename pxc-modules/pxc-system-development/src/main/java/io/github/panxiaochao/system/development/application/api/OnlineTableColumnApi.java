package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.PageRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnResponse;
import io.github.panxiaochao.system.development.application.service.OnlineTableColumnAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 【在线数据表字段】接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Tag(name = "在线数据表字段 接口", description = "在线数据表字段 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/online-table-column")
public class OnlineTableColumnApi {

	/**
	 * 在线数据表字段 服务
	 */
	private final OnlineTableColumnAppService onlineTableColumnAppService;

	/**
	 * 查询在线数据表字段分页数据
	 * @param pageRequest 分页请求参数
	 * @param queryRequest 在线数据表字段查询请求参数
	 * @return 封装分页查询结果统一响应对象
	 */
	@Operation(summary = "查询分页", description = "查询分页在线数据表字段列表", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<OnlineTableColumnQueryResponse>> page(PageRequest pageRequest,
			OnlineTableColumnQueryRequest queryRequest) {
		return R.ok(onlineTableColumnAppService.page(pageRequest, queryRequest));
	}

	/**
	 * 根据主键获取在线数据表字段详情
	 * @param id 在线数据表字段 主键
	 * @return 在线数据表字段响应对象
	 */
	@Operation(summary = "获取详情", description = "根据主键获取在线数据表字段详情", method = "GET")
	@Parameter(name = "id", description = "在线数据表字段 主键")
	@GetMapping(value = "/{id}")
	public R<OnlineTableColumnResponse> getById(@PathVariable("id") String id) {
		return onlineTableColumnAppService.getById(id);
	}

	/**
	 * 保存在线数据表字段对象
	 * @param createRequest 在线数据表字段请求参数
	 * @return 在线数据表字段响应对象
	 */
	@Operation(summary = "保存", description = "保存在线数据表字段", method = "POST")
	@PostMapping
	public R<OnlineTableColumnResponse> save(@RequestBody OnlineTableColumnCreateRequest createRequest) {
		return onlineTableColumnAppService.save(createRequest);
	}

	/**
	 * 根据主键更新在线数据表字段
	 * @param updateRequest 在线数据表字段请求参数
	 * @return 空返回
	 */
	@Operation(summary = "更新", description = "根据主键更新在线数据表字段", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody OnlineTableColumnUpdateRequest updateRequest) {
		return onlineTableColumnAppService.update(updateRequest);
	}

	/**
	 * 根据主键删除在线数据表字段
	 * @param id 在线数据表字段 主键
	 * @return 空返回
	 */
	@Operation(summary = "删除", description = "根据主键删除在线数据表字段", method = "DELETE")
	@Parameter(name = "id", description = "在线数据表字段 主键")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return onlineTableColumnAppService.deleteById(id);
	}

}
