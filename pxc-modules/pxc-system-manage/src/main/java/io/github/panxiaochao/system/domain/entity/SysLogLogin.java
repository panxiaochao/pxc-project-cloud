package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志登录/登出表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysLogLogin {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 登录类型: 1-登录 2-登出
	 */
	private Integer loginType;

	/**
	 * IP
	 */
	private String ip;

	/**
	 * 地点
	 */
	private String address;

	/**
	 * 浏览器
	 */
	private String browser;

	/**
	 * 操作系统
	 */
	private String os;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 状态: 1-成功 0-失败
	 */
	private String state;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

}
