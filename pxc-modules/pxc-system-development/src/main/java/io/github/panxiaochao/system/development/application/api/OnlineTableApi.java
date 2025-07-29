package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableAndColumnsRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.onlinetable.OnlineTableQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.onlinetable.OnlineTableResponse;
import io.github.panxiaochao.system.development.application.service.OnlineTableAppService;
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
 * 【在线数据表】接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Tag(name = "在线数据表 接口", description = "在线数据表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/online-table")
public class OnlineTableApi {

	/**
	 * 在线数据表 服务
	 */
	private final OnlineTableAppService onlineTableAppService;

	/**
	 * 查询在线数据表分页数据
	 * @param requestPage 分页请求参数
	 * @param queryRequest 在线数据表查询请求参数
	 * @return 封装分页查询结果统一响应对象
	 */
	@Operation(summary = "查询分页", description = "查询分页在线数据表列表", method = "GET")
	@GetMapping(value = "/page")
	public R<PageResponse<OnlineTableQueryResponse>> page(RequestPage requestPage,
			OnlineTableQueryRequest queryRequest) {
		return R.ok(onlineTableAppService.page(requestPage, queryRequest));
	}

	/**
	 * 根据主键获取在线数据表详情
	 * @param id 在线数据表 主键
	 * @return 在线数据表响应对象
	 */
	@Operation(summary = "获取详情", description = "根据主键获取在线数据表详情", method = "GET")
	@Parameter(name = "id", description = "在线数据表 主键")
	@GetMapping(value = "/{id}")
	public R<OnlineTableResponse> getById(@PathVariable("id") String id) {
		return onlineTableAppService.getById(id);
	}

	/**
	 * 保存在线数据表对象
	 * @param createRequest 在线数据表请求参数
	 * @return 在线数据表响应对象
	 */
	@Operation(summary = "保存", description = "保存在线数据表", method = "POST")
	@PostMapping
	public R<OnlineTableResponse> save(@RequestBody OnlineTableCreateRequest createRequest) {
		return onlineTableAppService.save(createRequest);
	}

	/**
	 * 根据主键更新在线数据表
	 * @param updateRequest 在线数据表请求参数
	 * @return 空返回
	 */
	@Operation(summary = "更新", description = "根据主键更新在线数据表", method = "PUT")
	@PutMapping
	public R<Void> update(@RequestBody OnlineTableUpdateRequest updateRequest) {
		return onlineTableAppService.update(updateRequest);
	}

	/**
	 * 根据主键删除在线数据表
	 * @param id 在线数据表 主键
	 * @return 空返回
	 */
	@Operation(summary = "删除", description = "根据主键删除在线数据表", method = "DELETE")
	@Parameter(name = "id", description = "在线数据表 主键")
	@DeleteMapping(value = "/{id}")
	public R<Void> deleteById(@PathVariable("id") String id) {
		return onlineTableAppService.deleteById(id);
	}

	/**
	 * 保存在线数据表和字段数组对象
	 * @param createRequest 在线数据表和字段数组 请求参数
	 * @return 在线数据表响应对象
	 */
	@Operation(summary = "保存在线数据表和字段数组对象", description = "保存在线数据表和字段数组对象", method = "POST")
	@PostMapping("/saveTableAndColumns")
	public R<OnlineTableResponse> saveTableAndColumns(@RequestBody OnlineTableAndColumnsRequest createRequest) {
		return onlineTableAppService.saveTableAndColumns(createRequest);
	}

}
