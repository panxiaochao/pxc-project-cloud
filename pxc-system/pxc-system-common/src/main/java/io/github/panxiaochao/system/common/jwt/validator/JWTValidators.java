package io.github.panxiaochao.system.common.jwt.validator;

import io.github.panxiaochao.system.common.jwt.Jwt;
import io.github.panxiaochao.system.common.jwt.JwtClaimNames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * Provides factory methods for creating {@code OAuth2TokenValidator<Jwt>}
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public class JWTValidators {

	private JWTValidators() {
	}

	/**
	 * <p>
	 * Create a {@link Jwt} Validator that contains all standard validators when an issuer
	 * is known.
	 * </p>
	 * <p>
	 * User's wanting to leverage the defaults plus additional validation can add the
	 * result of this method to {@code DelegatingOAuth2TokenValidator} along with the
	 * additional validators.
	 * </p>
	 * @param issuer the issuer
	 * @return - a delegating validator containing all standard validators as well as any
	 * supplied
	 */
	public static TokenValidator<Jwt> createDefaultWithIssuer(String issuer) {
		List<TokenValidator<Jwt>> validators = new ArrayList<>();
		validators.add(new JWTTimestampValidator());
		validators.add(new JWTClaimValidator<>(JwtClaimNames.EXP, Objects::nonNull));
		return new DelegatingTokenValidator<>(validators);
	}

	/**
	 * <p>
	 * Create a {@link Jwt} Validator that contains all standard validators.
	 * </p>
	 * <p>
	 * User's wanting to leverage the defaults plus additional validation can add the
	 * result of this method to {@code DelegatingOAuth2TokenValidator} along with the
	 * additional validators.
	 * </p>
	 * @return - a delegating validator containing all standard validators as well as any
	 * supplied
	 */
	public static TokenValidator<Jwt> createDefault() {
		return new DelegatingTokenValidator<>(Collections.singletonList(new JWTTimestampValidator()));
	}

}
