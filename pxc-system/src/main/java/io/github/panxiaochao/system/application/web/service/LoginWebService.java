package io.github.panxiaochao.system.application.web.service;

import io.github.panxiaochao.core.utils.JacksonUtil;
import io.github.panxiaochao.system.application.web.request.LoginRequest;
import org.apache.tomcat.util.codec.binary.Base64;
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

	@Resource
	private RestTemplate restTemplate;

	public Map<String, Object> login(LoginRequest loginRequest) {
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
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:18000/oauth2/v1/token",
				HttpMethod.POST, requestEntity, String.class);
		Map<String, Object> result = JacksonUtil.toMap(response.getBody());
		result.put("token", result.get("access_token"));
		return result;
	}

	private String basicAuth() {
		String auth = "client_auth:123456@";
		return "Basic " + Base64.encodeBase64String(auth.getBytes(StandardCharsets.US_ASCII));
	}

}
