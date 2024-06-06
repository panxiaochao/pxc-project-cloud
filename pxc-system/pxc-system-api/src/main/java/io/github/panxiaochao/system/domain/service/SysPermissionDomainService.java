package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysrole.SysRoleQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysMenuReadModelService;
import io.github.panxiaochao.system.application.repository.ISysRoleReadModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户权限聚合 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-28
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class SysPermissionDomainService {

	/**
	 * 角色表 读模型服务.
	 */
	private final ISysRoleReadModelService sysRoleReadModelService;

	/**
	 * 菜单配置 读模型服务.
	 */
	private final ISysMenuReadModelService sysMenuReadModelService;

	/**
	 * 根据用户ID获取角色数据权限
	 * @param userId 用户id
	 * @return 角色权限信息
	 */
	public Set<String> selectRolePermission(String userId) {
		List<SysRoleQueryResponse> list = sysRoleReadModelService.selectRolesByUserId(userId);
		Set<String> roleCodeSet = new HashSet<>();
		if (!CollectionUtils.isEmpty(list)) {
			roleCodeSet.addAll(list.stream().map(SysRoleQueryResponse::getRoleCode).collect(Collectors.toList()));
		}
		return roleCodeSet;
	}

	/**
	 * 根据用户ID获取菜单数据权限
	 * @param userId 用户id
	 * @return 菜单权限信息
	 */
	public Set<String> selectMenuPermissionCode(String userId) {
		List<String> list = sysMenuReadModelService.selectMenuPermissionCodeByUserId(userId);
		Set<String> menuCodeSet = new HashSet<>();
		if (!CollectionUtils.isEmpty(list)) {
			menuCodeSet.addAll(list);
		}
		return menuCodeSet;
	}

	/**
	 * 根据用户ID查询菜单列表（用户权限下的菜单）
	 * @param userId 用户id
	 * @return 菜单列表
	 */
	public List<SysMenuQueryResponse> selectMenu(String userId) {
		return sysMenuReadModelService.selectMenuByUserId(userId);
	}

}
