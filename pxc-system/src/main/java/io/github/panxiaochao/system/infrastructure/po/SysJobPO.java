package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 定时任务调度表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_job")
@Schema(name = "SysJobPO", description = "定时任务调度表")
public class SysJobPO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@Schema(description = "任务编码")
	@TableField("job_code")
	private String jobCode;

	@Schema(description = "任务名称")
	@TableField("job_name")
	private String jobName;

	@Schema(description = "任务组")
	@TableField("job_group")
	private String jobGroup;

	@Schema(description = "调用目标：可以是Bean")
	@TableField("invoke_bean")
	private String invokeBean;

	@Schema(description = "调用目标方法")
	@TableField("invoke_method")
	private String invokeMethod;

	@Schema(description = "目标方法参数")
	@TableField("method_params")
	private String methodParams;

	@Schema(description = "参数类型：string,int,boolean,long,float")
	@TableField("params_type")
	private String paramsType;

	@Schema(description = "cron执行表达式")
	@TableField("cron_expression")
	private String cronExpression;

	@Schema(description = "任务状态：1=正常 0=停用")
	@TableField("job_status")
	private String jobStatus;

	@Schema(description = "备注")
	@TableField("remark")
	private String remark;

	@Schema(description = "创建人")
	@TableField("create_id")
	private Long createId;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
