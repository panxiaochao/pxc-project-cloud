package io.github.panxiaochao.system.development.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 数据库字段类型码表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Getter
@Setter
@ToString
public class DatabaseFieldType {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 数据库字段类型
	 */
	private String columnType;

	/**
	 * 对应Java属性类型
	 */
	private String javaType;

	/**
	 * 对应Java包名
	 */
	private String packageName;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
