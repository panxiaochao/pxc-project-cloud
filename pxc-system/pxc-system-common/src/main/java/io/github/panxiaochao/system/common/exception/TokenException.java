package io.github.panxiaochao.system.common.exception;

import io.github.panxiaochao.core.ienums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * Token异常类
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-26
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum TokenException implements IEnum<Integer> {

	/**
	 * Token 为空
	 */
	TOKEN_EMPTY_EXCEPTION(10010, "Token 为空!"),
	/**
	 * Token 已过期
	 */
	TOKEN_EXPIRE_EXCEPTION(10011, "Token 已过期!"),

	;

	private final Integer code;

	private final String message;

}
