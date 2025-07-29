package io.github.panxiaochao.system.development.application.api.request.onlinetable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 【在线数据表】创建请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "在线数据表 创建请求对象")
public class OnlineTableCreateRequest {

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
	 * 项目版本号
	 */
	@Schema(description = "项目版本号")
	private String version;

	/**
	 * 数据源ID
	 */
	@Schema(description = "数据源ID")
	private Integer datasourceId;

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
