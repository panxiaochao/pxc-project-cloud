package io.github.panxiaochao.system.common.jwt.validator;

import io.github.panxiaochao.system.common.jwt.Jwt;
import io.github.panxiaochao.system.common.jwt.JwtClaimNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public class JWTTimestampValidator implements TokenValidator<Jwt> {

	/**
	 * LOGGER JwtTimestampValidator.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JWTTimestampValidator.class);

	private static final Duration DEFAULT_MAX_CLOCK_SKEW = Duration.of(60, ChronoUnit.SECONDS);

	private final Duration clockSkew;

	private Clock clock = Clock.systemUTC();

	/**
	 * A basic instance with no custom verification and the default max clock skew
	 */
	public JWTTimestampValidator() {
		this(DEFAULT_MAX_CLOCK_SKEW);
	}

	public JWTTimestampValidator(Duration clockSkew) {
		Assert.notNull(clockSkew, "clockSkew cannot be null");
		this.clockSkew = clockSkew;
	}

	@Override
	public boolean validate(Jwt jwt) {
		Assert.notNull(jwt, "jwt cannot be null");
		Instant expiry = jwt.getExpiresAt();
		if (expiry != null) {
			if (Instant.now(this.clock).minus(this.clockSkew).isAfter(expiry)) {
				tokenError(String.format("Jwt expired at %s", jwt.getExpiresAt()));
				return false;
			}
		}
		Date notBefore = (Date) jwt.getClaims().get(JwtClaimNames.NBF);
		if (notBefore != null) {
			if (Instant.now(this.clock).plus(this.clockSkew).isBefore(notBefore.toInstant())) {
				tokenError(String.format("Jwt used before %s", notBefore));
				return false;
			}
		}
		return true;
	}

	private void tokenError(String reason) {
		LOGGER.error("invalid_token, {}", reason);
	}

	/**
	 * Use this {@link Clock} with {@link Instant#now()} for assessing timestamp validity
	 * @param clock 时钟
	 */
	public void setClock(Clock clock) {
		Assert.notNull(clock, "clock cannot be null");
		this.clock = clock;
	}

}
