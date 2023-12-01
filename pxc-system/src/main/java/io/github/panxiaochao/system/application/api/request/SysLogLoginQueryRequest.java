package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志登录/登出表查询请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "系统日志登录/登出表查询请求对象")
public class SysLogLoginQueryRequest {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private String id;

    /**
     * 日志内容
     */
    @Schema(description = "日志内容")
    private String loginName;

    /**
     * 登录类型: 1-登录 2-登出
     */
    @Schema(description = "登录类型: 1-登录 2-登出")
    private Integer loginType;

    /**
     * IP
     */
    @Schema(description = "IP")
    private String ip;

    /**
     * 地点
     */
    @Schema(description = "地点")
    private String address;

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
     * 状态: 1-成功 0-失败
     */
    @Schema(description = "状态: 1-成功 0-失败")
	private String state;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
