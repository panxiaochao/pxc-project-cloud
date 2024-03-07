package io.github.panxiaochao.system.common.jwt;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-04
 * @version 1.0
 */
@FunctionalInterface
public interface JWTDecoder {

	/**
	 * Decodes the JWT from it's compact claims representation format and returns a
	 * {@link Jwt}.
	 * @param token the JWT value
	 * @return a {@link Jwt}
	 */
	Jwt decode(String token);

}
