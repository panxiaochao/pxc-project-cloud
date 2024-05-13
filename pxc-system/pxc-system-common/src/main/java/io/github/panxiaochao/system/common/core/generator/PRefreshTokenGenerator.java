package io.github.panxiaochao.system.common.core.generator;

import io.github.panxiaochao.core.utils.RandomUtil;
import io.github.panxiaochao.system.common.core.context.PTokenContext;
import io.github.panxiaochao.system.common.core.token.PRefreshToken;
import io.github.panxiaochao.system.common.core.tokentype.PTokenType;

import java.time.Duration;
import java.time.Instant;
import java.util.Base64;

/**
 * <p>
 * 刷新令牌生成
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class PRefreshTokenGenerator implements PTokenGenerator<PRefreshToken> {

	/**
	 * 生成令牌根据令牌类型
	 * @param pTokenContext token上下文
	 * @return 令牌
	 */
	@Override
	public PRefreshToken generate(PTokenContext pTokenContext) {
		if (!PTokenType.REFRESH_TOKEN.equals(pTokenContext.getPTokenType())) {
			return null;
		}

		Instant issuedAt = Instant.now();
		Long refreshTokenTimeToLive = pTokenContext.getRefreshTokenTimeToLive();
		Instant expiresAt = issuedAt.plus(Duration.ofSeconds(refreshTokenTimeToLive));
		return new PRefreshToken(generateKey(), issuedAt, expiresAt);
	}

	public String generateKey() {
		final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		byte[] key = RandomUtil.getBytesRandom(96);
		byte[] base64EncodedKey = encoder.encode(key);
		return new String(base64EncodedKey);
	}

}
