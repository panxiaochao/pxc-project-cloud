package io.github.panxiaochao.system.common.jwt;

import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.proc.JWTProcessor;
import io.github.panxiaochao.core.ienums.IEnum;
import io.github.panxiaochao.system.common.jwt.exception.JwtDecodingException;
import io.github.panxiaochao.system.common.jwt.validator.JWTValidators;
import io.github.panxiaochao.system.common.jwt.validator.TokenValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public class NimbusJWTDecoder implements JWTDecoder {

	private final JWTProcessor<SecurityContext> jwtProcessor;

	private TokenValidator<Jwt> jwtValidator = JWTValidators.createDefault();

	/**
	 * Configures a {@link NimbusJWTDecoder} with the given parameters
	 * @param jwtProcessor - the {@link JWTProcessor} to use
	 */
	public NimbusJWTDecoder(JWTProcessor<SecurityContext> jwtProcessor) {
		Assert.notNull(jwtProcessor, "jwtProcessor cannot be null");
		this.jwtProcessor = jwtProcessor;
	}

	/**
	 * Use this {@link Jwt} Validator
	 * @param jwtValidator - the Jwt Validator to use
	 */
	public void setJwtValidator(TokenValidator<Jwt> jwtValidator) {
		Assert.notNull(jwtValidator, "jwtValidator cannot be null");
		this.jwtValidator = jwtValidator;
	}

	/**
	 * Decodes the JWT from it's compact claims representation format and returns a
	 * {@link Jwt}.
	 * @param token the JWT value
	 * @return a {@link Jwt}
	 */
	@Override
	public Jwt decode(String token) {
		JWT jwt = parse(token);
		if (jwt instanceof PlainJWT) {
			throw new JwtDecodingException(JWTDecoderErrorEnum.JWT_DECODER_ERROR,
					String.format(JWTDecoderErrorEnum.JWT_DECODER_ERROR.getMessage(),
							"Unsupported algorithm of " + jwt.getHeader().getAlgorithm()));
		}
		Jwt createdJwt = createJwt(token, jwt);
		return validateJwt(createdJwt);
	}

	private JWT parse(String token) {
		try {
			return JWTParser.parse(token);
		}
		catch (Exception ex) {
			throw new JwtDecodingException(JWTDecoderErrorEnum.JWT_DECODER_ERROR,
					String.format(JWTDecoderErrorEnum.JWT_DECODER_ERROR.getMessage(), ex.getMessage()));
		}
	}

	private Jwt createJwt(String token, JWT parsedJwt) {
		try {
			// Verify the signature
			JWTClaimsSet jwtClaimsSet = this.jwtProcessor.process(parsedJwt, null);
			Map<String, Object> headers = new LinkedHashMap<>(parsedJwt.getHeader().toJSONObject());
			// Map<String, Object> claims =
			// this.claimSetConverter.convert(jwtClaimsSet.getClaims());
			Map<String, Object> claims = jwtClaimsSet.getClaims();
			// @formatter:off
            return Jwt.withTokenValue(token)
                    .headers((h) -> h.putAll(headers))
                    .claims((c) -> c.putAll(claims))
                    .build();
            // @formatter:on
		}
		catch (Exception ex) {
			if (ex.getCause() instanceof ParseException) {
				throw new JwtDecodingException(JWTDecoderErrorEnum.JWT_DECODER_ERROR,
						String.format(JWTDecoderErrorEnum.JWT_DECODER_ERROR.getMessage(), "Malformed payload"), ex);
			}
			throw new JwtDecodingException(JWTDecoderErrorEnum.JWT_DECODER_ERROR,
					String.format(JWTDecoderErrorEnum.JWT_DECODER_ERROR.getMessage(), ex.getMessage()), ex);
		}
	}

	private Jwt validateJwt(Jwt jwt) {
		boolean result = this.jwtValidator.validate(jwt);
		if (!result) {
			throw new JwtDecodingException(JWTDecoderErrorEnum.JWT_DECODER_ERROR,
					String.format(JWTDecoderErrorEnum.JWT_DECODER_ERROR.getMessage(), "validate jwt is error"));
		}
		return jwt;
	}

	/**
	 * JWT Decoder 错误码
	 */
	@Getter
	@AllArgsConstructor
	enum JWTDecoderErrorEnum implements IEnum<Integer> {

		/**
		 * JWT 解密错误
		 */
		JWT_DECODER_ERROR(10200, "An error occurred while attempting to decode the Jwt: %s");

		private final Integer code;

		private final String message;

	}

}
