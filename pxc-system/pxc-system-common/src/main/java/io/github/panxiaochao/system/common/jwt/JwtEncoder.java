package io.github.panxiaochao.system.common.jwt;

import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jwt.JWTClaimsSet;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
@FunctionalInterface
public interface JwtEncoder {


    Jwt encode(JWSHeader jwsHeader, JWTClaimsSet claims);

}

