package io.github.panxiaochao.system.development.application.api.request.gentemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 模板更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Getter
@Setter
@ToString
@Schema(description = "模板更新请求对象")
public class GenTemplateUpdateRequest {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 模板名称
	 */
	@Schema(description = "模板名称")
	private String templateName;

	/**
	 * 模板路径
	 */
	@Schema(description = "模板路径")
	private String generatorPath;

	/**
	 * 模板描述
	 */
	@Schema(description = "模板描述")
	private String templateDesc;

	/**
	 * 模板代码
	 */
	@Schema(description = "模板代码")
	private String templateCode;

	/**
	 * 模板类型
	 */
	@Schema(description = "模板类型")
	private String templateType;

}
