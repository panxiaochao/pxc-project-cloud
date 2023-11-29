package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 菜单配置 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_menu")
@Schema(name = "SysMenuPO", description = "菜单配置")
public class SysMenuPO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "父id")
	@TableField("parent_id")
	private Integer parentId;

	@Schema(description = "菜单名称")
	@TableField("menu_name")
	private String menuName;

	@Schema(description = "链接地址")
	@TableField("url")
	private String url;

	@Schema(description = "一级菜单默认跳转地址")
	@TableField("redirect_url")
	private String redirectUrl;

	@Schema(description = "前端组件")
	@TableField("`component`")
	private String component;

	@Schema(description = "前端组件名字")
	@TableField("component_name")
	private String componentName;

	@Schema(description = "菜单权限编码")
	@TableField("permission_code")
	private String permissionCode;

	@Schema(description = "菜单权限状态：1显示，2禁用")
	@TableField("permission_status")
	private String permissionStatus;

	@Schema(description = "菜单图标")
	@TableField("icon")
	private String icon;

	@Schema(description = "类型：0-一级菜单；1-子菜单 ；2-按钮权限")
	@TableField("menu_type")
	private String menuType;

	@Schema(description = "打开页面方式： 0-内部；1-外链（默认值0）")
	@TableField("open_type")
	private String openType;

	@Schema(description = "是否显示：0-否；1-是（默认值1）")
	@TableField("is_display")
	private String isDisplay;

	@Schema(description = "是否路由菜单：0-不是 1-是（默认值1）")
	@TableField("is_route")
	private String isRoute;

	@Schema(description = "是否缓存页面：0-不是 1-是（默认值0）")
	@TableField("keep_alive")
	private String keepAlive;

	@Schema(description = "是否隐藏路由菜单：0-不是 1-是（默认值0）")
	@TableField("is_hidden")
	private String isHidden;

	@Schema(description = "描述")
	@TableField("`description`")
	private String description;

	@Schema(description = "状态：1正常，0不正常")
	@TableField("`status`")
	private String status;

	@Schema(description = "排序")
	@TableField("sort")
	private Integer sort;

	@Schema(description = "创建人")
	@TableField("create_id")
	private Integer createId;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
