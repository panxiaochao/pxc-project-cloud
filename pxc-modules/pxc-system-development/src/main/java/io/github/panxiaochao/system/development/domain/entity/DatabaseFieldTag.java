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
	 * 数据库字段类型
	 */
	private String columnType;

	/**
	 * 创建时间
	 */
	private LocalDateTime createAt;

	public DatabaseFieldTag() {
	}

	public DatabaseFieldTag(String fieldTypeId, String tag, String columnType) {
		this.fieldTypeId = Integer.parseInt(fieldTypeId);
		this.tag = tag;
		this.columnType = columnType;
	}

	public DatabaseFieldTag(Integer fieldTypeId, String tag, String columnType) {
		this.fieldTypeId = fieldTypeId;
		this.tag = tag;
		this.columnType = columnType;
	}

}
