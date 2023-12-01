package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysPostQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysPostQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysPostReadModelService;
import io.github.panxiaochao.system.domain.entity.SysPost;
import io.github.panxiaochao.system.domain.repository.ISysPostService;
import io.github.panxiaochao.system.infrastructure.convert.ISysPostPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysPostMapper;
import io.github.panxiaochao.system.infrastructure.po.SysPostPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 岗位表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysPostServiceImpl implements ISysPostService, ISysPostReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysPostMapper sysPostMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysPostQueryResponse> page(Pagination pagination, RequestPage<SysPostQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysPostPO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 分页查询
		Page<SysPostPO> page = sysPostMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysPostPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysPostPO> lambdaQuery(SysPostQueryRequest queryRequest) {
		LambdaQueryWrapper<SysPostPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(SysPostPO::getId);
			// 如果 岗位名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getPostName())) {
				lqw.eq(SysPostPO::getPostName, queryRequest.getPostName());
			}
			// 如果 岗位编码 不为空
			if (StringUtils.isNotBlank(queryRequest.getPostCode())) {
				lqw.eq(SysPostPO::getPostCode, queryRequest.getPostCode());
			}
			// 如果 备注 不为空
			if (StringUtils.isNotBlank(queryRequest.getRemark())) {
				lqw.eq(SysPostPO::getRemark, queryRequest.getRemark());
			}
			// 如果 排序 不为空
			if (queryRequest.getSort() != null) {
				lqw.eq(SysPostPO::getSort, queryRequest.getSort());
			}
			// 如果 状态：1正常，0不正常 不为空
			if (StringUtils.isNotBlank(queryRequest.getState())) {
				lqw.eq(SysPostPO::getState, queryRequest.getState());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysPostPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysPostPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysPost 实体
	 */
	@Override
	public SysPost getById(String id) {
		SysPostPO sysPostPO = sysPostMapper.selectById(id);
		return ISysPostPOConvert.INSTANCE.toEntity(sysPostPO);
	}

	/**
	 * 保存
	 * @param sysPost SysPost 实体
	 * @return SysPost 实体
	 */
	@Override
	public SysPost save(SysPost sysPost) {
		SysPostPO sysPostPO = ISysPostPOConvert.INSTANCE.fromEntity(sysPost);
		sysPostMapper.insert(sysPostPO);
		return ISysPostPOConvert.INSTANCE.toEntity(sysPostPO);
	}

	/**
	 * 根据主键更新
	 * @param sysPost SysPost 实体
	 */
	@Override
	public void update(SysPost sysPost) {
		SysPostPO sysPostPO = ISysPostPOConvert.INSTANCE.fromEntity(sysPost);
		sysPostMapper.updateById(sysPostPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysPostMapper.deleteById(id);
	}

}

