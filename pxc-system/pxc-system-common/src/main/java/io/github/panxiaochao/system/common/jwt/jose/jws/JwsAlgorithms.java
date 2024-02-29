package io.github.panxiaochao.system.common.jwt.jose.jws;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
public interface JwsAlgorithms {

	/**
	 * HMAC using SHA-256 (Required)
	 */
	String HS256 = "HS256";

	/**
	 * HMAC using SHA-384 (Optional)
	 */
	String HS384 = "HS384";

	/**
	 * HMAC using SHA-512 (Optional)
	 */
	String HS512 = "HS512";

	/**
	 * RSASSA-PKCS1-v1_5 using SHA-256 (Recommended)
	 */
	String RS256 = "RS256";

	/**
	 * RSASSA-PKCS1-v1_5 using SHA-384 (Optional)
	 */
	String RS384 = "RS384";

	/**
	 * RSASSA-PKCS1-v1_5 using SHA-512 (Optional)
	 */
	String RS512 = "RS512";

	/**
	 * ECDSA using P-256 and SHA-256 (Recommended+)
	 */
	String ES256 = "ES256";

	/**
	 * ECDSA using P-384 and SHA-384 (Optional)
	 */
	String ES384 = "ES384";

	/**
	 * ECDSA using P-521 and SHA-512 (Optional)
	 */
	String ES512 = "ES512";

	/**
	 * RSASSA-PSS using SHA-256 and MGF1 with SHA-256 (Optional)
	 */
	String PS256 = "PS256";

	/**
	 * RSASSA-PSS using SHA-384 and MGF1 with SHA-384 (Optional)
	 */
	String PS384 = "PS384";

	/**
	 * RSASSA-PSS using SHA-512 and MGF1 with SHA-512 (Optional)
	 */
	String PS512 = "PS512";

}
