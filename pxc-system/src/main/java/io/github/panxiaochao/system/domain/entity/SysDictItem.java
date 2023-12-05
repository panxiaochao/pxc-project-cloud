package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 数据字典配置表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysDictItem {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 字典关联ID
	 */
	private String dictId;

	/**
	 * 字典名称
	 */
	private String dictItemText;

	/**
	 * 字典code
	 */
	private String dictItemValue;

	/**
	 * 描述
	 */
	private String remark;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 状态：1正常，0不正常
	 */
	private String state;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
