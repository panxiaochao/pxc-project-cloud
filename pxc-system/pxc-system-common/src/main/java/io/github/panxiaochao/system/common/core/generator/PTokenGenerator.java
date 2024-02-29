package io.github.panxiaochao.system.common.core.generator;

import io.github.panxiaochao.system.common.core.context.PTokenContext;
import io.github.panxiaochao.system.common.core.token.PToken;
import org.springframework.lang.Nullable;

/**
 * <p>
 * 令牌生成核心接口
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 * @param <T> the type of the PToken
 */
@FunctionalInterface
public interface PTokenGenerator<T extends PToken> {

	/**
	 * 生成令牌根据令牌类型
	 * @param pTokenContext token上下文
	 * @return 令牌
	 */
	@Nullable
	T generate(PTokenContext pTokenContext);

}
