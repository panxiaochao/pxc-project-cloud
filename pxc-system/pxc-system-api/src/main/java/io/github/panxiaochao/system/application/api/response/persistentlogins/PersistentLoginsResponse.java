package io.github.panxiaochao.system.application.api.response.persistentlogins;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "响应对象")
public class PersistentLoginsResponse {

	/**
	 *
	*/
	@Schema(description = "")
	private String username;

	/**
	 *
	 */
	@Schema(description = "")
	private String series;

	/**
	 *
	*/
	@Schema(description = "")
	private String token;

	/**
	 *
	*/
	@Schema(description = "")
	private LocalDateTime lastUsed;

}
