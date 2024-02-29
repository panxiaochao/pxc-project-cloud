package io.github.panxiaochao.system.common.jwt.jose.jws;


/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
public enum MacAlgorithm implements JwsAlgorithm {
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
    HS512(JwsAlgorithms.HS512);

    private final String name;

    MacAlgorithm(String name) {
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
     * Attempt to resolve the provided algorithm name to a {@code MacAlgorithm}.
     * @param name the algorithm name
     * @return the resolved {@code MacAlgorithm}, or {@code null} if not found
     */
    public static MacAlgorithm from(String name) {
        for (MacAlgorithm algorithm : values()) {
            if (algorithm.getName().equals(name)) {
                return algorithm;
            }
        }
        return null;
    }
}
