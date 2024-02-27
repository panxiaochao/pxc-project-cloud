package io.github.panxiaochao.system.common.core.tokentype;

/**
 * <p>
 * 基于{@link AbstractPTokenType}实现的访问令牌类型
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class PAccessTokenType extends AbstractPTokenType {

	public static final AbstractPTokenType ACCESS_TOKEN = new PAccessTokenType("access_token");

	/**
	 * 构造函数
	 *
	 */
	public PAccessTokenType(String value) {
		super(value);
	}

}
