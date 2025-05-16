package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.gentemplategroup.GenTemplateGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gentemplategroup.GenTemplateGroupQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IGenTemplateGroupReadModelService;
import io.github.panxiaochao.system.development.domain.entity.GenTemplateGroup;
import io.github.panxiaochao.system.development.domain.repository.IGenTemplateGroupService;
import io.github.panxiaochao.system.development.infrastructure.convert.IGenTemplateGroupPOConvert;
import io.github.panxiaochao.system.development.infrastructure.dao.mapper.GenTemplateGroupMapper;
import io.github.panxiaochao.system.development.infrastructure.dao.po.GenTemplateGroupPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 模板分组关联表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Service
@RequiredArgsConstructor
public class GenTemplateGroupServiceImpl implements IGenTemplateGroupService, IGenTemplateGroupReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final GenTemplateGroupMapper genTemplateGroupMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 模板分组关联表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<GenTemplateGroupQueryResponse> page(Pagination pagination, GenTemplateGroupQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTemplateGroupPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<GenTemplateGroupPO> page = genTemplateGroupMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IGenTemplateGroupPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 模板分组关联表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<GenTemplateGroupQueryResponse> selectList(GenTemplateGroupQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTemplateGroupPO> lqw = lambdaQuery(queryRequest);
		return IGenTemplateGroupPOConvert.INSTANCE.toQueryResponse(genTemplateGroupMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 模板分组关联表查询请求对象
	 * @return 模板分组关联表查询响应对象
	 */
	@Override
	public GenTemplateGroupQueryResponse getOne(GenTemplateGroupQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenTemplateGroupPO> lqw = lambdaQuery(queryRequest);
		try {
			GenTemplateGroupPO genTemplateGroupPO = genTemplateGroupMapper.selectOne(lqw);
			return IGenTemplateGroupPOConvert.INSTANCE.toQueryResponse(genTemplateGroupPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 模板分组关联表查询请求对象
	 * @return 模板分组关联表Lambda表达式
	 */
	private LambdaQueryWrapper<GenTemplateGroupPO> lambdaQuery(GenTemplateGroupQueryRequest queryRequest) {
		LambdaQueryWrapper<GenTemplateGroupPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(GenTemplateGroupPO::getGroupId);
			// 默认按照主键倒序排序
			lqw.orderByDesc(GenTemplateGroupPO::getTemplateId);
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return GenTemplateGroup 实体
	 */
	@Override
	public GenTemplateGroup getById(String id) {
		GenTemplateGroupPO genTemplateGroupPO = genTemplateGroupMapper.selectById(id);
		return IGenTemplateGroupPOConvert.INSTANCE.toEntity(genTemplateGroupPO);
	}

	/**
	 * 保存
	 * @param genTemplateGroup GenTemplateGroup 实体
	 * @return GenTemplateGroup 实体
	 */
	@Override
	public GenTemplateGroup save(GenTemplateGroup genTemplateGroup) {
		GenTemplateGroupPO genTemplateGroupPO = IGenTemplateGroupPOConvert.INSTANCE.fromEntity(genTemplateGroup);
		genTemplateGroupMapper.insert(genTemplateGroupPO);
		return IGenTemplateGroupPOConvert.INSTANCE.toEntity(genTemplateGroupPO);
	}

	/**
	 * 批量保存
	 * @param list GenTemplateGroup 数据实体
	 */
	@Override
	public void saveBatch(List<GenTemplateGroup> list) {
		List<GenTemplateGroupPO> genTemplateGroupPOList = IGenTemplateGroupPOConvert.INSTANCE.fromEntity(list);
		Db.saveBatch(genTemplateGroupPOList);
	}

	/**
	 * 根据主键更新
	 * @param genTemplateGroup GenTemplateGroup 实体
	 */
	@Override
	public void update(GenTemplateGroup genTemplateGroup) {
		GenTemplateGroupPO genTemplateGroupPO = IGenTemplateGroupPOConvert.INSTANCE.fromEntity(genTemplateGroup);
		genTemplateGroupMapper.updateById(genTemplateGroupPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		genTemplateGroupMapper.deleteById(id);
	}

	/**
	 * 根据模版分组主键批量删除
	 * @param groupId 模版分组主键
	 */
	@Override
	public void deleteByGroupId(String groupId) {
		genTemplateGroupMapper
			.delete(new LambdaQueryWrapper<GenTemplateGroupPO>().eq(GenTemplateGroupPO::getGroupId, groupId));
	}

}
