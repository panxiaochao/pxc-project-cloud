package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.component.select.Select;
import io.github.panxiaochao.core.component.select.SelectBuilder;
import io.github.panxiaochao.core.component.select.SelectOption;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.CharPools;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.system.application.api.request.databasefieldtype.DatabaseFieldTypeCreateRequest;
import io.github.panxiaochao.system.application.api.request.databasefieldtype.DatabaseFieldTypeQueryRequest;
import io.github.panxiaochao.system.application.api.request.databasefieldtype.DatabaseFieldTypeUpdateRequest;
import io.github.panxiaochao.system.application.api.response.databasefieldtype.DatabaseFieldTypeQueryResponse;
import io.github.panxiaochao.system.application.api.response.databasefieldtype.DatabaseFieldTypeResponse;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.convert.IDatabaseFieldTypeDTOConvert;
import io.github.panxiaochao.system.application.repository.IDatabaseFieldTypeReadModelService;
import io.github.panxiaochao.system.application.runner.helper.CacheHelper;
import io.github.panxiaochao.system.domain.entity.DatabaseFieldType;
import io.github.panxiaochao.system.domain.service.DatabaseFieldTypeDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据库字段类型码表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Service
@RequiredArgsConstructor
public class DatabaseFieldTypeAppService {

	/**
	 * 数据库字段类型码表 Domain服务类
	 */
	private final DatabaseFieldTypeDomainService databaseFieldTypeDomainService;

	/**
	 * 数据库字段类型码表 读模型服务
	 */
	private final IDatabaseFieldTypeReadModelService databaseFieldTypeReadModelService;

	/**
	 * 数据库类型 常量名
	 */
	private static final String DB_TYPE = "DB_TYPE";

	/**
	 * JAVA_TYPE类型 常量名
	 */
	private static final String JAVA_TYPE = "JAVA_TYPE";

	/**
	 * 查询分页
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 数据库字段类型码表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<DatabaseFieldTypeQueryResponse> page(RequestPage requestPage,
			DatabaseFieldTypeQueryRequest queryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<DatabaseFieldTypeQueryResponse> list = databaseFieldTypeReadModelService.page(pagination, queryRequest);
		list.forEach(s -> {
			SysDictItemQueryResponse sysDictItemQueryResponse = CacheHelper.getSysDictItemByValue(DB_TYPE,
					s.getDbType());
			if (Objects.isNull(sysDictItemQueryResponse)) {
				s.setDbTypeStr(StringPools.EMPTY);
			}
			else {
				s.setDbTypeStr(sysDictItemQueryResponse.getDictItemText());
			}
		});
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<DatabaseFieldTypeResponse> getById(String id) {
		DatabaseFieldType databaseFieldType = databaseFieldTypeDomainService.getById(id);
		DatabaseFieldTypeResponse databaseFieldTypeResponse = IDatabaseFieldTypeDTOConvert.INSTANCE
			.toResponse(databaseFieldType);
		return R.ok(databaseFieldTypeResponse);
	}

	/**
	 * 保存
	 * @param databaseFieldTypeCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<DatabaseFieldTypeResponse> save(DatabaseFieldTypeCreateRequest databaseFieldTypeCreateRequest) {
		DatabaseFieldType databaseFieldType = IDatabaseFieldTypeDTOConvert.INSTANCE
			.fromCreateRequest(databaseFieldTypeCreateRequest);
		// 判断 数据库下字段类型是否唯一
		DatabaseFieldTypeQueryRequest queryRequest = new DatabaseFieldTypeQueryRequest();
		queryRequest.setDbType(databaseFieldType.getDbType());
		queryRequest.setColumnType(databaseFieldType.getColumnType());
		List<DatabaseFieldTypeQueryResponse> list = databaseFieldTypeReadModelService.selectList(queryRequest);
		if (!CollectionUtils.isEmpty(list)) {
			return R.fail(String.format("数据库[%s]下字段类型[%s]已存在", databaseFieldType.getDbType().toUpperCase(),
					databaseFieldType.getColumnType()));
		}
		String javaType = databaseFieldType.getPackageName()
			.substring(databaseFieldType.getPackageName().lastIndexOf(CharPools.DOT) + 1);
		databaseFieldType.setJavaType(javaType);
		databaseFieldType = databaseFieldTypeDomainService.save(databaseFieldType);
		DatabaseFieldTypeResponse databaseFieldTypeResponse = IDatabaseFieldTypeDTOConvert.INSTANCE
			.toResponse(databaseFieldType);
		return R.ok(databaseFieldTypeResponse);
	}

	/**
	 * 根据主键更新
	 * @param databaseFieldTypeUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(DatabaseFieldTypeUpdateRequest databaseFieldTypeUpdateRequest) {
		DatabaseFieldType databaseFieldType = IDatabaseFieldTypeDTOConvert.INSTANCE
			.fromUpdateRequest(databaseFieldTypeUpdateRequest);
		String javaType = databaseFieldType.getPackageName()
			.substring(databaseFieldType.getPackageName().lastIndexOf(CharPools.DOT) + 1);
		databaseFieldType.setJavaType(javaType);
		databaseFieldTypeDomainService.update(databaseFieldType);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		databaseFieldTypeDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 获取数据库类型下拉菜单
	 * @return 返回通用下拉菜单
	 */
	public List<Select<String>> selectDbTypes() {
		List<SysDictItemQueryResponse> list = CacheHelper.getSysDictItemListByCode(DB_TYPE);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(false, m.getId(), m.getDictItemText(), m.getDictItemValue(), m.getSort(), null))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

	/**
	 * 获取Java类型下拉菜单
	 * @return 返回通用下拉菜单
	 */
	public List<Select<String>> selectJavaTypes() {
		List<SysDictItemQueryResponse> list = CacheHelper.getSysDictItemListByCode(JAVA_TYPE);
		List<SelectOption<String>> selectOptionList = list.stream()
			.map(m -> SelectOption.of(false, m.getId(), m.getDictItemText(), m.getDictItemValue(), m.getSort(), null))
			.collect(Collectors.toList());
		List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
		return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
	}

}
