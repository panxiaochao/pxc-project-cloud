package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysDictQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysDictQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysDictReadModelService;
import io.github.panxiaochao.system.domain.entity.SysDict;
import io.github.panxiaochao.system.domain.repository.ISysDictService;
import io.github.panxiaochao.system.infrastructure.convert.ISysDictPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysDictMapper;
import io.github.panxiaochao.system.infrastructure.po.SysDictPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据字典表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysDictServiceImpl implements ISysDictService, ISysDictReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysDictMapper sysDictMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysDictQueryResponse> page(Pagination pagination, RequestPage<SysDictQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysDictPO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 默认按照主键倒序排序
		lqw.orderByDesc(SysDictPO::getId);
		// 分页查询
		Page<SysDictPO> page = sysDictMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysDictPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysDictPO> lambdaQuery(SysDictQueryRequest queryRequest) {
		LambdaQueryWrapper<SysDictPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 如果 字典名称 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getDictName())) {
				lqw.eq(SysDictPO::getDictName, queryRequest.getDictName());
			}
			// 如果 字典code 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getDictCode())) {
				lqw.eq(SysDictPO::getDictCode, queryRequest.getDictCode());
			}
			// 如果 字典类型：0为string,1为number 不为空 Integer
			if (queryRequest.getDictType() != null) {
				lqw.eq(SysDictPO::getDictType, queryRequest.getDictType());
			}
			// 如果 备注 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getRemark())) {
				lqw.eq(SysDictPO::getRemark, queryRequest.getRemark());
			}
			// 如果 排序 不为空 Integer
			if (queryRequest.getSort() != null) {
				lqw.eq(SysDictPO::getSort, queryRequest.getSort());
			}
			// 如果 状态：1正常，0不正常 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getState())) {
				lqw.eq(SysDictPO::getState, queryRequest.getState());
			}
			// 如果 创建时间 不为空 LocalDateTime
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysDictPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空 LocalDateTime
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysDictPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysDict 实体
	 */
	@Override
	public SysDict getById(String id) {
		SysDictPO sysDictPO = sysDictMapper.selectById(id);
		return ISysDictPOConvert.INSTANCE.toEntity(sysDictPO);
	}

	/**
	 * 保存
	 * @param sysDict SysDict 实体
	 * @return SysDict 实体
	 */
	@Override
	public SysDict save(SysDict sysDict) {
		SysDictPO sysDictPO = ISysDictPOConvert.INSTANCE.fromEntity(sysDict);
		sysDictMapper.insert(sysDictPO);
		return ISysDictPOConvert.INSTANCE.toEntity(sysDictPO);
	}

	/**
	 * 根据主键更新
	 * @param sysDict SysDict 实体
	 */
	@Override
	public void update(SysDict sysDict) {
		SysDictPO sysDictPO = ISysDictPOConvert.INSTANCE.fromEntity(sysDict);
		sysDictMapper.updateById(sysDictPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysDictMapper.deleteById(id);
	}

}

