package io.github.panxiaochao.system.common.core.token;

import java.time.Instant;

/**
 * <p>
 * 基于{@link AbstractPToken}实现的刷新令牌
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class PRefreshToken extends AbstractPToken {

	/**
	 * 构造函数.
	 * @param tokenValue 令牌
	 * @param issuedAt 颁发令牌的时间
	 */
	public PRefreshToken(String tokenValue, Instant issuedAt) {
		this(tokenValue, issuedAt, null);
	}

	/**
	 * 构造函数.
	 * @param tokenValue 令牌
	 * @param issuedAt 颁发令牌的时间
	 * @param expiresAt 令牌的到期时间
	 */
	protected PRefreshToken(String tokenValue, Instant issuedAt, Instant expiresAt) {
		super(tokenValue, issuedAt, expiresAt);
	}

}
