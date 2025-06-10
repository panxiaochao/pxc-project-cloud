package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.component.select.Select;
import io.github.panxiaochao.component.select.SelectBuilder;
import io.github.panxiaochao.component.select.SelectOption;
import io.github.panxiaochao.component.tree.Tree;
import io.github.panxiaochao.component.tree.TreeBuilder;
import io.github.panxiaochao.component.tree.TreeNode;
import io.github.panxiaochao.component.tree.TreeNodeProperties;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysorg.SysOrgCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysorg.SysOrgQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysorg.SysOrgUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysorg.SysOrgQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysorg.SysOrgResponse;
import io.github.panxiaochao.system.application.convert.ISysOrgDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysOrgReadModelService;
import io.github.panxiaochao.system.common.cache.CacheHelper;
import io.github.panxiaochao.system.domain.entity.SysOrg;
import io.github.panxiaochao.system.domain.service.SysOrgDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 机构部门表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysOrgAppService {

	/**
	 * 机构部门表 Domain服务类
	 */
	private final SysOrgDomainService sysOrgDomainService;

	/**
	 * 机构部门表 读模型服务
	 */
	private final ISysOrgReadModelService sysOrgReadModelService;

	/**
	 * 机构类别 常量名
	 */
	private static final String ORG_CATEGORY = "ORG_CATEGORY";

	/**
	 * 查询分页
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 机构部门表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysOrgQueryResponse> page(RequestPage requestPage, SysOrgQueryRequest queryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<SysOrgQueryResponse> list = sysOrgReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysOrgResponse> getById(String id) {
		SysOrg sysOrg = sysOrgDomainService.getById(id);
		SysOrgResponse sysOrgResponse = ISysOrgDTOConvert.INSTANCE.toResponse(sysOrg);
		return R.ok(sysOrgResponse);
	}

	/**
	 * 保存
	 * @param sysOrgCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysOrgResponse> save(SysOrgCreateRequest sysOrgCreateRequest) {
		SysOrg sysOrg = ISysOrgDTOConvert.INSTANCE.fromCreateRequest(sysOrgCreateRequest);
		sysOrg = sysOrgDomainService.save(sysOrg);
		SysOrgResponse sysOrgResponse = ISysOrgDTOConvert.INSTANCE.toResponse(sysOrg);
		return R.ok(sysOrgResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysOrgUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysOrgUpdateRequest sysOrgUpdateRequest) {
		SysOrg sysOrg = ISysOrgDTOConvert.INSTANCE.fromUpdateRequest(sysOrgUpdateRequest);
		sysOrgDomainService.update(sysOrg);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		SysOrgQueryRequest queryRequest = new SysOrgQueryRequest();
		queryRequest.setParentId(id);
		List<SysOrgQueryResponse> list = sysOrgReadModelService.list(queryRequest);
		if (CollectionUtils.isEmpty(list)) {
			sysOrgDomainService.deleteById(id);
		}
		else {
			return R.fail("存在关联数据，请删除完全！");
		}
		return R.ok();
	}

	/**
	 * 组织树列表
	 * @param rootId 根节点
	 * @return 树列表
	 */
	public List<Tree<String>> listTree(String rootId) {
		SysOrgQueryRequest queryRequest = new SysOrgQueryRequest();
		if (StringUtils.hasText(rootId)) {
			queryRequest.setParentId(rootId);
		}
		else {
			rootId = CommonConstant.TREE_ROOT_ID.toString();
		}
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		List<TreeNode<String>> treeNodeList = sysOrgReadModelService.list(queryRequest)
			.stream()
			.map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getOrgName(), s.getSort(),
					(extraMap) -> extraMap.put("value", s.getId())))
			.collect(Collectors.toList());
		// 修改节点属性
		TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
		treeNodeProperties.labelKey("title");
		treeNodeProperties.idKey("key");
		// 构建树
		List<Tree<String>> treeList = TreeBuilder.of(rootId, true, treeNodeProperties)
			.append(treeNodeList)
			.fastBuild()
			.toTreeList();
		return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
	}

	/**
	 * 获取机构表格树列表
	 * @param orgId 菜单ID
	 * @return 树列表
	 */
	public List<Tree<String>> tableTree(String orgId) {
		SysOrgQueryRequest queryRequest = new SysOrgQueryRequest();
		String rootId = CommonConstant.TREE_ROOT_ID.toString();
		// 有数据就说明需要查下级
		if (StringUtils.hasText(orgId)) {
			// 设置父节点为菜单ID
			queryRequest.setParentId(orgId);
			queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
			rootId = orgId;
		}
		List<SysOrgQueryResponse> list = sysOrgReadModelService.list(queryRequest);
		List<TreeNode<String>> treeNodeList = list.stream()
			.map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getOrgName(), s.getSort(), (extraMap) -> {
				extraMap.put("areaId", s.getAreaId());
				extraMap.put("areaCode", s.getAreaCode());
				extraMap.put("orgNameEn", s.getOrgNameEn());
				extraMap.put("orgNameAbbr", s.getOrgNameAbbr());
				extraMap.put("orgCode", s.getOrgCode());
				extraMap.put("sort", s.getSort());
				extraMap.put("orgCategory", s.getOrgCategory());
				extraMap.put("orgCategoryStr",
						s.getOrgCategory() != null
								? CacheHelper.getSysDictItemByValue(ORG_CATEGORY, String.valueOf(s.getOrgCategory()))
									.getDictItemText()
								: "");
				extraMap.put("mobile", s.getMobile());
				extraMap.put("fax", s.getSort());
				extraMap.put("address", s.getAddress());
				extraMap.put("state", s.getState());
				extraMap.put("remark", s.getState());
			}))
			.collect(Collectors.toList());
		// 修改节点属性
		TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
		treeNodeProperties.labelKey("orgName");
		// 构建树
		List<Tree<String>> treeList = TreeBuilder.of(rootId, false, treeNodeProperties)
			.append(treeNodeList)
			.fastBuild()
			.toTreeList();
		return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
	}

	/**
	 * 获取机构类别下拉
	 */
	public List<Select<Integer>> selectOrgCategoryList() {
		List<CacheHelper.SysDictItem> list = CacheHelper.getSysDictItemListByCode(ORG_CATEGORY);
		List<SelectOption<Integer>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(Integer.valueOf(m.getDictItemValue()), m.getDictItemText(), m.getSort(),
					(extraMap) -> extraMap.put("label", m.getDictItemText())))
			.collect(Collectors.toList());
		List<Select<Integer>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

}
