package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 角色菜单表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Getter
@Setter
@TableName("sys_role_menu")
public class SysRoleMenuPO {

	/**
	 * 角色ID
	 */
	@TableId(value = "role_id")
	private Integer roleId;

	/**
	 * 菜单ID
	 */
	@TableField(value = "menu_id")
	private Integer menuId;

}
