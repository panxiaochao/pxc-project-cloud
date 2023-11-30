package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysParamQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysParamQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysParamReadModelService;
import io.github.panxiaochao.system.domain.entity.SysParam;
import io.github.panxiaochao.system.domain.repository.ISysParamService;
import io.github.panxiaochao.system.infrastructure.convert.ISysParamPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysParamMapper;
import io.github.panxiaochao.system.infrastructure.po.SysParamPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统参数 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysParamServiceImpl implements ISysParamService, ISysParamReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysParamMapper sysParamMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysParamQueryResponse> page(Pagination pagination, RequestPage<SysParamQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysParamPO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 默认按照主键倒序排序
		lqw.orderByDesc(SysParamPO::getId);
		// 分页查询
		Page<SysParamPO> page = sysParamMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()),
				lqw);
		pagination.setTotal(page.getTotal());
		return ISysParamPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysParamPO> lambdaQuery(SysParamQueryRequest queryRequest) {
		LambdaQueryWrapper<SysParamPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 如果 参数名称 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getParamName())) {
				lqw.eq(SysParamPO::getParamName, queryRequest.getParamName());
			}
			// 如果 参数键 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getParamKey())) {
				lqw.eq(SysParamPO::getParamKey, queryRequest.getParamKey());
			}
			// 如果 参数值 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getParamValue())) {
				lqw.eq(SysParamPO::getParamValue, queryRequest.getParamValue());
			}
			// 如果 参数类型1-系统类 2-业务类 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getParamType())) {
				lqw.eq(SysParamPO::getParamType, queryRequest.getParamType());
			}
			// 如果 状态1-正常 0-删除 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getStatus())) {
				lqw.eq(SysParamPO::getStatus, queryRequest.getStatus());
			}
			// 如果 创建时间 不为空 LocalDateTime
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysParamPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空 LocalDateTime
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysParamPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysParam 实体
	 */
	@Override
	public SysParam getById(String id) {
		SysParamPO sysParamPO = sysParamMapper.selectById(id);
		return ISysParamPOConvert.INSTANCE.toEntity(sysParamPO);
	}

	/**
	 * 保存
	 * @param sysParam SysParam 实体
	 * @return SysParam 实体
	 */
	@Override
	public SysParam save(SysParam sysParam) {
		SysParamPO sysParamPO = ISysParamPOConvert.INSTANCE.fromEntity(sysParam);
		sysParamMapper.insert(sysParamPO);
		return ISysParamPOConvert.INSTANCE.toEntity(sysParamPO);
	}

	/**
	 * 根据主键更新
	 * @param sysParam SysParam 实体
	 */
	@Override
	public void update(SysParam sysParam) {
		SysParamPO sysParamPO = ISysParamPOConvert.INSTANCE.fromEntity(sysParam);
		sysParamMapper.updateById(sysParamPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysParamMapper.deleteById(id);
	}

}
