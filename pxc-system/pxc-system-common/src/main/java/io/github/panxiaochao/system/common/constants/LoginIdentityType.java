package io.github.panxiaochao.system.common.constants;

import lombok.Getter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * <p>
 * 登录身份类型枚举
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-26
 * @version 1.0
 */
@Getter
public enum LoginIdentityType {

	/**
	 * EMAIL.
	 */
	EMAIL("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$") {
		@Override
		public String parse(String value) {
			if (this.getPattern().matcher(value).matches()) {
				return "EMAIL";
			}
			return null;
		}
	},
	/**
	 * PHONE.
	 */
	PHONE("^1(3|4|5|6|7|8|9)\\d{9}$") {
		@Override
		public String parse(String value) {
			if (this.getPattern().matcher(value).matches()) {
				return "PHONE";
			}
			return null;
		}
	},
	/**
	 * DEFAULT USERNAME.
	 */
	USERNAME("") {
		@Override
		public String parse(String value) {
			return "USERNAME";
		}
	};

	private final Pattern pattern;

	LoginIdentityType(String pattern) {
		this.pattern = Pattern.compile(pattern);
	}

	/**
	 * Parse the given value to identity type.
	 * @param value the value to parse
	 * @return identity type
	 */
	public abstract String parse(String value);

	/**
	 * Detect the identity type from the given source value.
	 * @param value the source value
	 * @return the identity type
	 * @throws IllegalArgumentException if the value is not a known identity type
	 */
	public static String detect(String value) {
		Assert.notNull(value, "Value must not be null");
		for (LoginIdentityType candidate : values()) {
			String parseValue = candidate.parse(value);
			if (StringUtils.hasText(parseValue)) {
				return parseValue;
			}
		}
		throw new IllegalArgumentException("'" + value + "' is not a valid identity type");
	}

}
