package io.github.panxiaochao.system.development.application.api.request.gengroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 模板分组查询请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Getter
@Setter
@ToString
@Schema(description = "模板分组查询请求对象")
public class GenGroupQueryRequest {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

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

}
