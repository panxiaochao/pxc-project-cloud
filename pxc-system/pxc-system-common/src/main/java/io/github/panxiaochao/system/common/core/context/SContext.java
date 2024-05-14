package io.github.panxiaochao.system.common.core.context;

import io.github.panxiaochao.system.common.model.LoginUser;

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
	 * Obtains the currently LoginUser.
	 * @return the <code>LoginUser</code> or <code>null</code> if no LoginUser information is
	 * available
	 */
	LoginUser getLoginUser();

	/**
	 * Changes the currently LoginUser, or removes the LoginUser information.
	 * @param loginUser the new <code>LoginUser</code>
	 * PToken information should be stored
	 */
	void setLoginUser(LoginUser loginUser);

}
