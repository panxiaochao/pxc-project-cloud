package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 全国5级行政区划 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysArea {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 父ID
	 */
	private Integer parentId;

	/**
	 * 区划名称
	 */
	private String areaName;

	/**
	 * 区域简称
	 */
	private String areaNameAbbr;

	/**
	 * 地区代码
	 */
	private String areaCode;

	/**
	 * 行政编码
	 */
	private String cityCode;

	/**
	 * 上级地区代码，组合路径
	 */
	private String parentPath;

	/**
	 * 0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区
	 */
	private Integer areaLevel;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 英文名称
	 */
	private String areaNameEn;

	/**
	 * 英文简称
	 */
	private String areaNameEnAbbr;

	/**
	 * 经度
	 */
	private String longitude;

	/**
	 * 纬度
	 */
	private String latitude;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
}
