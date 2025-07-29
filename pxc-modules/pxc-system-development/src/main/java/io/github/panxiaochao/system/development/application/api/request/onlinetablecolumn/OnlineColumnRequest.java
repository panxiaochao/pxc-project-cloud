package io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <p>
 * 【在线字段】请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "在线字段 请求对象")
public class OnlineColumnRequest {

	/**
	 * 字段名称
	 */
	@Schema(description = "字段名称")
	private String fieldName;

	/**
	 * 字段类型
	 */
	@Schema(description = "字段类型")
	private List<String> fieldType;

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
	private boolean primaryPk;

	/**
	 * 是否自增 0：否 1：是
	 */
	@Schema(description = "是否自增 0：否 1：是")
	private boolean autoIncrement;

	/**
	 * 是否可空 0：否 1：是
	 */
	@Schema(description = "是否可空 0：否  1：是")
	private boolean nullable;

}
