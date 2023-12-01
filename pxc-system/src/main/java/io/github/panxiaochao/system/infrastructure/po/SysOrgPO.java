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
 * 机构部门表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_org")
public class SysOrgPO {

	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 父ID
	 */
	@TableField("parent_id")
	private Integer parentId;

	/**
	 * 地区ID
	 */
	@TableField("area_id")
	private Integer areaId;

	/**
	 * 地区代码code
	 */
	@TableField("area_code")
	private String areaCode;

	/**
	 * 机构/部门名称
	 */
	@TableField("org_name")
	private String orgName;

	/**
	 * 英文名
	 */
	@TableField("org_name_en")
	private String orgNameEn;

	/**
	 * 缩写
	 */
	@TableField("org_name_abbr")
	private String orgNameAbbr;

	/**
	 * 机构/部门编码code
	 */
	@TableField("org_code")
	private String orgCode;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 机构类别：1-公司，2-机构，3-部门
	 */
	@TableField("org_category")
	private Integer orgCategory;

	/**
	 * 手机号码
	 */
	@TableField("mobile")
	private String mobile;

	/**
	 * 传真号码
	 */
	@TableField("fax")
	private String fax;

	/**
	 * 地址
	 */
	@TableField("address")
	private String address;

	/**
	 * 状态：1正常，0不正常
	 */
	@TableField("state")
	private String state;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

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
