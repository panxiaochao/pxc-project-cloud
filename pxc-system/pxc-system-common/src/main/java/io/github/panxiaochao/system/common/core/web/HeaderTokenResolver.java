package io.github.panxiaochao.system.common.core.web;

import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Generic resolver extracting pre-authenticated JWT identity from a custom header.
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public class HeaderTokenResolver implements TokenResolver {

	private final String header;

	public HeaderTokenResolver(String header) {
		Assert.hasText(header, "header cannot be empty");
		this.header = header;
	}

	@Override
	public String resolve(HttpServletRequest request) {
		return request.getHeader(this.header);
	}

	/**
	 * Set the TokenType from the token value prefix
	 * @param tokenType the TokenType
	 */
	@Override
	public void setTokenType(String tokenType) {
	}

	/**
	 * Get the TokenType
	 * @return the TokenType value
	 */
	@Override
	public String getTokenType() {
		return "";
	}

}
