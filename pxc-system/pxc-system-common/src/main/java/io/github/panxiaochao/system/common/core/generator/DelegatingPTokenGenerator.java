package io.github.panxiaochao.system.common.core.generator;

import io.github.panxiaochao.system.common.core.token.PToken;
import io.github.panxiaochao.system.common.core.tokentype.AbstractPTokenType;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class DelegatingPTokenGenerator implements PTokenGenerator<PToken> {

	private final List<PTokenGenerator<PToken>> tokenGenerators;

	/**
	 * 构造函数
	 * @param tokenGenerators an array of {@link PTokenGenerator}(s)
	 */
	@SafeVarargs
	public DelegatingPTokenGenerator(PTokenGenerator<? extends PToken>... tokenGenerators) {
		Assert.notEmpty(tokenGenerators, "tokenGenerators cannot be empty");
		Assert.noNullElements(tokenGenerators, "tokenGenerator cannot be null");
		this.tokenGenerators = Collections.unmodifiableList(asList(tokenGenerators));
	}

	@Nullable
	@Override
	public PToken generate(AbstractPTokenType pTokenType) {
		for (PTokenGenerator<PToken> tokenGenerator : this.tokenGenerators) {
			PToken token = tokenGenerator.generate(pTokenType);
			if (token != null) {
				return token;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private static List<PTokenGenerator<PToken>> asList(PTokenGenerator<? extends PToken>... tokenGenerators) {
		List<PTokenGenerator<PToken>> tokenGeneratorList = new ArrayList<>();
		for (PTokenGenerator<? extends PToken> tokenGenerator : tokenGenerators) {
			tokenGeneratorList.add((PTokenGenerator<PToken>) tokenGenerator);
		}
		return tokenGeneratorList;
	}

}
