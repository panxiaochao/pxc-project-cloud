package io.github.panxiaochao.system.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户Token
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-26
 * @version 1.0
 */
@Getter
@Setter
public class AuthUserToken {

	/**
	 * 授权令牌
	 */
	@JsonProperty("access_token")
	private String accessToken;

	/**
	 * 刷新令牌
	 */
	@JsonProperty("refresh_token")
	private String refreshToken;

	/**
	 * 授权令牌 access_token 的有效期
	 */
	@JsonProperty("expire_in")
	private Long expireIn;

	/**
	 * 刷新令牌 refresh_token 的有效期
	 */
	@JsonProperty("refresh_expire_in")
	private Long refreshExpireIn;

	/**
	 * 应用id
	 */
	@JsonProperty("token_type")
	private String tokenType;

	/**
	 * 令牌权限
	 */
	private String scope;

}
