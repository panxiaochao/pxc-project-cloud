package io.github.panxiaochao.system.development.application.api.request.gentable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 多数据源表请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Getter
@Setter
@ToString
@Schema(description = "多数据源表查询请求对象")
public class DsQueryRequest {

	/**
	 * 表名
	 */
	@Schema(description = "表名")
	private String tableName;

	/**
	 * 数据源名
	 */
	@Schema(description = "数据源名")
	private String dbName;

}
