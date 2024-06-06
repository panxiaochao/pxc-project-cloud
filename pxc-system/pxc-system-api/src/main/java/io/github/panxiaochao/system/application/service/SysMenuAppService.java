package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.component.tree.Tree;
import io.github.panxiaochao.core.component.tree.TreeBuilder;
import io.github.panxiaochao.core.component.tree.TreeNode;
import io.github.panxiaochao.core.component.tree.TreeNodeProperties;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuResponse;
import io.github.panxiaochao.system.application.convert.ISysMenuDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.SysMenu;
import io.github.panxiaochao.system.domain.service.SysMenuDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单配置 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysMenuAppService {

	/**
	 * 菜单配置 Domain服务类
	 */
	private final SysMenuDomainService sysMenuDomainService;

	/**
	 * 菜单配置 读模型服务
	 */
	private final ISysMenuReadModelService sysMenuReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 菜单配置查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysMenuQueryResponse> page(RequestPage pageRequest, SysMenuQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysMenuQueryResponse> list = sysMenuReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysMenuResponse> getById(String id) {
		SysMenu sysMenu = sysMenuDomainService.getById(id);
		SysMenuResponse sysMenuResponse = ISysMenuDTOConvert.INSTANCE.toResponse(sysMenu);
		return R.ok(sysMenuResponse);
	}

	/**
	 * 保存
	 * @param sysMenuCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysMenuResponse> save(SysMenuCreateRequest sysMenuCreateRequest) {
		SysMenu sysMenu = ISysMenuDTOConvert.INSTANCE.fromCreateRequest(sysMenuCreateRequest);
		// TODO 判断路由名称是否唯一

		// "0" = 一级菜单
		if ("0".equals(sysMenu.getMenuType())) {
			sysMenu.setParentId(CommonConstant.TREE_ROOT_ID.toString());
		}
		sysMenu = sysMenuDomainService.save(sysMenu);
		SysMenuResponse sysMenuResponse = ISysMenuDTOConvert.INSTANCE.toResponse(sysMenu);
		return R.ok(sysMenuResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysMenuUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysMenuUpdateRequest sysMenuUpdateRequest) {
		SysMenu sysMenu = ISysMenuDTOConvert.INSTANCE.fromUpdateRequest(sysMenuUpdateRequest);
		sysMenuDomainService.update(sysMenu);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysMenuDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 获取菜单表格树列表
	 * @param menuId 菜单ID
	 * @return 树列表
	 */
	public List<Tree<String>> tableTree(String menuId) {
		SysMenuQueryRequest queryRequest = new SysMenuQueryRequest();
		String rootId = CommonConstant.TREE_ROOT_ID.toString();
		// 有数据就说明需要查下级
		if (StringUtils.hasText(menuId)) {
			// 设置父节点为菜单ID
			queryRequest.setParentId(menuId);
			queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
			rootId = menuId;
		}
		List<SysMenuQueryResponse> list = sysMenuReadModelService.list(queryRequest);
		List<TreeNode<String>> treeNodeList = list.stream()
			.map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getMenuName(), s.getSort(), (extraMap) -> {
				extraMap.put("url", s.getUrl());
				extraMap.put("redirectUrl", s.getRedirectUrl());
				extraMap.put("component", s.getComponent());
				extraMap.put("componentName", s.getComponentName());
				extraMap.put("permissionCode", s.getPermissionCode());
				extraMap.put("icon", s.getIcon());
				extraMap.put("menuType", s.getMenuType());
				extraMap.put("openType", s.getOpenType());
				extraMap.put("keepAlive", s.getKeepAlive());
				extraMap.put("sort", s.getSort());
				extraMap.put("isHidden", s.getIsHidden());
				extraMap.put("state", s.getState());
			}))
			.collect(Collectors.toList());
		// 修改节点属性
		TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
		treeNodeProperties.labelKey("menuName");
		// 构建树
		List<Tree<String>> treeList = TreeBuilder.of(rootId, false, treeNodeProperties)
			.append(treeNodeList)
			.fastBuild()
			.toTreeList();
		return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
	}

	/**
	 * 获取菜单树列表
	 * @param menuId 菜单ID
	 * @param isOnlyMenu 是否只显示菜单，排除按钮
	 * @return 树列表
	 */
	public List<Tree<String>> listTree(String menuId, boolean isOnlyMenu) {
		SysMenuQueryRequest queryRequest = new SysMenuQueryRequest();
		String rootId = CommonConstant.TREE_ROOT_ID.toString();
		// 有数据就说明需要查下级
		if (StringUtils.hasText(menuId)) {
			// 设置父节点为菜单ID
			queryRequest.setParentId(menuId);
			queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
			rootId = menuId;
		}
		List<SysMenuQueryResponse> list = sysMenuReadModelService.list(queryRequest);
		if (isOnlyMenu) {
			// 排除是否需要按钮
			List<String> menuTypeList = Arrays.asList("0", "1");
			list = list.stream().filter(f -> menuTypeList.contains(f.getMenuType())).collect(Collectors.toList());
		}
		List<TreeNode<String>> treeNodeList = list.stream()
			.map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getMenuName(), s.getSort(),
					(extraMap) -> extraMap.put("value", s.getId())))
			.collect(Collectors.toList());
		// 修改节点属性
		TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
		treeNodeProperties.idKey("key");
		treeNodeProperties.labelKey("title");
		// 构建树
		List<Tree<String>> treeList = TreeBuilder.of(rootId, true, treeNodeProperties)
			.append(treeNodeList)
			.fastBuild()
			.toTreeList();
		return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
	}

	/**
	 * 获取所有菜单树下拉
	 * @return 集合对象数据，包含下拉菜单数据，所有菜单ID集合
	 */
	public Map<String, Object> queryAllTree() {
		SysMenuQueryRequest queryRequest = new SysMenuQueryRequest();
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		String rootId = CommonConstant.TREE_ROOT_ID.toString();
		List<SysMenuQueryResponse> list = sysMenuReadModelService.list(queryRequest);
		// 所有菜单ID结合
		List<String> ids = new ArrayList<>();
		List<TreeNode<String>> treeNodeList = list.stream().map(s -> {
			// 顺带放入，不要要再多一次循环
			ids.add(s.getId());
			return TreeNode.of(s.getId(), s.getParentId(), s.getMenuName(), s.getSort(),
					(extraMap) -> extraMap.put("value", s.getId()));
		}).collect(Collectors.toList());
		// 修改节点属性
		TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
		treeNodeProperties.idKey("key");
		treeNodeProperties.labelKey("title");
		// 构建树
		List<Tree<String>> treeList = TreeBuilder.of(rootId, true, treeNodeProperties)
			.append(treeNodeList)
			.fastBuild()
			.toTreeList();
		// 输出结果封装
		Map<String, Object> result = new HashMap<>();
		result.put("list", CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList);
		result.put("ids", ids);
		return result;
	}

}
