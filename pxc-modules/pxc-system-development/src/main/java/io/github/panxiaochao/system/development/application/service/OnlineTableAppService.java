package io.github.panxiaochao.system.development.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.PageRequest;
import io.github.panxiaochao.system.development.application.api.request.databasesource.DatabaseSourceQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableAndColumnsRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableCreateRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableQueryRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableUpdateRequest;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineColumnRequest;
import io.github.panxiaochao.system.development.application.api.response.databasesource.DatabaseSourceQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.onlinetable.OnlineTableQueryResponse;
import io.github.panxiaochao.system.development.application.api.response.onlinetable.OnlineTableResponse;
import io.github.panxiaochao.system.development.application.convert.IOnlineTableDTOConvert;
import io.github.panxiaochao.system.development.application.repository.IDatabaseSourceReadModelService;
import io.github.panxiaochao.system.development.application.repository.IOnlineTableReadModelService;
import io.github.panxiaochao.system.development.domain.entity.OnlineTable;
import io.github.panxiaochao.system.development.domain.entity.OnlineTableColumn;
import io.github.panxiaochao.system.development.domain.service.OnlineTableColumnDomainService;
import io.github.panxiaochao.system.development.domain.service.OnlineTableDomainService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>
 * 【在线数据表】App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class OnlineTableAppService {

	/**
	 * LOGGER OnlineTableAppService.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OnlineTableAppService.class);

	/**
	 * 在线数据表 Domain服务类
	 */
	private final OnlineTableDomainService onlineTableDomainService;

	/**
	 * 在线数据表字段 Domain服务类
	 */
	private final OnlineTableColumnDomainService onlineTableColumnDomainService;

	/**
	 * 在线数据表 读模型服务
	 */
	private final IOnlineTableReadModelService onlineTableReadModelService;

	/**
	 * 数据库-数据源管理 读模型服务
	 */
	private final IDatabaseSourceReadModelService databaseSourceReadModelService;

	/**
	 * 查询在线数据表分页数据
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 在线数据表查询请求对象
	 * @return 分页对象
	 */
	public PageResponse<OnlineTableQueryResponse> page(PageRequest pageRequest, OnlineTableQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<OnlineTableQueryResponse> list = onlineTableReadModelService.page(pagination, queryRequest);
		// 读取所有数据源
		List<DatabaseSourceQueryResponse> databaseSourceQueryResponseList = databaseSourceReadModelService
			.selectList(new DatabaseSourceQueryRequest());
		Map<String, DatabaseSourceQueryResponse> dataSourceMap = databaseSourceQueryResponseList.stream()
			.collect(Collectors.toMap(DatabaseSourceQueryResponse::getId, Function.identity()));

		list.forEach(m -> {
			if (m.getDatasourceId() != null) {
				DatabaseSourceQueryResponse source = dataSourceMap.get(m.getDatasourceId().toString());
				if (source != null) {
					m.setDbName(source.getDbName());
					m.setDbType(source.getDbType());
				}
			}
		});
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 根据主键获取在线数据表详情
	 * @param id 主键
	 * @return 在线数据表响应对象
	 */
	public R<OnlineTableResponse> getById(String id) {
		OnlineTable onlineTable = onlineTableDomainService.getById(id);
		OnlineTableResponse onlineTableResponse = IOnlineTableDTOConvert.INSTANCE.toResponse(onlineTable);
		return R.ok(onlineTableResponse);
	}

	/**
	 * 保存在线数据表
	 * @param onlineTableCreateRequest 创建请求对象
	 * @return 在线数据表响应对象
	 */
	public R<OnlineTableResponse> save(OnlineTableCreateRequest onlineTableCreateRequest) {
		OnlineTable onlineTable = IOnlineTableDTOConvert.INSTANCE.fromCreateRequest(onlineTableCreateRequest);
		onlineTable = onlineTableDomainService.save(onlineTable);
		OnlineTableResponse onlineTableResponse = IOnlineTableDTOConvert.INSTANCE.toResponse(onlineTable);
		return R.ok(onlineTableResponse);
	}

	/**
	 * 根据主键更新在线数据表
	 * @param onlineTableUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(OnlineTableUpdateRequest onlineTableUpdateRequest) {
		OnlineTable onlineTable = IOnlineTableDTOConvert.INSTANCE.fromUpdateRequest(onlineTableUpdateRequest);
		onlineTableDomainService.update(onlineTable);
		return R.ok();
	}

	/**
	 * 根据主键删除在线数据表
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		onlineTableDomainService.deleteById(id);
		// 删除OnlineTableColumn
		onlineTableColumnDomainService.deleteByTableId(id);
		return R.ok();
	}

	/**
	 * 保存在线数据表和字段数组对象
	 * @param createRequest 创建请求对象
	 * @return 在线数据表响应对象
	 */
	public R<Void> saveTableAndColumns(OnlineTableAndColumnsRequest createRequest) {
		// 先保存 OnlineTable
		OnlineTable onlineTable = new OnlineTable();
		onlineTable.setTableName(createRequest.getTableName());
		onlineTable.setTableComment(createRequest.getTableComment());
		onlineTable.setDatasourceId(createRequest.getDatasourceId());
		try {
			onlineTable = onlineTableDomainService.save(onlineTable);
		}
		catch (Exception e) {
			LOGGER.error("新建表失败", e);
			String message = e.getMessage();
			if (message.contains("Duplicate entry")) {
				return R.fail("数据表已存在");
			}
			else {
				return R.fail("新建表失败，请联系管理员");
			}
		}
		if (!CollectionUtils.isEmpty(createRequest.getColumns())) {
			final String tableId = onlineTable.getId();
			final String tableName = onlineTable.getTableName();
			List<OnlineTableColumn> onlineTableColumns = IntStream.range(0, createRequest.getColumns().size())
				.mapToObj(i -> {
					OnlineColumnRequest onlineColumnRequest = createRequest.getColumns().get(i);
					OnlineTableColumn onlineTableColumn = new OnlineTableColumn();
					onlineTableColumn.setTableId(tableId);
					onlineTableColumn.setTableName(tableName);
					onlineTableColumn.setFieldName(onlineColumnRequest.getFieldName());
					// 安全获取字段类型（避免空列表/空指针导致的IndexOutOfBoundsException）
					List<String> fieldTypes = onlineColumnRequest.getFieldType();
					onlineTableColumn.setFieldType(!CollectionUtils.isEmpty(fieldTypes) ? fieldTypes.get(0) : null);
					onlineTableColumn.setFieldComment(onlineColumnRequest.getFieldComment());
					onlineTableColumn.setColumnSize(onlineColumnRequest.getColumnSize());
					onlineTableColumn.setScale(onlineColumnRequest.getScale());
					onlineTableColumn.setFieldDefault(onlineColumnRequest.getFieldDefault());
					onlineTableColumn.setSort(i);
					onlineTableColumn.setPrimaryPk(BooleanUtils.toString(onlineColumnRequest.isPrimaryPk(), "1", "0"));
					onlineTableColumn
						.setAutoIncrement(BooleanUtils.toString(onlineColumnRequest.isAutoIncrement(), "1", "0"));
					onlineTableColumn.setNullable(BooleanUtils.toString(onlineColumnRequest.isNullable(), "1", "0"));
					return onlineTableColumn;
				})
				.collect(Collectors.toList());
			// 批量保存 OnlineTableColumn
			onlineTableColumnDomainService.saveBatch(onlineTableColumns);
		}
		return R.ok();
	}

}
