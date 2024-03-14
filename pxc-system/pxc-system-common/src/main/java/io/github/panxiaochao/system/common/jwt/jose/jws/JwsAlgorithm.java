package io.github.panxiaochao.system.common.jwt.jose.jws;

import io.github.panxiaochao.system.common.jwt.jose.JwaAlgorithm;

/**
 * <p>
 * JwsAlgorithm 枚举类
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
public enum JwsAlgorithm implements JwaAlgorithm {

	/**
	 * HMAC using SHA-256 (Required)
	 */
	HS256(JwsAlgorithms.HS256),

	/**
	 * HMAC using SHA-384 (Optional)
	 */
	HS384(JwsAlgorithms.HS384),

	/**
	 * HMAC using SHA-512 (Optional)
	 */
	HS512(JwsAlgorithms.HS512),

	/**
	 * RSASSA-PKCS1-v1_5 using SHA-256 (Recommended)
	 */
	RS256(JwsAlgorithms.RS256),

	/**
	 * RSASSA-PKCS1-v1_5 using SHA-384 (Optional)
	 */
	RS384(JwsAlgorithms.RS384),

	/**
	 * RSASSA-PKCS1-v1_5 using SHA-512 (Optional)
	 */
	RS512(JwsAlgorithms.RS512),

	/**
	 * ECDSA using P-256 and SHA-256 (Recommended+)
	 */
	ES256(JwsAlgorithms.ES256),

	/**
	 * ECDSA using P-384 and SHA-384 (Optional)
	 */
	ES384(JwsAlgorithms.ES384),

	/**
	 * ECDSA using P-521 and SHA-512 (Optional)
	 */
	ES512(JwsAlgorithms.ES512),

	/**
	 * RSASSA-PSS using SHA-256 and MGF1 with SHA-256 (Optional)
	 */
	PS256(JwsAlgorithms.PS256),

	/**
	 * RSASSA-PSS using SHA-384 and MGF1 with SHA-384 (Optional)
	 */
	PS384(JwsAlgorithms.PS384),

	/**
	 * RSASSA-PSS using SHA-512 and MGF1 with SHA-512 (Optional)
	 */
	PS512(JwsAlgorithms.PS512);

	private final String name;

	JwsAlgorithm(String name) {
		this.name = name;
	}

	/**
	 * Returns the algorithm name.
	 * @return the algorithm name
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Attempt to resolve the provided algorithm name to a {@code SignatureAlgorithm}.
	 * @param name the algorithm name
	 * @return the resolved {@code SignatureAlgorithm}, or {@code null} if not found
	 */
	public static JwsAlgorithm from(String name) {
		for (JwsAlgorithm value : values()) {
			if (value.getName().equals(name)) {
				return value;
			}
		}
		return null;
	}

}
