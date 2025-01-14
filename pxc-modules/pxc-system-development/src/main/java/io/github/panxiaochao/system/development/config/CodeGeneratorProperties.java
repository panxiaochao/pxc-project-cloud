package io.github.panxiaochao.system.development.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 代码生成 默认属性文件
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-09
 * @version 1.0
 */
@Getter
@Setter
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = CodeGeneratorProperties.PREFIX)
public class CodeGeneratorProperties {

	public static final String PREFIX = "spring.pxc-framework.codegen";

	/**
	 * 生成代码的包名
	 */
	private String packageName = "io.github.panxiaochao";

	/**
	 * 生成代码的版本
	 */
	private String version = "1.0";

	/**
	 * 生成代码的模块名
	 */
	private String moduleName = "admin";

	/**
	 * 生成代码的后端路径
	 */
	private String backendPath = "project";

	/**
	 * 生成代码的前端路径
	 */
	private String frontendPath = "web-ui";

	/**
	 * 生成代码的作者
	 */
	private String author = "Lypxc";

	/**
	 * 生成代码的邮箱
	 */
	private String email = "545685602@qq.com";

	/**
	 * 表单布局（1：一列 2：两列）
	 */
	private String formLayout = "2";

	/**
	 * 下载方式 （0：zip文件下载 1：自定义目录）
	 */
	private String generatorType = "0";

}
