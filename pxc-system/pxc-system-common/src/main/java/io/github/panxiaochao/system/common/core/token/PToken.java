package io.github.panxiaochao.system.common.core.token;

import org.springframework.lang.Nullable;

import java.time.Instant;

/**
 * <p>
 * PToken 令牌核心接口.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 * @see AbstractPToken
 */
public interface PToken {

	/**
	 * 返回令牌.
	 * @return the token value
	 */
	String getTokenValue();

	/**
	 * 返回颁发令牌的时间.
	 * @return the time the token was issued or {@code null}
	 */
	@Nullable
	default Instant getIssuedAt() {
		return null;
	}

	/**
	 * 返回令牌的到期时间.
	 * @return the token expiration time or {@code null}
	 */
	@Nullable
	default Instant getExpiresAt() {
		return null;
	}

}
