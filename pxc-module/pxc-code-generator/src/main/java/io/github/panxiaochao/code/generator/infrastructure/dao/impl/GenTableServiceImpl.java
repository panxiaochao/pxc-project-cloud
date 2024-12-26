package io.github.panxiaochao.code.generator.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.code.generator.application.api.request.gentable.GenTableQueryRequest;
import io.github.panxiaochao.code.generator.application.api.response.gentable.GenTableQueryResponse;
import io.github.panxiaochao.code.generator.application.repository.IGenTableReadModelService;
import io.github.panxiaochao.code.generator.domain.entity.GenTable;
import io.github.panxiaochao.code.generator.domain.repository.IGenTableService;
import io.github.panxiaochao.code.generator.infrastructure.convert.IGenTablePOConvert;
import io.github.panxiaochao.code.generator.infrastructure.mapper.GenTableMapper;
import io.github.panxiaochao.code.generator.infrastructure.po.GenTablePO;
import io.github.panxiaochao.core.response.page.Pagination;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 代码生成表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-12-26
 */
@Service
@RequiredArgsConstructor
public class GenTableServiceImpl implements IGenTableService, IGenTableReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final GenTableMapper genTableMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<GenTableQueryResponse> page(Pagination pagination, GenTableQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTablePO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<GenTablePO> page = genTableMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()),
				lqw);
		pagination.setTotal(page.getTotal());
		return IGenTablePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<GenTableQueryResponse> selectList(GenTableQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTablePO> lqw = lambdaQuery(queryRequest);
		return IGenTablePOConvert.INSTANCE.toQueryResponse(genTableMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 代码生成表查询响应对象
	 */
	@Override
	public GenTableQueryResponse getOne(GenTableQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTablePO> lqw = lambdaQuery(queryRequest);
		try {
			GenTablePO genTablePO = genTableMapper.selectOne(lqw);
			return IGenTablePOConvert.INSTANCE.toQueryResponse(genTablePO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 代码生成表查询请求对象
	 * @return 代码生成表Lambda表达式
	 */
	private LambdaQueryWrapper<GenTablePO> lambdaQuery(GenTableQueryRequest queryRequest) {
		LambdaQueryWrapper<GenTablePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(GenTablePO::getId);
			// 如果 表名 不为空
			if (StringUtils.isNotBlank(queryRequest.getTableName())) {
				lqw.eq(GenTablePO::getTableName, queryRequest.getTableName());
			}
			// 如果 类名 不为空
			if (StringUtils.isNotBlank(queryRequest.getClassName())) {
				lqw.eq(GenTablePO::getClassName, queryRequest.getClassName());
			}
			// 如果 说明 不为空
			if (StringUtils.isNotBlank(queryRequest.getTableComment())) {
				lqw.eq(GenTablePO::getTableComment, queryRequest.getTableComment());
			}
			// 如果 作者 不为空
			if (StringUtils.isNotBlank(queryRequest.getAuthor())) {
				lqw.eq(GenTablePO::getAuthor, queryRequest.getAuthor());
			}
			// 如果 邮箱 不为空
			if (StringUtils.isNotBlank(queryRequest.getEmail())) {
				lqw.eq(GenTablePO::getEmail, queryRequest.getEmail());
			}
			// 如果 项目包名 不为空
			if (StringUtils.isNotBlank(queryRequest.getPackageName())) {
				lqw.eq(GenTablePO::getPackageName, queryRequest.getPackageName());
			}
			// 如果 项目版本号 不为空
			if (StringUtils.isNotBlank(queryRequest.getVersion())) {
				lqw.eq(GenTablePO::getVersion, queryRequest.getVersion());
			}
			// 如果 代码风格 不为空
			if (queryRequest.getStyle() != null) {
				lqw.eq(GenTablePO::getStyle, queryRequest.getStyle());
			}
			// 如果 子表名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getChildTableName())) {
				lqw.eq(GenTablePO::getChildTableName, queryRequest.getChildTableName());
			}
			// 如果 主表关联键 不为空
			if (StringUtils.isNotBlank(queryRequest.getMainField())) {
				lqw.eq(GenTablePO::getMainField, queryRequest.getMainField());
			}
			// 如果 子表关联键 不为空
			if (StringUtils.isNotBlank(queryRequest.getChildField())) {
				lqw.eq(GenTablePO::getChildField, queryRequest.getChildField());
			}
			// 如果 生成方式 0：zip压缩包 1：自定义目录 不为空
			if (StringUtils.isNotBlank(queryRequest.getGeneratorType())) {
				lqw.eq(GenTablePO::getGeneratorType, queryRequest.getGeneratorType());
			}
			// 如果 后端生成路径 不为空
			if (StringUtils.isNotBlank(queryRequest.getBackendPath())) {
				lqw.eq(GenTablePO::getBackendPath, queryRequest.getBackendPath());
			}
			// 如果 前端生成路径 不为空
			if (StringUtils.isNotBlank(queryRequest.getFrontendPath())) {
				lqw.eq(GenTablePO::getFrontendPath, queryRequest.getFrontendPath());
			}
			// 如果 模块名 不为空
			if (StringUtils.isNotBlank(queryRequest.getModuleName())) {
				lqw.eq(GenTablePO::getModuleName, queryRequest.getModuleName());
			}
			// 如果 功能名 不为空
			if (StringUtils.isNotBlank(queryRequest.getFunctionName())) {
				lqw.eq(GenTablePO::getFunctionName, queryRequest.getFunctionName());
			}
			// 如果 表单布局 1：一列 2：两列 不为空
			if (StringUtils.isNotBlank(queryRequest.getFormLayout())) {
				lqw.eq(GenTablePO::getFormLayout, queryRequest.getFormLayout());
			}
			// 如果 数据源ID 不为空
			if (StringUtils.isNotBlank(queryRequest.getDatasourceId())) {
				lqw.eq(GenTablePO::getDatasourceId, queryRequest.getDatasourceId());
			}
			// 如果 基类ID 不为空
			if (queryRequest.getBaseclassId() != null) {
				lqw.eq(GenTablePO::getBaseclassId, queryRequest.getBaseclassId());
			}
			// 如果 创建人 不为空
			if (StringUtils.isNotBlank(queryRequest.getCreateId())) {
				lqw.eq(GenTablePO::getCreateId, queryRequest.getCreateId());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(GenTablePO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(GenTablePO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return GenTable 实体
	 */
	@Override
	public GenTable getById(String id) {
		GenTablePO genTablePO = genTableMapper.selectById(id);
		return IGenTablePOConvert.INSTANCE.toEntity(genTablePO);
	}

	/**
	 * 保存
	 * @param genTable GenTable 实体
	 * @return GenTable 实体
	 */
	@Override
	public GenTable save(GenTable genTable) {
		GenTablePO genTablePO = IGenTablePOConvert.INSTANCE.fromEntity(genTable);
		genTableMapper.insert(genTablePO);
		return IGenTablePOConvert.INSTANCE.toEntity(genTablePO);
	}

	/**
	 * 根据主键更新
	 * @param genTable GenTable 实体
	 */
	@Override
	public void update(GenTable genTable) {
		GenTablePO genTablePO = IGenTablePOConvert.INSTANCE.fromEntity(genTable);
		genTableMapper.updateById(genTablePO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		genTableMapper.deleteById(id);
	}

}
