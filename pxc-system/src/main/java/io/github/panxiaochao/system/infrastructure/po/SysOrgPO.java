package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 机构部门表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_org")
@Schema(name = "SysOrgPO", description = "机构部门表")
public class SysOrgPO {

	@Schema(description = "ID")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "父ID")
	@TableField("parent_id")
	private Integer parentId;

	@Schema(description = "地区ID")
	@TableField("area_id")
	private Integer areaId;

	@Schema(description = "地区代码code")
	@TableField("area_code")
	private String areaCode;

	@Schema(description = "机构/部门名称")
	@TableField("org_name")
	private String orgName;

	@Schema(description = "英文名")
	@TableField("org_name_en")
	private String orgNameEn;

	@Schema(description = "缩写")
	@TableField("org_name_abbr")
	private String orgNameAbbr;

	@Schema(description = "机构/部门编码code")
	@TableField("org_code")
	private String orgCode;

	@Schema(description = "描述")
	@TableField("`description`")
	private String description;

	@Schema(description = "排序")
	@TableField("sort")
	private Integer sort;

	@Schema(description = "机构类别：1-公司，2-机构，3-部门")
	@TableField("org_category")
	private Integer orgCategory;

	@Schema(description = "手机号码")
	@TableField("mobile")
	private String mobile;

	@Schema(description = "传真号码")
	@TableField("fax")
	private String fax;

	@Schema(description = "地址")
	@TableField("address")
	private String address;

	@Schema(description = "状态：1正常，0不正常")
	@TableField("`status`")
	private String status;

	@Schema(description = "备注")
	@TableField("remark")
	private String remark;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
