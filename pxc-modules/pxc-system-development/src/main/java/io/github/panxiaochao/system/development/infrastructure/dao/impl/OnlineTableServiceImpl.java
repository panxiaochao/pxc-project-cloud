package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.onlinetable.OnlineTableQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.onlinetable.OnlineTableQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IOnlineTableReadModelService;
import io.github.panxiaochao.system.development.domain.entity.OnlineTable;
import io.github.panxiaochao.system.development.domain.repository.IOnlineTableService;
import io.github.panxiaochao.system.development.infrastructure.convert.IOnlineTablePOConvert;
import io.github.panxiaochao.system.development.infrastructure.dao.mapper.OnlineTableMapper;
import io.github.panxiaochao.system.development.infrastructure.dao.po.OnlineTablePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【在线数据表】Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class OnlineTableServiceImpl implements IOnlineTableService, IOnlineTableReadModelService {

	/**
	 * 在线数据表 持久化接口
	 */
	private final OnlineTableMapper onlineTableMapper;

	/**
	 * 查询 在线数据表分页数据
	 * @param pagination 分页属性对象
	 * @param queryRequest 在线数据表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<OnlineTableQueryResponse> page(Pagination pagination, OnlineTableQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<OnlineTablePO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<OnlineTablePO> page = onlineTableMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IOnlineTablePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询 在线数据表对象数组
	 * @param queryRequest 在线数据表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<OnlineTableQueryResponse> selectList(OnlineTableQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<OnlineTablePO> lqw = lambdaQuery(queryRequest);
		return IOnlineTablePOConvert.INSTANCE.toQueryResponse(onlineTableMapper.selectList(lqw));
	}

	/**
	 * 查询 在线数据表单条记录
	 * @param queryRequest 在线数据表查询请求对象
	 * @param throwEx boolean 参数，为true如果存在多个结果直接抛出异常
	 * @return 在线数据表查询响应对象
	 */
	@Override
	public OnlineTableQueryResponse getOne(OnlineTableQueryRequest queryRequest, boolean throwEx) {
		// 构造查询条件
		LambdaQueryWrapper<OnlineTablePO> lqw = lambdaQuery(queryRequest);
		try {
			OnlineTablePO onlineTablePO = onlineTableMapper.selectOne(lqw, throwEx);
			return IOnlineTablePOConvert.INSTANCE.toQueryResponse(onlineTablePO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 在线数据表查询请求对象
	 * @return 在线数据表Lambda表达式
	 */
	private LambdaQueryWrapper<OnlineTablePO> lambdaQuery(OnlineTableQueryRequest queryRequest) {
		LambdaQueryWrapper<OnlineTablePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(OnlineTablePO::getId);
			// 如果 表名 不为空
			if (StringUtils.isNotBlank(queryRequest.getTableName())) {
				lqw.eq(OnlineTablePO::getTableName, queryRequest.getTableName());
			}
			// 如果 说明 不为空
			if (StringUtils.isNotBlank(queryRequest.getTableComment())) {
				lqw.eq(OnlineTablePO::getTableComment, queryRequest.getTableComment());
			}
			// 如果 项目版本号 不为空
			if (StringUtils.isNotBlank(queryRequest.getVersion())) {
				lqw.eq(OnlineTablePO::getVersion, queryRequest.getVersion());
			}
			// 如果 数据源ID 不为空
			if (queryRequest.getDatasourceId() != null) {
				lqw.eq(OnlineTablePO::getDatasourceId, queryRequest.getDatasourceId());
			}
			// 如果 创建人 不为空
			if (queryRequest.getCreateId() != null) {
				lqw.eq(OnlineTablePO::getCreateId, queryRequest.getCreateId());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(OnlineTablePO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(OnlineTablePO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 根据主键 获取在线数据表详情
	 * @param id 主键
	 * @return OnlineTable 实体
	 */
	@Override
	public OnlineTable getById(String id) {
		OnlineTablePO onlineTablePO = onlineTableMapper.selectById(id);
		return IOnlineTablePOConvert.INSTANCE.toEntity(onlineTablePO);
	}

	/**
	 * 保存在线数据表对象
	 * @param onlineTable OnlineTable 实体
	 * @return OnlineTable 实体
	 */
	@Override
	public OnlineTable save(OnlineTable onlineTable) {
		OnlineTablePO onlineTablePO = IOnlineTablePOConvert.INSTANCE.fromEntity(onlineTable);
		onlineTableMapper.insert(onlineTablePO);
		return IOnlineTablePOConvert.INSTANCE.toEntity(onlineTablePO);
	}

	/**
	 * 批量 保存在线数据表对象
	 * @param list 批量数据
	 * @return OnlineTable 实体数组
	 */
	@Override
	public List<OnlineTable> saveBatch(List<OnlineTable> list) {
		List<OnlineTablePO> onlineTablePOList = IOnlineTablePOConvert.INSTANCE.fromEntity(list);
		Db.saveBatch(onlineTablePOList);
		return IOnlineTablePOConvert.INSTANCE.toEntity(onlineTablePOList);
	}

	/**
	 * 根据主键 更新在线数据表对象
	 * @param onlineTable OnlineTable 实体
	 */
	@Override
	public void update(OnlineTable onlineTable) {
		OnlineTablePO onlineTablePO = IOnlineTablePOConvert.INSTANCE.fromEntity(onlineTable);
		onlineTableMapper.updateById(onlineTablePO);
	}

	/**
	 * 根据主键 批量更新在线数据表对象
	 * @param list 批量数据
	 */
	@Override
	public void updateBatch(List<OnlineTable> list) {
		List<OnlineTablePO> onlineTablePOList = IOnlineTablePOConvert.INSTANCE.fromEntity(list);
		Db.updateBatchById(onlineTablePOList);
	}

	/**
	 * 根据主键 删除在线数据表对象
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		onlineTableMapper.deleteById(id);
	}

	/**
	 * 根据主键 批量删除在线数据表对象
	 * @param list 批量数据
	 */
	@Override
	public void deleteBatch(List<OnlineTable> list) {
		throw new UnsupportedOperationException("请自定义实现批量删除方法！");
	}

}
