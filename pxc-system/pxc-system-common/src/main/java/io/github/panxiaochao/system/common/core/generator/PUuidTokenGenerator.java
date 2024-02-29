package io.github.panxiaochao.system.common.core.generator;

import io.github.panxiaochao.system.common.core.context.PTokenContext;
import io.github.panxiaochao.system.common.core.token.PAccessToken;
import io.github.panxiaochao.system.common.core.tokentype.PUuidTokenType;

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
		if (!PUuidTokenType.UUID_TOKEN.equals(pTokenContext.getPTokenType())) {
			return null;
		}

		return null;
	}

}
