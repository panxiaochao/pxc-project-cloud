package io.github.panxiaochao.system.auth.web;

import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.JacksonUtil;
import io.github.panxiaochao.core.utils.StrUtil;
import io.github.panxiaochao.core.utils.StringPools;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

	private TokenResolver tokenResolver;

	private JWTDecoder jwtDecoder;

	private PTokenType tokenType;

	private final List<RequestMatcher> requestMatchers = new ArrayList<>();

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
		if (!CollectionUtils.isEmpty(whiteUrls)) {
			whiteUrls.forEach(url -> {
				String[] splits = StrUtil.split(url, StringPools.COMMA);
				if (splits.length > 1 && !splits[1].equals(StringPools.ASTERISK)) {
					requestMatchers.add(new AntPathRequestMatcher(splits[0], splits[1].toUpperCase()));
				}
				else {
					requestMatchers.add(new AntPathRequestMatcher(splits[0]));
				}
			});
		}
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
		LOGGER.info("url:{}, method:[{}]", url, request.getMethod());
		if (!CollectionUtils.isEmpty(requestMatchers)
				&& requestMatchers.stream().anyMatch(matcher -> matcher.matches(request))) {
			return true;
		}
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
					// fix(preHandle)[2024-07-01 16:52:42]:修复报错直接返回false
					return false;
				}
			}
			loginUser = getRedisToken(headToken, response);
		}
		else if (StrUtil.isNotBlank(token)) {
			// 浏览器参数token判断逻辑
		}
		LOGGER.info("url:{}, token:{}, headToken:{}", url, token, headToken);
		if (StrUtil.isAllBlank(token, headToken)) {
			LOGGER.info("url:{}, token is empty!", url);
			commence(response, new TokenAuthenticationException(TokenException.TOKEN_EMPTY_EXCEPTION));
			return false;
		}
		try {
			// 缓存中Token数据已失效
			if (null == loginUser) {
				LOGGER.info("url:{}, loginUser is empty!", url);
				commence(response, new TokenAuthenticationException(TokenException.TOKEN_EXPIRE_EXCEPTION));
				// fix(preHandle)[2024-06-17 14:57:44]:修复报错直接返回false
				return false;
			}
			// SContextHolder 上下文构建存储 Token
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
		if (null == loginUser || System.currentTimeMillis() > loginUser.getExpiresAt()) {
			// fix(getRedisToken)[2024-07-01 16:50:25]: Redis为空或者当前时间已大于过期时间
			return null;
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
		catch (TokenResolverException e) {
			// fix(getHeadToken)[2024-07-01 16:55:50]: 报错直接打印，返回NULL
			LOGGER.error("TokenResolver is error", e);
			return null;
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
