package io.github.panxiaochao.system.auth.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * <p>
 * 当前登录用户对象
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-04
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "当前登录用户对象")
public class LoginUserResponse {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 角色集合
     */
    private Set<String> roles;

	/**
	 * 权限集合
	 */
    private Set<String> permissions;

}
