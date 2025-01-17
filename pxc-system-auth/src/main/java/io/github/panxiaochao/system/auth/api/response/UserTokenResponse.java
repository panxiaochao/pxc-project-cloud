package io.github.panxiaochao.system.auth.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>用户Token对象
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-17
 * @version 1.0
 */
@Getter
@Setter
@Schema(description = "用户Token对象")
public class UserTokenResponse {
    /**
     * 授权令牌
     */
    @JsonProperty("access_token")
    @Schema(description = "授权令牌")
    private String accessToken;

    /**
     * 刷新令牌
     */
    @JsonProperty("refresh_token")
    @Schema(description = "刷新令牌")
    private String refreshToken;

    /**
     * 授权令牌 access_token 的有效期, 默认秒
     */
    @JsonProperty("expire_in")
    @Schema(description = "授权令牌 access_token 的有效期, 默认秒")
    private long expireIn;

    /**
     * 刷新令牌 refresh_token 的有效期, 默认秒
     */
    @JsonProperty("refresh_expire_in")
    @Schema(description = "刷新令牌 refresh_token 的有效期, 默认秒")
    private long refreshExpireIn;

    /**
     * token_type
     */
    @JsonProperty("token_type")
    @Schema(description = "token_type")
    private String tokenType = "Bearer";

    /**
     * 令牌权限
     */
    // private String scope;
}
