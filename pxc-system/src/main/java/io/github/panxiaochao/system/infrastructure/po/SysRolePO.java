package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 角色表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_role")
@Schema(name = "SysRolePO", description = "角色表")
public class SysRolePO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "角色名称")
	@TableField("role_name")
	private String roleName;

	@Schema(description = "角色code")
	@TableField("role_code")
	private String roleCode;

	@Schema(description = "描述")
	@TableField("`description`")
	private String description;

	@Schema(description = "排序")
	@TableField("sort")
	private Integer sort;

	@Schema(description = "状态：1正常，0不正常")
	@TableField("`status`")
	private String status;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
