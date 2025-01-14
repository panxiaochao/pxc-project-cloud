package io.github.panxiaochao.system.development.application.api.request.gentablecolumn;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 代码生成表字段查询请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Getter
@Setter
@ToString
@Schema(description = "代码生成表字段查询请求对象")
public class GenTableColumnQueryRequest {

	/**
	 *主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 表ID
	 */
	@Schema(description = "表ID")
	private String tableId;

	/**
	 * 表名称
	 */
	@Schema(description = "表名称")
	private String tableName;

	/**
	 * 字段名称
	 */
	@Schema(description = "字段名称")
	private String fieldName;

	/**
	 * 字段类型
	 */
	@Schema(description = "字段类型")
	private String fieldType;

	/**
	 * 字段说明
	 */
	@Schema(description = "字段说明")
	private String fieldComment;

	/**
	 * 属性名
	 */
	@Schema(description = "属性名")
	private String attrName;

	/**
	 * 属性类型
	 */
	@Schema(description = "属性类型")
	private String attrType;

	/**
	 * 属性包名
	 */
	@Schema(description = "属性包名")
	private String packageName;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private String sort;

	/**
	 * 自动填充 DEFAULT、INSERT、UPDATE、INSERT_UPDATE
	 */
	@Schema(description = "自动填充  DEFAULT、INSERT、UPDATE、INSERT_UPDATE")
	private String autoFill;

	/**
	 * 主键 0：否 1：是
	 */
	@Schema(description = "主键 0：否  1：是")
	private String primaryPk;

	/**
	 * 基类字段 0：否 1：是
	 */
	@Schema(description = "基类字段 0：否  1：是")
	private String baseField;

	/**
	 * 表单项 0：否 1：是
	 */
	@Schema(description = "表单项 0：否  1：是")
	private String formItem;

	/**
	 * 表单必填 0：否 1：是
	 */
	@Schema(description = "表单必填 0：否  1：是")
	private String formRequired;

	/**
	 * 表单类型
	 */
	@Schema(description = "表单类型")
	private String formType;

	/**
	 * 表单效验
	 */
	@Schema(description = "表单效验")
	private String formValidator;

	/**
	 * 列表项 0：否 1：是
	 */
	@Schema(description = "列表项 0：否  1：是")
	private String gridItem;

	/**
	 * 列表排序 0：否 1：是
	 */
	@Schema(description = "列表排序 0：否  1：是")
	private String gridSort;

	/**
	 * 查询项 0：否 1：是
	 */
	@Schema(description = "查询项 0：否  1：是")
	private String queryItem;

	/**
	 * 查询方式
	 */
	@Schema(description = "查询方式")
	private String queryType;

	/**
	 * 查询表单类型
	 */
	@Schema(description = "查询表单类型")
	private String queryFormType;

	/**
	 * 字典类型
	 */
	@Schema(description = "字典类型")
	private String fieldDict;

	/**
	 * 创建人
	 */
	@Schema(description = "创建人")
	private String createId;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@Schema(description = "更新时间")
	private LocalDateTime updateTime;

}
