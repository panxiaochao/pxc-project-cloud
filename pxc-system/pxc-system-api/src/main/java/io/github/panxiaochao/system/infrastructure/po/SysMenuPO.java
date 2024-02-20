package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 菜单配置 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@TableName("sys_menu")
public class SysMenuPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 父id
	 */
	@TableField("parent_id")
	private Integer parentId;

	/**
	 * 菜单名称
	 */
	@TableField("menu_name")
	private String menuName;

	/**
	 * 链接地址
	 */
	@TableField("url")
	private String url;

	/**
	 * 一级菜单默认跳转地址
	 */
	@TableField("redirect_url")
	private String redirectUrl;

	/**
	 * 前端组件
	 */
	@TableField("`component`")
	private String component;

	/**
	 * 前端组件名字
	 */
	@TableField("component_name")
	private String componentName;

	/**
	 * 菜单权限编码
	 */
	@TableField("permission_code")
	private String permissionCode;

	/**
	 * 菜单权限状态：1显示，0禁用
	 */
	@TableField("permission_status")
	private String permissionStatus;

	/**
	 * 菜单图标
	 */
	@TableField("icon")
	private String icon;

	/**
	 * 类型：0-一级菜单；1-子菜单 ；2-按钮权限
	 */
	@TableField("menu_type")
	private String menuType;

	/**
	 * 打开页面方式： 0-内部；1-外链（默认值0）
	 */
	@TableField("open_type")
	private String openType;

	/**
	 * 是否显示：0-否；1-是（默认值1）
	 */
	@TableField("is_display")
	private String isDisplay;

	/**
	 * 是否路由菜单：0-不是 1-是（默认值1）
	 */
	@TableField("is_route")
	private String isRoute;

	/**
	 * 是否缓存页面：0-不是 1-是（默认值0）
	 */
	@TableField("keep_alive")
	private String keepAlive;

	/**
	 * 是否隐藏路由菜单：0-不是 1-是（默认值0）
	 */
	@TableField("is_hidden")
	private String isHidden;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 状态：1正常，0不正常
	 */
	@TableField("state")
	private String state;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 创建人
	 */
	@TableField("create_id")
	private Integer createId;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

}
