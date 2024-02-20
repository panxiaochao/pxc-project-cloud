package io.github.panxiaochao.system.application.api.response.oauth2registeredclient;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "响应对象")
public class Oauth2RegisteredClientResponse {

	/**
	 *
	 */
	@Schema(description = "")
	private String id;

	/**
	 *
	*/
	@Schema(description = "")
	private String clientId;

	/**
	 *
	*/
	@Schema(description = "")
	private LocalDateTime clientIdIssuedAt;

	/**
	 *
	*/
	@Schema(description = "")
	private String clientSecret;

	/**
	 *
	*/
	@Schema(description = "")
	private LocalDateTime clientSecretExpiresAt;

	/**
	 *
	*/
	@Schema(description = "")
	private String clientName;

	/**
	 *
	*/
	@Schema(description = "")
	private String clientAuthenticationMethods;

	/**
	 *
	*/
	@Schema(description = "")
	private String authorizationGrantTypes;

	/**
	 *
	*/
	@Schema(description = "")
	private String redirectUris;

	/**
	 *
	*/
	@Schema(description = "")
	private String scopes;

	/**
	 *
	*/
	@Schema(description = "")
	private String clientSettings;

	/**
	 *
	*/
	@Schema(description = "")
	private String tokenSettings;

}
