package io.github.panxiaochao.system.development.application.api.request.databasefieldtag;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】创建请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "数据库字段类型-数据库标签表 创建请求对象")
public class DatabaseFieldTagCreateRequest {

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

}
