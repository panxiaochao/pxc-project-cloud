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
 * 定时任务调度表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_job")
public class SysJobPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 任务编码
	 */
	@TableField("job_code")
	private String jobCode;

	/**
	 * 任务名称
	 */
	@TableField("job_name")
	private String jobName;

	/**
	 * 任务组
	 */
	@TableField("job_group")
	private String jobGroup;

	/**
	 * 调用目标：可以是Bean
	 */
	@TableField("invoke_bean")
	private String invokeBean;

	/**
	 * 调用目标方法
	 */
	@TableField("invoke_method")
	private String invokeMethod;

	/**
	 * 目标方法参数
	 */
	@TableField("method_params")
	private String methodParams;

	/**
	 * 参数类型：string,int,boolean,long,float
	 */
	@TableField("params_type")
	private String paramsType;

	/**
	 * cron执行表达式
	 */
	@TableField("cron_expression")
	private String cronExpression;

	/**
	 * 任务状态：1=正常 0=停用
	 */
	@TableField("job_status")
	private String jobStatus;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 创建人
	 */
	@TableField("create_id")
	private Long createId;

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
