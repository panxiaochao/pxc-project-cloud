package io.github.panxiaochao.system.common.core.token;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collections;
import java.util.Set;

/**
 * <p>
 * 基于{@link AbstractPToken}实现的访问令牌
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class PAccessToken extends AbstractPToken {

	private final TokenType tokenType;

	private final Set<String> scopes;

	/**
	 * 构造函数.
	 * @param tokenType the access token type
	 * @param tokenValue 令牌
	 * @param issuedAt 颁发令牌的时间
	 * @param expiresAt 令牌的到期时间
	 */
	protected PAccessToken(TokenType tokenType, String tokenValue, Instant issuedAt, Instant expiresAt) {
		this(tokenType, tokenValue, issuedAt, expiresAt, Collections.emptySet());
	}

	/**
	 * 构造函数.
	 * @param tokenType the access token type
	 * @param tokenValue 令牌
	 * @param issuedAt 颁发令牌的时间
	 * @param expiresAt 令牌的到期时间
	 * @param scopes 令牌作用域（权限域）
	 */
	protected PAccessToken(TokenType tokenType, String tokenValue, Instant issuedAt, Instant expiresAt,
			Set<String> scopes) {
		super(tokenValue, issuedAt, expiresAt);
		Assert.notNull(tokenType, "tokenType cannot be null");
		this.tokenType = tokenType;
		this.scopes = Collections.unmodifiableSet((scopes != null) ? scopes : Collections.emptySet());
	}

	/**
	 * Returns the {@link TokenType token type}.
	 * @return the {@link TokenType}
	 */
	public TokenType getTokenType() {
		return this.tokenType;
	}

	/**
	 * Returns the scope(s) associated to the token.
	 * @return the scope(s) associated to the token
	 */
	public Set<String> getScopes() {
		return this.scopes;
	}

	/**
	 * Access Token Types.
	 *
	 * @see <a target="_blank" href=
	 * "https://tools.ietf.org/html/rfc6749#section-7.1">Section 7.1 Access Token
	 * Types</a>
	 */
	public static class TokenType implements Serializable {

		private static final long serialVersionUID = 1L;

		public static final TokenType BEARER = new TokenType("Bearer");

		private final String value;

		private TokenType(String value) {
			Assert.hasText(value, "value cannot be empty");
			this.value = value;
		}

		/**
		 * Returns the value of the token type.
		 * @return the value of the token type
		 */
		public String getValue() {
			return this.value;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || this.getClass() != obj.getClass()) {
				return false;
			}
			TokenType that = (TokenType) obj;
			return this.getValue().equalsIgnoreCase(that.getValue());
		}

		@Override
		public int hashCode() {
			return this.getValue().hashCode();
		}

	}

}
