package io.github.panxiaochao.system.common.core.context;

import io.github.panxiaochao.system.common.model.LoginUser;
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

	private LoginUser loginUser;

	public SContextImpl() {
	}

	public SContextImpl(LoginUser loginUser) {
		this.loginUser = loginUser;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SContextImpl) {
			SContextImpl other = (SContextImpl) obj;
			if ((this.getLoginUser() == null) && (other.getLoginUser() == null)) {
				return true;
			}
			return (this.getLoginUser() != null) && (other.getLoginUser() != null)
					&& this.getLoginUser().equals(other.getLoginUser());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return ObjectUtils.nullSafeHashCode(this.loginUser);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName()).append(" [");
		if (this.loginUser == null) {
			sb.append("Null loginUser");
		}
		else {
			sb.append("LoginUser=").append(this.loginUser);
		}
		sb.append("]");
		return sb.toString();
	}

}
