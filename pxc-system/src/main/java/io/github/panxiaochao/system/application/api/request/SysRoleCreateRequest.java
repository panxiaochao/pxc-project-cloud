package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>角色表创建请求对象</p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Getter
@Setter
@ToString
@Schema(description = "角色表创建请求对象")
public class SysRoleCreateRequest {

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
