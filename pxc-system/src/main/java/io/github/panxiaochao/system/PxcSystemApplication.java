package io.github.panxiaochao.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;

/**
 * <p>
 * 系统模块启动类
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-27
 */
@SpringBootApplication
public class PxcSystemApplication {

	private static final Logger LOG = LoggerFactory.getLogger(PxcSystemApplication.class);

	private static final String PATH = "/";

	/**
	 * @param args args
	 * @throws Exception Exception
	 */
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext application = SpringApplication.run(PxcSystemApplication.class, args);
		Environment env = application.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		String applicationName = env.getProperty("spring.application.name");
		String port = env.getProperty("server.port");
		String path = env.getProperty("server.servlet.context-path");
		if (!StringUtils.hasText(path) || PATH.equals(path)) {
			path = "";
		}
		//@formatter:off
		LOG.info("\n----------------------------------------------------------\n" +
				"{} is running! Access URLs:\n" +
				"Local    访问网址: \thttp://localhost:{}{}\n" +
				"External 访问网址: \thttp://{}:{}{}\n" +
				"Doc      访问网址: \thttp://{}:{}{}/doc.html" +
				"\n----------------------------------------------------------\n",
				applicationName, port, path, ip, port, path, ip, port, path);
		//@formatter:on
	}

}
