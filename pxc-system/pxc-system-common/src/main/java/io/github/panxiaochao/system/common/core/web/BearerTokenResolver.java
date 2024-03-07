package io.github.panxiaochao.system.common.core.web;

import io.github.panxiaochao.core.ienums.IEnum;
import io.github.panxiaochao.system.common.core.web.exception.TokenResolverException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public class BearerTokenResolver implements TokenResolver {

	private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+=*)$",
			Pattern.CASE_INSENSITIVE);

	private boolean allowFormEncodedBodyParameter = false;

	private boolean allowUriQueryParameter = false;

	private String bearerTokenHeaderName = HttpHeaders.AUTHORIZATION;

	private String tokenType;

	/**
	 * Resolve any Bearer Token value from the request.
	 * @param request the request
	 * @return the Token value or {@code null} if none found
	 */
	@Override
	public String resolve(final HttpServletRequest request) {
		final String authorizationHeaderToken = resolveFromAuthorizationHeader(request);
		final String parameterToken = isParameterTokenSupportedForRequest(request)
				? resolveFromRequestParameters(request) : null;
		if (authorizationHeaderToken != null) {
			if (parameterToken != null) {
				throw new TokenResolverException(BearerTokenErrorEnum.BEARER_TOKEN_INVALID_REQUEST,
						"Found multiple bearer tokens in the request");
			}
			return authorizationHeaderToken;
		}
		if (parameterToken != null && isParameterTokenEnabledForRequest(request)) {
			return parameterToken;
		}
		return null;
	}

	/**
	 * Set the TokenType from the token value prefix
	 * @param tokenType the TokenType
	 */
	@Override
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@Override
	public String getTokenType() {
		return this.tokenType;
	}

	/**
	 * Set if transport of access token using form-encoded body parameter is supported.
	 * Defaults to {@code false}.
	 * @param allowFormEncodedBodyParameter if the form-encoded body parameter is
	 * supported
	 */
	public void setAllowFormEncodedBodyParameter(boolean allowFormEncodedBodyParameter) {
		this.allowFormEncodedBodyParameter = allowFormEncodedBodyParameter;
	}

	/**
	 * Set if transport of access token using URI query parameter is supported. Defaults
	 * to {@code false}.
	 *
	 * The spec recommends against using this mechanism for sending bearer tokens, and
	 * even goes as far as stating that it was only included for completeness.
	 * @param allowUriQueryParameter if the URI query parameter is supported
	 */
	public void setAllowUriQueryParameter(boolean allowUriQueryParameter) {
		this.allowUriQueryParameter = allowUriQueryParameter;
	}

	/**
	 * Set this value to configure what header is checked when resolving a Bearer Token.
	 * This value is defaulted to {@link HttpHeaders#AUTHORIZATION}.
	 *
	 * This allows other headers to be used as the Bearer Token source such as
	 * {@link HttpHeaders#PROXY_AUTHORIZATION}
	 * @param bearerTokenHeaderName the header to check when retrieving the Bearer Token.
	 */
	public void setBearerTokenHeaderName(String bearerTokenHeaderName) {
		this.bearerTokenHeaderName = bearerTokenHeaderName;
	}

	private String resolveFromAuthorizationHeader(HttpServletRequest request) {
		String authorization = request.getHeader(this.bearerTokenHeaderName);
		if (!StringUtils.startsWithIgnoreCase(authorization, this.tokenType)) {
			return null;
		}
		Matcher matcher = AUTHORIZATION_PATTERN.matcher(authorization);
		if (!matcher.matches()) {
			throw new TokenResolverException(BearerTokenErrorEnum.BEARER_TOKEN_INVALID_TOKEN,
					"Bearer token is malformed");
		}
		return matcher.group("token");
	}

	private static String resolveFromRequestParameters(HttpServletRequest request) {
		String[] values = request.getParameterValues("access_token");
		if (values == null || values.length == 0) {
			return null;
		}
		if (values.length == 1) {
			return values[0];
		}
		throw new TokenResolverException(BearerTokenErrorEnum.BEARER_TOKEN_INVALID_REQUEST,
				"Found multiple bearer tokens in the request");
	}

	private boolean isParameterTokenSupportedForRequest(final HttpServletRequest request) {
		return (("POST".equals(request.getMethod())
				&& MediaType.APPLICATION_FORM_URLENCODED_VALUE.equals(request.getContentType()))
				|| "GET".equals(request.getMethod()));
	}

	private boolean isParameterTokenEnabledForRequest(final HttpServletRequest request) {
		return ((this.allowFormEncodedBodyParameter && "POST".equals(request.getMethod())
				&& MediaType.APPLICATION_FORM_URLENCODED_VALUE.equals(request.getContentType()))
				|| (this.allowUriQueryParameter && "GET".equals(request.getMethod())));
	}

	/**
	 * Bearer token 错误码
	 */
	@Getter
	@AllArgsConstructor
	enum BearerTokenErrorEnum implements IEnum<Integer> {

		/**
		 * Invalid request
		 */
		BEARER_TOKEN_INVALID_REQUEST(10300, "Invalid request"),
		/**
		 * Invalid token
		 */
		BEARER_TOKEN_INVALID_TOKEN(10301, "Invalid token");

		private final Integer code;

		private final String message;

	}

}
