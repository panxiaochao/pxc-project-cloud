package io.github.panxiaochao.system.common.core.generator;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jwt.JWTClaimsSet;
import io.github.panxiaochao.core.utils.RequestUtil;
import io.github.panxiaochao.system.common.core.context.PTokenContext;
import io.github.panxiaochao.system.common.core.tokentype.PTokenType;
import io.github.panxiaochao.system.common.jwt.JWTEncoder;
import io.github.panxiaochao.system.common.jwt.Jwt;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
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
		if (!PTokenType.JWT_TOKEN.equals(pTokenContext.getPTokenType())) {
			return null;
		}

		Date issuedAt = new Date();
		Long accessTokenTimeToLive = pTokenContext.getAccessTokenTimeToLive();
		Date expiresAt = Date.from(issuedAt.toInstant().plus(Duration.ofSeconds(accessTokenTimeToLive)));
		// 算法
		JWSAlgorithm algorithm = parseJWSAlgorithm(pTokenContext.getJWSAlgorithm());
		JWSHeader jwsHeader = new JWSHeader.Builder(algorithm).type(JOSEObjectType.JWT).build();
		JWTClaimsSet.Builder claims = new JWTClaimsSet.Builder()
			// 发行人
			.issuer(getRequestPath())
			// 主题
			.subject(pTokenContext.getPrincipal())
			// 受众
			.audience(Collections.singletonList(pTokenContext.getPrincipal()))
			// 签发时间
			.issueTime(issuedAt)
			// 过期时间
			.expirationTime(expiresAt)
			// 生效时间，在此之前不可用
			.notBeforeTime(issuedAt)
			// 唯一编号
			.jwtID(UUID.randomUUID().toString());
		// TODO 额外参数
		// if (MapUtil.isNotEmpty(pTokenContext.getLoginUser())) {
		// pTokenContext.getLoginUser().forEach(claims::claim);
		// }
		return jwtEncoder.encode(jwsHeader, claims.build());
	}

	private JWSAlgorithm parseJWSAlgorithm(String algorithm) {
		if (StringUtils.hasText(algorithm)) {
			// Infer algorithm type
			if (algorithm.equals(Algorithm.NONE.getName())) {
				// Plain
				return JWSAlgorithm.RS256;
			}
			// else if (json.containsKey(HeaderParameterNames.ENCRYPTION_ALGORITHM)) {
			// // JWE
			// return JWEAlgorithm.parse(algName);
			// }
			else {
				// JWS
				return JWSAlgorithm.parse(algorithm);
			}
		}
		else {
			return JWSAlgorithm.RS256;
		}
	}

	private String getRequestPath() {
		HttpServletRequest request = RequestUtil.getRequest();
		StringBuilder url = new StringBuilder();
		url.append(request.getScheme())
			.append("://")
			.append(request.getServerName())
			.append(":")
			.append(request.getServerPort());
		return url.toString();
	}

}
