package io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "更新请求对象")
public class Oauth2AuthorizationUpdateRequest {

	/**
	 *
	 */
	@Schema(description = "")
	private String id;

	/**
	 *
	 */
	@Schema(description = "")
	private String registeredClientId;

	/**
	 *
	 */
	@Schema(description = "")
	private String principalName;

	/**
	 *
	 */
	@Schema(description = "")
	private String authorizationGrantType;

	/**
	 *
	 */
	@Schema(description = "")
	private String authorizedScopes;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] attributes;

	/**
	 *
	 */
	@Schema(description = "")
	private String state;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] authorizationCodeValue;

	/**
	 *
	 */
	@Schema(description = "")
	private LocalDateTime authorizationCodeIssuedAt;

	/**
	 *
	 */
	@Schema(description = "")
	private LocalDateTime authorizationCodeExpiresAt;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] authorizationCodeMetadata;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] accessTokenValue;

	/**
	 *
	 */
	@Schema(description = "")
	private LocalDateTime accessTokenIssuedAt;

	/**
	 *
	 */
	@Schema(description = "")
	private LocalDateTime accessTokenExpiresAt;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] accessTokenMetadata;

	/**
	 *
	 */
	@Schema(description = "")
	private String accessTokenType;

	/**
	 *
	 */
	@Schema(description = "")
	private String accessTokenScopes;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] oidcIdTokenValue;

	/**
	 *
	 */
	@Schema(description = "")
	private LocalDateTime oidcIdTokenIssuedAt;

	/**
	 *
	 */
	@Schema(description = "")
	private LocalDateTime oidcIdTokenExpiresAt;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] oidcIdTokenMetadata;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] refreshTokenValue;

	/**
	 *
	 */
	@Schema(description = "")
	private LocalDateTime refreshTokenIssuedAt;

	/**
	 *
	 */
	@Schema(description = "")
	private LocalDateTime refreshTokenExpiresAt;

	/**
	 *
	 */
	@Schema(description = "")
	private byte[] refreshTokenMetadata;

}
