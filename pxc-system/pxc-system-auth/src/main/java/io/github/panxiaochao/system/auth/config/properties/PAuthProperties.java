package io.github.panxiaochao.system.auth.config.properties;

import io.github.panxiaochao.system.common.core.tokentype.PTokenType;
import io.github.panxiaochao.system.common.jwt.jose.jws.JwsAlgorithm;
import lombok.AllArgsConstructor;
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
 * @since 2024-02-28
 * @version 1.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.pxc-framework.auth", ignoreInvalidFields = true)
@Component
public class PAuthProperties {

	/**
	 * Access Token Type
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

	/**
	 * 加密算法
	 */
	private JwsAlgorithm algorithm = JwsAlgorithm.RS256;

	/**
	 * Token 样式风格（默认可取值：uuid、simple-uuid、random-128、jwt）
	 */
	private TokenType tokenStyle = TokenType.UUID;

	/**
	 * Head Token名称
	 */
	private String tokenHeaderName = "Authorization";

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

	@Getter
	@AllArgsConstructor
	public enum TokenType {

		/**
		 * tokenType - uuid
		 */
		UUID("uuid", PTokenType.UUID_TOKEN),
		/**
		 * tokenType - simple-uuid
		 */
		SIMPLE_UUID("simple-uuid", PTokenType.SIMPLE_UUID_TOKEN),
		/**
		 * tokenType - random-128
		 */
		random("random-128", PTokenType.ACCESS_TOKEN),
		/**
		 * tokenType - jwt
		 */
		JWT("jwt", PTokenType.JWT_TOKEN);

		private final String name;

		private final PTokenType type;

	}

}
