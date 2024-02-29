package io.github.panxiaochao.system.auth.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Token自定义属性
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-28
 * @version 1.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "p-auth", ignoreInvalidFields = true)
@Component
public class PAuthProperties {

	/**
	 * Access Token Type, 注意有空格
	 */
	private String tokenType = "Bearer";

	/**
	 * 访问令牌存活时间，默认秒
	 */
	private long accessTokenTimeToLive = 3600L;

	/**
	 * 刷新令牌存活时间，默认秒
	 */
	private long refreshTokenTimeToLive = 7200L;

	/**
	 * 加密盐种子
	 */
	private String seed = "@123456$";

}
