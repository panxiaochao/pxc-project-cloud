package io.github.panxiaochao.system.application.api.response.sysmenu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 菜单配置响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "菜单配置响应对象")
public class SysMenuResponse {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private String id;
        
    /**
     * 父id
    */
    @Schema(description = "父id")
    private Integer parentId;
        
    /**
     * 菜单名称
    */
    @Schema(description = "菜单名称")
    private String menuName;
        
    /**
     * 链接地址
    */
    @Schema(description = "链接地址")
    private String url;
        
    /**
     * 一级菜单默认跳转地址
    */
    @Schema(description = "一级菜单默认跳转地址")
    private String redirectUrl;
        
    /**
     * 前端组件
    */
    @Schema(description = "前端组件")
    private String component;
        
    /**
     * 前端组件名字
    */
    @Schema(description = "前端组件名字")
    private String componentName;
        
    /**
     * 菜单权限编码
    */
    @Schema(description = "菜单权限编码")
    private String permissionCode;
        
    /**
     * 菜单权限状态：1显示，2禁用
    */
    @Schema(description = "菜单权限状态：1显示，2禁用")
    private String permissionStatus;
        
    /**
     * 菜单图标
    */
    @Schema(description = "菜单图标")
    private String icon;
        
    /**
     * 类型：0-一级菜单；1-子菜单 ；2-按钮权限
    */
    @Schema(description = "类型：0-一级菜单；1-子菜单 ；2-按钮权限")
    private String menuType;
        
    /**
     * 打开页面方式： 0-内部；1-外链（默认值0）
    */
    @Schema(description = "打开页面方式： 0-内部；1-外链（默认值0）")
    private String openType;
        
    /**
     * 是否显示：0-否；1-是（默认值1）
    */
    @Schema(description = "是否显示：0-否；1-是（默认值1）")
    private String isDisplay;
        
    /**
     * 是否路由菜单：0-不是 1-是（默认值1）
    */
    @Schema(description = "是否路由菜单：0-不是 1-是（默认值1）")
    private String isRoute;
        
    /**
     * 是否缓存页面：0-不是 1-是（默认值0）
    */
    @Schema(description = "是否缓存页面：0-不是 1-是（默认值0）")
    private String keepAlive;
        
    /**
     * 是否隐藏路由菜单：0-不是 1-是（默认值0）
    */
    @Schema(description = "是否隐藏路由菜单：0-不是 1-是（默认值0）")
    private String isHidden;
        
    /**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;
        
    /**
     * 状态：1正常，0不正常
    */
    @Schema(description = "状态：1正常，0不正常")
	private String state;
        
    /**
     * 排序
    */
    @Schema(description = "排序")
    private Integer sort;
        
    /**
     * 创建人
    */
    @Schema(description = "创建人")
    private Integer createId;
        
    /**
     * 创建时间
    */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
        
    /**
     * 更新时间
    */
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
