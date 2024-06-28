package io.github.panxiaochao.system.application.api.response.systenantpackagemenu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 租户套餐菜单表查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Getter
@Setter
@ToString
@Schema(description = "租户套餐菜单表查询响应对象")
public class SysTenantPackageMenuQueryResponse {

	/**
	 * 租户套餐id
	 */
	@Schema(description = "租户套餐id")
	private String packageId;

	/**
	 * 菜单ID
	 */
	@Schema(description = "菜单ID")
	private String menuId;

}
