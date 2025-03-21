package io.github.panxiaochao.system.development.application.api.request.gentemplategroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 模板分组关联表更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Getter
@Setter
@ToString
@Schema(description = "模板分组关联表更新请求对象")
public class GenTemplateGroupUpdateRequest {

	/**
	 * 分组id
	 */
	@Schema(description = "分组id")
	private String groupId;

	/**
	 * 模板id
	 */
	@Schema(description = "模板id")
	private String templateId;

}
