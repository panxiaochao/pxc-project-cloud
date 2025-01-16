package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.gentablecolumn.GenTableColumnQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gentablecolumn.GenTableColumnQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IGenTableColumnReadModelService;
import io.github.panxiaochao.system.development.domain.entity.GenTableColumn;
import io.github.panxiaochao.system.development.domain.repository.IGenTableColumnService;
import io.github.panxiaochao.system.development.infrastructure.convert.IGenTableColumnPOConvert;
import io.github.panxiaochao.system.development.infrastructure.mapper.GenTableColumnMapper;
import io.github.panxiaochao.system.development.infrastructure.po.GenTableColumnPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 代码生成表字段 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Service
@RequiredArgsConstructor
public class GenTableColumnServiceImpl implements IGenTableColumnService, IGenTableColumnReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final GenTableColumnMapper genTableColumnMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 代码生成表字段查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<GenTableColumnQueryResponse> page(Pagination pagination, GenTableColumnQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTableColumnPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<GenTableColumnPO> page = genTableColumnMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IGenTableColumnPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 代码生成表字段查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<GenTableColumnQueryResponse> selectList(GenTableColumnQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTableColumnPO> lqw = lambdaQuery(queryRequest);
		return IGenTableColumnPOConvert.INSTANCE.toQueryResponse(genTableColumnMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 代码生成表字段查询请求对象
	 * @return 代码生成表字段查询响应对象
	 */
	@Override
	public GenTableColumnQueryResponse getOne(GenTableColumnQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTableColumnPO> lqw = lambdaQuery(queryRequest);
		try {
			GenTableColumnPO genTableColumnPO = genTableColumnMapper.selectOne(lqw);
			return IGenTableColumnPOConvert.INSTANCE.toQueryResponse(genTableColumnPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 代码生成表字段查询请求对象
	 * @return 代码生成表字段Lambda表达式
	 */
	private LambdaQueryWrapper<GenTableColumnPO> lambdaQuery(GenTableColumnQueryRequest queryRequest) {
		LambdaQueryWrapper<GenTableColumnPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(GenTableColumnPO::getId);
			// 如果 表名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getTableName())) {
				lqw.eq(GenTableColumnPO::getTableName, queryRequest.getTableName());
			}
			// 如果 表ID 不为空
			if (StringUtils.isNotBlank(queryRequest.getTableId())) {
				lqw.eq(GenTableColumnPO::getTableId, queryRequest.getTableId());
			}
			// 如果 字段名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getFieldName())) {
				lqw.eq(GenTableColumnPO::getFieldName, queryRequest.getFieldName());
			}
			// 如果 字段类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getFieldType())) {
				lqw.eq(GenTableColumnPO::getFieldType, queryRequest.getFieldType());
			}
			// 如果 字段说明 不为空
			if (StringUtils.isNotBlank(queryRequest.getFieldComment())) {
				lqw.eq(GenTableColumnPO::getFieldComment, queryRequest.getFieldComment());
			}
			// 如果 属性名 不为空
			if (StringUtils.isNotBlank(queryRequest.getAttrName())) {
				lqw.eq(GenTableColumnPO::getAttrName, queryRequest.getAttrName());
			}
			// 如果 属性类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getAttrType())) {
				lqw.eq(GenTableColumnPO::getAttrType, queryRequest.getAttrType());
			}
			// 如果 属性包名 不为空
			if (StringUtils.isNotBlank(queryRequest.getPackageName())) {
				lqw.eq(GenTableColumnPO::getPackageName, queryRequest.getPackageName());
			}
			// 如果 排序 不为空
			if (StringUtils.isNotBlank(queryRequest.getSort())) {
				lqw.eq(GenTableColumnPO::getSort, queryRequest.getSort());
			}
			// 如果 自动填充 DEFAULT、INSERT、UPDATE、INSERT_UPDATE 不为空
			if (StringUtils.isNotBlank(queryRequest.getAutoFill())) {
				lqw.eq(GenTableColumnPO::getAutoFill, queryRequest.getAutoFill());
			}
			// 如果 主键 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getPrimaryPk())) {
				lqw.eq(GenTableColumnPO::getPrimaryPk, queryRequest.getPrimaryPk());
			}
			// 如果 基类字段 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getBaseField())) {
				lqw.eq(GenTableColumnPO::getBaseField, queryRequest.getBaseField());
			}
			// 如果 表单项 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getFormItem())) {
				lqw.eq(GenTableColumnPO::getFormItem, queryRequest.getFormItem());
			}
			// 如果 表单必填 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getFormRequired())) {
				lqw.eq(GenTableColumnPO::getFormRequired, queryRequest.getFormRequired());
			}
			// 如果 表单类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getFormType())) {
				lqw.eq(GenTableColumnPO::getFormType, queryRequest.getFormType());
			}
			// 如果 表单效验 不为空
			if (StringUtils.isNotBlank(queryRequest.getFormValidator())) {
				lqw.eq(GenTableColumnPO::getFormValidator, queryRequest.getFormValidator());
			}
			// 如果 列表项 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getGridItem())) {
				lqw.eq(GenTableColumnPO::getGridItem, queryRequest.getGridItem());
			}
			// 如果 列表排序 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getGridSort())) {
				lqw.eq(GenTableColumnPO::getGridSort, queryRequest.getGridSort());
			}
			// 如果 查询项 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getQueryItem())) {
				lqw.eq(GenTableColumnPO::getQueryItem, queryRequest.getQueryItem());
			}
			// 如果 查询方式 不为空
			if (StringUtils.isNotBlank(queryRequest.getQueryType())) {
				lqw.eq(GenTableColumnPO::getQueryType, queryRequest.getQueryType());
			}
			// 如果 查询表单类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getQueryFormType())) {
				lqw.eq(GenTableColumnPO::getQueryFormType, queryRequest.getQueryFormType());
			}
			// 如果 字典类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getFieldDict())) {
				lqw.eq(GenTableColumnPO::getFieldDict, queryRequest.getFieldDict());
			}
			// 如果 创建人 不为空
			if (StringUtils.isNotBlank(queryRequest.getCreateId())) {
				lqw.eq(GenTableColumnPO::getCreateId, queryRequest.getCreateId());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(GenTableColumnPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(GenTableColumnPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return GenTableColumn 实体
	 */
	@Override
	public GenTableColumn getById(String id) {
		GenTableColumnPO genTableColumnPO = genTableColumnMapper.selectById(id);
		return IGenTableColumnPOConvert.INSTANCE.toEntity(genTableColumnPO);
	}

	/**
	 * 保存
	 * @param genTableColumn GenTableColumn 实体
	 * @return GenTableColumn 实体
	 */
	@Override
	public GenTableColumn save(GenTableColumn genTableColumn) {
		GenTableColumnPO genTableColumnPO = IGenTableColumnPOConvert.INSTANCE.fromEntity(genTableColumn);
		genTableColumnMapper.insert(genTableColumnPO);
		return IGenTableColumnPOConvert.INSTANCE.toEntity(genTableColumnPO);
	}

	/**
	 * 批量保存
	 * @param list GenTableColumn 数据实体
	 */
	@Override
	public void saveBatch(List<GenTableColumn> list) {
		List<GenTableColumnPO> genTableColumnPOList = IGenTableColumnPOConvert.INSTANCE.fromEntity(list);
		Db.saveBatch(genTableColumnPOList);
	}

	/**
	 * 根据主键更新
	 * @param genTableColumn GenTableColumn 实体
	 */
	@Override
	public void update(GenTableColumn genTableColumn) {
		GenTableColumnPO genTableColumnPO = IGenTableColumnPOConvert.INSTANCE.fromEntity(genTableColumn);
		genTableColumnMapper.updateById(genTableColumnPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		genTableColumnMapper.deleteById(id);
	}

	/**
	 * 根据表ID删除
	 * @param tableId 表主键
	 */
	@Override
	public void deleteByTableId(String tableId) {
		genTableColumnMapper
			.delete(new LambdaQueryWrapper<GenTableColumnPO>().eq(GenTableColumnPO::getTableId, tableId));
	}

}
