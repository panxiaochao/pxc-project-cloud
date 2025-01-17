package io.github.panxiaochao.system.satoken.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Token自定义属性
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-17
 * @version 1.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "sa-token", ignoreInvalidFields = true)
@Component
public class SaTokenProperties {

	/**
	 * Access Token Type
	 */
	private String tokenType = "Bearer";

	/**
	 * 白名单, 格式如下
	 *
	 * <pre>
	 *     /adc/**,*
	 *     /abc,*
	 *     /abc,get
	 *     /abc,GET
	 *     /abc,POST
	 *     /abc,PUT
	 *     /abc,post
	 *     /abd/{id},delete
	 *     /abc
	 *     /adc/**\/acc,*
	 * </pre>
	 */
	private List<String> whiteUrls = new ArrayList<>();

}
