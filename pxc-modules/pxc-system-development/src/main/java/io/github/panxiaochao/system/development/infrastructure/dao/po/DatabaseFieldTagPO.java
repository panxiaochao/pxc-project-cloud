package io.github.panxiaochao.system.development.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Getter
@Setter
@TableName("database_field_tag")
public class DatabaseFieldTagPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 数据库字段类型码表ID
	 */
	@TableField("field_type_id")
	private Integer fieldTypeId;

	/**
	 * 数据库类型标签
	 */
	@TableField("tag")
	private String tag;

	/**
	 * 数据库字段类型
	 */
	@TableField("column_type")
	private String columnType;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_at", fill = FieldFill.INSERT)
	private LocalDateTime createAt;

}
