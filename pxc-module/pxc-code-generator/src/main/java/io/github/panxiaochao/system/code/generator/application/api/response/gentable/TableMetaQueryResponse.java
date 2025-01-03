package io.github.panxiaochao.system.code.generator.application.api.response.gentable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 数据库表元数据查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Getter
@Setter
@ToString
@Schema(description = "数据库表元数据查询响应对象")
public class TableMetaQueryResponse {

	/**
	 * 数据库 名
	 */
	@Schema(description = "数据库 名")
	private String schema;

	/**
	 * 数据库 目录
	 */
	@Schema(description = "数据库 目录")
	private String catalog;

	/**
	 * 数据库 表名
	 */
	@Schema(description = "数据库 表名")
	private String tableName;

	/**
	 * 表 注释
	 */
	@Schema(description = "表 注释")
	private String tableComment;

	/**
	 * 表 类型
	 */
	@Schema(description = "表 类型")
	private String tableType;

}
