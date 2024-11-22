package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.systenantpackage.SysTenantPackageQueryRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackage.SysTenantPackageQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageReadModelService;
import io.github.panxiaochao.system.domain.entity.SysTenantPackage;
import io.github.panxiaochao.system.domain.repository.ISysTenantPackageService;
import io.github.panxiaochao.system.infrastructure.convert.ISysTenantPackagePOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysTenantPackageMapper;
import io.github.panxiaochao.system.infrastructure.po.SysTenantPackagePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租户套餐表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageServiceImpl implements ISysTenantPackageService, ISysTenantPackageReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysTenantPackageMapper sysTenantPackageMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 租户套餐表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysTenantPackageQueryResponse> page(Pagination pagination, SysTenantPackageQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPackagePO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<SysTenantPackagePO> page = sysTenantPackageMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysTenantPackagePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 租户套餐表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<SysTenantPackageQueryResponse> selectList(SysTenantPackageQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPackagePO> lqw = lambdaQuery(queryRequest);
		return ISysTenantPackagePOConvert.INSTANCE.toQueryResponse(sysTenantPackageMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 租户套餐表查询请求对象
	 * @return 租户套餐表查询响应对象
	 */
	@Override
	public SysTenantPackageQueryResponse getOne(SysTenantPackageQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPackagePO> lqw = lambdaQuery(queryRequest);
		try {
			SysTenantPackagePO sysTenantPackagePO = sysTenantPackageMapper.selectOne(lqw);
			return ISysTenantPackagePOConvert.INSTANCE.toQueryResponse(sysTenantPackagePO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 租户套餐表查询请求对象
	 * @return 租户套餐表Lambda表达式
	 */
	private LambdaQueryWrapper<SysTenantPackagePO> lambdaQuery(SysTenantPackageQueryRequest queryRequest) {
		LambdaQueryWrapper<SysTenantPackagePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照创建时间倒序排序
			lqw.orderByDesc(SysTenantPackagePO::getCreateTime);
			// 如果 租户套餐id 不为空
			if (StringUtils.isNotBlank(queryRequest.getPackageId())) {
				lqw.eq(SysTenantPackagePO::getPackageId, queryRequest.getPackageId());
			}
			// 如果 套餐名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getPackageName())) {
				lqw.eq(SysTenantPackagePO::getPackageName, queryRequest.getPackageName());
			}
			// 如果 删除标志：0正常，1删除 不为空
			if (StringUtils.isNotBlank(queryRequest.getDeleted())) {
				lqw.eq(SysTenantPackagePO::getDeleted, queryRequest.getDeleted());
			}
			// 如果 备注 不为空
			if (StringUtils.isNotBlank(queryRequest.getRemark())) {
				lqw.eq(SysTenantPackagePO::getRemark, queryRequest.getRemark());
			}
			// 如果 租户套餐状态：1正常，0不正常 不为空
			if (StringUtils.isNotBlank(queryRequest.getState())) {
				lqw.eq(SysTenantPackagePO::getState, queryRequest.getState());
			}
			// 如果 排序 不为空
			if (StringUtils.isNotBlank(queryRequest.getSort())) {
				lqw.eq(SysTenantPackagePO::getSort, queryRequest.getSort());
			}
			// 如果 创建人 不为空
			if (StringUtils.isNotBlank(queryRequest.getCreateId())) {
				lqw.eq(SysTenantPackagePO::getCreateId, queryRequest.getCreateId());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysTenantPackagePO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysTenantPackagePO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysTenantPackage 实体
	 */
	@Override
	public SysTenantPackage getById(String id) {
		SysTenantPackagePO sysTenantPackagePO = sysTenantPackageMapper.selectById(id);
		return ISysTenantPackagePOConvert.INSTANCE.toEntity(sysTenantPackagePO);
	}

	/**
	 * 保存
	 * @param sysTenantPackage SysTenantPackage 实体
	 * @return SysTenantPackage 实体
	 */
	@Override
	public SysTenantPackage save(SysTenantPackage sysTenantPackage) {
		SysTenantPackagePO sysTenantPackagePO = ISysTenantPackagePOConvert.INSTANCE.fromEntity(sysTenantPackage);
		sysTenantPackageMapper.insert(sysTenantPackagePO);
		return ISysTenantPackagePOConvert.INSTANCE.toEntity(sysTenantPackagePO);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantPackage SysTenantPackage 实体
	 */
	@Override
	public void update(SysTenantPackage sysTenantPackage) {
		SysTenantPackagePO sysTenantPackagePO = ISysTenantPackagePOConvert.INSTANCE.fromEntity(sysTenantPackage);
		sysTenantPackageMapper.updateById(sysTenantPackagePO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysTenantPackageMapper.deleteById(id);
	}

}
