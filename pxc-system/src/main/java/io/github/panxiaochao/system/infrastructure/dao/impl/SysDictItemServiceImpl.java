package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysDictItemQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysDictItemReadModelService;
import io.github.panxiaochao.system.domain.entity.SysDictItem;
import io.github.panxiaochao.system.domain.repository.ISysDictItemService;
import io.github.panxiaochao.system.infrastructure.convert.ISysDictItemPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysDictItemMapper;
import io.github.panxiaochao.system.infrastructure.po.SysDictItemPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据字典配置表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysDictItemServiceImpl implements ISysDictItemService, ISysDictItemReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysDictItemMapper sysDictItemMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysDictItemQueryResponse> page(Pagination pagination,
			RequestPage<SysDictItemQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysDictItemPO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 分页查询
		Page<SysDictItemPO> page = sysDictItemMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysDictItemPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysDictItemPO> lambdaQuery(SysDictItemQueryRequest queryRequest) {
		LambdaQueryWrapper<SysDictItemPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(SysDictItemPO::getId);
			// 如果 字典关联ID 不为空
			if (queryRequest.getDictId() != null) {
				lqw.eq(SysDictItemPO::getDictId, queryRequest.getDictId());
			}
			// 如果 字典名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getDictItemText())) {
				lqw.eq(SysDictItemPO::getDictItemText, queryRequest.getDictItemText());
			}
			// 如果 字典code 不为空
			if (StringUtils.isNotBlank(queryRequest.getDictItemValue())) {
				lqw.eq(SysDictItemPO::getDictItemValue, queryRequest.getDictItemValue());
			}
			// 如果 描述 不为空
			if (StringUtils.isNotBlank(queryRequest.getDescription())) {
				lqw.eq(SysDictItemPO::getDescription, queryRequest.getDescription());
			}
			// 如果 排序 不为空
			if (queryRequest.getSort() != null) {
				lqw.eq(SysDictItemPO::getSort, queryRequest.getSort());
			}
			// 如果 状态：1正常，0不正常 不为空
			if (StringUtils.isNotBlank(queryRequest.getState())) {
				lqw.eq(SysDictItemPO::getState, queryRequest.getState());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysDictItemPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysDictItemPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysDictItem 实体
	 */
	@Override
	public SysDictItem getById(String id) {
		SysDictItemPO sysDictItemPO = sysDictItemMapper.selectById(id);
		return ISysDictItemPOConvert.INSTANCE.toEntity(sysDictItemPO);
	}

	/**
	 * 保存
	 * @param sysDictItem SysDictItem 实体
	 * @return SysDictItem 实体
	 */
	@Override
	public SysDictItem save(SysDictItem sysDictItem) {
		SysDictItemPO sysDictItemPO = ISysDictItemPOConvert.INSTANCE.fromEntity(sysDictItem);
		sysDictItemMapper.insert(sysDictItemPO);
		return ISysDictItemPOConvert.INSTANCE.toEntity(sysDictItemPO);
	}

	/**
	 * 根据主键更新
	 * @param sysDictItem SysDictItem 实体
	 */
	@Override
	public void update(SysDictItem sysDictItem) {
		SysDictItemPO sysDictItemPO = ISysDictItemPOConvert.INSTANCE.fromEntity(sysDictItem);
		sysDictItemMapper.updateById(sysDictItemPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysDictItemMapper.deleteById(id);
	}

}
