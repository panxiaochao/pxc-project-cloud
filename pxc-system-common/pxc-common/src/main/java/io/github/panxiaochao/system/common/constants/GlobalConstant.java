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
	 * 查询遍历Redis key限制数量
	 */
	int KEY_COUNT = 100;

	/**
	 * Token 前缀
	 */
	String TOKEN_PREFIX = "Bearer";

}
