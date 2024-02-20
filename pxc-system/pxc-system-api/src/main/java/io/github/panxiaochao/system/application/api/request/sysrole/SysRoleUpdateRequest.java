package io.github.panxiaochao.system.application.api.request.sysrole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 角色表更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "角色表更新请求对象")
public class SysRoleUpdateRequest {

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
	 * 数据权限（1.全部数据 2.自定义数据 3.本部门数据 4.本部门及以下数据 5.仅本人数据）
	 */
	@Schema(description = "数据权限")
	private String dataScope;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;

	/**
	 * 状态：1正常，0不正常
	 */
	@Schema(description = "状态：1正常，0不正常")
	private String state;

}
