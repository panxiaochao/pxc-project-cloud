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
		long start = System.currentTimeMillis();
		ConfigurableApplicationContext application = SpringApplication.run(PxcSystemApplication.class, args);
		Environment env = application.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		String applicationName = env.getProperty("spring.application.name");
		String port = env.getProperty("server.port");
		String path = env.getProperty("server.servlet.context-path");
		if (!StringUtils.hasText(path) || PATH.equals(path)) {
			path = "";
		}
		String banner = "\n----------------------------------------------------------\n";
		banner += String.format("%s is running! Access URLs:\n", applicationName);
		banner += String.format("Local    访问网址: http://localhost:%s%s\n", port, path);
		banner += String.format("External 访问网址: http://%s:%s%s\n", ip, port, path);
		banner += String.format("Doc      访问网址: http://%s:%s%s/doc.html\n", ip, port, path);
		long end = System.currentTimeMillis() - start;
		banner += String.format("耗时         启动: %d ms\n", end);
		LOG.info(banner);
	}

}
