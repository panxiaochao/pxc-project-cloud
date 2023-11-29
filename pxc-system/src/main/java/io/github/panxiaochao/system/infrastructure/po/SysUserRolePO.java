package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 用户角色表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user_role")
@Schema(name = "SysUserRolePO", description = "用户角色表")
public class SysUserRolePO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "用户ID")
	@TableField("user_id")
	private Integer userId;

	@Schema(description = "角色ID")
	@TableField("role_id")
	private Integer roleId;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
