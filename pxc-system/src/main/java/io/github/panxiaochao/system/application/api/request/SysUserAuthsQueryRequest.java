package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户授权信息表查询请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "用户授权信息表查询请求对象")
public class SysUserAuthsQueryRequest {

	/**
	 * 唯一标识
	 */
	@Schema(description = "唯一标识")
    private String id;

    /**
     * 关联用户ID
     */
    @Schema(description = "关联用户ID")
    private Integer userId;

    /**
     * 登录类型(手机号/邮箱/用户名/微信/微博/QQ）等
     */
    @Schema(description = "登录类型(手机号/邮箱/用户名/微信/微博/QQ）等")
    private String identityType;

    /**
     * 登录标识(手机号/邮箱/用户名/微信/微博/QQ）等唯一标识，等同于登录账号
     */
    @Schema(description = "登录标识(手机号/邮箱/用户名/微信/微博/QQ）等唯一标识，等同于登录账号")
    private String identifier;

    /**
     * 密码凭证（自建密码，或者第三方access_token）
     */
    @Schema(description = "密码凭证（自建密码，或者第三方access_token）")
    private String credential;

    /**
     * 是否已经验证：1验证，0未验证
     */
    @Schema(description = "是否已经验证：1验证，0未验证")
    private String verified;

    /**
     * 登录标识失效时间
     */
    @Schema(description = "登录标识失效时间")
    private LocalDateTime expireTime;

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
