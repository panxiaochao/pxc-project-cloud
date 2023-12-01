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
@TableName("oauth2_authorization")
public class Oauth2AuthorizationPO {

	@TableId(value = "id", type = IdType.ASSIGN_UUID)
	private String id;

	@TableField("registered_client_id")
	private String registeredClientId;

	@TableField("principal_name")
	private String principalName;

	@TableField("authorization_grant_type")
	private String authorizationGrantType;

	@TableField("authorized_scopes")
	private String authorizedScopes;

	@TableField("attributes")
	private byte[] attributes;

	@TableField("state")
	private String state;

	@TableField("authorization_code_value")
	private byte[] authorizationCodeValue;

	@TableField("authorization_code_issued_at")
	private LocalDateTime authorizationCodeIssuedAt;

	@TableField("authorization_code_expires_at")
	private LocalDateTime authorizationCodeExpiresAt;

	@TableField("authorization_code_metadata")
	private byte[] authorizationCodeMetadata;

	@TableField("access_token_value")
	private byte[] accessTokenValue;

	@TableField("access_token_issued_at")
	private LocalDateTime accessTokenIssuedAt;

	@TableField("access_token_expires_at")
	private LocalDateTime accessTokenExpiresAt;

	@TableField("access_token_metadata")
	private byte[] accessTokenMetadata;

	@TableField("access_token_type")
	private String accessTokenType;

	@TableField("access_token_scopes")
	private String accessTokenScopes;

	@TableField("oidc_id_token_value")
	private byte[] oidcIdTokenValue;

	@TableField("oidc_id_token_issued_at")
	private LocalDateTime oidcIdTokenIssuedAt;

	@TableField("oidc_id_token_expires_at")
	private LocalDateTime oidcIdTokenExpiresAt;

	@TableField("oidc_id_token_metadata")
	private byte[] oidcIdTokenMetadata;

	@TableField("refresh_token_value")
	private byte[] refreshTokenValue;

	@TableField("refresh_token_issued_at")
	private LocalDateTime refreshTokenIssuedAt;

	@TableField("refresh_token_expires_at")
	private LocalDateTime refreshTokenExpiresAt;

	@TableField("refresh_token_metadata")
	private byte[] refreshTokenMetadata;

}
