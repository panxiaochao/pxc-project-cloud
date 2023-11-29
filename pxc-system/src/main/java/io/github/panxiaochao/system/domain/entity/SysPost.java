package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 岗位表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@ToString
public class SysPost {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 岗位名称
	 */
	private String postName;

	/**
	 * 岗位编码
	 */
	private String postCode;

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
