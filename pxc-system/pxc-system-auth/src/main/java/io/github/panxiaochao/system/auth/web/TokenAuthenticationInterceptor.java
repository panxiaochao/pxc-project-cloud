package io.github.panxiaochao.system.auth.web;

import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.JacksonUtil;
import io.github.panxiaochao.core.utils.StrUtil;
import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.common.constants.GlobalConstant;
import io.github.panxiaochao.system.common.core.context.SContext;
import io.github.panxiaochao.system.common.core.context.SContextHolder;
import io.github.panxiaochao.system.common.core.tokentype.PTokenType;
import io.github.panxiaochao.system.common.core.web.TokenResolver;
import io.github.panxiaochao.system.common.core.web.exception.TokenAuthenticationException;
import io.github.panxiaochao.system.common.core.web.exception.TokenResolverException;
import io.github.panxiaochao.system.common.exception.TokenException;
import io.github.panxiaochao.system.common.jwt.JWTDecoder;
import io.github.panxiaochao.system.common.jwt.Jwt;
import io.github.panxiaochao.system.common.jwt.exception.JwtDecodingException;
import io.github.panxiaochao.system.common.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-07
 * @version 1.0
 */
public class TokenAuthenticationInterceptor implements HandlerInterceptor {

	/**
	 * LOGGER TokenAuthenticationFilter.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationInterceptor.class);

	private List<String> whiteUrls;

	private TokenResolver tokenResolver;

	private JWTDecoder jwtDecoder;

	private PTokenType tokenType;

	public TokenAuthenticationInterceptor() {
	}

	public TokenAuthenticationInterceptor setJwtDecoder(JWTDecoder jwtDecoder) {
		Assert.notNull(jwtDecoder, "jwtDecoder cannot be null");
		this.jwtDecoder = jwtDecoder;
		return this;
	}

	public TokenAuthenticationInterceptor setTokenResolver(TokenResolver tokenResolver) {
		Assert.notNull(tokenResolver, "tokenResolver cannot be null");
		Assert.notNull(tokenResolver.getTokenType(), "tokenResolver.tokenType cannot be null");
		this.tokenResolver = tokenResolver;
		return this;
	}

	public TokenAuthenticationInterceptor setWhiteUrls(List<String> whiteUrls) {
		Assert.notNull(whiteUrls, "whiteUrls cannot be null");
		this.whiteUrls = whiteUrls;
		return this;
	}

	public TokenAuthenticationInterceptor setTokenType(PTokenType tokenType) {
		Assert.notNull(tokenType, "tokenType cannot be null");
		this.tokenType = tokenType;
		return this;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		// 不是HandlerMethod方法的通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		// 放行白名单
		String url = getRequestPath(request);
		if (!CollectionUtils.isEmpty(whiteUrls) && whiteUrls.contains(url)) {
			return true;
		}
		// TODO 这里必须确保 handler 是 HandlerMethod 类型时，才能进行注解鉴权
		// if (handler instanceof HandlerMethod) {
		// }
		LoginUser loginUser = null;
		// 从浏览器参数中获取特定参数的 token
		String token = request.getParameter("token");
		// 获取请求头部 Authorization
		String headToken = getHeadToken(request, response);
		if (StrUtil.isNotBlank(headToken)) {
			if (PTokenType.JWT_TOKEN.equals(tokenType)) {
				Jwt jwt = this.jwtDecoder.decode(token);
				if (null == jwt || System.currentTimeMillis() > Date.from(jwt.getExpiresAt()).getTime()) {
					commence(response, new TokenAuthenticationException(TokenException.TOKEN_EXPIRE_EXCEPTION));
				}
			}
			loginUser = getRedisToken(headToken, response);
		}
		else if (StrUtil.isNotBlank(token)) {
			// 浏览器参数token判断逻辑
		}
		if (StrUtil.isAllBlank(token, headToken)) {
			commence(response, new TokenAuthenticationException(TokenException.TOKEN_EMPTY_EXCEPTION));
			return false;
		}
		try {
			// SecurityContextHolder 上下文构建存储 Token
			SContext context = SContextHolder.createEmptyContext();
			context.setLoginUser(loginUser);
			SContextHolder.setContext(context);
			return true;
		}
		catch (JwtDecodingException e) {
			SContextHolder.clearContext();
			commence(response, e);
			return false;
		}
	}

	private LoginUser getRedisToken(String headToken, HttpServletResponse response) {
		LoginUser loginUser = RedissonUtil.get(GlobalConstant.LOGIN_TOKEN_PREFIX + headToken);
		// Redis为空或者当前时间已大于过期时间
		if (null == loginUser || System.currentTimeMillis() > loginUser.getExpiresAt()) {
			commence(response, new TokenAuthenticationException(TokenException.TOKEN_EXPIRE_EXCEPTION));
		}
		return loginUser;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		SContextHolder.clearContext();
	}

	/**
	 * 获取请求 HeadToken
	 */
	private String getHeadToken(HttpServletRequest request, HttpServletResponse response) {
		// 解析 head token
		String headToken = null;
		try {
			headToken = this.tokenResolver.resolve(request);
		}
		catch (TokenResolverException invalid) {
			commence(response, invalid);
		}
		return headToken;
	}

	private String getRequestPath(HttpServletRequest request) {
		String url = request.getServletPath();
		String pathInfo = request.getPathInfo();
		if (pathInfo != null) {
			url = StringUtils.hasLength(url) ? url + pathInfo : pathInfo;
		}
		return url;
	}

	private void commence(HttpServletResponse response, ServerRuntimeException exception) {
		try {
			String errorMessage = "token is unauthorized";
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(JacksonUtil.toString(R.fail(exception.getCode(), errorMessage)));
			out.flush();
			out.close();
		}
		catch (IOException e) {
			LOGGER.error("返回错误信息失败", e);
		}
	}

}
