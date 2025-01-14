package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.systenantuser.SysTenantUserQueryRequest;
import io.github.panxiaochao.system.application.api.response.systenantuser.SysTenantUserQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysTenantUserReadModelService;
import io.github.panxiaochao.system.domain.entity.SysTenantUser;
import io.github.panxiaochao.system.domain.repository.ISysTenantUserService;
import io.github.panxiaochao.system.infrastructure.convert.ISysTenantUserPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysTenantUserMapper;
import io.github.panxiaochao.system.infrastructure.po.SysTenantUserPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租户用户表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-11-27
 */
@Service
@RequiredArgsConstructor
public class SysTenantUserServiceImpl implements ISysTenantUserService, ISysTenantUserReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysTenantUserMapper sysTenantUserMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 租户用户表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysTenantUserQueryResponse> page(Pagination pagination, SysTenantUserQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantUserPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<SysTenantUserPO> page = sysTenantUserMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysTenantUserPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 租户用户表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<SysTenantUserQueryResponse> selectList(SysTenantUserQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantUserPO> lqw = lambdaQuery(queryRequest);
		return ISysTenantUserPOConvert.INSTANCE.toQueryResponse(sysTenantUserMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 租户用户表查询请求对象
	 * @return 租户用户表查询响应对象
	 */
	@Override
	public SysTenantUserQueryResponse getOne(SysTenantUserQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantUserPO> lqw = lambdaQuery(queryRequest);
		try {
			SysTenantUserPO sysTenantUserPO = sysTenantUserMapper.selectOne(lqw);
			return ISysTenantUserPOConvert.INSTANCE.toQueryResponse(sysTenantUserPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 租户用户表查询请求对象
	 * @return 租户用户表Lambda表达式
	 */
	private LambdaQueryWrapper<SysTenantUserPO> lambdaQuery(SysTenantUserQueryRequest queryRequest) {
		LambdaQueryWrapper<SysTenantUserPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 如果 租户id 不为空
			if (StringUtils.isNotBlank(queryRequest.getTenantId())) {
				lqw.eq(SysTenantUserPO::getTenantId, queryRequest.getTenantId());
			}
			// 如果 用户ID 不为空
			if (StringUtils.isNotBlank(queryRequest.getUserId())) {
				lqw.eq(SysTenantUserPO::getUserId, queryRequest.getUserId());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysTenantUser 实体
	 */
	@Override
	public SysTenantUser getById(String id) {
		SysTenantUserPO sysTenantUserPO = sysTenantUserMapper.selectById(id);
		return ISysTenantUserPOConvert.INSTANCE.toEntity(sysTenantUserPO);
	}

	/**
	 * 保存
	 * @param sysTenantUser SysTenantUser 实体
	 * @return SysTenantUser 实体
	 */
	@Override
	public SysTenantUser save(SysTenantUser sysTenantUser) {
		SysTenantUserPO sysTenantUserPO = ISysTenantUserPOConvert.INSTANCE.fromEntity(sysTenantUser);
		sysTenantUserMapper.insert(sysTenantUserPO);
		return ISysTenantUserPOConvert.INSTANCE.toEntity(sysTenantUserPO);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantUser SysTenantUser 实体
	 */
	@Override
	public void update(SysTenantUser sysTenantUser) {
		SysTenantUserPO sysTenantUserPO = ISysTenantUserPOConvert.INSTANCE.fromEntity(sysTenantUser);
		sysTenantUserMapper.updateById(sysTenantUserPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysTenantUserMapper.deleteById(id);
	}

	/**
	 * 批量保存
	 * @param list 批量数据
	 */
	@Override
	public void saveBath(List<SysTenantUser> list) {
		List<SysTenantUserPO> sysTenantUserPOList = ISysTenantUserPOConvert.INSTANCE.fromEntity(list);
		Db.saveBatch(sysTenantUserPOList);
	}

	/**
	 * 根据租户ID和用户ID删除
	 * @param sysTenantUser 实体
	 */
	@Override
	public void deleteTenantUser(SysTenantUser sysTenantUser) {
		sysTenantUserMapper.delete(
				new LambdaQueryWrapper<SysTenantUserPO>().eq(SysTenantUserPO::getTenantId, sysTenantUser.getTenantId())
					.eq(SysTenantUserPO::getUserId, sysTenantUser.getUserId()));
	}

}
