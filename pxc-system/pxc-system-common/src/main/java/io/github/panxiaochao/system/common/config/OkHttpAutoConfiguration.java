/*
 * Copyright © 2023-2024 潘骁超 (545685602@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.panxiaochao.system.common.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * OkHttp3 自动配置类
 * </p>
 * Ï
 *
 * @author Lypxc
 * @since 2023-08-18
 */
@Configuration
public class OkHttpAutoConfiguration {

	/**
	 * 连接超时，默认 10 秒，0 表示没有超时限制
	 */
	private final Integer connectTimeout = 10;

	/**
	 * 响应超时，默认 10 秒，0 表示没有超时限制
	 */
	private final Integer readTimeout = 10;

	/**
	 * 写超时，默认 10 秒，0 表示没有超时限制
	 */
	private final Integer writeTimeout = 10;

	/**
	 * 连接池中整体的空闲连接的最大数量，默认 5 个连接数
	 */
	private final Integer maxIdleConnections = 10;

	/**
	 * 连接空闲时间最大时间，单位秒，默认 300 秒
	 */
	private final Long keepAliveDuration = 300L;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory());
		restTemplate.getMessageConverters().forEach(httpMessageConverter -> {
			if (httpMessageConverter instanceof StringHttpMessageConverter) {
				// 解决乱码问题
				StringHttpMessageConverter messageConverter = (StringHttpMessageConverter) httpMessageConverter;
				messageConverter.setDefaultCharset(StandardCharsets.UTF_8);
			}
		});
		return restTemplate;
	}

	@Bean
	public ClientHttpRequestFactory httpRequestFactory() {
		return new OkHttp3ClientHttpRequestFactory(okHttpClient());
	}

	@Bean
	public OkHttpClient okHttpClient() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		builder.sslSocketFactory(sslSocketFactory(), x509TrustManager());
		// 是否开启缓存
		builder.setRetryOnConnectionFailure$okhttp(false);
		// 构建列连接池
		ConnectionPool pool = new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.SECONDS);
		builder.setConnectionPool$okhttp(pool);
		builder.connectTimeout(connectTimeout, TimeUnit.SECONDS);
		builder.readTimeout(readTimeout, TimeUnit.SECONDS);
		builder.writeTimeout(writeTimeout, TimeUnit.SECONDS);
		// 设置默认主机验证规则
		builder.setHostnameVerifier$okhttp((hostname, session) -> true);
		return builder.build();
	}

	@Bean
	public X509TrustManager x509TrustManager() {
		return new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		};
	}

	@Bean
	public SSLSocketFactory sslSocketFactory() {
		try {
			// 信任任何链接
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] { x509TrustManager() }, new SecureRandom());
			return sslContext.getSocketFactory();
		}
		catch (Exception e) {
			// skip
		}
		return null;
	}

}
