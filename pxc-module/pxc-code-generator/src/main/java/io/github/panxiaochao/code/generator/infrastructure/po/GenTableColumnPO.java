package io.github.panxiaochao.code.generator.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 代码生成表字段 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Getter
@Setter
@TableName("gen_table_column")
public class GenTableColumnPO {

	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 表名称
	 */
	@TableField("`table_name`")
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
	 * 属性名
	 */
	@TableField("attr_name")
	private String attrName;

	/**
	 * 属性类型
	 */
	@TableField("attr_type")
	private String attrType;

	/**
	 * 属性包名
	 */
	@TableField("package_name")
	private String packageName;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 自动填充 DEFAULT、INSERT、UPDATE、INSERT_UPDATE
	 */
	@TableField("auto_fill")
	private String autoFill;

	/**
	 * 主键 0：否 1：是
	 */
	@TableField("primary_pk")
	private String primaryPk;

	/**
	 * 基类字段 0：否 1：是
	 */
	@TableField("base_field")
	private String baseField;

	/**
	 * 表单项 0：否 1：是
	 */
	@TableField("form_item")
	private String formItem;

	/**
	 * 表单必填 0：否 1：是
	 */
	@TableField("form_required")
	private String formRequired;

	/**
	 * 表单类型
	 */
	@TableField("form_type")
	private String formType;

	/**
	 * 表单效验
	 */
	@TableField("form_validator")
	private String formValidator;

	/**
	 * 列表项 0：否 1：是
	 */
	@TableField("grid_item")
	private String gridItem;

	/**
	 * 列表排序 0：否 1：是
	 */
	@TableField("grid_sort")
	private String gridSort;

	/**
	 * 查询项 0：否 1：是
	 */
	@TableField("query_item")
	private String queryItem;

	/**
	 * 查询方式
	 */
	@TableField("query_type")
	private String queryType;

	/**
	 * 查询表单类型
	 */
	@TableField("query_form_type")
	private String queryFormType;

	/**
	 * 字典类型
	 */
	@TableField("field_dict")
	private String fieldDict;

	/**
	 * 创建人
	 */
	@TableField("create_id")
	private Integer createId;

	/**
	 * 创建时间
	 */
	@TableField("create_time")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField("update_time")
	private LocalDateTime updateTime;

}
