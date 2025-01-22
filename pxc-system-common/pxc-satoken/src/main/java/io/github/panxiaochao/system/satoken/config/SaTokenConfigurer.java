package io.github.panxiaochao.system.satoken.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import io.github.panxiaochao.system.satoken.config.properties.SaTokenProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Sa-Token WebMvc拦截
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-17
 * @version 1.0
 */
@Configuration
@RequiredArgsConstructor
public class SaTokenConfigurer implements WebMvcConfigurer {

	private final SaTokenProperties saTokenProperties;

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

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> whitelist = saTokenProperties.getWhiteUrls();
		whitelist.addAll(Arrays.asList(SWAGGER_EXCLUDE));
		// 注册 Sa-Token 拦截器，定义详细认证规则
		registry.addInterceptor(new SaInterceptor(handler -> SaRouter.match("/**").check(StpUtil::checkLogin)))
			.addPathPatterns("/**")
			.excludePathPatterns(whitelist);
	}

}
