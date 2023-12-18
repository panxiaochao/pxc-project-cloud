package io.github.panxiaochao.system.application.runner.helper;

import io.github.panxiaochao.system.application.api.response.sysdict.SysDictQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
public class DictHelper {

	/**
	 * 数据字典 主表
	 */
	private static final Map<String, SysDictQueryResponse> SYS_DICT_MAP = new LinkedHashMap<>();

	/**
	 * 数据字典 配置表
	 */
	private static final Map<String, SysDictItemQueryResponse> SYS_DICT_ITEM_MAP = new LinkedHashMap<>();

	/**
	 * 加载数据字典主表
	 * @param sysDictMap 数据字典Map
	 */
	public static void putAllSysDict(Map<String, SysDictQueryResponse> sysDictMap) {
		SYS_DICT_MAP.clear();
		SYS_DICT_MAP.putAll(sysDictMap);
	}

	/**
	 * 加载数据字典配置表
	 * @param stringSysDictItemMap 数据字典配置Map
	 */
	public static void putAllSysDictItem(Map<String, SysDictItemQueryResponse> stringSysDictItemMap) {
		SYS_DICT_ITEM_MAP.clear();
		SYS_DICT_ITEM_MAP.putAll(stringSysDictItemMap);
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
		Optional<SysDictItemQueryResponse> optionalSysDictItem = SYS_DICT_ITEM_MAP.values()
			.stream()
			.filter(o -> (o.getDictId().equals(sysDict.getId()) && o.getDictItemValue().equals(value)))
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
		Optional<SysDictItemQueryResponse> optionalSysDictItem = SYS_DICT_ITEM_MAP.values()
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
		return SYS_DICT_ITEM_MAP.values()
			.stream()
			.filter(o -> o.getDictId().equals(sysDict.getId()))
			.collect(Collectors.toList());
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
		Optional<SysDictQueryResponse> optionalSysDict = SYS_DICT_MAP.values()
			.stream()
			.filter(s -> s.getDictCode().equals(code))
			.findFirst();
		return optionalSysDict.orElse(null);
	}

}
