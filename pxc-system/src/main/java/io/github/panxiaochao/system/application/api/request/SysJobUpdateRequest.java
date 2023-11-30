package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>定时任务调度表更新请求对象</p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Getter
@Setter
@ToString
@Schema(description = "定时任务调度表更新请求对象")
public class SysJobUpdateRequest {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private String id;

    /**
     * 任务编码
     */
    @Schema(description = "任务编码")
    private String jobCode;

    /**
     * 任务名称
     */
    @Schema(description = "任务名称")
    private String jobName;

    /**
     * 任务组
     */
    @Schema(description = "任务组")
    private String jobGroup;

    /**
     * 调用目标：可以是Bean
     */
    @Schema(description = "调用目标：可以是Bean")
    private String invokeBean;

    /**
     * 调用目标方法
     */
    @Schema(description = "调用目标方法")
    private String invokeMethod;

    /**
     * 目标方法参数
     */
    @Schema(description = "目标方法参数")
    private String methodParams;

    /**
     * 参数类型：string,int,boolean,long,float
     */
    @Schema(description = "参数类型：string,int,boolean,long,float")
    private String paramsType;

    /**
     * cron执行表达式
     */
    @Schema(description = "cron执行表达式")
    private String cronExpression;

    /**
     * 任务状态：1=正常 0=停用
     */
    @Schema(description = "任务状态：1=正常 0=停用")
    private String jobStatus;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private Long createId;

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
