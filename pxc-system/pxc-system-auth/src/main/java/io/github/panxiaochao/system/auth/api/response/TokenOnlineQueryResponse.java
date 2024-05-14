package io.github.panxiaochao.system.auth.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 在线会话查询响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-10
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "用户授权信息表查询响应对象")
public class TokenOnlineQueryResponse {

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 用户账号
	 */
	private String userName;

	/**
	 * 登录IP地址
	 */
	private String ip;

	/**
	 * 登录时间
	 */
	private LocalDateTime loginTime;

	/**
	 * 授权令牌
	 */
	private String accessToken;

	/*
	 * 授权令牌 access_token 过期时间
	 */
	private long expiresAt;

	/*
	 * 授权令牌 access_token 过期时间 字符串
	 */
	private LocalDateTime expireAtStr;

}
