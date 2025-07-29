package io.github.panxiaochao.system.development.application.api.request.onlinetable;

import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineColumnRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <p>
 * 【在线数据表和字段数组】请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "在线数据表和字段数组 请求对象")
public class OnlineTableAndColumnsRequest {

	/**
	 * 表名
	 */
	@Schema(description = "表名")
	private String tableName;

	/**
	 * 说明
	 */
	@Schema(description = "说明")
	private String tableComment;

	/**
	 * 数据源ID
	 */
	@Schema(description = "数据源ID")
	private Integer datasourceId;

	/**
	 * 字段数组
	 */
	@Schema(description = "字段数组")
	private List<OnlineColumnRequest> columns;

}
