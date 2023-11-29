package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 角色表创建请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@ToString
@Schema(description = "角色表创建请求对象")
public class SysRoleCreateRequest {

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
	 * 描述
	 */
	@Schema(description = "描述")
	private String description;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort = 0;

	/**
	 * 状态：1正常，0不正常
	 */
	@Schema(description = "状态：1正常，0不正常")
	private String status;

}
