package io.github.panxiaochao.system.application.api.response.sysuserrole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户角色表查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "用户角色表查询响应对象")
public class SysUserRoleQueryResponse {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private String id;

    /**
    * 用户ID
    */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
    * 角色ID
    */
    @Schema(description = "角色ID")
    private Integer roleId;

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
