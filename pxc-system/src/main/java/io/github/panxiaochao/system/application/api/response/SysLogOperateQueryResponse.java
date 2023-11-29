package io.github.panxiaochao.system.application.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志操作表查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@ToString
@Schema(description = "系统日志操作表查询响应对象")
public class SysLogOperateQueryResponse {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 日志内容
	 */
	@Schema(description = "日志内容")
	private String logContent;

	/**
	 * 操作类型
	 */
	@Schema(description = "操作类型")
	private Integer operateType;

	/**
	 * IP
	 */
	@Schema(description = "IP")
	private String ip;

	/**
	 * 请求java方法
	 */
	@Schema(description = "请求java方法")
	private String method;

	/**
	 * 请求路径
	 */
	@Schema(description = "请求路径")
	private String requestUrl;

	/**
	 * 请求参数
	 */
	@Schema(description = "请求参数")
	private String requestParams;

	/**
	 * 请求类型
	 */
	@Schema(description = "请求类型")
	private String requestMethod;

	/**
	 * 耗时
	 */
	@Schema(description = "耗时")
	private String costTime;

	/**
	 * 是否成功
	 */
	@Schema(description = "是否成功")
	private String status;

	/**
	 * 浏览器
	 */
	@Schema(description = "浏览器")
	private String browser;

	/**
	 * 操作系统
	 */
	@Schema(description = "操作系统")
	private String os;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private LocalDateTime createTime;

}
