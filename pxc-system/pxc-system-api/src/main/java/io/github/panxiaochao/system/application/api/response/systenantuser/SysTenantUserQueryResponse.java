package io.github.panxiaochao.system.application.api.response.systenantuser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 租户用户表查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Getter
@Setter
@ToString
@Schema(description = "租户用户表查询响应对象")
public class SysTenantUserQueryResponse {

	/**
	 * 租户ID
	 */
	@Schema(description = "租户ID")
	private String tenantId;

	/**
	 * 用户ID
	 */
	@Schema(description = "用户ID")
	private String userId;

}
