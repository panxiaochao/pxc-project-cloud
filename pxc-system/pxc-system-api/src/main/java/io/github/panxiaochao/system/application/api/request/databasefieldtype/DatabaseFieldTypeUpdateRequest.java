package io.github.panxiaochao.system.application.api.request.databasefieldtype;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 数据库字段类型码表更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Getter
@Setter
@ToString
@Schema(description = "数据库字段类型码表更新请求对象")
public class DatabaseFieldTypeUpdateRequest {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 数据库类型
	 */
	@Schema(description = "数据库类型")
	private String dbType;

	/**
	 * 数据库字段类型
	 */
	@Schema(description = "数据库字段类型")
	private String columnType;

	/**
	 * 对应Java属性类型
	 */
	@Schema(description = "对应Java属性类型")
	private String javaType;

	/**
	 * 对应Java包名
	 */
	@Schema(description = "对应Java包名")
	private String packageName;

}
