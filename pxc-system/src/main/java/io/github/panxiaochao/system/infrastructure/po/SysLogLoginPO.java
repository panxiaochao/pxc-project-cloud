package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 系统日志登录/登出表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_log_login")
@Schema(name = "SysLogLoginPO", description = "系统日志登录/登出表")
public class SysLogLoginPO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@Schema(description = "日志内容")
	@TableField("login_name")
	private String loginName;

	@Schema(description = "登录类型: 1-登录 2-登出")
	@TableField("login_type")
	private Integer loginType;

	@Schema(description = "IP")
	@TableField("ip")
	private String ip;

	@Schema(description = "地点")
	@TableField("address")
	private String address;

	@Schema(description = "浏览器")
	@TableField("browser")
	private String browser;

	@Schema(description = "操作系统")
	@TableField("os")
	private String os;

	@Schema(description = "状态: 1-成功 0-失败")
	@TableField("`status`")
	private String status;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

}
