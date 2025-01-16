package io.github.panxiaochao.system.development.application.api.request.databasefieldtype;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 数据库字段类型码表创建请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Getter
@Setter
@ToString
@Schema(description = "数据库字段类型码表创建请求对象")
public class DatabaseFieldTypeCreateRequest {

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
