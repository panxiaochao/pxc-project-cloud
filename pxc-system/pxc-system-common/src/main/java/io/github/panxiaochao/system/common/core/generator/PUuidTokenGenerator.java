package io.github.panxiaochao.system.common.core.generator;

import io.github.panxiaochao.core.utils.UuidUtil;
import io.github.panxiaochao.system.common.core.context.PTokenContext;
import io.github.panxiaochao.system.common.core.token.PAccessToken;
import io.github.panxiaochao.system.common.core.tokentype.PTokenType;

import java.time.Duration;
import java.time.Instant;

/**
 * <p>
 * UUID-令牌生成
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class PUuidTokenGenerator implements PTokenGenerator<PAccessToken> {

	/**
	 * 生成令牌根据令牌类型
	 * @param pTokenContext token上下文
	 * @return 令牌
	 */
	@Override
	public PAccessToken generate(PTokenContext pTokenContext) {
		if (!PTokenType.UUID_TOKEN.equals(pTokenContext.getPTokenType())
				&& !PTokenType.SIMPLE_UUID_TOKEN.equals(pTokenContext.getPTokenType())) {
			return null;
		}

		Instant issuedAt = Instant.now();
		Long accessTokenTimeToLive = pTokenContext.getAccessTokenTimeToLive();
		Instant expiresAt = issuedAt.plus(Duration.ofSeconds(accessTokenTimeToLive));
		// Token 风格
		String tokenValue;
		if (PTokenType.UUID_TOKEN.equals(pTokenContext.getPTokenType())) {
			tokenValue = UuidUtil.getUUID();
		}
		else {
			tokenValue = UuidUtil.getSimpleUUID();
		}
		return new PAccessToken(PAccessToken.TokenType.BEARER, tokenValue, issuedAt, expiresAt);
	}

}
