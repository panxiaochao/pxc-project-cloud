package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 角色表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@ToString
public class SysRole {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色code
	 */
	private String roleCode;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 状态：1正常，0不正常
	 */
	private String status;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
