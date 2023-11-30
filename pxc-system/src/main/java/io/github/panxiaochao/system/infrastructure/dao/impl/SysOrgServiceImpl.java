package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysOrgQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysOrgQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysOrgReadModelService;
import io.github.panxiaochao.system.domain.entity.SysOrg;
import io.github.panxiaochao.system.domain.repository.ISysOrgService;
import io.github.panxiaochao.system.infrastructure.convert.ISysOrgPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysOrgMapper;
import io.github.panxiaochao.system.infrastructure.po.SysOrgPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 机构部门表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysOrgServiceImpl implements ISysOrgService, ISysOrgReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysOrgMapper sysOrgMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysOrgQueryResponse> page(Pagination pagination, RequestPage<SysOrgQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysOrgPO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 默认按照主键倒序排序
		lqw.orderByDesc(SysOrgPO::getId);
		// 分页查询
		Page<SysOrgPO> page = sysOrgMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysOrgPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysOrgPO> lambdaQuery(SysOrgQueryRequest queryRequest) {
		LambdaQueryWrapper<SysOrgPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 如果 父ID 不为空 Integer
			if (queryRequest.getParentId() != null) {
				lqw.eq(SysOrgPO::getParentId, queryRequest.getParentId());
			}
			// 如果 地区ID 不为空 Integer
			if (queryRequest.getAreaId() != null) {
				lqw.eq(SysOrgPO::getAreaId, queryRequest.getAreaId());
			}
			// 如果 地区代码code 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getAreaCode())) {
				lqw.eq(SysOrgPO::getAreaCode, queryRequest.getAreaCode());
			}
			// 如果 机构/部门名称 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getOrgName())) {
				lqw.eq(SysOrgPO::getOrgName, queryRequest.getOrgName());
			}
			// 如果 英文名 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getOrgNameEn())) {
				lqw.eq(SysOrgPO::getOrgNameEn, queryRequest.getOrgNameEn());
			}
			// 如果 缩写 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getOrgNameAbbr())) {
				lqw.eq(SysOrgPO::getOrgNameAbbr, queryRequest.getOrgNameAbbr());
			}
			// 如果 机构/部门编码code 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getOrgCode())) {
				lqw.eq(SysOrgPO::getOrgCode, queryRequest.getOrgCode());
			}
			// 如果 描述 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getDescription())) {
				lqw.eq(SysOrgPO::getDescription, queryRequest.getDescription());
			}
			// 如果 排序 不为空 Integer
			if (queryRequest.getSort() != null) {
				lqw.eq(SysOrgPO::getSort, queryRequest.getSort());
			}
			// 如果 机构类别：1-公司，2-机构，3-部门 不为空 Integer
			if (queryRequest.getOrgCategory() != null) {
				lqw.eq(SysOrgPO::getOrgCategory, queryRequest.getOrgCategory());
			}
			// 如果 手机号码 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getMobile())) {
				lqw.eq(SysOrgPO::getMobile, queryRequest.getMobile());
			}
			// 如果 传真号码 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getFax())) {
				lqw.eq(SysOrgPO::getFax, queryRequest.getFax());
			}
			// 如果 地址 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getAddress())) {
				lqw.eq(SysOrgPO::getAddress, queryRequest.getAddress());
			}
			// 如果 状态：1正常，0不正常 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getStatus())) {
				lqw.eq(SysOrgPO::getStatus, queryRequest.getStatus());
			}
			// 如果 备注 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getRemark())) {
				lqw.eq(SysOrgPO::getRemark, queryRequest.getRemark());
			}
			// 如果 创建时间 不为空 LocalDateTime
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysOrgPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空 LocalDateTime
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysOrgPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysOrg 实体
	 */
	@Override
	public SysOrg getById(String id) {
		SysOrgPO sysOrgPO = sysOrgMapper.selectById(id);
		return ISysOrgPOConvert.INSTANCE.toEntity(sysOrgPO);
	}

	/**
	 * 保存
	 * @param sysOrg SysOrg 实体
	 * @return SysOrg 实体
	 */
	@Override
	public SysOrg save(SysOrg sysOrg) {
		SysOrgPO sysOrgPO = ISysOrgPOConvert.INSTANCE.fromEntity(sysOrg);
		sysOrgMapper.insert(sysOrgPO);
		return ISysOrgPOConvert.INSTANCE.toEntity(sysOrgPO);
	}

	/**
	 * 根据主键更新
	 * @param sysOrg SysOrg 实体
	 */
	@Override
	public void update(SysOrg sysOrg) {
		SysOrgPO sysOrgPO = ISysOrgPOConvert.INSTANCE.fromEntity(sysOrg);
		sysOrgMapper.updateById(sysOrgPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysOrgMapper.deleteById(id);
	}

}
