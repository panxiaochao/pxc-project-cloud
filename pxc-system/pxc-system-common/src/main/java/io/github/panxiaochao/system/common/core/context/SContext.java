package io.github.panxiaochao.system.common.core.context;

import io.github.panxiaochao.system.common.core.token.PToken;

import java.io.Serializable;

/**
 * <p>
 * SecurityContext interface
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-06
 * @version 1.0
 */
public interface SContext extends Serializable {

	/**
	 * Obtains the currently PToken.
	 * @return the <code>PToken</code> or <code>null</code> if no PToken information is
	 * available
	 */
	PToken getToken();

	/**
	 * Changes the currently PToken, or removes the PToken information.
	 * @param token the new <code>PToken</code> token, or <code>null</code> if no further
	 * PToken information should be stored
	 */
	void setToken(PToken token);

}
