package io.github.panxiaochao.system.development.application.api.request.gengroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <p>
 * 模板分组创建请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Getter
@Setter
@ToString
@Schema(description = "模板分组创建请求对象")
public class GenGroupCreateRequest {

	/**
	 * 分组名称
	 */
	@Schema(description = "分组名称")
	private String groupName;

	/**
	 * 分组描述
	 */
	@Schema(description = "分组描述")
	private String groupDesc;

	/**
	 * 模版类型数组
	 */
	@Schema(description = "模版类型数组")
	private List<String> templateIds;

}
