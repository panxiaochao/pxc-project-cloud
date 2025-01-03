package io.github.panxiaochao.system.code.generator.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 代码生成表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Getter
@Setter
@TableName("gen_table")
public class GenTablePO {

	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 表名
	 */
	@TableField("`table_name`")
	private String tableName;

	/**
	 * 类名
	 */
	@TableField("class_name")
	private String className;

	/**
	 * 说明
	 */
	@TableField("table_comment")
	private String tableComment;

	/**
	 * 作者
	 */
	@TableField("author")
	private String author;

	/**
	 * 邮箱
	 */
	@TableField("email")
	private String email;

	/**
	 * 项目包名
	 */
	@TableField("package_name")
	private String packageName;

	/**
	 * 项目版本号
	 */
	@TableField("version")
	private String version;

	/**
	 * 代码风格
	 */
	@TableField("style")
	private Long style;

	/**
	 * 子表名称
	 */
	@TableField("child_table_name")
	private String childTableName;

	/**
	 * 主表关联键
	 */
	@TableField("main_field")
	private String mainField;

	/**
	 * 子表关联键
	 */
	@TableField("child_field")
	private String childField;

	/**
	 * 生成方式 0：zip压缩包 1：自定义目录
	 */
	@TableField("generator_type")
	private String generatorType;

	/**
	 * 后端生成路径
	 */
	@TableField("backend_path")
	private String backendPath;

	/**
	 * 前端生成路径
	 */
	@TableField("frontend_path")
	private String frontendPath;

	/**
	 * 模块名
	 */
	@TableField("module_name")
	private String moduleName;

	/**
	 * 功能名
	 */
	@TableField("function_name")
	private String functionName;

	/**
	 * 表单布局 1：一列 2：两列
	 */
	@TableField("form_layout")
	private String formLayout;

	/**
	 * 数据源ID
	 */
	@TableField("datasource_id")
	private Integer datasourceId;

	/**
	 * 基类ID
	 */
	@TableField("baseclass_id")
	private Long baseclassId;

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
