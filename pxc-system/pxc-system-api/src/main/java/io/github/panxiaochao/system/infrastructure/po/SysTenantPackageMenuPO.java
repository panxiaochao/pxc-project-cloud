package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 租户套餐菜单表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Getter
@Setter
@TableName("sys_tenant_package_menu")
public class SysTenantPackageMenuPO {

	/**
	 * 租户套餐id
	 */
	@TableId(value = "package_id")
	private String packageId;

	/**
	 * 菜单ID
	 */
	@TableField(value = "menu_id")
	private Integer menuId;

}
