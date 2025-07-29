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
 * 【在线数据表字段】持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Getter
@Setter
@TableName("online_table_column")
public class OnlineTableColumnPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 表ID
	 */
	@TableField("table_id")
	private Long tableId;

	/**
	 * 表名称
	 */
	@TableField("table_name")
	private String tableName;

	/**
	 * 字段名称
	 */
	@TableField("field_name")
	private String fieldName;

	/**
	 * 字段类型
	 */
	@TableField("field_type")
	private String fieldType;

	/**
	 * 字段说明
	 */
	@TableField("field_comment")
	private String fieldComment;

	/**
	 * 字段长度
	 */
	@TableField("column_size")
	private Integer columnSize;

	/**
	 * 字段小数位
	 */
	@TableField("scale")
	private Integer scale;

	/**
	 * 字段默认值
	 */
	@TableField("field_default")
	private String fieldDefault;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 主键 0：否 1：是
	 */
	@TableField("primary_pk")
	private String primaryPk;

	/**
	 * 是否自增 0：否 1：是
	 */
	@TableField("auto_increment")
	private String autoIncrement;

	/**
	 * 是否可空 0：否 1：是
	 */
	@TableField("nullable")
	private String nullable;

	/**
	 * 创建人
	 */
	@TableField("create_id")
	private Integer createId;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

}
