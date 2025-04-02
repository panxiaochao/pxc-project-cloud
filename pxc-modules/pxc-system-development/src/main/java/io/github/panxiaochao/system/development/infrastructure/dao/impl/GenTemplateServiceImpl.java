package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.gentemplate.GenTemplateQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplate.GenTemplateQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IGenTemplateReadModelService;
import io.github.panxiaochao.system.development.domain.entity.GenTemplate;
import io.github.panxiaochao.system.development.domain.repository.IGenTemplateService;
import io.github.panxiaochao.system.development.infrastructure.convert.IGenTemplatePOConvert;
import io.github.panxiaochao.system.development.infrastructure.mapper.GenTemplateMapper;
import io.github.panxiaochao.system.development.infrastructure.po.GenTemplatePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 模板 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Service
@RequiredArgsConstructor
public class GenTemplateServiceImpl implements IGenTemplateService, IGenTemplateReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final GenTemplateMapper genTemplateMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 模板查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<GenTemplateQueryResponse> page(Pagination pagination, GenTemplateQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTemplatePO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<GenTemplatePO> page = genTemplateMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IGenTemplatePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 模板查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<GenTemplateQueryResponse> selectList(GenTemplateQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTemplatePO> lqw = lambdaQuery(queryRequest);
		return IGenTemplatePOConvert.INSTANCE.toQueryResponse(genTemplateMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 模板查询请求对象
	 * @return 模板查询响应对象
	 */
	@Override
	public GenTemplateQueryResponse getOne(GenTemplateQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTemplatePO> lqw = lambdaQuery(queryRequest);
		try {
			GenTemplatePO genTemplatePO = genTemplateMapper.selectOne(lqw);
			return IGenTemplatePOConvert.INSTANCE.toQueryResponse(genTemplatePO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 模板查询请求对象
	 * @return 模板Lambda表达式
	 */
	private LambdaQueryWrapper<GenTemplatePO> lambdaQuery(GenTemplateQueryRequest queryRequest) {
		LambdaQueryWrapper<GenTemplatePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(GenTemplatePO::getId);
			// 如果 模板名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getTemplateName())) {
				lqw.like(GenTemplatePO::getTemplateName, queryRequest.getTemplateName());
			}
			// 如果 模板路径 不为空
			if (StringUtils.isNotBlank(queryRequest.getGeneratorPath())) {
				lqw.eq(GenTemplatePO::getGeneratorPath, queryRequest.getGeneratorPath());
			}
			// 如果 模板描述 不为空
			if (StringUtils.isNotBlank(queryRequest.getTemplateDesc())) {
				lqw.eq(GenTemplatePO::getTemplateDesc, queryRequest.getTemplateDesc());
			}
			// 如果 模板代码 不为空
			if (StringUtils.isNotBlank(queryRequest.getTemplateCode())) {
				lqw.eq(GenTemplatePO::getTemplateCode, queryRequest.getTemplateCode());
			}
			// 如果 模板类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getTemplateType())) {
				lqw.eq(GenTemplatePO::getTemplateType, queryRequest.getTemplateType());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return GenTemplate 实体
	 */
	@Override
	public GenTemplate getById(String id) {
		GenTemplatePO genTemplatePO = genTemplateMapper.selectById(id);
		return IGenTemplatePOConvert.INSTANCE.toEntity(genTemplatePO);
	}

	/**
	 * 保存
	 * @param genTemplate GenTemplate 实体
	 * @return GenTemplate 实体
	 */
	@Override
	public GenTemplate save(GenTemplate genTemplate) {
		GenTemplatePO genTemplatePO = IGenTemplatePOConvert.INSTANCE.fromEntity(genTemplate);
		genTemplateMapper.insert(genTemplatePO);
		return IGenTemplatePOConvert.INSTANCE.toEntity(genTemplatePO);
	}

	/**
	 * 根据主键更新
	 * @param genTemplate GenTemplate 实体
	 */
	@Override
	public void update(GenTemplate genTemplate) {
		GenTemplatePO genTemplatePO = IGenTemplatePOConvert.INSTANCE.fromEntity(genTemplate);
		genTemplateMapper.updateById(genTemplatePO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		genTemplateMapper.deleteById(id);
	}

	/**
	 * 根据分组id查询模版列表
	 * @param groupId 分组id
	 * @return List<GenTemplate> 模版列表
	 */
	@Override
	public List<GenTemplateQueryResponse> selectByGroupId(String groupId) {
		List<GenTemplatePO> genTemplatePOS = genTemplateMapper.selectByGroupId(Long.parseLong(groupId));
		return IGenTemplatePOConvert.INSTANCE.toQueryResponse(genTemplatePOS);
	}

}
