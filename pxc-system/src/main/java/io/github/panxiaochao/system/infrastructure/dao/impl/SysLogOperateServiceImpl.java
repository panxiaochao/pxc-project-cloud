package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysLogOperateQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysLogOperateQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysLogOperateReadModelService;
import io.github.panxiaochao.system.domain.entity.SysLogOperate;
import io.github.panxiaochao.system.domain.repository.ISysLogOperateService;
import io.github.panxiaochao.system.infrastructure.convert.ISysLogOperatePOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysLogOperateMapper;
import io.github.panxiaochao.system.infrastructure.po.SysLogOperatePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统日志操作表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysLogOperateServiceImpl implements ISysLogOperateService, ISysLogOperateReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysLogOperateMapper sysLogOperateMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysLogOperateQueryResponse> page(Pagination pagination,
			RequestPage<SysLogOperateQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysLogOperatePO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 分页查询
		Page<SysLogOperatePO> page = sysLogOperateMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysLogOperatePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysLogOperatePO> lambdaQuery(SysLogOperateQueryRequest queryRequest) {
		LambdaQueryWrapper<SysLogOperatePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(SysLogOperatePO::getId);
			// 如果 日志内容 不为空
			if (StringUtils.isNotBlank(queryRequest.getLogContent())) {
				lqw.eq(SysLogOperatePO::getLogContent, queryRequest.getLogContent());
			}
			// 如果 操作类型 不为空
			if (queryRequest.getOperateType() != null) {
				lqw.eq(SysLogOperatePO::getOperateType, queryRequest.getOperateType());
			}
			// 如果 IP 不为空
			if (StringUtils.isNotBlank(queryRequest.getIp())) {
				lqw.eq(SysLogOperatePO::getIp, queryRequest.getIp());
			}
			// 如果 请求java方法 不为空
			if (StringUtils.isNotBlank(queryRequest.getMethod())) {
				lqw.eq(SysLogOperatePO::getMethod, queryRequest.getMethod());
			}
			// 如果 请求路径 不为空
			if (StringUtils.isNotBlank(queryRequest.getRequestUrl())) {
				lqw.eq(SysLogOperatePO::getRequestUrl, queryRequest.getRequestUrl());
			}
			// 如果 请求参数 不为空
			if (StringUtils.isNotBlank(queryRequest.getRequestParams())) {
				lqw.eq(SysLogOperatePO::getRequestParams, queryRequest.getRequestParams());
			}
			// 如果 请求类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getRequestMethod())) {
				lqw.eq(SysLogOperatePO::getRequestMethod, queryRequest.getRequestMethod());
			}
			// 如果 耗时 不为空
			if (queryRequest.getCostTime() != null) {
				lqw.eq(SysLogOperatePO::getCostTime, queryRequest.getCostTime());
			}
			// 如果 是否成功 不为空
			if (StringUtils.isNotBlank(queryRequest.getState())) {
				lqw.eq(SysLogOperatePO::getState, queryRequest.getState());
			}
			// 如果 浏览器 不为空
			if (StringUtils.isNotBlank(queryRequest.getBrowser())) {
				lqw.eq(SysLogOperatePO::getBrowser, queryRequest.getBrowser());
			}
			// 如果 操作系统 不为空
			if (StringUtils.isNotBlank(queryRequest.getOs())) {
				lqw.eq(SysLogOperatePO::getOs, queryRequest.getOs());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysLogOperatePO::getCreateTime, queryRequest.getCreateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysLogOperate 实体
	 */
	@Override
	public SysLogOperate getById(String id) {
		SysLogOperatePO sysLogOperatePO = sysLogOperateMapper.selectById(id);
		return ISysLogOperatePOConvert.INSTANCE.toEntity(sysLogOperatePO);
	}

	/**
	 * 保存
	 * @param sysLogOperate SysLogOperate 实体
	 * @return SysLogOperate 实体
	 */
	@Override
	public SysLogOperate save(SysLogOperate sysLogOperate) {
		SysLogOperatePO sysLogOperatePO = ISysLogOperatePOConvert.INSTANCE.fromEntity(sysLogOperate);
		sysLogOperateMapper.insert(sysLogOperatePO);
		return ISysLogOperatePOConvert.INSTANCE.toEntity(sysLogOperatePO);
	}

	/**
	 * 根据主键更新
	 * @param sysLogOperate SysLogOperate 实体
	 */
	@Override
	public void update(SysLogOperate sysLogOperate) {
		SysLogOperatePO sysLogOperatePO = ISysLogOperatePOConvert.INSTANCE.fromEntity(sysLogOperate);
		sysLogOperateMapper.updateById(sysLogOperatePO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysLogOperateMapper.deleteById(id);
	}

}

