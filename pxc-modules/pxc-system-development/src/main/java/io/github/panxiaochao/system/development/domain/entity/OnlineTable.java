package io.github.panxiaochao.system.development.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 【在线数据表】实体.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class OnlineTable {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 说明
	 */
	private String tableComment;

	/**
	 * 项目版本号
	 */
	private String version;

	/**
	 * 数据源ID
	 */
	private Integer datasourceId;

	/**
	 * 创建人
	 */
	private Integer createId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
