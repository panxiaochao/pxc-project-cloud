package io.github.panxiaochao.system.development.application.api.response.databasefieldtag;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "数据库字段类型-数据库标签表 查询响应对象")
public class DatabaseFieldTagQueryResponse {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 数据库字段类型码表ID
	 */
	@Schema(description = "数据库字段类型码表ID")
	private Integer fieldTypeId;

	/**
	 * 数据库类型标签
	 */
	@Schema(description = "数据库类型标签")
	private String tag;

	/**
	 * 数据库字段类型
	 */
	@Schema(description = "数据库字段类型")
	private String columnType;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private LocalDateTime createAt;

}
