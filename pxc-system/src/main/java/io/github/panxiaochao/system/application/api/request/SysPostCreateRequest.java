package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 岗位表创建请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@ToString
@Schema(description = "岗位表创建请求对象")
public class SysPostCreateRequest {

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
	 * 描述
	 */
	@Schema(description = "描述")
	private String description;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;

	/**
	 * 状态：1正常，0不正常
	 */
	@Schema(description = "状态：1正常，0不正常")
	private String status;

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

}
