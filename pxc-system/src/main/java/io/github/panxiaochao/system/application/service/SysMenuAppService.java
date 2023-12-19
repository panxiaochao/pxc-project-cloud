package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.enums.CommonConstants;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.tree.Tree;
import io.github.panxiaochao.core.utils.tree.TreeBuilder;
import io.github.panxiaochao.core.utils.tree.TreeNode;
import io.github.panxiaochao.core.utils.tree.TreeNodeProperties;
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
import java.util.List;
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
			sysMenu.setParentId(CommonConstants.TREE_ROOT_ID.toString());
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
		String rootId = CommonConstants.TREE_ROOT_ID.toString();
		// 有数据就说明需要查下级
		if (StringUtils.hasText(menuId)) {
			// 设置父节点为菜单ID
			queryRequest.setParentId(menuId);
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
				extraMap.put("permissionStatus", s.getPermissionStatus());
				extraMap.put("icon", s.getIcon());
				extraMap.put("menuType", s.getMenuType());
				extraMap.put("openType", s.getOpenType());
				extraMap.put("isRoute", s.getIsRoute());
				extraMap.put("keepAlive", s.getKeepAlive());
				extraMap.put("remark", s.getRemark());
				extraMap.put("state", s.getState());
				extraMap.put("sort", s.getSort());
				// 按钮状态和菜单显示合为一个状态，共用
				if (StringUtils.hasText(s.getPermissionStatus())) {
					// 是个反向操作显示
					extraMap.put("isHidden",
							s.getPermissionStatus().equals(CommonConstants.STATUS_NORMAL.toString()) ? "0" : "1");
				}
				else {
					extraMap.put("isHidden", s.getIsHidden());
				}
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
		String rootId = CommonConstants.TREE_ROOT_ID.toString();
		// 有数据就说明需要查下级
		if (StringUtils.hasText(menuId)) {
			// 设置父节点为菜单ID
			queryRequest.setParentId(menuId);
			rootId = menuId;
		}
		List<SysMenuQueryResponse> list = sysMenuReadModelService.list(queryRequest);
		// 排除是否需要按钮
		List<String> menuTypeList = Arrays.asList("0", "1");
		if (isOnlyMenu) {
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

}
