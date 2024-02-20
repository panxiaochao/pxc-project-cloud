package io.github.panxiaochao.system.application.runner.helper;

import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.application.api.response.sysdict.SysDictQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamQueryResponse;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据字典辅助类
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-15
 */
public class CacheHelper {

	/**
	 * RedissonClient 获取, 数据采用缓存共享
	 */
	private static final RedissonClient REDISSONCLIENT = RedissonUtil.INSTANCE().ofRedissonClient();

	/**
	 * 数据字典 主表 REDIS_KEY
	 */
	private static final String KEY_SYS_DICT = "CACHE:SYS_DICT";

	/**
	 * 数据字典 配置表 REDIS_KEY
	 */
	private static final String KEY_SYS_DICT_ITEM = "CACHE:SYS_DICT_ITEM";

	/**
	 * 系统参数 REDIS_KEY
	 */
	private static final String KEY_SYS_PARAM = "CACHE:SYS_PARAM";

	/**
	 * 加载数据字典主表
	 * @param sysDictMap 数据字典Map
	 */
	public static void putAllSysDict(Map<String, SysDictQueryResponse> sysDictMap) {
		RMap<String, SysDictQueryResponse> rMap = REDISSONCLIENT.getMap(KEY_SYS_DICT);
		rMap.clear();
		rMap.putAll(sysDictMap);
	}

	/**
	 * 加载数据字典配置表
	 * @param stringSysDictItemMap 数据字典配置Map
	 */
	public static void putAllSysDictItem(Map<String, SysDictItemQueryResponse> stringSysDictItemMap) {
		RMap<String, SysDictItemQueryResponse> rMap = REDISSONCLIENT.getMap(KEY_SYS_DICT_ITEM);
		rMap.clear();
		rMap.putAll(stringSysDictItemMap);
	}

	/**
	 * 加载系统参数
	 * @param sysParamMap 系统参数Map
	 */
	public static void putAllSysParam(Map<String, SysParamQueryResponse> sysParamMap) {
		RMap<String, SysParamQueryResponse> rMap = REDISSONCLIENT.getMap(KEY_SYS_PARAM);
		rMap.clear();
		rMap.putAll(sysParamMap);
	}

	/**
	 * 根据数据字典code和字典值查找数据字典配置
	 * @param code 数据字典code
	 * @param value 数据字典配置值
	 * @return 数据字典配置
	 */
	public static SysDictItemQueryResponse getSysDictItemByValue(String code, String value) {
		SysDictQueryResponse sysDict = getSysDictByCode(code);
		if (Objects.isNull(sysDict)) {
			return null;
		}
		RMap<String, SysDictItemQueryResponse> rMap = REDISSONCLIENT.getMap(KEY_SYS_DICT_ITEM);
		Optional<SysDictItemQueryResponse> optionalSysDictItem = rMap.values()
			.stream()
			.filter(f -> (f.getDictId().equals(sysDict.getId()) && f.getDictItemValue().equals(value)))
			.findFirst();
		return optionalSysDictItem.orElse(null);
	}

	/**
	 * 根据数据字典code和字文本查找数据字典配置
	 * @param code 数据字典code
	 * @param text 数据字典配置文本
	 * @return 数据字典配置
	 */
	public static SysDictItemQueryResponse getSysDictItemByText(String code, String text) {
		SysDictQueryResponse sysDict = getSysDictByCode(code);
		if (Objects.isNull(sysDict)) {
			return null;
		}
		RMap<String, SysDictItemQueryResponse> rMap = REDISSONCLIENT.getMap(KEY_SYS_DICT_ITEM);
		Optional<SysDictItemQueryResponse> optionalSysDictItem = rMap.values()
			.stream()
			.filter(o -> (o.getDictId().equals(sysDict.getId()) && o.getDictItemValue().equals(text)))
			.findFirst();
		return optionalSysDictItem.orElse(null);
	}

	/**
	 * 根据数据字典code获取下级字典数据列表
	 * @param code 数据字典code
	 * @return 数据字典配置列表
	 */
	public static List<SysDictItemQueryResponse> getSysDictItemListByCode(String code) {
		SysDictQueryResponse sysDict = getSysDictByCode(code);
		if (Objects.isNull(sysDict)) {
			return new ArrayList<>();
		}
		RMap<String, SysDictItemQueryResponse> rMap = REDISSONCLIENT.getMap(KEY_SYS_DICT_ITEM);
		return rMap.values().stream().filter(o -> o.getDictId().equals(sysDict.getId())).collect(Collectors.toList());
	}

	/**
	 * 根据数据字典code查询数据字典
	 * @param code 数据字典code
	 * @return 数据字典
	 */
	public static SysDictQueryResponse getSysDictByCode(String code) {
		if (!StringUtils.hasText(code)) {
			return null;
		}
		RMap<String, SysDictQueryResponse> rMap = REDISSONCLIENT.getMap(KEY_SYS_DICT);
		Optional<SysDictQueryResponse> optionalSysDict = rMap.values()
			.stream()
			.filter(s -> s.getDictCode().equals(code))
			.findFirst();
		return optionalSysDict.orElse(null);
	}

	/**
	 * 根据系统参数键值查询系统参数
	 * @param key 键值
	 * @return 系统参数
	 */
	public static SysParamQueryResponse getSysParamByKey(String key) {
		if (!StringUtils.hasText(key)) {
			return null;
		}
		RMap<String, SysParamQueryResponse> rMap = REDISSONCLIENT.getMap(KEY_SYS_PARAM);
		Optional<SysParamQueryResponse> optionalSysParam = rMap.values()
			.stream()
			.filter(s -> s.getParamKey().equals(key))
			.findFirst();
		return optionalSysParam.orElse(null);
	}

}
