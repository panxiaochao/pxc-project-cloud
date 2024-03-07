package io.github.panxiaochao.system.common.core.generator;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jwt.JWTClaimsSet;
import io.github.panxiaochao.core.utils.MapUtil;
import io.github.panxiaochao.system.common.core.context.PTokenContext;
import io.github.panxiaochao.system.common.core.tokentype.PAccessTokenType;
import io.github.panxiaochao.system.common.jwt.Jwt;
import io.github.panxiaochao.system.common.jwt.JWTEncoder;
import org.springframework.util.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 访问令牌生成
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-21
 * @version 1.0
 */
public final class JWTGenerator implements PTokenGenerator<Jwt> {

	private final JWTEncoder jwtEncoder;

	/**
	 * Constructs a {@code JwtGenerator} using the provided parameters.
	 * @param jwtEncoder the jwt encoder
	 */
	public JWTGenerator(JWTEncoder jwtEncoder) {
		Assert.notNull(jwtEncoder, "jwtEncoder cannot be null");
		this.jwtEncoder = jwtEncoder;
	}

	/**
	 * 生成令牌根据令牌类型
	 * @param pTokenContext token上下文
	 * @return 令牌
	 */
	@Override
	public Jwt generate(PTokenContext pTokenContext) {
		if (!PAccessTokenType.ACCESS_TOKEN.equals(pTokenContext.getPTokenType())) {
			return null;
		}

		Date issuedAt = new Date();
		Long accessTokenTimeToLive = pTokenContext.getAccessTokenTimeToLive();
		Date expiresAt = Date.from(issuedAt.toInstant().plus(Duration.ofSeconds(accessTokenTimeToLive)));

		JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.RS256).type(JOSEObjectType.JOSE).build();
		JWTClaimsSet.Builder claims = new JWTClaimsSet.Builder()
			// 发行人
			.issuer(pTokenContext.getPrincipal())
			// 主题
			.subject(pTokenContext.getPrincipal())
			// 受众
			.audience(Collections.singletonList(pTokenContext.getId()))
			// 签发时间
			.issueTime(issuedAt)
			// 过期时间
			.expirationTime(expiresAt)
			// 生效时间，在此之前不可用
			.notBeforeTime(issuedAt)
			// 唯一编号
			.jwtID(UUID.randomUUID().toString());
		// 额外参数
		if (MapUtil.isNotEmpty(pTokenContext.getLoginUser())) {
			pTokenContext.getLoginUser().forEach(claims::claim);
		}
		return jwtEncoder.encode(jwsHeader, claims.build());
	}

}