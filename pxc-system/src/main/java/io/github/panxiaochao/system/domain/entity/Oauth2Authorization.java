package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class Oauth2Authorization {

	/**
	*
	*/
	private String id;

	/**
	 *
	 */
	private String registeredClientId;

	/**
	 *
	 */
	private String principalName;

	/**
	 *
	 */
	private String authorizationGrantType;

	/**
	 *
	 */
	private String authorizedScopes;

	/**
	 *
	 */
	private byte[] attributes;

	/**
	 *
	 */
	private String state;

	/**
	 *
	 */
	private byte[] authorizationCodeValue;

	/**
	 *
	 */
	private LocalDateTime authorizationCodeIssuedAt;

	/**
	 *
	 */
	private LocalDateTime authorizationCodeExpiresAt;

	/**
	 *
	 */
	private byte[] authorizationCodeMetadata;

	/**
	 *
	 */
	private byte[] accessTokenValue;

	/**
	 *
	 */
	private LocalDateTime accessTokenIssuedAt;

	/**
	 *
	 */
	private LocalDateTime accessTokenExpiresAt;

	/**
	 *
	 */
	private byte[] accessTokenMetadata;

	/**
	 *
	 */
	private String accessTokenType;

	/**
	 *
	 */
	private String accessTokenScopes;

	/**
	 *
	 */
	private byte[] oidcIdTokenValue;

	/**
	 *
	 */
	private LocalDateTime oidcIdTokenIssuedAt;

	/**
	 *
	 */
	private LocalDateTime oidcIdTokenExpiresAt;

	/**
	 *
	 */
	private byte[] oidcIdTokenMetadata;

	/**
	 *
	 */
	private byte[] refreshTokenValue;

	/**
	 *
	 */
	private LocalDateTime refreshTokenIssuedAt;

	/**
	 *
	 */
	private LocalDateTime refreshTokenExpiresAt;

	/**
	 *
	 */
	private byte[] refreshTokenMetadata;

}
