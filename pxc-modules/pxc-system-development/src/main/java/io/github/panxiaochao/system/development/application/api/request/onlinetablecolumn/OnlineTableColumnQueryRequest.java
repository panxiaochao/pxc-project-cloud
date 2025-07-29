package io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 【在线数据表字段】查询请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "在线数据表字段 查询请求对象")
public class OnlineTableColumnQueryRequest {

	/**
	 * 主键
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
	 * 字段长度
	 */
	@Schema(description = "字段长度")
	private Integer columnSize;

	/**
	 * 字段小数位
	 */
	@Schema(description = "字段小数位")
	private Integer scale;

	/**
	 * 字段默认值
	 */
	@Schema(description = "字段默认值")
	private String fieldDefault;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;

	/**
	 * 主键 0：否 1：是
	 */
	@Schema(description = "主键 0：否  1：是")
	private String primaryPk;

	/**
	 * 是否自增 0：否 1：是
	 */
	@Schema(description = "是否自增 0：否 1：是")
	private String autoIncrement;

	/**
	 * 是否可空 0：否 1：是
	 */
	@Schema(description = "是否可空 0：否  1：是")
	private String nullable;

	/**
	 * 创建人
	 */
	@Schema(description = "创建人")
	private Integer createId;

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
