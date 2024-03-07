package io.github.panxiaochao.system.common.core.context;

import io.github.panxiaochao.system.common.core.tokentype.PTokenType;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * 一种用于保存与特定上下文相关联的PToken信息的类。
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-29
 * @version 1.0
 */
public final class PTokenContext {

	private final Map<Object, Object> context;

	public PTokenContext(Map<Object, Object> context) {
		this.context = Collections.unmodifiableMap(new HashMap<>(context));
	}

	public Long getAccessTokenTimeToLive() {
		return (Long) this.context.get(Builder.ACCESS_TOKEN_TIME_TO_LIVE);
	}

	public PTokenType getPTokenType() {
		return (PTokenType) this.context.get(PTokenType.class);
	}

	public Long getRefreshTokenTimeToLive() {
		return (Long) this.context.get(Builder.REFRESH_TOKEN_TIME_TO_LIVE);
	}

	public String getPrincipal() {
		return (String) this.context.get(Builder.PRINCIPAL);
	}

	public String getId() {
		return (String) this.context.get(Builder.ID);
	}

	public Map<String, Object> getLoginUser() {
		return (Map<String, Object>) this.context.get(Builder.LOGIN_USER);
	}

	public boolean hasKey(Object key) {
		Assert.notNull(key, "key cannot be null");
		return this.context.containsKey(key);
	}

	/**
	 * Returns a new {@link Builder}.
	 * @return the {@link Builder}
	 */
	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		public static final String PRINCIPAL = "PRINCIPAL";

		public static final String ID = "ID";

		public static final String LOGIN_USER = "LOGIN_USER";

		private static final String ACCESS_TOKEN_TIME_TO_LIVE = "ACCESS_TOKEN_TIME_TO_LIVE";

		private static final String REFRESH_TOKEN_TIME_TO_LIVE = "REFRESH_TOKEN_TIME_TO_LIVE";

		private final Map<Object, Object> context = new HashMap<>();

		private Builder() {
		}

		public Builder pTokenType(PTokenType pTokenType) {
			return put(PTokenType.class, pTokenType);
		}

		public Builder accessTokenTimeToLive(Long accessTokenTimeToLive) {
			return put(ACCESS_TOKEN_TIME_TO_LIVE, accessTokenTimeToLive);
		}

		public Builder refreshTokenTimeToLive(Long refreshTokenTimeToLive) {
			return put(REFRESH_TOKEN_TIME_TO_LIVE, refreshTokenTimeToLive);
		}

		public Builder principal(String principal) {
			return put(PRINCIPAL, principal);
		}

		public Builder id(String id) {
			return put(ID, id);
		}

		public Builder loginUser(Map<String, Object> loginUserMap) {
			return put(LOGIN_USER, loginUserMap);
		}

		public Builder put(Object key, Object value) {
			Assert.notNull(key, "key cannot be null");
			Assert.notNull(value, "value cannot be null");
			this.context.put(key, value);
			return this;
		}

		/**
		 * Builds a new {@link PTokenContext}.
		 * @return the {@link PTokenContext}
		 */
		public PTokenContext build() {
			Object id = this.context.get(ID);
			if (Objects.isNull(id)) {
				this.context.put(ID, UUID.randomUUID().toString());
			}
			return new PTokenContext(this.context);
		}

	}

}
