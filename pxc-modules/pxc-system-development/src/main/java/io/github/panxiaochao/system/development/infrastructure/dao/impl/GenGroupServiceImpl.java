package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.gengroup.GenGroupQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.gengroup.GenGroupQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IGenGroupReadModelService;
import io.github.panxiaochao.system.development.domain.entity.GenGroup;
import io.github.panxiaochao.system.development.domain.repository.IGenGroupService;
import io.github.panxiaochao.system.development.infrastructure.convert.IGenGroupPOConvert;
import io.github.panxiaochao.system.development.infrastructure.dao.mapper.GenGroupMapper;
import io.github.panxiaochao.system.development.infrastructure.dao.po.GenGroupPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 模板分组 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Service
@RequiredArgsConstructor
public class GenGroupServiceImpl implements IGenGroupService, IGenGroupReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final GenGroupMapper genGroupMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 模板分组查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<GenGroupQueryResponse> page(Pagination pagination, GenGroupQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenGroupPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<GenGroupPO> page = genGroupMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()),
				lqw);
		pagination.setTotal(page.getTotal());
		return IGenGroupPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 模板分组查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<GenGroupQueryResponse> selectList(GenGroupQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenGroupPO> lqw = lambdaQuery(queryRequest);
		return IGenGroupPOConvert.INSTANCE.toQueryResponse(genGroupMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 模板分组查询请求对象
	 * @return 模板分组查询响应对象
	 */
	@Override
	public GenGroupQueryResponse getOne(GenGroupQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<GenGroupPO> lqw = lambdaQuery(queryRequest);
		try {
			GenGroupPO genGroupPO = genGroupMapper.selectOne(lqw);
			return IGenGroupPOConvert.INSTANCE.toQueryResponse(genGroupPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 模板分组查询请求对象
	 * @return 模板分组Lambda表达式
	 */
	private LambdaQueryWrapper<GenGroupPO> lambdaQuery(GenGroupQueryRequest queryRequest) {
		LambdaQueryWrapper<GenGroupPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(GenGroupPO::getId);
			// 如果 分组名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getGroupName())) {
				lqw.like(GenGroupPO::getGroupName, queryRequest.getGroupName());
			}
			// 如果 分组描述 不为空
			if (StringUtils.isNotBlank(queryRequest.getGroupDesc())) {
				lqw.eq(GenGroupPO::getGroupDesc, queryRequest.getGroupDesc());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return GenGroup 实体
	 */
	@Override
	public GenGroup getById(String id) {
		GenGroupPO genGroupPO = genGroupMapper.selectById(id);
		return IGenGroupPOConvert.INSTANCE.toEntity(genGroupPO);
	}

	/**
	 * 保存
	 * @param genGroup GenGroup 实体
	 * @return GenGroup 实体
	 */
	@Override
	public GenGroup save(GenGroup genGroup) {
		GenGroupPO genGroupPO = IGenGroupPOConvert.INSTANCE.fromEntity(genGroup);
		genGroupMapper.insert(genGroupPO);
		return IGenGroupPOConvert.INSTANCE.toEntity(genGroupPO);
	}

	/**
	 * 根据主键更新
	 * @param genGroup GenGroup 实体
	 */
	@Override
	public void update(GenGroup genGroup) {
		GenGroupPO genGroupPO = IGenGroupPOConvert.INSTANCE.fromEntity(genGroup);
		genGroupMapper.updateById(genGroupPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		genGroupMapper.deleteById(id);
	}

}
