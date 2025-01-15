package io.github.panxiaochao.system.common.constants;

/**
 * <p>
 * Redis 常量类
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-14
 * @version 1.0
 */
public interface RedisConstant {

	/**
	 * Redis Login 前缀 KEY
	 */
	String REDIS_ROOT_KEY = "Auth-user:";

	/**
	 * LOGIN_TOKEN 前缀
	 */
	String LOGIN_TOKEN_PREFIX = REDIS_ROOT_KEY + "login:token:";

	/**
	 * LOGIN 前缀
	 */
	String LOGIN_PREFIX = REDIS_ROOT_KEY + "login:user:";

	/**
	 * LOGIN_ONLINE 前缀
	 */
	String LOGIN_ONLINE_PREFIX = REDIS_ROOT_KEY + "login:online:";

	/**
	 * 登录失败限制 key
	 */
	String LOGIN_FAIL_LIMIT_KEY = REDIS_ROOT_KEY + "login_fail_limit:";

	/**
	 * 数据字典 主表 REDIS_KEY
	 */
	String KEY_SYS_DICT = "CACHE:SYS_DICT:";

	/**
	 * 数据字典 主表 ALL_KEY 表达式
	 */
	String KEY_ALL_SYS_DICT = "CACHE:SYS_DICT:*";

	/**
	 * 数据字典 配置表 REDIS_KEY
	 */
	String KEY_SYS_DICT_ITEM = "CACHE:SYS_DICT_ITEM:";

	/**
	 * 数据字典 配置表 ALL_KEY 表达式
	 */
	String KEY_ALL_SYS_DICT_ITEM = "CACHE:SYS_DICT_ITEM:*";

	/**
	 * 系统参数 REDIS_KEY
	 */
	String KEY_SYS_PARAM = "CACHE:SYS_PARAM:";

	/**
	 * 系统参数 ALL_KEY 表达式
	 */
	String KEY_ALL_SYS_PARAM = "CACHE:SYS_PARAM:*";

}
