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
 * 系统日志登录/登出表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_log_login")
public class SysLogLoginPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 登录名
	 */
	@TableField("login_name")
	private String loginName;

	/**
	 * 登录类型: 1-登录 2-登出
	 */
	@TableField("login_type")
	private Integer loginType;

	/**
	 * IP
	 */
	@TableField("ip")
	private String ip;

	/**
	 * 地点
	 */
	@TableField("address")
	private String address;

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
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 状态: 1-成功 0-失败
	 */
	@TableField("state")
	private String state;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

}
