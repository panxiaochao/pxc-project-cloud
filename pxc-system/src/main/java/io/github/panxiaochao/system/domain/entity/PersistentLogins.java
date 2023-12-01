package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class PersistentLogins {

	/**
	 *
	 */
	private String username;

	/**
	*
	*/
	private String series;

	/**
	 *
	 */
	private String token;

	/**
	 *
	 */
	private LocalDateTime lastUsed;

}
