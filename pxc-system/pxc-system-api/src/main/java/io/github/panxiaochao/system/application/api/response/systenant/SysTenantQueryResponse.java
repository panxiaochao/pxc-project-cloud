package io.github.panxiaochao.system.application.api.response.systenant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 租户表查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Getter
@Setter
@ToString
@Schema(description = "租户表查询响应对象")
public class SysTenantQueryResponse {

	/**
	 * id
	 */
	@Schema(description = "id")
	private String id;

	/**
	 * 租户编号
	 */
	@Schema(description = "租户编号")
	private String tenantId;

	/**
	 * 租户套餐编号
	 */
	@Schema(description = "租户套餐编号")
	private String packageId;

	/**
	 * 租户套餐名称
	 */
	@Schema(description = "租户套餐名称")
	private String packageName;

	/**
	 * 联系人
	 */
	@Schema(description = "联系人")
	private String contactUserName;

	/**
	 * 联系电话
	 */
	@Schema(description = "联系电话")
	private String contactPhone;

	/**
	 * 企业名称
	 */
	@Schema(description = "企业名称")
	private String companyName;

	/**
	 * 统一社会信用代码
	 */
	@Schema(description = "统一社会信用代码")
	private String socialCode;

	/**
	 * 地址
	 */
	@Schema(description = "地址")
	private String companyAddress;

	/**
	 * 企业简介
	 */
	@Schema(description = "企业简介")
	private String companyIntro;

	/**
	 * 域名
	 */
	@Schema(description = "域名")
	private String companyDomain;

	/**
	 * 租户模式：0字段模式，1数据库模式
	 */
	@Schema(description = "租户模式：0字段模式，1数据库模式")
	private String mode;

	/**
	 * 租户模式：0字段模式，1数据库模式
	 */
	@Schema(description = "租户模式字符串")
	private String modeStr;

	/**
	 * 删除标志：0正常，1删除
	 */
	@Schema(description = "删除标志：0正常，1删除")
	private String deleted;

	/**
	 * 过期时间
	 */
	@Schema(description = "过期时间")
	private LocalDateTime expireTime;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

	/**
	 * 租户状态：1正常，0不正常
	 */
	@Schema(description = "租户状态：1正常，0不正常")
	private String state;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private String sort;

	/**
	 * 创建人
	 */
	@Schema(description = "创建人")
	private String createId;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@Schema(description = "更新时间")
	private LocalDateTime updateTime;

}
