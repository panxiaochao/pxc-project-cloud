package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysRole;
import io.github.panxiaochao.system.domain.repository.ISysRoleService;
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
	 * 角色表 Domain接口服务类.
	 */
	private final ISysRoleService sysRoleService;

	/**
	 * 获取角色数据权限
	 * @param userId 用户id
	 * @return 角色权限信息
	 */
	public Set<String> selectRolePermission(String userId) {
		List<SysRole> sysRoleList = sysRoleService.selectRolesByUserId(userId);
		Set<String> roleCodeSet = new HashSet<>();
		if (!CollectionUtils.isEmpty(sysRoleList)) {
			roleCodeSet.addAll(sysRoleList.stream().map(SysRole::getRoleCode).collect(Collectors.toList()));
		}
		return roleCodeSet;
	}

	/**
	 * 获取菜单数据权限
	 * @param userId 用户id
	 * @return 菜单权限信息
	 */
	public Set<String> selectMenuPermissionCode(String userId) {

		return null;
	}

}
