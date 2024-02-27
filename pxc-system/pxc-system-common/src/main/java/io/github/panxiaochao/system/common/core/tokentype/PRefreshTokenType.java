package io.github.panxiaochao.system.common.core.tokentype;

/**
 * <p>
 * 基于{@link AbstractPTokenType}实现的刷新令牌类型
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class PRefreshTokenType extends AbstractPTokenType {

	public static final AbstractPTokenType REFRESH_TOKEN = new PAccessTokenType("refresh_token");

	/**
	 * 构造函数
	 */
	public PRefreshTokenType(String value) {
		super(value);
	}

}
