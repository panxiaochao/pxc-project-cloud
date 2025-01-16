package io.github.panxiaochao.system.development.infrastructure.po;

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
 * 数据库字段类型码表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Getter
@Setter
@TableName("database_field_type")
public class DatabaseFieldTypePO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 数据库字段类型
	 */
	@TableField("column_type")
	private String columnType;

	/**
	 * 对应Java属性类型
	 */
	@TableField("java_type")
	private String javaType;

	/**
	 * 对应Java包名
	 */
	@TableField("package_name")
	private String packageName;

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
