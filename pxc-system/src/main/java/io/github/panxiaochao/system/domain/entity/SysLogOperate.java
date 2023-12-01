package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志操作表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysLogOperate {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 日志内容
	 */
	private String logContent;

	/**
	 * 操作类型
	 */
	private Integer operateType;

	/**
	 * IP
	 */
	private String ip;

	/**
	 * 请求java方法
	 */
	private String method;

	/**
	 * 请求路径
	 */
	private String requestUrl;

	/**
	 * 请求参数
	 */
	private String requestParams;

	/**
	 * 请求类型
	 */
	private String requestMethod;

	/**
	 * 耗时
	 */
	private Long costTime;

	/**
	 * 是否成功
	 */
	private String state;

	/**
	 * 浏览器
	 */
	private String browser;

	/**
	 * 操作系统
	 */
	private String os;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
}
