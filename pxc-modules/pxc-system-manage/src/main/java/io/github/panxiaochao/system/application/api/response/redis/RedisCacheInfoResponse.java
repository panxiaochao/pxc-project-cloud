package io.github.panxiaochao.system.application.api.response.redis;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * Redis缓存查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-10
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "Redis缓存查询响应对象")
public class RedisCacheInfoResponse {

	private Properties info;

	private Long dbSize;

	private List<Map<String, Object>> commandStats;

}
