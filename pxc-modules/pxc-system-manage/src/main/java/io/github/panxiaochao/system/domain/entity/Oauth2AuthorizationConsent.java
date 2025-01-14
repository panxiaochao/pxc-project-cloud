package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class Oauth2AuthorizationConsent {

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
	private String authorities;

}
