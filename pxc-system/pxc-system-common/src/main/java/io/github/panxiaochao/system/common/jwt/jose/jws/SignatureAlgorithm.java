package io.github.panxiaochao.system.common.jwt.jose.jws;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
public enum SignatureAlgorithm implements JwsAlgorithm {

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

    SignatureAlgorithm(String name) {
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
    public static SignatureAlgorithm from(String name) {
        for (SignatureAlgorithm value : values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

}
