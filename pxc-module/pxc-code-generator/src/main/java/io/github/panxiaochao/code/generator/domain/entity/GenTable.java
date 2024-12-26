package io.github.panxiaochao.code.generator.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 代码生成表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Getter
@Setter
@ToString
public class GenTable {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 类名
	 */
	private String className;

	/**
	 * 说明
	 */
	private String tableComment;

	/**
	 * 作者
	 */
	private String author;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 项目包名
	 */
	private String packageName;

	/**
	 * 项目版本号
	 */
	private String version;

	/**
	 * 代码风格
	 */
	private String style;

	/**
	 * 子表名称
	 */
	private String childTableName;

	/**
	 * 主表关联键
	 */
	private String mainField;

	/**
	 * 子表关联键
	 */
	private String childField;

	/**
	 * 生成方式 0：zip压缩包 1：自定义目录
	 */
	private String generatorType;

	/**
	 * 后端生成路径
	 */
	private String backendPath;

	/**
	 * 前端生成路径
	 */
	private String frontendPath;

	/**
	 * 模块名
	 */
	private String moduleName;

	/**
	 * 功能名
	 */
	private String functionName;

	/**
	 * 表单布局 1：一列 2：两列
	 */
	private String formLayout;

	/**
	 * 数据源ID
	 */
	private String datasourceId;

	/**
	 * 基类ID
	 */
	private String baseclassId;

	/**
	 * 创建人
	 */
	private String createId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
