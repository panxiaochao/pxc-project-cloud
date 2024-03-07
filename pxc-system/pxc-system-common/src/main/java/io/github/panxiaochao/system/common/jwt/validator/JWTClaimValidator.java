package io.github.panxiaochao.system.common.jwt.validator;

import io.github.panxiaochao.system.common.jwt.Jwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.function.Predicate;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public class JWTClaimValidator<T> implements TokenValidator<Jwt> {

	/**
	 * LOGGER JWTClaimValidator.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JWTClaimValidator.class);

	private final String claim;

	private final Predicate<T> test;

	/**
	 * Constructs a {@link JWTClaimValidator} using the provided parameters
	 * @param claim - is the name of the claim in {@link Jwt} to validate.
	 * @param test - is the predicate function for the claim to test against.
	 */
	public JWTClaimValidator(String claim, Predicate<T> test) {
		Assert.notNull(claim, "claim can not be null");
		Assert.notNull(test, "test can not be null");
		this.claim = claim;
		this.test = test;
	}

	@Override
	public boolean validate(Jwt token) {
		Assert.notNull(token, "token cannot be null");
		T claimValue = token.getClaim(this.claim);
		if (this.test.test(claimValue)) {
			return true;
		}
		LOGGER.error("Invalid token, {}", "The " + this.claim + " claim is not valid");
		return false;
	}

}
