package io.github.panxiaochao.system.common.core.web.exception;

import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.ienums.IEnum;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
public class TokenResolverException extends ServerRuntimeException {

	public TokenResolverException(IEnum<Integer> responseEnum) {
		super(responseEnum);
	}

	public TokenResolverException(IEnum<Integer> responseEnum, String message) {
		super(responseEnum, message);
	}

	public TokenResolverException(IEnum<Integer> responseEnum, Throwable cause) {
		super(responseEnum, cause);
	}

	public TokenResolverException(IEnum<Integer> responseEnum, String message, Throwable cause) {
		super(responseEnum, message, cause);
	}

}
