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
 * 系统日志操作表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_log_operate")
public class SysLogOperatePO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 操作标题
	 */
	@TableField("op_title")
	private String opTitle;

	/**
	 * 日志内容
	 */
	@TableField("log_content")
	private String logContent;

	/**
	 * 操作类型
	 */
	@TableField("operate_type")
	private Integer operateType;

	/**
	 * IP
	 */
	@TableField("ip")
	private String ip;

	/**
	 * 请求地址
	 */
	@TableField("address")
	private String address;

	/**
	 * 请求java方法
	 */
	@TableField("method")
	private String method;

	/**
	 * 请求路径
	 */
	@TableField("request_url")
	private String requestUrl;

	/**
	 * 请求参数
	 */
	@TableField("request_params")
	private String requestParams;

	/**
	 * 请求类型
	 */
	@TableField("request_method")
	private String requestMethod;

	/**
	 * 耗时
	 */
	@TableField("cost_time")
	private Long costTime;

	/**
	 * 是否成功
	 */
	@TableField("state")
	private String state;

	/**
	 * 浏览器
	 */
	@TableField("browser")
	private String browser;

	/**
	 * 操作系统
	 */
	@TableField("os")
	private String os;

	/**
	 * 操作用户
	 */
	@TableField("op_user")
	private String opUser;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

}
