package io.github.panxiaochao.system.development.cache;

import io.github.panxiaochao.redis.utils.RedissonUtil;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import java.util.function.Predicate;

/**
 * <p>
 * 缓存辅助类
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-13
 * @version 1.0
 */
public class CacheHelper<T> {

	/**
	 * RedissonClient 获取, 数据采用缓存共享
	 */
	private static final RedissonClient REDISSONCLIENT = RedissonUtil.ofRedissonClient();

	/**
	 * 获取缓存值
	 * @param cacheName 缓存名称
	 * @param key 缓存key
	 */
	public static <T> T get(String cacheName, String key, Predicate<? super T> predicate) {
		RMap<String, T> rMap = REDISSONCLIENT.getMap(cacheName);
		return rMap.values().stream().filter(predicate).findFirst().orElse(null);
	}

}
