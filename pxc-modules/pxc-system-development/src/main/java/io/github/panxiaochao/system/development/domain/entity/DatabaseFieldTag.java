package io.github.panxiaochao.system.development.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】实体.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class DatabaseFieldTag {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 数据库字段类型码表ID
	 */
	private Integer fieldTypeId;

	/**
	 * 数据库类型标签
	 */
	private String tag;

	/**
	 * 创建时间
	 */
	private LocalDateTime createAt;

}
