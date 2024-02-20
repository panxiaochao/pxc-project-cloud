package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户机构/部门表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysUserOrg {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 机构ID
	 */
	private String orgId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
