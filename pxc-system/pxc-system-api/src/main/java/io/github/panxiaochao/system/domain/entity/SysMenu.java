package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 菜单配置 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysMenu {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 父id
	 */
	private String parentId;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 链接地址
	 */
	private String url;

	/**
	 * 一级菜单默认跳转地址
	 */
	private String redirectUrl;

	/**
	 * 前端组件
	 */
	private String component;

	/**
	 * 前端组件名字
	 */
	private String componentName;

	/**
	 * 菜单权限编码
	 */
	private String permissionCode;

	/**
	 * 菜单图标
	 */
	private String icon;

	/**
	 * 类型：0-一级菜单；1-子菜单 ；2-按钮权限
	 */
	private String menuType;

	/**
	 * 打开页面方式： 0-内部；1-外链（默认值0）
	 */
	private String openType;

	/**
	 * 是否缓存页面：0-不是 1-是（默认值0）
	 */
	private String keepAlive;

	/**
	 * 是否隐藏路由菜单：0-不是 1-是（默认值0）
	 */
	private String isHidden;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 状态：1正常，0不正常
	 */
	private String state;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 创建人
	 */
	private Integer createId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
