package io.github.panxiaochao.system.common.core.web.exception;

import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.ienums.IEnum;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-07
 * @version 1.0
 */
public class TokenAuthenticationException extends ServerRuntimeException {

	public TokenAuthenticationException(IEnum<Integer> responseEnum) {
		super(responseEnum);
	}

	public TokenAuthenticationException(IEnum<Integer> responseEnum, String message) {
		super(responseEnum, message);
	}

	public TokenAuthenticationException(IEnum<Integer> responseEnum, Throwable cause) {
		super(responseEnum, cause);
	}

	public TokenAuthenticationException(IEnum<Integer> responseEnum, String message, Throwable cause) {
		super(responseEnum, message, cause);
	}

}
