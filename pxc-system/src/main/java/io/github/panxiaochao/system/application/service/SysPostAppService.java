package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.component.select.SelectBuilder;
import io.github.panxiaochao.core.component.select.SelectOption;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.syspost.SysPostCreateRequest;
import io.github.panxiaochao.system.application.api.request.syspost.SysPostQueryRequest;
import io.github.panxiaochao.system.application.api.request.syspost.SysPostUpdateRequest;
import io.github.panxiaochao.system.application.api.response.syspost.SysPostQueryResponse;
import io.github.panxiaochao.system.application.api.response.syspost.SysPostResponse;
import io.github.panxiaochao.system.application.convert.ISysPostDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysPostReadModelService;
import io.github.panxiaochao.system.domain.entity.SysPost;
import io.github.panxiaochao.system.domain.service.SysPostDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 岗位表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysPostAppService {

	/**
	 * 岗位表 Domain服务类
	 */
	private final SysPostDomainService sysPostDomainService;

	/**
	 * 岗位表 读模型服务
	 */
	private final ISysPostReadModelService sysPostReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 岗位表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysPostQueryResponse> page(RequestPage pageRequest, SysPostQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysPostQueryResponse> list = sysPostReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysPostResponse> getById(String id) {
		SysPost sysPost = sysPostDomainService.getById(id);
		SysPostResponse sysPostResponse = ISysPostDTOConvert.INSTANCE.toResponse(sysPost);
		return R.ok(sysPostResponse);
	}

	/**
	 * 保存
	 * @param sysPostCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysPostResponse> save(SysPostCreateRequest sysPostCreateRequest) {
		SysPost sysPost = ISysPostDTOConvert.INSTANCE.fromCreateRequest(sysPostCreateRequest);
		// 验证是否重复
		SysPostQueryRequest queryRequest = new SysPostQueryRequest();
		queryRequest.setPostCode(sysPost.getPostCode());
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		SysPostQueryResponse one = sysPostReadModelService.getOne(queryRequest);
		if (Objects.nonNull(one)) {
			return R.fail("岗位编码[" + sysPost.getPostCode() + "]已存在");
		}
		sysPost = sysPostDomainService.save(sysPost);
		SysPostResponse sysPostResponse = ISysPostDTOConvert.INSTANCE.toResponse(sysPost);
		return R.ok(sysPostResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysPostUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysPostUpdateRequest sysPostUpdateRequest) {
		SysPost sysPost = ISysPostDTOConvert.INSTANCE.fromUpdateRequest(sysPostUpdateRequest);
		// 验证是否重复
		SysPostQueryRequest queryRequest = new SysPostQueryRequest();
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		List<SysPostQueryResponse> list = sysPostReadModelService.list(queryRequest);
		Optional<SysPostQueryResponse> optionalSysPostQueryResponse = list.stream()
			.filter(f -> f.getId().equals(sysPost.getId()) && f.getPostCode().equals(sysPost.getPostCode()))
			.findFirst();
		// 没有数据，说明岗位编码变动了，需要判断岗位编码是否有重复
		if (!optionalSysPostQueryResponse.isPresent()) {
			optionalSysPostQueryResponse = list.stream()
				.filter(f -> !f.getId().equals(sysPost.getId()) && f.getPostCode().equals(sysPost.getPostCode()))
				.findFirst();
			// 有数据，说明重复
			if (optionalSysPostQueryResponse.isPresent()) {
				return R.fail("岗位编码[" + sysPost.getPostCode() + "]已存在");
			}
		}
		sysPostDomainService.update(sysPost);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysPostDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 获取岗位下拉菜单
	 * @return 返回通用下拉菜单
	 */
	public List<Select<String>> selectPosts() {
		List<SysPostQueryResponse> list = sysPostReadModelService.list(new SysPostQueryRequest());
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(m.getPostCode(), m.getPostName(), m.getSort()))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

}
