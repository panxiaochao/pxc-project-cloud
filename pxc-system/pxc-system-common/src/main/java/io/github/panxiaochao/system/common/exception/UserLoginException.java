package io.github.panxiaochao.system.common.exception;

import io.github.panxiaochao.core.ienums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 用户账号登录 异常类
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-26
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum UserLoginException implements IEnum<Integer> {

	/**
	 * 账号重复
	 */
	USER_MULTIPLE_EXCEPTION(10001, "账号重复!"),
	/**
	 * 账号不存在或密码错误
	 */
	USER_NOT_EXIST_EXCEPTION(10002, "账号不存在或密码错误!"),
	/**
	 * 账号已过期
	 */
	USER_ACCOUNT_EXPIRE_EXCEPTION(10003, "账号已过期!"),
	/**
	 * 账号登录错误次数超过5次，10分钟后再试
	 */
	USER_LOGIN_FAIL_EXCEED_EXCEPTION(10004, "账号登录错误次数超过5次，10分钟后再试!"),
	/**
	 * 密码已过期
	 */
	USER_PASSWORD_EXPIRE_EXCEPTION(10005, "密码已过期!"),
	/**
	 * 密码未验证
	 */
	USER_PASSWORD_VERIFY_EXCEPTION(10006, "密码未验证!"),
	/**
	 * 密码错误或不合法
	 */
	USER_PASSWORD_ILLEGAL_EXCEPTION(10007, "密码错误或不合法!");

	private final Integer code;

	private final String message;

}
