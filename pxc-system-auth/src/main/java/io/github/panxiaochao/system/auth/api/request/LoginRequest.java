package io.github.panxiaochao.system.auth.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 登录 请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Getter
@Setter
@Schema(description = "登录 请求对象")
public class LoginRequest {

	@Schema(description = "用户名")
	@NotBlank(message = "用户名不能为空")
	private String username;

	@Schema(description = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;

	@Schema(description = "登录设备")
	@NotBlank(message = "登录设备不能为空")
	private String loginDevice;

	@Schema(description = "验证码")
	private String captcha;

}
