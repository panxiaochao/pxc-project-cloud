package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtype.DatabaseFieldTypeQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtype.DatabaseFieldTypeQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IDatabaseFieldTypeReadModelService;
import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldType;
import io.github.panxiaochao.system.development.domain.repository.IDatabaseFieldTypeService;
import io.github.panxiaochao.system.development.infrastructure.convert.IDatabaseFieldTypePOConvert;
import io.github.panxiaochao.system.development.infrastructure.mapper.DatabaseFieldTypeMapper;
import io.github.panxiaochao.system.development.infrastructure.po.DatabaseFieldTypePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据库字段类型码表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Service
@RequiredArgsConstructor
public class DatabaseFieldTypeServiceImpl implements IDatabaseFieldTypeService, IDatabaseFieldTypeReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final DatabaseFieldTypeMapper databaseFieldTypeMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 数据库字段类型码表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<DatabaseFieldTypeQueryResponse> page(Pagination pagination,
			DatabaseFieldTypeQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<DatabaseFieldTypePO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<DatabaseFieldTypePO> page = databaseFieldTypeMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IDatabaseFieldTypePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 数据库字段类型码表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<DatabaseFieldTypeQueryResponse> selectList(DatabaseFieldTypeQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<DatabaseFieldTypePO> lqw = lambdaQuery(queryRequest);
		return IDatabaseFieldTypePOConvert.INSTANCE.toQueryResponse(databaseFieldTypeMapper.selectList(lqw));
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<DatabaseFieldTypePO> lambdaQuery(DatabaseFieldTypeQueryRequest queryRequest) {
		LambdaQueryWrapper<DatabaseFieldTypePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照创建时间倒序排序
			lqw.orderByAsc(DatabaseFieldTypePO::getCreateTime);
			// 如果 数据库字段类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getColumnType())) {
				lqw.eq(DatabaseFieldTypePO::getColumnType, queryRequest.getColumnType());
			}
			// 如果 对应Java属性类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getJavaType())) {
				lqw.eq(DatabaseFieldTypePO::getJavaType, queryRequest.getJavaType());
			}
			// 如果 对应Java包名 不为空
			if (StringUtils.isNotBlank(queryRequest.getPackageName())) {
				lqw.eq(DatabaseFieldTypePO::getPackageName, queryRequest.getPackageName());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return DatabaseFieldType 实体
	 */
	@Override
	public DatabaseFieldType getById(String id) {
		DatabaseFieldTypePO databaseFieldTypePO = databaseFieldTypeMapper.selectById(id);
		return IDatabaseFieldTypePOConvert.INSTANCE.toEntity(databaseFieldTypePO);
	}

	/**
	 * 保存
	 * @param databaseFieldType DatabaseFieldType 实体
	 * @return DatabaseFieldType 实体
	 */
	@Override
	public DatabaseFieldType save(DatabaseFieldType databaseFieldType) {
		DatabaseFieldTypePO databaseFieldTypePO = IDatabaseFieldTypePOConvert.INSTANCE.fromEntity(databaseFieldType);
		databaseFieldTypeMapper.insert(databaseFieldTypePO);
		return IDatabaseFieldTypePOConvert.INSTANCE.toEntity(databaseFieldTypePO);
	}

	/**
	 * 根据主键更新
	 * @param databaseFieldType DatabaseFieldType 实体
	 */
	@Override
	public void update(DatabaseFieldType databaseFieldType) {
		DatabaseFieldTypePO databaseFieldTypePO = IDatabaseFieldTypePOConvert.INSTANCE.fromEntity(databaseFieldType);
		databaseFieldTypeMapper.updateById(databaseFieldTypePO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		databaseFieldTypeMapper.deleteById(id);
	}

}
