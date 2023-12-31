package io.github.panxiaochao.system.application.api.request.sysorg;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 机构部门表更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "机构部门表更新请求对象")
public class SysOrgUpdateRequest {

	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 父ID
	 */
	@Schema(description = "父ID")
	private String parentId;

	/**
	 * 地区ID
	 */
	@Schema(description = "地区ID")
	private String areaId;

	/**
	 * 地区代码code
	 */
	@Schema(description = "地区代码code")
	private String areaCode;

	/**
	 * 机构/部门名称
	 */
	@Schema(description = "机构/部门名称")
	private String orgName;

	/**
	 * 英文名
	 */
	@Schema(description = "英文名")
	private String orgNameEn;

	/**
	 * 缩写
	 */
	@Schema(description = "缩写")
	private String orgNameAbbr;

	/**
	 * 机构/部门编码code
	 */
	@Schema(description = "机构/部门编码code")
	private String orgCode;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;

	/**
	 * 机构类别：1-公司，2-机构，3-部门
	 */
	@Schema(description = "机构类别：1-公司，2-机构，3-部门")
	private Integer orgCategory;

	/**
	 * 手机号码
	 */
	@Schema(description = "手机号码")
	private String mobile;

	/**
	 * 传真号码
	 */
	@Schema(description = "传真号码")
	private String fax;

	/**
	 * 地址
	 */
	@Schema(description = "地址")
	private String address;

	/**
	 * 状态：1正常，0不正常
	 */
	@Schema(description = "状态：1正常，0不正常")
	private String state;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

}
