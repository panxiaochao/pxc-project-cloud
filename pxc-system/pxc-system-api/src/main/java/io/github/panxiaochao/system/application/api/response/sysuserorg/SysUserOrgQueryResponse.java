package io.github.panxiaochao.system.application.api.response.sysuserorg;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户机构/部门表查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "用户机构/部门表查询响应对象")
public class SysUserOrgQueryResponse {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 用户ID
	 */
	@Schema(description = "用户ID")
	private String userId;

	/**
	 * 机构ID
	 */
	@Schema(description = "机构ID")
	private String orgId;

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
