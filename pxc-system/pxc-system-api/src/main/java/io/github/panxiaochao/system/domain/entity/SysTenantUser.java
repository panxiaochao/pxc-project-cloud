package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 租户用户表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Getter
@Setter
@ToString
public class SysTenantUser {

	/**
	 * 租户ID
	 */
	private String tenantId;

	/**
	 * 用户ID
	 */
	private String userId;

	public SysTenantUser(String tenantId, String userId) {
		this.tenantId = tenantId;
		this.userId = userId;
	}

}
