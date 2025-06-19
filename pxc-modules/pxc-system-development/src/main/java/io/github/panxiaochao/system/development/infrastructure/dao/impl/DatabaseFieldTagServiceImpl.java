package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.databasefieldtag.DatabaseFieldTagQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.databasefieldtag.DatabaseFieldTagQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IDatabaseFieldTagReadModelService;
import io.github.panxiaochao.system.development.domain.entity.DatabaseFieldTag;
import io.github.panxiaochao.system.development.domain.repository.IDatabaseFieldTagService;
import io.github.panxiaochao.system.development.infrastructure.convert.IDatabaseFieldTagPOConvert;
import io.github.panxiaochao.system.development.infrastructure.dao.mapper.DatabaseFieldTagMapper;
import io.github.panxiaochao.system.development.infrastructure.dao.po.DatabaseFieldTagPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【数据库字段类型-数据库标签表】Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-06-19
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class DatabaseFieldTagServiceImpl implements IDatabaseFieldTagService, IDatabaseFieldTagReadModelService {

	/**
	 * 数据库字段类型-数据库标签表 持久化接口
	 */
	private final DatabaseFieldTagMapper databaseFieldTagMapper;

	/**
	 * 查询 数据库字段类型-数据库标签表分页数据
	 * @param pagination 分页属性对象
	 * @param queryRequest 数据库字段类型-数据库标签表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<DatabaseFieldTagQueryResponse> page(Pagination pagination, DatabaseFieldTagQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<DatabaseFieldTagPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<DatabaseFieldTagPO> page = databaseFieldTagMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IDatabaseFieldTagPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询 数据库字段类型-数据库标签表对象数组
	 * @param queryRequest 数据库字段类型-数据库标签表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<DatabaseFieldTagQueryResponse> selectList(DatabaseFieldTagQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<DatabaseFieldTagPO> lqw = lambdaQuery(queryRequest);
		return IDatabaseFieldTagPOConvert.INSTANCE.toQueryResponse(databaseFieldTagMapper.selectList(lqw));
	}

	/**
	 * 查询 数据库字段类型-数据库标签表单条记录
	 * @param queryRequest 数据库字段类型-数据库标签表查询请求对象
	 * @param throwEx boolean 参数，为true如果存在多个结果直接抛出异常
	 * @return 数据库字段类型-数据库标签表查询响应对象
	 */
	@Override
	public DatabaseFieldTagQueryResponse getOne(DatabaseFieldTagQueryRequest queryRequest, boolean throwEx) {
		// 构造查询条件
		LambdaQueryWrapper<DatabaseFieldTagPO> lqw = lambdaQuery(queryRequest);
		try {
			DatabaseFieldTagPO databaseFieldTagPO = databaseFieldTagMapper.selectOne(lqw, throwEx);
			return IDatabaseFieldTagPOConvert.INSTANCE.toQueryResponse(databaseFieldTagPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 数据库字段类型-数据库标签表查询请求对象
	 * @return 数据库字段类型-数据库标签表Lambda表达式
	 */
	private LambdaQueryWrapper<DatabaseFieldTagPO> lambdaQuery(DatabaseFieldTagQueryRequest queryRequest) {
		LambdaQueryWrapper<DatabaseFieldTagPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(DatabaseFieldTagPO::getId);
			// 如果 数据库字段类型码表ID 不为空
			if (queryRequest.getFieldTypeId() != null) {
				lqw.eq(DatabaseFieldTagPO::getFieldTypeId, queryRequest.getFieldTypeId());
			}
			// 如果 数据库类型标签 不为空
			if (StringUtils.isNotBlank(queryRequest.getTag())) {
				lqw.eq(DatabaseFieldTagPO::getTag, queryRequest.getTag());
			}
		}
		return lqw;
	}

	/**
	 * 根据主键 获取数据库字段类型-数据库标签表详情
	 * @param id 主键
	 * @return DatabaseFieldTag 实体
	 */
	@Override
	public DatabaseFieldTag getById(String id) {
		DatabaseFieldTagPO databaseFieldTagPO = databaseFieldTagMapper.selectById(id);
		return IDatabaseFieldTagPOConvert.INSTANCE.toEntity(databaseFieldTagPO);
	}

	/**
	 * 保存数据库字段类型-数据库标签表对象
	 * @param databaseFieldTag DatabaseFieldTag 实体
	 * @return DatabaseFieldTag 实体
	 */
	@Override
	public DatabaseFieldTag save(DatabaseFieldTag databaseFieldTag) {
		DatabaseFieldTagPO databaseFieldTagPO = IDatabaseFieldTagPOConvert.INSTANCE.fromEntity(databaseFieldTag);
		databaseFieldTagMapper.insert(databaseFieldTagPO);
		return IDatabaseFieldTagPOConvert.INSTANCE.toEntity(databaseFieldTagPO);
	}

	/**
	 * 批量 保存数据库字段类型-数据库标签表对象
	 * @param list 批量数据
	 * @return DatabaseFieldTag 实体数组
	 */
	@Override
	public List<DatabaseFieldTag> saveBatch(List<DatabaseFieldTag> list) {
		List<DatabaseFieldTagPO> databaseFieldTagPOList = IDatabaseFieldTagPOConvert.INSTANCE.fromEntity(list);
		Db.saveBatch(databaseFieldTagPOList);
		return IDatabaseFieldTagPOConvert.INSTANCE.toEntity(databaseFieldTagPOList);
	}

	/**
	 * 根据主键 更新数据库字段类型-数据库标签表对象
	 * @param databaseFieldTag DatabaseFieldTag 实体
	 */
	@Override
	public void update(DatabaseFieldTag databaseFieldTag) {
		DatabaseFieldTagPO databaseFieldTagPO = IDatabaseFieldTagPOConvert.INSTANCE.fromEntity(databaseFieldTag);
		databaseFieldTagMapper.updateById(databaseFieldTagPO);
	}

	/**
	 * 根据主键 批量更新数据库字段类型-数据库标签表对象
	 * @param list 批量数据
	 */
	@Override
	public void updateBatch(List<DatabaseFieldTag> list) {
		List<DatabaseFieldTagPO> databaseFieldTagPOList = IDatabaseFieldTagPOConvert.INSTANCE.fromEntity(list);
		Db.updateBatchById(databaseFieldTagPOList);
	}

	/**
	 * 根据主键 删除数据库字段类型-数据库标签表对象
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		databaseFieldTagMapper.deleteById(id);
	}

	/**
	 * 根据主键 批量删除数据库字段类型-数据库标签表对象
	 * @param list 批量数据
	 */
	@Override
	public void deleteBatch(List<DatabaseFieldTag> list) {
		throw new UnsupportedOperationException("请自定义实现批量删除方法！");
	}

}
