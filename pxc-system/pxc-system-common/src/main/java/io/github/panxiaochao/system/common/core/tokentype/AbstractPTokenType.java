package io.github.panxiaochao.system.common.core.tokentype;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * <p>
 * PTokenType 令牌类型实现基类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class AbstractPTokenType implements PTokenType, Serializable {

	private static final long serialVersionUID = 1L;

	private final String tokenType;

	/**
	 * 构造函数
	 * @param value the value of the token type
	 */
	public AbstractPTokenType(String value) {
		Assert.hasText(value, "value cannot be empty");
		this.tokenType = value;
	}

	/**
	 * 返回令牌类型.
	 * @return the token type name
	 */
	@Override
	public String getTokenType() {
		return this.tokenType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		AbstractPTokenType that = (AbstractPTokenType) obj;
		return getTokenType().equals(that.getTokenType());
	}

	@Override
	public int hashCode() {
		return getTokenType().hashCode();
	}

}
