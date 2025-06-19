package io.github.panxiaochao.system.development.application.api.response.gengroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 模板分组响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Getter
@Setter
@ToString
@Schema(description = "模板分组响应对象")
public class GenGroupResponse {

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

	/**
	 * 模版类型数组
	 */
	@Schema(description = "模版类型数组")
	private List<String> templateIds;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@Schema(description = "更新时间")
	private LocalDateTime updateTime;

	/**
	 * 创建人
	 */
	@Schema(description = "创建人")
	private String createId;

	/**
	 * 修改人
	 */
	@Schema(description = "修改人")
	private String updateId;

}
