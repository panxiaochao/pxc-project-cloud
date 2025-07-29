package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.onlinetablecolumn.OnlineTableColumnQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.onlinetablecolumn.OnlineTableColumnQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IOnlineTableColumnReadModelService;
import io.github.panxiaochao.system.development.domain.entity.OnlineTableColumn;
import io.github.panxiaochao.system.development.domain.repository.IOnlineTableColumnService;
import io.github.panxiaochao.system.development.infrastructure.convert.IOnlineTableColumnPOConvert;
import io.github.panxiaochao.system.development.infrastructure.dao.mapper.OnlineTableColumnMapper;
import io.github.panxiaochao.system.development.infrastructure.dao.po.OnlineTableColumnPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【在线数据表字段】Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class OnlineTableColumnServiceImpl implements IOnlineTableColumnService, IOnlineTableColumnReadModelService {

	/**
	 * 在线数据表字段 持久化接口
	 */
	private final OnlineTableColumnMapper onlineTableColumnMapper;

	/**
	 * 查询 在线数据表字段分页数据
	 * @param pagination 分页属性对象
	 * @param queryRequest 在线数据表字段查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<OnlineTableColumnQueryResponse> page(Pagination pagination,
			OnlineTableColumnQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<OnlineTableColumnPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<OnlineTableColumnPO> page = onlineTableColumnMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IOnlineTableColumnPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询 在线数据表字段对象数组
	 * @param queryRequest 在线数据表字段查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<OnlineTableColumnQueryResponse> selectList(OnlineTableColumnQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<OnlineTableColumnPO> lqw = lambdaQuery(queryRequest);
		return IOnlineTableColumnPOConvert.INSTANCE.toQueryResponse(onlineTableColumnMapper.selectList(lqw));
	}

	/**
	 * 查询 在线数据表字段单条记录
	 * @param queryRequest 在线数据表字段查询请求对象
	 * @param throwEx boolean 参数，为true如果存在多个结果直接抛出异常
	 * @return 在线数据表字段查询响应对象
	 */
	@Override
	public OnlineTableColumnQueryResponse getOne(OnlineTableColumnQueryRequest queryRequest, boolean throwEx) {
		// 构造查询条件
		LambdaQueryWrapper<OnlineTableColumnPO> lqw = lambdaQuery(queryRequest);
		try {
			OnlineTableColumnPO onlineTableColumnPO = onlineTableColumnMapper.selectOne(lqw, throwEx);
			return IOnlineTableColumnPOConvert.INSTANCE.toQueryResponse(onlineTableColumnPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 在线数据表字段查询请求对象
	 * @return 在线数据表字段Lambda表达式
	 */
	private LambdaQueryWrapper<OnlineTableColumnPO> lambdaQuery(OnlineTableColumnQueryRequest queryRequest) {
		LambdaQueryWrapper<OnlineTableColumnPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(OnlineTableColumnPO::getId);
			// 如果 表ID 不为空
			if (queryRequest.getTableId() != null) {
				lqw.eq(OnlineTableColumnPO::getTableId, queryRequest.getTableId());
			}
			// 如果 表名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getTableName())) {
				lqw.eq(OnlineTableColumnPO::getTableName, queryRequest.getTableName());
			}
			// 如果 字段名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getFieldName())) {
				lqw.eq(OnlineTableColumnPO::getFieldName, queryRequest.getFieldName());
			}
			// 如果 字段类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getFieldType())) {
				lqw.eq(OnlineTableColumnPO::getFieldType, queryRequest.getFieldType());
			}
			// 如果 字段说明 不为空
			if (StringUtils.isNotBlank(queryRequest.getFieldComment())) {
				lqw.eq(OnlineTableColumnPO::getFieldComment, queryRequest.getFieldComment());
			}
			// 如果 字段长度 不为空
			if (queryRequest.getColumnSize() != null) {
				lqw.eq(OnlineTableColumnPO::getColumnSize, queryRequest.getColumnSize());
			}
			// 如果 字段小数位 不为空
			if (queryRequest.getScale() != null) {
				lqw.eq(OnlineTableColumnPO::getScale, queryRequest.getScale());
			}
			// 如果 排序 不为空
			if (queryRequest.getSort() != null) {
				lqw.eq(OnlineTableColumnPO::getSort, queryRequest.getSort());
			}
			// 如果 主键 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getPrimaryPk())) {
				lqw.eq(OnlineTableColumnPO::getPrimaryPk, queryRequest.getPrimaryPk());
			}
			// 如果 是否自增 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getAutoIncrement())) {
				lqw.eq(OnlineTableColumnPO::getAutoIncrement, queryRequest.getAutoIncrement());
			}
			// 如果 是否可空 0：否 1：是 不为空
			if (StringUtils.isNotBlank(queryRequest.getNullable())) {
				lqw.eq(OnlineTableColumnPO::getNullable, queryRequest.getNullable());
			}
			// 如果 创建人 不为空
			if (queryRequest.getCreateId() != null) {
				lqw.eq(OnlineTableColumnPO::getCreateId, queryRequest.getCreateId());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(OnlineTableColumnPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(OnlineTableColumnPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 根据主键 获取在线数据表字段详情
	 * @param id 主键
	 * @return OnlineTableColumn 实体
	 */
	@Override
	public OnlineTableColumn getById(String id) {
		OnlineTableColumnPO onlineTableColumnPO = onlineTableColumnMapper.selectById(id);
		return IOnlineTableColumnPOConvert.INSTANCE.toEntity(onlineTableColumnPO);
	}

	/**
	 * 保存在线数据表字段对象
	 * @param onlineTableColumn OnlineTableColumn 实体
	 * @return OnlineTableColumn 实体
	 */
	@Override
	public OnlineTableColumn save(OnlineTableColumn onlineTableColumn) {
		OnlineTableColumnPO onlineTableColumnPO = IOnlineTableColumnPOConvert.INSTANCE.fromEntity(onlineTableColumn);
		onlineTableColumnMapper.insert(onlineTableColumnPO);
		return IOnlineTableColumnPOConvert.INSTANCE.toEntity(onlineTableColumnPO);
	}

	/**
	 * 批量 保存在线数据表字段对象
	 * @param list 批量数据
	 * @return OnlineTableColumn 实体数组
	 */
	@Override
	public List<OnlineTableColumn> saveBatch(List<OnlineTableColumn> list) {
		List<OnlineTableColumnPO> onlineTableColumnPOList = IOnlineTableColumnPOConvert.INSTANCE.fromEntity(list);
		Db.saveBatch(onlineTableColumnPOList);
		return IOnlineTableColumnPOConvert.INSTANCE.toEntity(onlineTableColumnPOList);
	}

	/**
	 * 根据主键 更新在线数据表字段对象
	 * @param onlineTableColumn OnlineTableColumn 实体
	 */
	@Override
	public void update(OnlineTableColumn onlineTableColumn) {
		OnlineTableColumnPO onlineTableColumnPO = IOnlineTableColumnPOConvert.INSTANCE.fromEntity(onlineTableColumn);
		onlineTableColumnMapper.updateById(onlineTableColumnPO);
	}

	/**
	 * 根据主键 批量更新在线数据表字段对象
	 * @param list 批量数据
	 */
	@Override
	public void updateBatch(List<OnlineTableColumn> list) {
		List<OnlineTableColumnPO> onlineTableColumnPOList = IOnlineTableColumnPOConvert.INSTANCE.fromEntity(list);
		Db.updateBatchById(onlineTableColumnPOList);
	}

	/**
	 * 根据主键 删除在线数据表字段对象
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		onlineTableColumnMapper.deleteById(id);
	}

	/**
	 * 根据主键 批量删除在线数据表字段对象
	 * @param list 批量数据
	 */
	@Override
	public void deleteBatch(List<OnlineTableColumn> list) {
		throw new UnsupportedOperationException("请自定义实现批量删除方法！");
	}

}
