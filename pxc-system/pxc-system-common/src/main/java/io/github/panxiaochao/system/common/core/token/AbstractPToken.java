package io.github.panxiaochao.system.common.core.token;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.time.Instant;

/**
 * <p>
 * PToken 令牌实现基类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public abstract class AbstractPToken implements PToken, Serializable {

	private static final long serialVersionUID = 1L;

	private final String tokenValue;

	private final Instant issuedAt;

	private final Instant expiresAt;

	/**
	 * 构造函数.
	 * @param tokenValue 令牌
	 */
	protected AbstractPToken(String tokenValue) {
		this(tokenValue, null, null);
	}

	/**
	 * 构造函数.
	 * @param tokenValue 令牌
	 * @param issuedAt 颁发令牌的时间
	 * @param expiresAt 令牌的到期时间
	 */
	protected AbstractPToken(String tokenValue, @Nullable Instant issuedAt, @Nullable Instant expiresAt) {
		Assert.hasText(tokenValue, "tokenValue cannot be empty");
		if (issuedAt != null && expiresAt != null) {
			Assert.isTrue(expiresAt.isAfter(issuedAt), "expiresAt must be after issuedAt");
		}
		this.tokenValue = tokenValue;
		this.issuedAt = issuedAt;
		this.expiresAt = expiresAt;
	}

	/**
	 * 返回令牌.
	 * @return the token value
	 */
	@Override
	public String getTokenValue() {
		return this.tokenValue;
	}

	/**
	 * 返回颁发令牌的时间.
	 * @return the time the token was issued or {@code null}
	 */
	@Override
	public Instant getIssuedAt() {
		return this.issuedAt;
	}

	/**
	 * 返回令牌的到期时间.
	 * @return the token expiration time or {@code null}
	 */
	@Override
	public Instant getExpiresAt() {
		return this.expiresAt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		AbstractPToken other = (AbstractPToken) obj;
		if (!this.getTokenValue().equals(other.getTokenValue())) {
			return false;
		}
		if ((this.getIssuedAt() != null) ? !this.getIssuedAt().equals(other.getIssuedAt())
				: other.getIssuedAt() != null) {
			return false;
		}
		return (this.getExpiresAt() != null) ? this.getExpiresAt().equals(other.getExpiresAt())
				: other.getExpiresAt() == null;
	}

	@Override
	public int hashCode() {
		int result = this.getTokenValue().hashCode();
		result = 31 * result + ((this.getIssuedAt() != null) ? this.getIssuedAt().hashCode() : 0);
		result = 31 * result + ((this.getExpiresAt() != null) ? this.getExpiresAt().hashCode() : 0);
		return result;
	}

}
