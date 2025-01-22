package io.github.panxiaochao.system.satoken.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import io.github.panxiaochao.core.enums.CommonResponseEnum;
import io.github.panxiaochao.core.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * SaToken异常处理器
 *
 * @author Lion Li
 */
@Slf4j
@RestControllerAdvice
public class SaTokenExceptionHandler {

	/**
	 * 权限码异常
	 */
	@ExceptionHandler(NotPermissionException.class)
	public R<Void> handleNotPermissionException(NotPermissionException e, HttpServletRequest request) {
		log.error("请求地址：{},权限码校验失败{}", request.getRequestURI(), e.getMessage());
		return R.fail(CommonResponseEnum.FORBIDDEN.getCode(), "没有访问权限，请联系管理员授权");
	}

	/**
	 * 角色权限异常
	 */
	@ExceptionHandler(NotRoleException.class)
	public R<Void> handleNotRoleException(NotRoleException e, HttpServletRequest request) {
		log.error("请求地址：{},角色权限校验失败{}", request.getRequestURI(), e.getMessage());
		return R.fail(CommonResponseEnum.FORBIDDEN.getCode(), "没有访问权限，请联系管理员授权");
	}

	/**
	 * 认证失败
	 */
	@ExceptionHandler(NotLoginException.class)
	public R<Void> handleNotLoginException(NotLoginException e, HttpServletRequest request) {
		log.error("请求地址：{},认证失败{},无法访问系统资源", request.getRequestURI(), e.getMessage());
		return R.fail(CommonResponseEnum.FORBIDDEN.getCode(), "认证失败，无法访问系统资源");
	}

}
