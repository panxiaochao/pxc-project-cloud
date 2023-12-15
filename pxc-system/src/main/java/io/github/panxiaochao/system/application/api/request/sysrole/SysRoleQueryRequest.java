package io.github.panxiaochao.system.application.api.request.sysrole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 角色表查询请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "角色表查询请求对象")
public class SysRoleQueryRequest {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 角色名称
	 */
	@Schema(description = "角色名称")
	private String roleName;

	/**
	 * 角色code
	 */
	@Schema(description = "角色code")
	private String roleCode;

	/**
	 * 状态1正常，0失效
	 */
	@Schema(description = "状态1正常，0失效")
	private String state;

}
