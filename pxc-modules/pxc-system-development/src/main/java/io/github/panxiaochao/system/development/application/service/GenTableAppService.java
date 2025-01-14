package io.github.panxiaochao.system.development.application.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.NamingCase;
import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.DbMetaUtil;
import io.github.panxiaochao.core.utils.meta.db.ColumnMeta;
import io.github.panxiaochao.core.utils.meta.db.TableMeta;
import io.github.panxiaochao.system.development.application.api.request.gentable.DsQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentable.GenTableCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.gentable.GenTableQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.gentable.GenTableUpdateRequest;
import io.github.panxiaochao.system.development.application.api.response.gentable.GenTableQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.gentable.GenTableResponse;
import io.github.panxiaochao.system.development.application.api.response.gentable.TableMetaQueryResponse;
import io.github.panxiaochao.system.development.application.convert.IGenTableDTOConvert;
import io.github.panxiaochao.system.development.application.convert.ITableMetaDTOConvert;
import io.github.panxiaochao.system.development.application.repository.IGenTableReadModelService;
import io.github.panxiaochao.system.development.config.CodeGeneratorProperties;
import io.github.panxiaochao.system.development.domain.entity.GenTable;
import io.github.panxiaochao.system.development.domain.entity.GenTableColumn;
import io.github.panxiaochao.system.development.domain.service.GenTableDomainService;
import io.github.panxiaochao.system.development.enums.AutoFillEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 代码生成表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Service
@RequiredArgsConstructor
public class GenTableAppService {

	/**
	 * 代码生成表 Domain服务类
	 */
	private final GenTableDomainService genTableDomainService;

	/**
	 * 代码生成表 读模型服务
	 */
	private final IGenTableReadModelService genTableReadModelService;

	/**
	 * 数据源
	 */
	private final DataSource dataSource;

	/**
	 * 数据源创建器
	 */
	private final DefaultDataSourceCreator defaultDataSourceCreator;

	/**
	 * 生成代码属性配置
	 */
	private final CodeGeneratorProperties codeGeneratorProperties;

	/**
	 * 查询分页
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<GenTableQueryResponse> page(RequestPage requestPage, GenTableQueryRequest queryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<GenTableQueryResponse> list = genTableReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 查询动态数据源下的元数据表分页
	 * @param requestPage 请求分页参数对象
	 * @param dsQueryRequest 多数据源表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<TableMetaQueryResponse> queryDsTablePage(RequestPage requestPage,
			DsQueryRequest dsQueryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		if (!StringUtils.hasText(dsQueryRequest.getDbName())) {
			return new PageResponse<>(pagination, new ArrayList<>());
		}
		// 手动切换数据源
		DynamicDataSourceContextHolder.push(dsQueryRequest.getDbName());
		List<TableMeta> tableMetaList = DbMetaUtil.getSimplifyTableMeta(dataSource, null, null, null);
		List<TableMeta> records = CollUtil.page((int) pagination.getPageNo() - 1, (int) pagination.getPageSize(),
				tableMetaList);
		pagination.setTotal(tableMetaList.size());
		return new PageResponse<>(pagination, ITableMetaDTOConvert.INSTANCE.toQueryResponse(records));
	}

	/**
	 * 查询动态数据源下的元数据表
	 * @param dsQueryRequest 多数据源表查询请求对象
	 * @return 分页数组响应实体
	 */
	public List<TableMetaQueryResponse> queryDsTable(DsQueryRequest dsQueryRequest) {
		if (!StringUtils.hasText(dsQueryRequest.getDbName())) {
			return new ArrayList<>();
		}
		// 手动切换数据源
		DynamicDataSourceContextHolder.push(dsQueryRequest.getDbName());
		List<TableMeta> tableMetaList = DbMetaUtil.getSimplifyTableMeta(dataSource, null, null, null);
		return ITableMetaDTOConvert.INSTANCE.toQueryResponse(tableMetaList);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<GenTableResponse> getById(String id) {
		GenTable genTable = genTableDomainService.getById(id);
		GenTableResponse genTableResponse = IGenTableDTOConvert.INSTANCE.toResponse(genTable);
		return R.ok(genTableResponse);
	}

	/**
	 * 保存
	 * @param genTableCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<GenTableResponse> save(GenTableCreateRequest genTableCreateRequest) {
		GenTable genTable = IGenTableDTOConvert.INSTANCE.fromCreateRequest(genTableCreateRequest);
		genTable = genTableDomainService.save(genTable);
		GenTableResponse genTableResponse = IGenTableDTOConvert.INSTANCE.toResponse(genTable);
		return R.ok(genTableResponse);
	}

	/**
	 * 根据主键更新
	 * @param genTableUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(GenTableUpdateRequest genTableUpdateRequest) {
		GenTable genTable = IGenTableDTOConvert.INSTANCE.fromUpdateRequest(genTableUpdateRequest);
		genTableDomainService.update(genTable);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		genTableDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 增加动态数据源状态
	 */
	public void addDataSource(GenTable genTable) {
		DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
		// String name = rs.getString("name");
		// String url = rs.getString("url");
		// String username = rs.getString("username");
		// String password = rs.getString("password");
		// DataSourceProperty property = new DataSourceProperty();
		// property.setUsername(genTable.getu);
		// property.setLazy(true);
		// property.setPassword(password);
		// property.setUrl(url);

	}

	/**
	 * 通过选择数据源导入需要生成代码的数据表
	 * @param datasourceId 数据源ID
	 * @param dbName 数据源名称
	 * @param tableNames 需要导入的数据表数组
	 */
	public void importTables(String datasourceId, String dbName, List<String> tableNames) {
		if (!CollectionUtils.isEmpty(tableNames)) {
			for (String tableName : tableNames) {
				// 1.检验tableName是否已存在
				GenTableQueryRequest queryRequest = new GenTableQueryRequest();
				queryRequest.setTableName(tableName);
				queryRequest.setDatasourceId(datasourceId);
				GenTableQueryResponse genTableQueryResponse = genTableReadModelService.getOne(queryRequest);
				// 如果存在，就跳过继续
				if (genTableQueryResponse != null) {
					continue;
				}
				// 手动切换数据源
				DynamicDataSourceContextHolder.push(dbName);
				// 2.获取数据表属性实体
				List<TableMeta> tableMetaList = DbMetaUtil.getSimplifyTableMeta(dataSource, null, null, tableName);
				// 3.获取某表的字段属性实体
				List<ColumnMeta> columnMetaList = DbMetaUtil.getColumnMeta(dataSource, null, null, tableName);
				// 使用默认数据源，进行存储工作
				DynamicDataSourceContextHolder.clear();
				GenTable genTable = buildGenTable(datasourceId, tableMetaList.get(0));
				List<GenTableColumn> genTableColumnList = buildGenTableColumnList(columnMetaList);
				genTableDomainService.save(genTable);

			}
		}
	}

	/**
	 * 构建数据表元数据
	 * @param datasourceId 数据源ID
	 * @param tableMeta 数据表元数据
	 * @return GenTable
	 */
	private GenTable buildGenTable(String datasourceId, TableMeta tableMeta) {
		GenTable genTable = new GenTable();
		genTable.setTableName(tableMeta.getTableName());
		genTable.setClassName(NamingCase.toPascalCase(tableMeta.getTableName()));
		genTable.setTableComment(tableMeta.getTableComment());
		genTable.setAuthor(codeGeneratorProperties.getAuthor());
		genTable.setEmail(codeGeneratorProperties.getEmail());
		genTable.setPackageName(codeGeneratorProperties.getPackageName());
		genTable.setVersion(codeGeneratorProperties.getVersion());
		genTable.setGeneratorType(codeGeneratorProperties.getGeneratorType());
		genTable.setBackendPath(codeGeneratorProperties.getBackendPath());
		genTable.setFrontendPath(codeGeneratorProperties.getFrontendPath());
		genTable.setModuleName(codeGeneratorProperties.getModuleName());
		// 功能名：a_b aB
		genTable.setFunctionName(StrUtil.toCamelCase(tableMeta.getTableName()));
		genTable.setFormLayout(codeGeneratorProperties.getFormLayout());
		genTable.setDatasourceId(datasourceId);
		return genTable;
	}

	private List<GenTableColumn> buildGenTableColumnList(List<ColumnMeta> columnMetaList) {
		List<GenTableColumn> genTableColumnList = new ArrayList<>();
		// 序号
		AtomicInteger index = new AtomicInteger(0);
		for (ColumnMeta columnMeta : columnMetaList) {
			GenTableColumn genTableColumn = new GenTableColumn();
			genTableColumn.setTableName(columnMeta.getTableName());
			genTableColumn.setFieldName(columnMeta.getColumnName());
			genTableColumn.setFieldType(columnMeta.getJdbcTypeName());
			genTableColumn.setFieldComment(columnMeta.getColumnComment());
			genTableColumn.setPrimaryPk(columnMeta.isAutoIncrement() ? "1" : "0");
			genTableColumn.setAutoFill(AutoFillEnum.DEFAULT.name());
			genTableColumn.setFormItem(CommonConstant.IS_DELETE.toString());
			genTableColumn.setGridItem(CommonConstant.IS_DELETE.toString());
			genTableColumn.setQueryType("=");
			genTableColumn.setQueryFormType("text");
			genTableColumn.setFormType("text");
			genTableColumn.setSort(String.valueOf(index.getAndIncrement()));
			genTableColumnList.add(genTableColumn);
		}

		return genTableColumnList;
	}

}
