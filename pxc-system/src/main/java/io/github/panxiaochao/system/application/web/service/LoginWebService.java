package io.github.panxiaochao.system.application.web.service;

import io.github.panxiaochao.core.enums.CommonResponseEnum;
import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.JacksonUtil;
import io.github.panxiaochao.core.utils.MapUtil;
import io.github.panxiaochao.system.application.web.request.LoginRequest;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
public class LoginWebService {

	/**
	 * LOGGER LoginWebService.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginWebService.class);

	@Resource
	private RestTemplate restTemplate;

	@Getter
	@Setter
	@Value("${pxc-auth.url}")
	private String url;

	public R<Map<String, Object>> login(LoginRequest loginRequest) {
		// 设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", basicAuth());
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 将请求头部和参数合成一个请求
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("username", loginRequest.getUsername());
		multiValueMap.add("password", loginRequest.getPassword());
		multiValueMap.add("grant_type", "password");

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(multiValueMap, headers);
		Map<String, Object> result = MapUtil.newHashMap();
		// TODO 需要做登录日志
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
			Map<String, Object> body = JacksonUtil.toMap(response.getBody());
			if (null != body.get("access_token")) {
				result.put("token", body.get("access_token"));
				return R.ok(result);
			} else{
				return R.fail("用户名或密码错误，请重新登录！");
			}
		}
		catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			throw new ServerRuntimeException(CommonResponseEnum.INTERNAL_SERVER_ERROR, "登录异常，请联系管理员!");
		}
	}

	private String basicAuth() {
		String auth = "client_auth:123456@";
		return "Basic " + Base64.encodeBase64String(auth.getBytes(StandardCharsets.US_ASCII));
	}

}
