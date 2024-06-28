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
 * 租户表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Getter
@Setter
@TableName("sys_tenant")
public class SysTenantPO {

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 租户编号
	 */
	@TableField("tenant_id")
	private Long tenantId;

	/**
	 * 租户套餐编号
	 */
	@TableField("package_id")
	private Long packageId;

	/**
	 * 联系人
	 */
	@TableField("contact_user_name")
	private String contactUserName;

	/**
	 * 联系电话
	 */
	@TableField("contact_phone")
	private String contactPhone;

	/**
	 * 企业名称
	 */
	@TableField("company_name")
	private String companyName;

	/**
	 * 统一社会信用代码
	 */
	@TableField("social_code")
	private String socialCode;

	/**
	 * 地址
	 */
	@TableField("company_address")
	private String companyAddress;

	/**
	 * 企业简介
	 */
	@TableField("company_intro")
	private String companyIntro;

	/**
	 * 域名
	 */
	@TableField("company_domain")
	private String companyDomain;

	/**
	 * 租户模式：0字段模式，1数据库模式
	 */
	@TableField("`mode`")
	private String mode;

	/**
	 * 删除标志：0正常，1删除
	 */
	@TableField("deleted")
	@TableLogic
	private String deleted;

	/**
	 * 过期时间
	 */
	@TableField("expire_time")
	private LocalDateTime expireTime;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 租户状态：1正常，0不正常
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
	@TableField("create_id")
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
