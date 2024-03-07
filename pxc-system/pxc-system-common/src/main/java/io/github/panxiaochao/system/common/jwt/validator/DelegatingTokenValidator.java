package io.github.panxiaochao.system.common.jwt.validator;

import io.github.panxiaochao.system.common.core.token.AbstractPToken;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public class DelegatingTokenValidator<T extends AbstractPToken> implements TokenValidator<T> {

	private final Collection<TokenValidator<T>> tokenValidators;

	/**
	 * Constructs a {@code DelegatingTokenValidator} using the provided validators.
	 * @param tokenValidators the {@link Collection} of {@link TokenValidator}s to use
	 */
	public DelegatingTokenValidator(Collection<TokenValidator<T>> tokenValidators) {
		Assert.notNull(tokenValidators, "tokenValidators cannot be null");
		this.tokenValidators = new ArrayList<>(tokenValidators);
	}

	/**
	 * Constructs a {@code DelegatingTokenValidator} using the provided validators.
	 * @param tokenValidators the collection of {@link TokenValidator}s to use
	 */
	@SafeVarargs
	public DelegatingTokenValidator(TokenValidator<T>... tokenValidators) {
		this(Arrays.asList(tokenValidators));
	}

	@Override
	public boolean validate(T token) {
		List<Boolean> errors = new ArrayList<>();
		for (TokenValidator<T> validator : this.tokenValidators) {
			errors.add(validator.validate(token));
		}
		return errors.stream().allMatch(s -> s.equals(Boolean.TRUE));
	}

}
