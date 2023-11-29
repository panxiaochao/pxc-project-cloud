package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 数据字典表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@ToString
public class SysDict {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 字典名称
	 */
	private String dictName;

	/**
	 * 字典code
	 */
	private String dictCode;

	/**
	 * 字典类型：0为string,1为number
	 */
	private Integer dictType;

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
