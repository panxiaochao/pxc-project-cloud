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
 * 全国5级行政区划 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_area")
public class SysAreaPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 父Code
	 */
	@TableField("parent_code")
	private String parentCode;

	/**
	 * 区划名称
	 */
	@TableField("area_name")
	private String areaName;

	/**
	 * 区域简称
	 */
	@TableField("area_name_abbr")
	private String areaNameAbbr;

	/**
	 * 地区代码
	 */
	@TableField("area_code")
	private String areaCode;

	/**
	 * 行政编码
	 */
	@TableField("city_code")
	private String cityCode;

	/**
	 * 上级地区代码，组合路径
	 */
	@TableField("parent_path")
	private String parentPath;

	/**
	 * 0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区
	 */
	@TableField("area_level")
	private Integer areaLevel;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 英文名称
	 */
	@TableField("area_name_en")
	private String areaNameEn;

	/**
	 * 英文简称
	 */
	@TableField("area_name_en_abbr")
	private String areaNameEnAbbr;

	/**
	 * 经度
	 */
	@TableField("longitude")
	private String longitude;

	/**
	 * 纬度
	 */
	@TableField("latitude")
	private String latitude;

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
