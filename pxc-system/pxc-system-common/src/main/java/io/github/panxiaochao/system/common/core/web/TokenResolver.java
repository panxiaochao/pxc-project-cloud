package io.github.panxiaochao.system.common.core.web;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public interface TokenResolver {

	/**
	 * Resolve any Token value from the request.
	 * @param request the request
	 * @return the Token value or {@code null} if none found
	 */
	String resolve(HttpServletRequest request);

	/**
	 * Set the TokenType from the token value prefix
	 * @param tokenType the TokenType
	 */
	void setTokenType(String tokenType);

	/**
	 * Get the TokenType
	 * @return the TokenType value
	 */
	String getTokenType();

}
