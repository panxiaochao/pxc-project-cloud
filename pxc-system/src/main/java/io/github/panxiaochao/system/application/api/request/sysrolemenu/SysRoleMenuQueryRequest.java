package io.github.panxiaochao.system.application.api.request.sysrolemenu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 角色菜单表查询请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Getter
@Setter
@ToString
@Schema(description = "角色菜单表查询请求对象")
public class SysRoleMenuQueryRequest {

	/**
	 * 角色ID
	 */
	@Schema(description = "角色ID")
	private String roleId;

	/**
	 * 菜单ID
	 */
	@Schema(description = "菜单ID")
	private String menuId;

}
