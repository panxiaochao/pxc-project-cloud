package io.github.panxiaochao.system.development.application.api.response.gen;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 预览模版代码 响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Getter
@Setter
@ToString
@Schema(description = "预览模版代码响应对象")
@AllArgsConstructor
public class PreviewResponse {

	/**
	 * 文件id
	 */
	@Schema(description = "文件id")
	private String id;

	/**
	 * 文件名称
	 */
	@Schema(description = "文件名称")
	private String fileName;

	/**
	 * 文件路径
	 */
	@Schema(description = "文件路径")
	private String filePath;

	/**
	 * 文件内容
	 */
	@Schema(description = "文件内容")
	private String content;

	/**
	 * 代码类型
	 */
	@Schema(description = "代码类型")
	private String codeType;

}
