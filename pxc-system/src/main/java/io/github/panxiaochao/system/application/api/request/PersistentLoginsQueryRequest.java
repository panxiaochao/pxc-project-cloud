package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 查询请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "查询请求对象")
public class PersistentLoginsQueryRequest {

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
