package io.github.panxiaochao.system.common.constants;

/**
 * <p>
 * 全局常量类
 * </p>
 *
 * @author Lypxc
 * @since 2024-01-10
 */
public interface GlobalConstant {

	/**
	 * 过期时间
	 */
	String EXPIRE_TIME = "2099-12-31 23:59:59";

	/**
	 * 超级管理员角色
	 */
	String SUPER_ROLE = "superAdmin";

	/**
	 * 超级管理员唯一账号
	 */
	String SUPER_USER = "root";

	/**
	 * Redis Login 前缀 KEY
	 */
	String REDIS_ROOT_KEY = "Auth-user:";

	/**
	 * LOGIN_USER_TOKEN 前缀
	 */
	String LOGIN_USER_TOKEN_PREFIX = REDIS_ROOT_KEY + "loginUser:token:";

	/**
	 * LOGIN_USER 前缀
	 */
	String LOGIN_USER_PREFIX = REDIS_ROOT_KEY + "loginUser:user:";

	/**
	 * LOGIN_USER_ONLINE 前缀
	 */
	String LOGIN_USER_ONLINE_PREFIX = REDIS_ROOT_KEY + "loginUser:online:";

	/**
	 * 登录失败限制 key
	 */
	String LOGIN_FAIL_LIMIT_KEY = REDIS_ROOT_KEY + "login_fail_limit:";

}
