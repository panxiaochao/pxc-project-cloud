package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.systenant.SysTenantQueryRequest;
import io.github.panxiaochao.system.application.api.response.systenant.SysTenantQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysTenantReadModelService;
import io.github.panxiaochao.system.domain.entity.SysTenant;
import io.github.panxiaochao.system.domain.repository.ISysTenantService;
import io.github.panxiaochao.system.infrastructure.convert.ISysTenantPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysTenantMapper;
import io.github.panxiaochao.system.infrastructure.po.SysTenantPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租户表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantServiceImpl implements ISysTenantService, ISysTenantReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysTenantMapper sysTenantMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 租户表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysTenantQueryResponse> page(Pagination pagination, SysTenantQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<SysTenantPO> page = sysTenantMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()),
				lqw);
		pagination.setTotal(page.getTotal());
		return ISysTenantPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 租户表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<SysTenantQueryResponse> selectList(SysTenantQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPO> lqw = lambdaQuery(queryRequest);
		return ISysTenantPOConvert.INSTANCE.toQueryResponse(sysTenantMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 租户表查询请求对象
	 * @return 租户表查询响应对象
	 */
	@Override
	public SysTenantQueryResponse getOne(SysTenantQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPO> lqw = lambdaQuery(queryRequest);
		try {
			SysTenantPO sysTenantPO = sysTenantMapper.selectOne(lqw);
			return ISysTenantPOConvert.INSTANCE.toQueryResponse(sysTenantPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 租户表查询请求对象
	 * @return 租户表Lambda表达式
	 */
	private LambdaQueryWrapper<SysTenantPO> lambdaQuery(SysTenantQueryRequest queryRequest) {
		LambdaQueryWrapper<SysTenantPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照创建时间倒序排序
			lqw.orderByDesc(SysTenantPO::getCreateTime);
			// 如果 租户编号 不为空
			if (StringUtils.isNotBlank(queryRequest.getTenantId())) {
				lqw.eq(SysTenantPO::getTenantId, queryRequest.getTenantId());
			}
			// 如果 租户套餐编号 不为空
			if (StringUtils.isNotBlank(queryRequest.getPackageId())) {
				lqw.eq(SysTenantPO::getPackageId, queryRequest.getPackageId());
			}
			// 如果 联系人 不为空
			if (StringUtils.isNotBlank(queryRequest.getContactUserName())) {
				lqw.like(SysTenantPO::getContactUserName, queryRequest.getContactUserName());
			}
			// 如果 联系电话 不为空
			if (StringUtils.isNotBlank(queryRequest.getContactPhone())) {
				lqw.eq(SysTenantPO::getContactPhone, queryRequest.getContactPhone());
			}
			// 如果 企业名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getCompanyName())) {
				lqw.eq(SysTenantPO::getCompanyName, queryRequest.getCompanyName());
			}
			// 如果 统一社会信用代码 不为空
			if (StringUtils.isNotBlank(queryRequest.getSocialCode())) {
				lqw.eq(SysTenantPO::getSocialCode, queryRequest.getSocialCode());
			}
			// 如果 地址 不为空
			if (StringUtils.isNotBlank(queryRequest.getCompanyAddress())) {
				lqw.eq(SysTenantPO::getCompanyAddress, queryRequest.getCompanyAddress());
			}
			// 如果 企业简介 不为空
			if (StringUtils.isNotBlank(queryRequest.getCompanyIntro())) {
				lqw.eq(SysTenantPO::getCompanyIntro, queryRequest.getCompanyIntro());
			}
			// 如果 域名 不为空
			if (StringUtils.isNotBlank(queryRequest.getCompanyDomain())) {
				lqw.eq(SysTenantPO::getCompanyDomain, queryRequest.getCompanyDomain());
			}
			// 如果 租户模式：0字段模式，1数据库模式 不为空
			if (StringUtils.isNotBlank(queryRequest.getMode())) {
				lqw.eq(SysTenantPO::getMode, queryRequest.getMode());
			}
			// 如果 删除标志：0正常，1删除 不为空
			if (StringUtils.isNotBlank(queryRequest.getDeleted())) {
				lqw.eq(SysTenantPO::getDeleted, queryRequest.getDeleted());
			}
			// 如果 过期时间 不为空
			if (queryRequest.getExpireTime() != null) {
				lqw.eq(SysTenantPO::getExpireTime, queryRequest.getExpireTime());
			}
			// 如果 备注 不为空
			if (StringUtils.isNotBlank(queryRequest.getRemark())) {
				lqw.eq(SysTenantPO::getRemark, queryRequest.getRemark());
			}
			// 如果 租户状态：1正常，0不正常 不为空
			if (StringUtils.isNotBlank(queryRequest.getState())) {
				lqw.eq(SysTenantPO::getState, queryRequest.getState());
			}
			// 如果 排序 不为空
			if (StringUtils.isNotBlank(queryRequest.getSort())) {
				lqw.eq(SysTenantPO::getSort, queryRequest.getSort());
			}
			// 如果 创建人 不为空
			if (StringUtils.isNotBlank(queryRequest.getCreateId())) {
				lqw.eq(SysTenantPO::getCreateId, queryRequest.getCreateId());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysTenantPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysTenantPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysTenant 实体
	 */
	@Override
	public SysTenant getById(String id) {
		SysTenantPO sysTenantPO = sysTenantMapper.selectById(id);
		return ISysTenantPOConvert.INSTANCE.toEntity(sysTenantPO);
	}

	/**
	 * 保存
	 * @param sysTenant SysTenant 实体
	 * @return SysTenant 实体
	 */
	@Override
	public SysTenant save(SysTenant sysTenant) {
		SysTenantPO sysTenantPO = ISysTenantPOConvert.INSTANCE.fromEntity(sysTenant);
		sysTenantMapper.insert(sysTenantPO);
		return ISysTenantPOConvert.INSTANCE.toEntity(sysTenantPO);
	}

	/**
	 * 根据主键更新
	 * @param sysTenant SysTenant 实体
	 */
	@Override
	public void update(SysTenant sysTenant) {
		SysTenantPO sysTenantPO = ISysTenantPOConvert.INSTANCE.fromEntity(sysTenant);
		sysTenantMapper.updateById(sysTenantPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysTenantMapper.deleteById(id);
	}

}
