package io.github.panxiaochao.system.common.jwt.exception;

import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.ienums.IEnum;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
public class JwtEncodingException extends ServerRuntimeException {

	public JwtEncodingException(IEnum<Integer> responseEnum) {
		super(responseEnum);
	}

	public JwtEncodingException(IEnum<Integer> responseEnum, String message) {
		super(responseEnum, message);
	}

	public JwtEncodingException(IEnum<Integer> responseEnum, Throwable cause) {
		super(responseEnum, cause);
	}

	public JwtEncodingException(IEnum<Integer> responseEnum, String message, Throwable cause) {
		super(responseEnum, message, cause);
	}

}
