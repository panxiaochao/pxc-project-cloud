package io.github.panxiaochao.system.common.core.generator;

import io.github.panxiaochao.system.common.core.token.PAccessToken;
import io.github.panxiaochao.system.common.core.tokentype.AbstractPTokenType;
import io.github.panxiaochao.system.common.core.tokentype.PUuidTokenType;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class PUuidTokenGenerator implements PTokenGenerator<PAccessToken> {

	/**
	 * 生成令牌根据令牌类型
	 * @param pTokenType 令牌类型
	 * @return 令牌
	 */
	@Override
	public PAccessToken generate(AbstractPTokenType pTokenType) {
		if (!PUuidTokenType.UUID_TOKEN.equals(pTokenType)) {
			return null;
		}

		return null;
	}

}
