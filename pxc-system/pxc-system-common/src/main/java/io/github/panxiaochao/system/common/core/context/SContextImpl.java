package io.github.panxiaochao.system.common.core.context;

import io.github.panxiaochao.system.common.core.token.PToken;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-06
 * @version 1.0
 */
@Getter
@Setter
public class SContextImpl implements SContext {

	private static final long serialVersionUID = 1L;

	private PToken token;

	public SContextImpl() {
	}

	public SContextImpl(PToken token) {
		this.token = token;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SContextImpl) {
			SContextImpl other = (SContextImpl) obj;
			if ((this.getToken() == null) && (other.getToken() == null)) {
				return true;
			}
			return (this.getToken() != null) && (other.getToken() != null) && this.getToken().equals(other.getToken());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return ObjectUtils.nullSafeHashCode(this.token);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName()).append(" [");
		if (this.token == null) {
			sb.append("Null token");
		}
		else {
			sb.append("PToken=").append(this.token);
		}
		sb.append("]");
		return sb.toString();
	}

}
