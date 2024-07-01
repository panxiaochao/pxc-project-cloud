package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 租户套餐表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Getter
@Setter
@TableName("sys_tenant_package")
public class SysTenantPackagePO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 租户套餐id
	 */
	@TableField("package_id")
	private Long packageId;

	/**
	 * 套餐名称
	 */
	@TableField("package_name")
	private String packageName;

	/**
	 * 删除标志：0正常，1删除
	 */
	@TableField("deleted")
	@TableLogic
	private Integer deleted;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 租户套餐状态：1正常，0不正常
	 */
	@TableField("state")
	private Integer state;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 创建人
	 */
	@TableField(value = "create_id", fill = FieldFill.INSERT)
	private Integer createId;

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
