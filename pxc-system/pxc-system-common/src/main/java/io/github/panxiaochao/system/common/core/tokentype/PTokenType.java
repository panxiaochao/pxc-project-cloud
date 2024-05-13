package io.github.panxiaochao.system.common.core.tokentype;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * <p>
 * PTokenType 令牌类型
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public class PTokenType implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final PTokenType JWT_TOKEN = new PTokenType("jwt_token");

	public static final PTokenType ACCESS_TOKEN = new PTokenType("access_token");

	public static final PTokenType REFRESH_TOKEN = new PTokenType("refresh_token");

	public static final PTokenType UUID_TOKEN = new PTokenType("uuid");

	public static final PTokenType SIMPLE_UUID_TOKEN = new PTokenType("simple-uuid");

	private final String tokenType;

	/**
	 * 构造函数
	 * @param value the value of the token type
	 */
	public PTokenType(String value) {
		Assert.hasText(value, "value cannot be empty");
		this.tokenType = value;
	}

	/**
	 * 返回令牌类型.
	 * @return the token type name
	 */
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
		PTokenType that = (PTokenType) obj;
		return getTokenType().equals(that.getTokenType());
	}

	@Override
	public int hashCode() {
		return getTokenType().hashCode();
	}

}
