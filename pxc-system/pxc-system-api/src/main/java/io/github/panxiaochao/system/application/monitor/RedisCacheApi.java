package io.github.panxiaochao.system.application.monitor;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.ConvertUtils;
import io.github.panxiaochao.core.utils.StrUtil;
import io.github.panxiaochao.system.application.api.response.redis.RedisCacheInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * Redis 缓存监控
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-10
 * @version 1.0
 */
@Tag(name = "Redis缓存监控 接口", description = "Redis缓存监控 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/web/v1/redis")
public class RedisCacheApi {

	private final RedissonConnectionFactory connectionFactory;

	/**
	 * 获取缓存监控列表
	 * <p>
	 * RedisConnection info 命令: <br/>
	 * <pre> server: 常规信息 clients: 客户端连接部分 memory: 内存消耗相关信息 persistence: RDB和AOF相关信息
	 * stats: 统计信息 replication: 主/从复制信息 cpu: CPU消耗统计 commandstats: Redis命令统计 cluster: 集群部分
	 * keyspace: 数据库、key相关统计
	 *
	 * </p>
	 */
	@Operation(summary = "获取系统信息", description = "获取系统信息", method = "GET")
	@GetMapping("/cache")
	public R<RedisCacheInfoResponse> getRedisCacheInfo() throws Exception {
		RedisConnection connection = connectionFactory.getConnection();
		Properties commandStats = connection.info("commandstats");

		List<Map<String, Object>> pieList = new ArrayList<>();
		if (commandStats != null) {
			commandStats.stringPropertyNames().forEach(key -> {
				Map<String, Object> data = new HashMap<>(2);
				String propertyVal = commandStats.getProperty(key);
				data.put("name", StrUtil.removeStart(key, "cmdstat_"));
				int value = ConvertUtils.toInt(StrUtil.substringBetween(propertyVal, "calls=", ",usec"), 0);
				data.put("value", value);
				pieList.add(data);
			});
		}
		RedisCacheInfoResponse cacheInfo = new RedisCacheInfoResponse();
		cacheInfo.setInfo(connection.info());
		cacheInfo.setDbSize(connection.dbSize());
		cacheInfo.setCommandStats(pieList);
		return R.ok(cacheInfo);
	}

}
