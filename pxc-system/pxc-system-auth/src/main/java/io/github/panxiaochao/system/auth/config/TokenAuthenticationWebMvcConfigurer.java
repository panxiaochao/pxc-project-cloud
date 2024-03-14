package io.github.panxiaochao.system.auth.config;

import io.github.panxiaochao.system.common.core.web.TokenAuthenticationInterceptor;
import io.github.panxiaochao.system.common.core.web.TokenResolver;
import io.github.panxiaochao.system.common.jwt.JWTDecoder;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * The Token Authentication web mvc configurer.
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-08
 * @version 1.0
 */
public class TokenAuthenticationWebMvcConfigurer implements WebMvcConfigurer {

	private final JWTDecoder jwtDecoder;

	private final TokenResolver tokenResolver;

	private final List<String> whiteUrls;

	//@formatter:off
	public static final String[] SWAGGER_EXCLUDE = {
			"/swagger-ui.html",
			"/swagger-ui/*",
			"/swagger-resources/**",
			"/*/api-docs",
			"/webjars/**",
			"/v2/**",
			"/v3/**",
			"/doc.html",
			"/static/**",
			"/favicon.ico"
	};
	//@formatter:on

	public TokenAuthenticationWebMvcConfigurer(JWTDecoder jwtDecoder, TokenResolver tokenResolver) {
		this.whiteUrls = Collections.emptyList();
		this.tokenResolver = tokenResolver;
		this.jwtDecoder = jwtDecoder;
	}

	public TokenAuthenticationWebMvcConfigurer(JWTDecoder jwtDecoder, TokenResolver tokenResolver,
			List<String> whiteUrls) {
		Assert.notEmpty(whiteUrls, "whiteUrls cannot be empty");
		this.whiteUrls = whiteUrls;
		this.tokenResolver = tokenResolver;
		this.jwtDecoder = jwtDecoder;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		TokenAuthenticationInterceptor interceptor = new TokenAuthenticationInterceptor()
			.setTokenResolver(tokenResolver)
			.setJwtDecoder(jwtDecoder)
			.setWhiteUrls(whiteUrls);
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(SWAGGER_EXCLUDE);
	}

}
