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
public class PUuidTokenType extends AbstractPTokenType {

	public static final AbstractPTokenType UUID_TOKEN = new PUuidTokenType("uuid");

	/**
	 * 构造函数
	 *
	 */
	public PUuidTokenType(String value) {
		super(value);
	}

}
