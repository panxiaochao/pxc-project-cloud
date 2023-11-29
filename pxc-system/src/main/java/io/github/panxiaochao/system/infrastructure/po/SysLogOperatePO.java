package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 系统日志操作表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_log_operate")
@Schema(name = "SysLogOperatePO", description = "系统日志操作表")
public class SysLogOperatePO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@Schema(description = "日志内容")
	@TableField("log_content")
	private String logContent;

	@Schema(description = "操作类型")
	@TableField("operate_type")
	private Integer operateType;

	@Schema(description = "IP")
	@TableField("ip")
	private String ip;

	@Schema(description = "请求java方法")
	@TableField("method")
	private String method;

	@Schema(description = "请求路径")
	@TableField("request_url")
	private String requestUrl;

	@Schema(description = "请求参数")
	@TableField("request_params")
	private String requestParams;

	@Schema(description = "请求类型")
	@TableField("request_method")
	private String requestMethod;

	@Schema(description = "耗时")
	@TableField("cost_time")
	private Long costTime;

	@Schema(description = "是否成功")
	@TableField("`status`")
	private String status;

	@Schema(description = "浏览器")
	@TableField("browser")
	private String browser;

	@Schema(description = "操作系统")
	@TableField("os")
	private String os;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

}
