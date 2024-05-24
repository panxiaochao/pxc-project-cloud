package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.component.select.SelectBuilder;
import io.github.panxiaochao.core.component.select.SelectOption;
import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.JdbcUtil;
import io.github.panxiaochao.system.application.api.request.databasesource.DatabaseSourceCreateRequest;
import io.github.panxiaochao.system.application.api.request.databasesource.DatabaseSourceQueryRequest;
import io.github.panxiaochao.system.application.api.request.databasesource.DatabaseSourceUpdateRequest;
import io.github.panxiaochao.system.application.api.response.databasesource.DatabaseSourceQueryResponse;
import io.github.panxiaochao.system.application.api.response.databasesource.DatabaseSourceResponse;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.convert.IDatabaseSourceDTOConvert;
import io.github.panxiaochao.system.application.repository.IDatabaseSourceReadModelService;
import io.github.panxiaochao.system.application.runner.helper.CacheHelper;
import io.github.panxiaochao.system.domain.entity.DatabaseSource;
import io.github.panxiaochao.system.domain.service.DatabaseSourceDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据库-数据源管理 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Service
@RequiredArgsConstructor
public class DatabaseSourceAppService {

	/**
	 * 数据库-数据源管理 Domain服务类
	 */
	private final DatabaseSourceDomainService databaseSourceDomainService;

	/**
	 * 数据库-数据源管理 读模型服务
	 */
	private final IDatabaseSourceReadModelService databaseSourceReadModelService;

	/**
	 * 数据源类型 常量名
	 */
	private static final String DB_SOURCE = "DB_SOURCE";

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 数据库-数据源管理查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<DatabaseSourceQueryResponse> page(RequestPage pageRequest,
			DatabaseSourceQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<DatabaseSourceQueryResponse> list = databaseSourceReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<DatabaseSourceResponse> getById(String id) {
		DatabaseSource databaseSource = databaseSourceDomainService.getById(id);
		DatabaseSourceResponse databaseSourceResponse = IDatabaseSourceDTOConvert.INSTANCE.toResponse(databaseSource);
		return R.ok(databaseSourceResponse);
	}

	/**
	 * 保存
	 * @param databaseSourceCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<DatabaseSourceResponse> save(DatabaseSourceCreateRequest databaseSourceCreateRequest) {
		DatabaseSource databaseSource = IDatabaseSourceDTOConvert.INSTANCE
			.fromCreateRequest(databaseSourceCreateRequest);
		// 验证是否重复
		DatabaseSourceQueryRequest queryRequest = new DatabaseSourceQueryRequest();
		queryRequest.setDbCode(databaseSource.getDbCode());
		DatabaseSourceQueryResponse one = databaseSourceReadModelService.getOne(queryRequest);
		if (Objects.nonNull(one)) {
			return R.fail("数据库编码[" + one.getDbCode() + "]已存在");
		}
		databaseSource = databaseSourceDomainService.save(databaseSource);
		DatabaseSourceResponse databaseSourceResponse = IDatabaseSourceDTOConvert.INSTANCE.toResponse(databaseSource);
		return R.ok(databaseSourceResponse);
	}

	/**
	 * 根据主键更新
	 * @param databaseSourceUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(DatabaseSourceUpdateRequest databaseSourceUpdateRequest) {
		DatabaseSource databaseSource = IDatabaseSourceDTOConvert.INSTANCE
			.fromUpdateRequest(databaseSourceUpdateRequest);
		databaseSourceDomainService.update(databaseSource);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		databaseSourceDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 获取数据源类型下拉菜单
	 */
	public List<Select<String>> selectDbSources() {
		List<SysDictItemQueryResponse> list = CacheHelper.getSysDictItemListByCode(DB_SOURCE);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(false, m.getId(), m.getDictItemText(), m.getDictItemValue(), m.getSort(),
					extraMap -> extraMap.put("url", m.getRemark())))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

	/**
	 * 测试连接
	 * @param databaseSourceCreateRequest 请求对象
	 * @return 返回数据
	 */
	public R<DatabaseSourceResponse> testConn(DatabaseSourceCreateRequest databaseSourceCreateRequest) {
		DatabaseSource databaseSource = IDatabaseSourceDTOConvert.INSTANCE
			.fromCreateRequest(databaseSourceCreateRequest);
		boolean testConnectionValid = JdbcUtil.testConnection(
				// 连接url
				databaseSource.getDbJdbcUrl(),
				// 用户名
				databaseSource.getDbUsername(),
				// 密码
				databaseSource.getDbPassword());
		// 连接成功
		if (testConnectionValid) {
			databaseSource.setTestConn(CommonConstant.OK.toString());
			databaseSource.setTestConnTime(LocalDateTime.now());
			return R.ok(IDatabaseSourceDTOConvert.INSTANCE.toResponse(databaseSource));
		}
		else {
			databaseSource.setTestConn(CommonConstant.FAIL.toString());
		}
		return R.fail("数据库连接失败", IDatabaseSourceDTOConvert.INSTANCE.toResponse(databaseSource));
	}

}
