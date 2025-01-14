package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 租户套餐表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Getter
@Setter
@ToString
public class SysTenantPackage {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 租户套餐id
	 */
	private String packageId;

	/**
	 * 套餐名称
	 */
	private String packageName;

	/**
	 * 删除标志：0正常，1删除
	 */
	private String deleted;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 租户套餐状态：1正常，0不正常
	 */
	private String state;

	/**
	 * 排序
	 */
	private String sort;

	/**
	 * 创建人
	 */
	private String createId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
