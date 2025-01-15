package io.github.panxiaochao.system.common.cache;

import io.github.panxiaochao.core.utils.JacksonUtil;
import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.common.constants.RedisConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 缓存工具类
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-15
 * @version 1.0
 */
public class CacheHelper {

	/**
	 * 根据数据字典code和字典值查找数据字典配置
	 * @param code 数据字典code
	 * @param value 数据字典配置值
	 * @return 数据字典配置
	 */
	public static SysDictItem getSysDictItemByValue(String code, String value) {
		SysDict sysDict = getSysDictByCode(code);
		if (Objects.isNull(sysDict)) {
			return null;
		}
		Optional<SysDictItem> optionalSysDictItem = sysDict.getSysDictItemList()
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
	public static SysDictItem getSysDictItemByText(String code, String text) {
		SysDict sysDict = getSysDictByCode(code);
		if (Objects.isNull(sysDict)) {
			return null;
		}
		Optional<SysDictItem> optionalSysDictItem = sysDict.getSysDictItemList()
			.stream()
			.filter(o -> (o.getDictId().equals(sysDict.getId()) && o.getDictItemText().equals(text)))
			.findFirst();
		return optionalSysDictItem.orElse(null);
	}

	/**
	 * 根据数据字典code获取下级字典数据列表
	 * @param code 数据字典code
	 * @return 数据字典配置列表
	 */
	public static List<SysDictItem> getSysDictItemListByCode(String code) {
		SysDict sysDict = getSysDictByCode(code);
		if (Objects.isNull(sysDict)) {
			return new ArrayList<>();
		}
		return sysDict.getSysDictItemList()
			.stream()
			.filter(o -> o.getDictId().equals(sysDict.getId()))
			.collect(Collectors.toList());
	}

	/**
	 * 根据数据字典code查询数据字典
	 * @param code 数据字典code
	 * @return 数据字典
	 */
	public static SysDict getSysDictByCode(String code) {
		if (!StringUtils.hasText(code)) {
			return null;
		}
		return JacksonUtil.toBean(RedissonUtil.getMapAll(RedisConstant.KEY_SYS_DICT + code));
	}

	/**
	 * 根据系统参数键值查询系统参数
	 * @param key 键值
	 * @return 系统参数
	 */
	public static SysParam getSysParamByKey(String key) {
		if (!StringUtils.hasText(key)) {
			return null;
		}
		return JacksonUtil.toBean(RedissonUtil.getMapAll(RedisConstant.KEY_SYS_PARAM + key));
	}

	/**
	 * 数据字典表
	 */
	@Getter
	@Setter
	public static class SysDict {

		/**
		 * 主键
		 */
		private String id;

		/**
		 * 字典名称
		 */
		private String dictName;

		/**
		 * 字典code
		 */
		private String dictCode;

		/**
		 * 字典类型：0为string,1为number
		 */
		private String dictType;

		/**
		 * 排序
		 */
		private Integer sort;

		/**
		 * 数据字典配置表 数组
		 */
		private List<SysDictItem> sysDictItemList;

	}

	/**
	 * 数据字典配置表
	 */
	@Getter
	@Setter
	public static class SysDictItem {

		/**
		 * 主键
		 */
		private String id;

		/**
		 * 字典关联ID
		 */
		private String dictId;

		/**
		 * 字典文本
		 */
		private String dictItemText;

		/**
		 * 字典值
		 */
		private String dictItemValue;

		/**
		 * 排序
		 */
		private Integer sort;

	}

	/**
	 * 系统参数
	 */
	@Getter
	@Setter
	public static class SysParam {

		/**
		 * ID
		 */
		private String id;

		/**
		 * 参数名称
		 */
		private String paramName;

		/**
		 * 参数键
		 */
		private String paramKey;

		/**
		 * 参数值
		 */
		private String paramValue;

		/**
		 * 参数类型1-系统类 2-业务类
		 */
		private String paramType;

	}

}
