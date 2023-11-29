package io.github.panxiaochao.system.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc 文档配置
 *
 * @author Lypxc
 * @since 2023-01-01 11:45
 */
@Configuration
public class SpringDocConfig {

	/**
	 * 配置 API文档
	 * @return API Bean
	 */
	@Bean
	public OpenAPI openAPI() {
		Info info = new Info();
		info.title("PXC-SYSTEM微服务")
			.description("PXC-SYSTEM微服务 - API接口文档")
			.version("1.0")
			.contact(new Contact().name("Lypxc").url("https://github.com/panxiaochao").email("545685602@qq.con"));
		return new OpenAPI().info(info);
	}

	/**
	 * 配置 API分组
	 * @return API分组Bean
	 */
	@Bean
	public GroupedOpenApi defaultGroupApi() {
		return GroupedOpenApi.builder().group("pxc-system-v1").pathsToMatch("/system/v1/**").build();
	}

}