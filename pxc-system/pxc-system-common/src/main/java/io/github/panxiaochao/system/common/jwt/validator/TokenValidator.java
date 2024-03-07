package io.github.panxiaochao.system.common.jwt.validator;

import io.github.panxiaochao.system.common.core.token.AbstractPToken;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
@FunctionalInterface
public interface TokenValidator<T extends AbstractPToken> {

	/**
	 * Verify the validity and/or constraints of the provided OAuth 2.0 Token.
	 * @param token an OAuth 2.0 token
	 */
	boolean validate(T token);

}
