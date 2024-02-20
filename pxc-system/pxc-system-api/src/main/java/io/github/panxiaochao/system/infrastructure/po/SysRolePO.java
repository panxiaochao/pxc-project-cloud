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
 * 角色表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@TableName("sys_role")
public class SysRolePO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 角色名称
	 */
	@TableField("role_name")
	private String roleName;

	/**
	 * 角色code
	 */
	@TableField("role_code")
	private String roleCode;

	/**
	 * 数据权限（1.全部数据 2.自定义数据 3.本部门数据 4.本部门及以下数据 5.仅本人数据）
	 */
	@TableField("data_scope")
	private String dataScope;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 状态：1正常，0不正常
	 */
	@TableField("state")
	private String state;

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
