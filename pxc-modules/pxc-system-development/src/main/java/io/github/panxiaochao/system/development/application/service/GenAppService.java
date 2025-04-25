package io.github.panxiaochao.system.development.application.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import io.github.panxiaochao.core.enums.CommonResponseEnum;
import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.utils.BooleanUtil;
import io.github.panxiaochao.core.utils.CollectionUtil;
import io.github.panxiaochao.core.utils.StrUtil;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.core.utils.date.LocalDateTimeUtil;
import io.github.panxiaochao.system.common.utils.FreemarkerUtils;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtype.DatabaseFieldTypeQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentablecolumn.GenTableColumnQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtype.DatabaseFieldTypeQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gen.PreviewResponse;
import io.github.panxiaochao.system.development.application.api.response.gentablecolumn.GenTableColumnQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IDatabaseFieldTypeReadModelService;
import io.github.panxiaochao.system.development.application.repository.IGenTableColumnReadModelService;
import io.github.panxiaochao.system.development.application.repository.IGenTemplateReadModelService;
import io.github.panxiaochao.system.development.domain.entity.DatabaseSource;
import io.github.panxiaochao.system.development.domain.entity.GenTable;
import io.github.panxiaochao.system.development.domain.service.DatabaseSourceDomainService;
import io.github.panxiaochao.system.development.domain.service.GenTableDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <p>
 * 代码生成生成 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-04-01
 */
@Service
@RequiredArgsConstructor
public class GenAppService {

	/**
	 * 代码生成表 Domain服务类
	 */
	private final GenTableDomainService genTableDomainService;

	/**
	 * 数据库-数据源管理 Domain服务类
	 */
	private final DatabaseSourceDomainService databaseSourceDomainService;

	/**
	 * 代码生成表字段 读模型服务
	 */
	private final IGenTableColumnReadModelService genTableColumnReadModelService;

	/**
	 * 数据库字段类型码表 读模型服务
	 */
	private final IDatabaseFieldTypeReadModelService databaseFieldTypeReadModelService;

	/**
	 * 模板 读模型服务
	 */
	private final IGenTemplateReadModelService genTemplateReadModelService;

	/**
	 * 预览代码
	 * @param tableId 表ID
	 * @return {@link List<PreviewResponse>}
	 */
	public List<PreviewResponse> preview(String tableId) {
		// 1.组装数据模型
		Map<String, Object> dataModel = getDataModel(tableId);
		// 2.获取代码模板
		String style = (String) dataModel.get("style");
		List<GenTemplateQueryResponse> templates = genTemplateReadModelService.selectByGroupId(style);
		return templates.stream().map(template -> {
			String templateName = template.getTemplateName();
			String content = FreemarkerUtils.getContent(templateName, template.getTemplateCode(), dataModel);
			String generatorPath = FreemarkerUtils.getContent(templateName, template.getGeneratorPath(), dataModel);
			String fileName = generatorPath.substring(generatorPath.lastIndexOf("/") + 1);
			return new PreviewResponse(template.getId(), fileName, generatorPath, content, template.getTemplateType());
		}).collect(Collectors.toList());
	}

	/**
	 * 生成代码 - ZIP
	 * @param tableId 表格 ID
	 * @param zip 压缩流
	 */
	public void download(String tableId, ZipOutputStream zip) {
		Map<String, Object> dataModel = getDataModel(tableId);
		String style = (String) dataModel.get("style");
		List<GenTemplateQueryResponse> templates = genTemplateReadModelService.selectByGroupId(style);
		for (GenTemplateQueryResponse template : templates) {
			String content = FreemarkerUtils.getContent(template.getTemplateName(), template.getTemplateCode(),
					dataModel);
			String generatorPath = FreemarkerUtils.getContent(template.getTemplateName(), template.getGeneratorPath(),
					dataModel);
			try {
				zip.putNextEntry(new ZipEntry(generatorPath));
				IoUtil.writeUtf8(zip, false, content);
				zip.flush();
				zip.closeEntry();
			}
			catch (IOException e) {
				throw new ServerRuntimeException(CommonResponseEnum.INTERNAL_SERVER_ERROR, "ZIP写入失败！");
			}
		}
	}

	/**
	 * 生成代码 - 自定义路径
	 * @param tableId 表格 ID
	 */
	public void generatorCode(String tableId) {
		Map<String, Object> dataModel = getDataModel(tableId);
		String style = (String) dataModel.get("style");
		List<GenTemplateQueryResponse> templates = genTemplateReadModelService.selectByGroupId(style);
		for (GenTemplateQueryResponse template : templates) {
			String content = FreemarkerUtils.getContent(template.getTemplateName(), template.getTemplateCode(),
					dataModel);
			String generatorPath = FreemarkerUtils.getContent(template.getTemplateName(), template.getGeneratorPath(),
					dataModel);
			FileUtil.writeUtf8String(content, generatorPath);
		}
	}

	/**
	 * 通过 Lambda 表达式优化的获取数据模型方法
	 * @param tableId 表格 ID
	 * @return 数据模型 Map 对象
	 */
	private Map<String, Object> getDataModel(String tableId) {
		// 获取表格信息
		GenTable table = genTableDomainService.getById(tableId);
		// 获取字段列表
		GenTableColumnQueryRequest queryRequest = new GenTableColumnQueryRequest();
		queryRequest.setTableId(tableId);
		List<GenTableColumnQueryResponse> columnList = genTableColumnReadModelService.selectList(queryRequest);
		// 创建数据模型对象
		Map<String, Object> dataModel = new HashMap<>();

		// 数据库类型
		DatabaseSource databaseSource = databaseSourceDomainService.getById(table.getDatasourceId());
		dataModel.put("dbType", databaseSource.getDbType());

		// 项目信息
		dataModel.put("package", packageModel(table));
		dataModel.put("packagePath", table.getPackageName().replace(".", File.separator));
		dataModel.put("version", table.getVersion());
		dataModel.put("moduleName", table.getModuleName());
		dataModel.put("ModuleName", StrUtil.upperFirst(table.getModuleName()));
		dataModel.put("functionName", table.getFunctionName());
		dataModel.put("FunctionName", StrUtil.upperFirst(table.getFunctionName()));
		dataModel.put("formLayout", table.getFormLayout());

		// 类名
		// dataModel.put("ControllerName", String.join(StringPools.EMPTY,
		// table.getClassName(), "Api"));
		// dataModel.put("ServiceName", String.join(StringPools.EMPTY,
		// table.getClassName(), "Service"));
		// dataModel.put("ServiceImplName", String.join(StringPools.EMPTY,
		// table.getClassName(), "ServiceImpl"));
		// dataModel.put("MapperName", String.join(StringPools.EMPTY,
		// table.getClassName(), "Mapper"));

		// 开发者信息
		dataModel.put("email", table.getEmail());
		dataModel.put("style", table.getStyle());
		dataModel.put("author", table.getAuthor());
		dataModel.put("datetime", LocalDateTimeUtil.localDateTimeToTimestamp(LocalDateTime.now()));
		dataModel.put("date", LocalDateTimeUtil.localDateToString(LocalDate.now()));

		// 设置字段分类
		setFieldTypeList(dataModel, columnList);

		// 获取导入的包列表
		List<DatabaseFieldTypeQueryResponse> fieldTypeList = databaseFieldTypeReadModelService
			.selectList(new DatabaseFieldTypeQueryRequest());
		Set<String> importList = fieldTypeList.stream()
			.map(DatabaseFieldTypeQueryResponse::getJavaType)
			.collect(Collectors.toSet());
		dataModel.put("importList", importList);
		dataModel.put("tableName", table.getTableName());
		dataModel.put("tableComment", table.getTableComment());
		dataModel.put("className", StrUtil.lowerFirst(table.getClassName()));
		dataModel.put("ClassName", table.getClassName());
		dataModel.put("classname", table.getClassName().toLowerCase());
		dataModel.put("fieldList", columnList);

		// 生成路径
		dataModel.put("backendPath", table.getBackendPath());
		dataModel.put("frontendPath", table.getFrontendPath());

		return dataModel;
	}

	/**
	 * 包信息
	 * @param table 表格信息
	 * @return 包信息 Map 对象
	 */
	private Map<String, String> packageModel(GenTable table) {
		Map<String, String> packageModel = new HashMap<>();
		packageModel.put("parent", table.getPackageName());
		packageModel.put("application",
				String.join(StringPools.DOT, table.getPackageName(), table.getModuleName(), "application"));
		packageModel.put("applicationPath", packageModel.get("application").replace(".", File.separator));
		packageModel.put("domain",
				String.join(StringPools.DOT, table.getPackageName(), table.getModuleName(), "domain"));
		packageModel.put("domainPath", packageModel.get("domain").replace(".", File.separator));
		packageModel.put("infrastructure",
				String.join(StringPools.DOT, table.getPackageName(), table.getModuleName(), "infrastructure"));
		packageModel.put("infrastructurePath", packageModel.get("infrastructure").replace(".", File.separator));
		return packageModel;
	}

	/**
	 * 将表字段按照类型分组并存储到数据模型中
	 * @param dataModel 存储数据的 Map 对象
	 * @param columnList 表字段列表
	 */
	private void setFieldTypeList(Map<String, Object> dataModel, List<GenTableColumnQueryResponse> columnList) {
		// 按字段类型分组，使用 Map 存储不同类型的字段列表
		Map<Boolean, List<GenTableColumnQueryResponse>> typeMap = columnList.stream()
			.collect(Collectors.partitioningBy(columnEntity -> BooleanUtil.toBoolean(columnEntity.getPrimaryPk())));
		// 从分组后的 Map 中获取不同类型的字段列表
		List<GenTableColumnQueryResponse> primaryList = typeMap.get(true);
		List<GenTableColumnQueryResponse> formList = typeMap.get(false)
			.stream()
			.filter(columnEntity -> BooleanUtil.toBoolean(columnEntity.getFormItem()))
			.collect(Collectors.toList());
		List<GenTableColumnQueryResponse> gridList = typeMap.get(false)
			.stream()
			.filter(columnEntity -> BooleanUtil.toBoolean(columnEntity.getGridItem()))
			.collect(Collectors.toList());
		List<GenTableColumnQueryResponse> queryList = typeMap.get(false)
			.stream()
			.filter(columnEntity -> BooleanUtil.toBoolean(columnEntity.getQueryItem()))
			.collect(Collectors.toList());

		if (CollectionUtil.isNotEmpty(primaryList)) {
			dataModel.put("pk", primaryList.get(0));
		}
		dataModel.put("primaryList", primaryList);
		dataModel.put("formList", formList);
		dataModel.put("gridList", gridList);
		dataModel.put("queryList", queryList);
		dataModel.put("fieldList", columnList);
		dataModel.put("fieldNames",
				columnList.stream()
					.map(GenTableColumnQueryResponse::getFieldName)
					.collect(Collectors.joining(StringPools.COMMA)));
	}

}
