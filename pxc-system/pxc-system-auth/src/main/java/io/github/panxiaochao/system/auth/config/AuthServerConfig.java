package io.github.panxiaochao.system.auth.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import io.github.panxiaochao.system.auth.config.properties.PAuthProperties;
import io.github.panxiaochao.system.common.core.generator.DelegatingPTokenGenerator;
import io.github.panxiaochao.system.common.core.generator.JwtGenerator;
import io.github.panxiaochao.system.common.core.generator.PAccessTokenGenerator;
import io.github.panxiaochao.system.common.core.generator.PRefreshTokenGenerator;
import io.github.panxiaochao.system.common.core.generator.PTokenGenerator;
import io.github.panxiaochao.system.common.core.generator.PUuidTokenGenerator;
import io.github.panxiaochao.system.common.core.token.PToken;
import io.github.panxiaochao.system.common.jwt.JwtEncoder;
import io.github.panxiaochao.system.common.jwt.NimbusJwtEncoder;
import io.github.panxiaochao.system.common.jwt.utils.JwkUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-28
 * @version 1.0
 */
@Configuration
@RequiredArgsConstructor
public class AuthServerConfig {

	/**
	 * Token自定义属性
	 */
	private final PAuthProperties pAuthProperties;

	/**
	 * 令牌生成
	 * @return pTokenGenerator
	 */
	@Bean
	public PTokenGenerator<? extends PToken> pTokenGenerator(JWKSource<SecurityContext> jwkSource) {
		JwtEncoder jwtEncoder = new NimbusJwtEncoder(jwkSource);
		JwtGenerator jwtGenerator = new JwtGenerator(jwtEncoder);
		return new DelegatingPTokenGenerator(jwtGenerator, new PUuidTokenGenerator(), new PAccessTokenGenerator(),
				new PRefreshTokenGenerator());
	}

	/**
	 * JSON Web Key (JWK) source.
	 * @return JWKSource
	 */
	@Bean
	public JWKSource<SecurityContext> jwkSource() {
		RSAKey rsaKey = JwkUtil.generateRsaKey(pAuthProperties.getSeed());
		JWKSet jwkSet = new JWKSet(rsaKey);
		return new ImmutableJWKSet<>(jwkSet);
	}

	/**
	 * @param jwkSource jwkSource
	 */
	@Bean
	public ConfigurableJWTProcessor<? extends SecurityContext> configurableJWTProcessor(
			JWKSource<SecurityContext> jwkSource) {
		ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
		jwtProcessor.setJWSKeySelector(new JWSVerificationKeySelector<>(JWSAlgorithm.RS256, jwkSource));
		return jwtProcessor;
	}

}
