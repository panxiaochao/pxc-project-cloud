package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 全国5级行政区划 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_area")
@Schema(name = "SysAreaPO", description = "全国5级行政区划")
public class SysAreaPO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "父ID")
	@TableField("parent_id")
	private Integer parentId;

	@Schema(description = "区划名称")
	@TableField("area_name")
	private String areaName;

	@Schema(description = "区域简称")
	@TableField("area_name_abbr")
	private String areaNameAbbr;

	@Schema(description = "地区代码")
	@TableField("area_code")
	private String areaCode;

	@Schema(description = "行政编码")
	@TableField("city_code")
	private String cityCode;

	@Schema(description = "上级地区代码，组合路径")
	@TableField("parent_path")
	private String parentPath;

	@Schema(description = "0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区")
	@TableField("area_level")
	private Integer areaLevel;

	@Schema(description = "排序")
	@TableField("sort")
	private Integer sort;

	@Schema(description = "英文名称")
	@TableField("area_name_en")
	private String areaNameEn;

	@Schema(description = "英文简称")
	@TableField("area_name_en_abbr")
	private String areaNameEnAbbr;

	@Schema(description = "经度")
	@TableField("longitude")
	private String longitude;

	@Schema(description = "纬度")
	@TableField("latitude")
	private String latitude;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
