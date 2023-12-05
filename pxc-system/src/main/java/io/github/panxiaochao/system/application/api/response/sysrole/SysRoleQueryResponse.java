package io.github.panxiaochao.system.application.api.response.sysrole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 角色表查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "角色表查询响应对象")
public class SysRoleQueryResponse {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private String id;

    /**
    * 角色名称
    */
    @Schema(description = "角色名称")
    private String roleName;

    /**
    * 角色code
    */
    @Schema(description = "角色code")
    private String roleCode;

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
