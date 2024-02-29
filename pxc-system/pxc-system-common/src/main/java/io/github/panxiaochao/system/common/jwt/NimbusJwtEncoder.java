package io.github.panxiaochao.system.common.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.factories.DefaultJWSSignerFactory;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.KeyType;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.produce.JWSSignerFactory;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import io.github.panxiaochao.core.ienums.IEnum;
import io.github.panxiaochao.system.common.jwt.exception.JwtEncodingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
public class NimbusJwtEncoder implements JwtEncoder {

	private static final String ENCODING_ERROR_MESSAGE_TEMPLATE = "An error occurred while attempting to encode the Jwt: %s";

	private static final JWSHeader DEFAULT_JWS_HEADER = new JWSHeader.Builder(JWSAlgorithm.RS256)
		.keyID(UUID.randomUUID().toString())
		.build();

	private static final JWSSignerFactory JWS_SIGNER_FACTORY = new DefaultJWSSignerFactory();

	private final Map<JWK, JWSSigner> jwsSigners = new ConcurrentHashMap<>();

	private final JWKSource<SecurityContext> jwkSource;

	/**
	 * Constructs a {@code NimbusJwtEncoder} using the provided parameters.
	 * @param jwkSource the {@code com.nimbusds.jose.jwk.source.JWKSource}
	 */
	public NimbusJwtEncoder(JWKSource<SecurityContext> jwkSource) {
		Assert.notNull(jwkSource, "jwkSource cannot be null");
		this.jwkSource = jwkSource;
	}

	@Override
	public Jwt encode(JWSHeader jwsHeader, JWTClaimsSet claims) {
		if (jwsHeader == null) {
			jwsHeader = DEFAULT_JWS_HEADER;
		}
		JWK jwk = selectJwk(jwsHeader);
		jwsHeader = addKeyIdentifierHeadersIfNecessary(jwsHeader, jwk);
		String jws = serialize(jwsHeader, claims, jwk);

		return new Jwt(jws, claims.getIssueTime().toInstant(), claims.getExpirationTime().toInstant(),
				jwsHeader.toJSONObject(), claims.getClaims());
	}

	private JWK selectJwk(JWSHeader headers) {
		List<JWK> jwks;
		try {
			JWKSelector jwkSelector = new JWKSelector(createJwkMatcher(headers));
			jwks = this.jwkSource.get(jwkSelector, null);
		}
		catch (Exception ex) {
			throw new JwtEncodingException(JwtEncoderErrorEnum.JWT_ENCODER_ERROR,
					String.format(JwtEncoderErrorEnum.JWT_ENCODER_ERROR.getMessage(),
							"Failed to select a JWK signing key -> " + ex.getMessage()),
					ex);
		}

		if (jwks.size() > 1) {
			throw new JwtEncodingException(JwtEncoderErrorEnum.JWT_ENCODER_ERROR, String.format(
					JwtEncoderErrorEnum.JWT_ENCODER_ERROR.getMessage(),
					"Found multiple JWK signing keys for algorithm '" + headers.getAlgorithm().getName() + "'"));
		}

		if (jwks.isEmpty()) {
			throw new JwtEncodingException(JwtEncoderErrorEnum.JWT_ENCODER_ERROR, String
				.format(JwtEncoderErrorEnum.JWT_ENCODER_ERROR.getMessage(), "Failed to select a JWK signing key"));
		}

		return jwks.get(0);
	}

	private String serialize(JWSHeader headers, JWTClaimsSet claims, JWK jwk) {
		JWSHeader jwsHeader = convert(headers);
		JWTClaimsSet jwtClaimsSet = convert(claims);
		JWSSigner jwsSigner = this.jwsSigners.computeIfAbsent(jwk, NimbusJwtEncoder::createSigner);
		SignedJWT signedJwt = new SignedJWT(jwsHeader, jwtClaimsSet);
		try {
			signedJwt.sign(jwsSigner);
		}
		catch (JOSEException ex) {
			throw new JwtEncodingException(JwtEncoderErrorEnum.JWT_ENCODER_ERROR,
					String.format(JwtEncoderErrorEnum.JWT_ENCODER_ERROR.getMessage(),
							"Failed to sign the JWT -> " + ex.getMessage()),
					ex);
		}
		return signedJwt.serialize();
	}

	private static JWKMatcher createJwkMatcher(JWSHeader headers) {
		JWSAlgorithm jwsAlgorithm = JWSAlgorithm.parse(headers.getAlgorithm().getName());
		if (JWSAlgorithm.Family.RSA.contains(jwsAlgorithm) || JWSAlgorithm.Family.EC.contains(jwsAlgorithm)) {
			// @formatter:off
            return new JWKMatcher.Builder()
                    .keyType(KeyType.forAlgorithm(jwsAlgorithm))
                    .keyID(headers.getKeyID())
                    .keyUses(KeyUse.SIGNATURE, null)
                    .algorithms(jwsAlgorithm, null)
                    .x509CertSHA256Thumbprint(headers.getX509CertSHA256Thumbprint())
                    .build();
            // @formatter:on
		}
		else if (JWSAlgorithm.Family.HMAC_SHA.contains(jwsAlgorithm)) {
			// @formatter:off
            return new JWKMatcher.Builder()
                    .keyType(KeyType.forAlgorithm(jwsAlgorithm))
                    .keyID(headers.getKeyID())
                    .privateOnly(true)
                    .algorithms(jwsAlgorithm, null)
                    .build();
            // @formatter:on
		}
		return null;
	}

	private static JWSHeader addKeyIdentifierHeadersIfNecessary(JWSHeader headers, JWK jwk) {
		// Check if headers have already been added
		if (StringUtils.hasText(headers.getKeyID()) && null != headers.getX509CertSHA256Thumbprint()) {
			return headers;
		}
		// Check if headers can be added from JWK
		if (!StringUtils.hasText(jwk.getKeyID()) && jwk.getX509CertSHA256Thumbprint() == null) {
			return headers;
		}

		JWSHeader.Builder headersBuilder = new JWSHeader.Builder(headers);
		if (!StringUtils.hasText(headers.getKeyID()) && StringUtils.hasText(jwk.getKeyID())) {
			headersBuilder.keyID(jwk.getKeyID());
		}
		if (null != headers.getX509CertSHA256Thumbprint() && null != jwk.getX509CertSHA256Thumbprint()) {
			headersBuilder.x509CertSHA256Thumbprint(jwk.getX509CertSHA256Thumbprint());
		}

		return headersBuilder.build();
	}

	private static JWSSigner createSigner(JWK jwk) {
		try {
			return JWS_SIGNER_FACTORY.createJWSSigner(jwk);
		}
		catch (JOSEException ex) {
			throw new JwtEncodingException(JwtEncoderErrorEnum.JWT_ENCODER_ERROR,
					String.format(JwtEncoderErrorEnum.JWT_ENCODER_ERROR.getMessage(),
							"Failed to create a JWS Signer -> " + ex.getMessage()),
					ex);
		}
	}

	private static JWSHeader convert(JWSHeader headers) {
		JWSHeader.Builder builder = new JWSHeader.Builder(JWSAlgorithm.parse(headers.getAlgorithm().getName()));

		if (headers.getJWKURL() != null) {
			builder.jwkURL(headers.getJWKURL());
		}

		JWK jwk = headers.getJWK();
		if (null != jwk) {
			builder.jwk(jwk);
		}

		String keyId = headers.getKeyID();
		if (StringUtils.hasText(keyId)) {
			builder.keyID(keyId);
		}

		if (headers.getX509CertURL() != null) {
			builder.x509CertURL(headers.getX509CertURL());
		}

		List<Base64> x509CertificateChain = headers.getX509CertChain();
		if (!CollectionUtils.isEmpty(x509CertificateChain)) {
			builder.x509CertChain(x509CertificateChain);
		}

		// Base64URL x509SHA1Thumbprint = headers.getX509CertSHA256Thumbprint();
		// if (null != x509SHA1Thumbprint) {
		// builder.x509CertThumbprint(x509SHA1Thumbprint);
		// }

		Base64URL x509SHA256Thumbprint = headers.getX509CertSHA256Thumbprint();
		if (null != x509SHA256Thumbprint) {
			builder.x509CertSHA256Thumbprint(x509SHA256Thumbprint);
		}

		JOSEObjectType type = headers.getType();
		if (null != type) {
			builder.type(type);
		}

		String contentType = headers.getContentType();
		if (StringUtils.hasText(contentType)) {
			builder.contentType(contentType);
		}

		Set<String> critical = headers.getCriticalParams();
		if (!CollectionUtils.isEmpty(critical)) {
			builder.criticalParams(critical);
		}

		Map<String, Object> customHeaders = new HashMap<>();
		headers.getCustomParams().forEach((name, value) -> {
			if (!JWSHeader.getRegisteredParameterNames().contains(name)) {
				customHeaders.put(name, value);
			}
		});
		if (!customHeaders.isEmpty()) {
			builder.customParams(customHeaders);
		}

		return builder.build();
	}

	private static JWTClaimsSet convert(JWTClaimsSet claims) {
		JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();

		// NOTE: The value of the 'iss' claim is a String or URL (StringOrURI).
		Object issuer = claims.getClaim(JwtClaimNames.ISS);
		if (issuer != null) {
			builder.issuer(issuer.toString());
		}

		String subject = claims.getSubject();
		if (StringUtils.hasText(subject)) {
			builder.subject(subject);
		}

		List<String> audience = claims.getAudience();
		if (!CollectionUtils.isEmpty(audience)) {
			builder.audience(audience);
		}

		Date expiresAt = claims.getExpirationTime();
		if (expiresAt != null) {
			builder.expirationTime(expiresAt);
		}

		Date notBefore = claims.getNotBeforeTime();
		if (notBefore != null) {
			builder.notBeforeTime(notBefore);
		}

		Date issuedAt = claims.getIssueTime();
		if (issuedAt != null) {
			builder.issueTime(issuedAt);
		}

		String jwtId = claims.getJWTID();
		if (StringUtils.hasText(jwtId)) {
			builder.jwtID(jwtId);
		}

		Map<String, Object> customClaims = new HashMap<>();
		claims.getClaims().forEach((name, value) -> {
			if (!JWTClaimsSet.getRegisteredNames().contains(name)) {
				customClaims.put(name, value);
			}
		});
		if (!customClaims.isEmpty()) {
			customClaims.forEach(builder::claim);
		}

		return builder.build();
	}

	/**
	 * 限重复提交错误码
	 */
	@Getter
	@AllArgsConstructor
	enum JwtEncoderErrorEnum implements IEnum<Integer> {

		/**
		 * JWT 加密错误
		 */
		JWT_ENCODER_ERROR(10100, "An error occurred while attempting to encode the Jwt: %s");

		private final Integer code;

		private final String message;

	}

}
