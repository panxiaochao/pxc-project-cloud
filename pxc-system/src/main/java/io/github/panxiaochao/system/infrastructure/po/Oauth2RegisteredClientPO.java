package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("oauth2_registered_client")
public class Oauth2RegisteredClientPO {

	@TableId(value = "id", type = IdType.ASSIGN_UUID)
	private String id;

	@TableField("client_id")
	private String clientId;

	@TableField("client_id_issued_at")
	private LocalDateTime clientIdIssuedAt;

	@TableField("client_secret")
	private String clientSecret;

	@TableField("client_secret_expires_at")
	private LocalDateTime clientSecretExpiresAt;

	@TableField("client_name")
	private String clientName;

	@TableField("client_authentication_methods")
	private String clientAuthenticationMethods;

	@TableField("authorization_grant_types")
	private String authorizationGrantTypes;

	@TableField("redirect_uris")
	private String redirectUris;

	@TableField("scopes")
	private String scopes;

	@TableField("client_settings")
	private String clientSettings;

	@TableField("token_settings")
	private String tokenSettings;

}
