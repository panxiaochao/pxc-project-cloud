package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 岗位表更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "岗位表更新请求对象")
public class SysPostUpdateRequest {

	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 岗位名称
	 */
	@Schema(description = "岗位名称")
	private String postName;

	/**
	 * 岗位编码
	 */
	@Schema(description = "岗位编码")
	private String postCode;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;

	/**
	 * 状态：1正常，0不正常
	 */
	@Schema(description = "状态：1正常，0不正常")
	private String state;

}
