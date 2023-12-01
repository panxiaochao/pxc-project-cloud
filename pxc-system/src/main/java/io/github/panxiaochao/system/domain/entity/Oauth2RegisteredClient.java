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
public class Oauth2RegisteredClient {

	/**
	*
	*/
	private String id;

	/**
	 *
	 */
	private String clientId;

	/**
	 *
	 */
	private LocalDateTime clientIdIssuedAt;

	/**
	 *
	 */
	private String clientSecret;

	/**
	 *
	 */
	private LocalDateTime clientSecretExpiresAt;

	/**
	 *
	 */
	private String clientName;

	/**
	 *
	 */
	private String clientAuthenticationMethods;

	/**
	 *
	 */
	private String authorizationGrantTypes;

	/**
	 *
	 */
	private String redirectUris;

	/**
	 *
	 */
	private String scopes;

	/**
	 *
	 */
	private String clientSettings;

	/**
	 *
	 */
	private String tokenSettings;

}
