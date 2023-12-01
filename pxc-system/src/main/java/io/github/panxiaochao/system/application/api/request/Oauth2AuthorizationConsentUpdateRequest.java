package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class Oauth2AuthorizationConsentUpdateRequest {

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
	private String authorities;

}
