package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 机构部门表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysOrg {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 父ID
	 */
	private String parentId;

	/**
	 * 地区ID
	 */
	private String areaId;

	/**
	 * 地区代码code
	 */
	private String areaCode;

	/**
	 * 机构/部门名称
	 */
	private String orgName;

	/**
	 * 英文名
	 */
	private String orgNameEn;

	/**
	 * 缩写
	 */
	private String orgNameAbbr;

	/**
	 * 机构/部门编码code
	 */
	private String orgCode;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 机构类别：1-公司，2-机构，3-部门
	 */
	private Integer orgCategory;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 传真号码
	 */
	private String fax;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 状态：1正常，0不正常
	 */
	private String state;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
