package io.github.panxiaochao.system.common.utils;

import cn.hutool.core.io.IoUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import io.github.panxiaochao.core.enums.CommonResponseEnum;
import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.utils.StringPools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <p>
 * Freemarker 模板工具类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-04-01
 */
public class FreemarkerUtils {

	/**
	 * LOGGER FreemarkerUtils.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FreemarkerUtils.class);

	private static final Configuration CONFIGURATION;

	static {
		CONFIGURATION = new Configuration(Configuration.VERSION_2_3_34);
		CONFIGURATION.setDefaultEncoding(StandardCharsets.UTF_8.name());
		CONFIGURATION.setClassForTemplateLoading(FreemarkerUtils.class, StringPools.SLASH);
		CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	/**
	 * 将数据模型应用到指定的模板文件，并将处理结果写入到输出文件中
	 * @param templatePath 模板文件的路径
	 * @param outputFile 要写入的数据文件
	 * @param dataModel 包含数据的模型，用于填充模板
	 */
	public void writer(String templatePath, File outputFile, Map<String, Object> dataModel) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
			Template template = CONFIGURATION.getTemplate(templatePath);
			template.process(dataModel, new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
			LOGGER.info("模板:{};  文件:{}", templatePath, outputFile);
		}
		catch (Exception e) {
			throw new ServerRuntimeException(CommonResponseEnum.INTERNAL_SERVER_ERROR, "模版写入失败！");
		}
	}

	/**
	 * 获取模板渲染后的内容
	 * @param content 模板内容
	 * @param dataModel 数据模型
	 */
	public static String getContent(String templateName, String content, Map<String, Object> dataModel) {
		if (dataModel.isEmpty()) {
			return content;
		}
		StringReader reader = new StringReader(content);
		try (StringWriter sw = new StringWriter()) {
			// 渲染模板
			Template template = new Template(templateName, reader, CONFIGURATION, StandardCharsets.UTF_8.name());
			template.process(dataModel, sw);
			content = sw.toString();
		}
		catch (Exception e) {
			throw new ServerRuntimeException(CommonResponseEnum.INTERNAL_SERVER_ERROR, "渲染模板失败，请检查模板语法", e);
		}
		finally {
			IoUtil.close(reader);
		}
		return content;
	}

}
