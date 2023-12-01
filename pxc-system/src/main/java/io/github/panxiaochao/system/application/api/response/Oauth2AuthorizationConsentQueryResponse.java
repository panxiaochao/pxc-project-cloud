package io.github.panxiaochao.system.application.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "查询响应对象")
public class Oauth2AuthorizationConsentQueryResponse {

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
