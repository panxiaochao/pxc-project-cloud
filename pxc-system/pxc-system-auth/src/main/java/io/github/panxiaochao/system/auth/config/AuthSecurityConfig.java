package io.github.panxiaochao.system.auth.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import io.github.panxiaochao.system.auth.config.properties.PAuthProperties;
import io.github.panxiaochao.system.common.core.generator.DelegatingPTokenGenerator;
import io.github.panxiaochao.system.common.core.generator.JWTGenerator;
import io.github.panxiaochao.system.common.core.generator.PAccessTokenGenerator;
import io.github.panxiaochao.system.common.core.generator.PRefreshTokenGenerator;
import io.github.panxiaochao.system.common.core.generator.PTokenGenerator;
import io.github.panxiaochao.system.common.core.generator.PUuidTokenGenerator;
import io.github.panxiaochao.system.common.core.token.PToken;
import io.github.panxiaochao.system.common.core.web.BearerTokenResolver;
import io.github.panxiaochao.system.common.core.web.TokenResolver;
import io.github.panxiaochao.system.common.jwt.JWTDecoder;
import io.github.panxiaochao.system.common.jwt.JWTEncoder;
import io.github.panxiaochao.system.common.jwt.NimbusJWTDecoderFactory;
import io.github.panxiaochao.system.common.jwt.NimbusJWTEncoder;
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
@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class AuthSecurityConfig {

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
		JWTEncoder jwtEncoder = new NimbusJWTEncoder(jwkSource);
		JWTGenerator jwtGenerator = new JWTGenerator(jwtEncoder);
		return new DelegatingPTokenGenerator(jwtGenerator, new PUuidTokenGenerator(), new PAccessTokenGenerator(),
				new PRefreshTokenGenerator());
	}

	/**
	 * JSON Web Key (JWK) source.
	 * @return JWKSource
	 */
	@Bean
	public JWKSource<SecurityContext> jwkSource() {
		RSAKey rsaKey = JwkUtil.defaultRsaKey(pAuthProperties.getSeed());
		JWKSet jwkSet = new JWKSet(rsaKey);
		return new ImmutableJWKSet<>(jwkSet);
	}

	/**
	 * generate JwtDecoder
	 * @param jwkSource jwkSource
	 */
	@Bean
	public JWTDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
		return NimbusJWTDecoderFactory.withDefault(jwkSource);
	}

	/**
	 * token resolver
	 * @return the token resolver bean
	 */
	@Bean
	public TokenResolver tokenResolver() {
		BearerTokenResolver bearerTokenResolver = new BearerTokenResolver();
		bearerTokenResolver.setTokenType(pAuthProperties.getTokenType());
		return bearerTokenResolver;
	}

	/**
	 * The Token Authentication web mvc configurer.
	 * @param jwtDecoder the jwt decoder
	 * @param tokenResolver the token resolver
	 * @return the Token Authentication web mvc configurer
	 */
	@Bean
	public TokenAuthenticationWebMvcConfigurer tokenAuthenticationWebMvcConfigurer(JWTDecoder jwtDecoder,
			TokenResolver tokenResolver) {
		return new TokenAuthenticationWebMvcConfigurer(jwtDecoder, tokenResolver, pAuthProperties.getWhiteUrls());
	}

}
