package io.github.panxiaochao.system.common.jwt;

import io.github.panxiaochao.system.common.core.token.AbstractPToken;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
public class Jwt extends AbstractPToken {

	private final Map<String, Object> headers;

	private final Map<String, Object> claims;

	/**
	 * 构造函数.
	 * @param tokenValue 令牌
	 */
	protected Jwt(String tokenValue, Instant issuedAt, Instant expiresAt, Map<String, Object> headers,
			Map<String, Object> claims) {
		super(tokenValue, issuedAt, expiresAt);
		Assert.notEmpty(headers, "headers cannot be empty");
		Assert.notEmpty(claims, "claims cannot be empty");
		this.headers = Collections.unmodifiableMap(new LinkedHashMap<>(headers));
		this.claims = Collections.unmodifiableMap(new LinkedHashMap<>(claims));
	}

	/**
	 * Returns the JOSE header(s).
	 * @return a {@code Map} of the JOSE header(s)
	 */
	public Map<String, Object> getHeaders() {
		return this.headers;
	}

	/**
	 * Returns the JWT Claims Set.
	 * @return a {@code Map} of the JWT Claims Set
	 */
	public Map<String, Object> getClaims() {
		return this.claims;
	}

	/**
	 * Returns the claim value as a {@code T} type. The claim value is expected to be of
	 * type {@code T}.
	 * @param claim the name of the claim
	 * @param <T> the type of the claim value
	 * @return the claim value
	 */
	@SuppressWarnings("unchecked")
	public <T> T getClaim(String claim) {
		return !hasClaim(claim) ? null : (T) getClaims().get(claim);
	}

	/**
	 * Returns {@code true} if the claim exists in {@link #getClaims()}, otherwise
	 * {@code false}.
	 * @param claim the name of the claim
	 * @return {@code true} if the claim exists, otherwise {@code false}
	 */
	public boolean hasClaim(String claim) {
		Assert.notNull(claim, "claim cannot be null");
		return getClaims().containsKey(claim);
	}

	/**
	 * Return a {@link Jwt.Builder}
	 * @return A {@link Jwt.Builder}
	 */
	public static Builder withTokenValue(String tokenValue) {
		return new Builder(tokenValue);
	}

	/**
	 * Helps configure a {@link Jwt}
	 *
	 * @author Jérôme Wacongne &lt;ch4mp&#64;c4-soft.com&gt;
	 * @author Josh Cummings
	 * @since 5.2
	 */
	public static final class Builder {

		private String tokenValue;

		private final Map<String, Object> claims = new LinkedHashMap<>();

		private final Map<String, Object> headers = new LinkedHashMap<>();

		private Builder(String tokenValue) {
			this.tokenValue = tokenValue;
		}

		/**
		 * Use this token value in the resulting {@link Jwt}
		 * @param tokenValue The token value to use
		 * @return the {@link Builder} for further configurations
		 */
		public Builder tokenValue(String tokenValue) {
			this.tokenValue = tokenValue;
			return this;
		}

		/**
		 * Use this claim in the resulting {@link Jwt}
		 * @param name The claim name
		 * @param value The claim value
		 * @return the {@link Builder} for further configurations
		 */
		public Builder claim(String name, Object value) {
			this.claims.put(name, value);
			return this;
		}

		/**
		 * Provides access to every {@link #claim(String, Object)} declared so far with
		 * the possibility to add, replace, or remove.
		 * @param claimsConsumer the consumer
		 * @return the {@link Builder} for further configurations
		 */
		public Builder claims(Consumer<Map<String, Object>> claimsConsumer) {
			claimsConsumer.accept(this.claims);
			return this;
		}

		/**
		 * Use this header in the resulting {@link Jwt}
		 * @param name The header name
		 * @param value The header value
		 * @return the {@link Builder} for further configurations
		 */
		public Builder header(String name, Object value) {
			this.headers.put(name, value);
			return this;
		}

		/**
		 * Provides access to every {@link #header(String, Object)} declared so far with
		 * the possibility to add, replace, or remove.
		 * @param headersConsumer the consumer
		 * @return the {@link Builder} for further configurations
		 */
		public Builder headers(Consumer<Map<String, Object>> headersConsumer) {
			headersConsumer.accept(this.headers);
			return this;
		}

		/**
		 * Sets a single-valued audience ({@code aud}) claim.
		 * @param aud The audience claim, {@code null} if not specified.
		 * @return This builder.
		 */
		public Builder audience(final String aud) {
			if (aud == null) {
				claims.put(com.nimbusds.jwt.JWTClaimNames.AUDIENCE, null);
			}
			else {
				claims.put(com.nimbusds.jwt.JWTClaimNames.AUDIENCE, Collections.singletonList(aud));
			}
			return this;
		}

		/**
		 * Use this audience in the resulting {@link Jwt}
		 * @param audience The audience(s) to use
		 * @return the {@link Builder} for further configurations
		 */
		public Builder audience(Collection<String> audience) {
			return claim(JwtClaimNames.AUD, audience);
		}

		/**
		 * Use this expiration in the resulting {@link Jwt}
		 * @param expiresAt The expiration to use
		 * @return the {@link Builder} for further configurations
		 */
		public Builder expiresAt(Instant expiresAt) {
			this.claim(JwtClaimNames.EXP, expiresAt);
			return this;
		}

		/**
		 * Use this identifier in the resulting {@link Jwt}
		 * @param jti The identifier to use
		 * @return the {@link Builder} for further configurations
		 */
		public Builder jti(String jti) {
			this.claim(JwtClaimNames.JTI, jti);
			return this;
		}

		/**
		 * Use this issued-at timestamp in the resulting {@link Jwt}
		 * @param issuedAt The issued-at timestamp to use
		 * @return the {@link Builder} for further configurations
		 */
		public Builder issuedAt(Instant issuedAt) {
			this.claim(JwtClaimNames.IAT, issuedAt);
			return this;
		}

		/**
		 * Use this issuer in the resulting {@link Jwt}
		 * @param issuer The issuer to use
		 * @return the {@link Builder} for further configurations
		 */
		public Builder issuer(String issuer) {
			this.claim(JwtClaimNames.ISS, issuer);
			return this;
		}

		/**
		 * Use this not-before timestamp in the resulting {@link Jwt}
		 * @param notBefore The not-before timestamp to use
		 * @return the {@link Builder} for further configurations
		 */
		public Builder notBefore(Instant notBefore) {
			this.claim(JwtClaimNames.NBF, notBefore);
			return this;
		}

		/**
		 * Use this subject in the resulting {@link Jwt}
		 * @param subject The subject to use
		 * @return the {@link Builder} for further configurations
		 */
		public Builder subject(String subject) {
			this.claim(JwtClaimNames.SUB, subject);
			return this;
		}

		/**
		 * Build the {@link Jwt}
		 * @return The constructed {@link Jwt}
		 */
		public Jwt build() {
			Instant iat = toInstant(this.claims.get(JwtClaimNames.IAT));
			Instant exp = toInstant(this.claims.get(JwtClaimNames.EXP));
			return new Jwt(this.tokenValue, iat, exp, this.headers, this.claims);
		}

		private Instant toInstant(Object timestamp) {
			if (timestamp != null) {
				Assert.isInstanceOf(Instant.class, timestamp, "timestamps must be of type Instant");
			}
			return (Instant) timestamp;
		}

	}

}
