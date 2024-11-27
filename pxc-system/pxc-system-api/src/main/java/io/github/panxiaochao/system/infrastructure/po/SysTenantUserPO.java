package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 租户用户表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Getter
@Setter
@TableName("sys_tenant_user")
public class SysTenantUserPO {

	/**
	 * 租户ID
	 */
	@TableId(value = "tenant_id")
	private String tenantId;

	/**
	 * 用户ID
	 */
	@TableField(value = "user_id")
	private Integer userId;

}
