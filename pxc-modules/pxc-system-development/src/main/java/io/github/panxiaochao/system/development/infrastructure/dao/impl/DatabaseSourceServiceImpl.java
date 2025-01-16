package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.request.databasesource.DatabaseSourceQueryRequest;
import io.github.panxiaochao.system.development.application.api.response.databasesource.DatabaseSourceQueryResponse;
import io.github.panxiaochao.system.development.application.repository.IDatabaseSourceReadModelService;
import io.github.panxiaochao.system.development.domain.entity.DatabaseSource;
import io.github.panxiaochao.system.development.domain.repository.IDatabaseSourceService;
import io.github.panxiaochao.system.development.infrastructure.convert.IDatabaseSourcePOConvert;
import io.github.panxiaochao.system.development.infrastructure.mapper.DatabaseSourceMapper;
import io.github.panxiaochao.system.development.infrastructure.po.DatabaseSourcePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据库-数据源管理 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Service
@RequiredArgsConstructor
public class DatabaseSourceServiceImpl implements IDatabaseSourceService, IDatabaseSourceReadModelService {

	/**
	 * LOGGER DatabaseSourceServiceImpl.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSourceServiceImpl.class);

	/**
	 * 角色表 持久化接口
	 */
	private final DatabaseSourceMapper databaseSourceMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 数据库-数据源管理查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<DatabaseSourceQueryResponse> page(Pagination pagination, DatabaseSourceQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<DatabaseSourcePO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<DatabaseSourcePO> page = databaseSourceMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IDatabaseSourcePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 数据库-数据源管理查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<DatabaseSourceQueryResponse> selectList(DatabaseSourceQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<DatabaseSourcePO> lqw = lambdaQuery(queryRequest);
		return IDatabaseSourcePOConvert.INSTANCE.toQueryResponse(databaseSourceMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 数据库-数据源管理查询请求对象
	 * @return 数据库-数据源管理查询响应对象
	 */
	@Override
	public DatabaseSourceQueryResponse getOne(DatabaseSourceQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<DatabaseSourcePO> lqw = lambdaQuery(queryRequest);
		try {
			DatabaseSourcePO databaseSourcePO = databaseSourceMapper.selectOne(lqw);
			return IDatabaseSourcePOConvert.INSTANCE.toQueryResponse(databaseSourcePO);
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<DatabaseSourcePO> lambdaQuery(DatabaseSourceQueryRequest queryRequest) {
		LambdaQueryWrapper<DatabaseSourcePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照创建时间倒序排序
			lqw.orderByDesc(DatabaseSourcePO::getCreateTime);
			// 如果 数据库名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbName())) {
				lqw.like(DatabaseSourcePO::getDbName, queryRequest.getDbName());
			}
			// 如果 数据源编码 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbCode())) {
				lqw.eq(DatabaseSourcePO::getDbCode, queryRequest.getDbCode());
			}
			// 如果 主机 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbHost())) {
				lqw.eq(DatabaseSourcePO::getDbHost, queryRequest.getDbHost());
			}
			// 如果 端口 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbPort())) {
				lqw.eq(DatabaseSourcePO::getDbPort, queryRequest.getDbPort());
			}
			// 如果 数据库类型 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbType())) {
				lqw.eq(DatabaseSourcePO::getDbType, queryRequest.getDbType());
			}
			// 如果 驱动类 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbDriver())) {
				lqw.eq(DatabaseSourcePO::getDbDriver, queryRequest.getDbDriver());
			}
			// 如果 数据源地址 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbJdbcUrl())) {
				lqw.eq(DatabaseSourcePO::getDbJdbcUrl, queryRequest.getDbJdbcUrl());
			}
			// 如果 用户名 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbUsername())) {
				lqw.eq(DatabaseSourcePO::getDbUsername, queryRequest.getDbUsername());
			}
			// 如果 密码 不为空
			if (StringUtils.isNotBlank(queryRequest.getDbPassword())) {
				lqw.eq(DatabaseSourcePO::getDbPassword, queryRequest.getDbPassword());
			}
			// 如果 测试连接是否成功 不为空
			if (StringUtils.isNotBlank(queryRequest.getTestConn())) {
				lqw.eq(DatabaseSourcePO::getTestConn, queryRequest.getTestConn());
			}
			// 如果 最近一次测试连接时间 不为空
			if (queryRequest.getTestConnTime() != null) {
				lqw.eq(DatabaseSourcePO::getTestConnTime, queryRequest.getTestConnTime());
			}
			// 如果 备注 不为空
			if (StringUtils.isNotBlank(queryRequest.getRemark())) {
				lqw.eq(DatabaseSourcePO::getRemark, queryRequest.getRemark());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return DatabaseSource 实体
	 */
	@Override
	public DatabaseSource getById(String id) {
		DatabaseSourcePO databaseSourcePO = databaseSourceMapper.selectById(id);
		return IDatabaseSourcePOConvert.INSTANCE.toEntity(databaseSourcePO);
	}

	/**
	 * 保存
	 * @param databaseSource DatabaseSource 实体
	 * @return DatabaseSource 实体
	 */
	@Override
	public DatabaseSource save(DatabaseSource databaseSource) {
		DatabaseSourcePO databaseSourcePO = IDatabaseSourcePOConvert.INSTANCE.fromEntity(databaseSource);
		databaseSourceMapper.insert(databaseSourcePO);
		return IDatabaseSourcePOConvert.INSTANCE.toEntity(databaseSourcePO);
	}

	/**
	 * 根据主键更新
	 * @param databaseSource DatabaseSource 实体
	 */
	@Override
	public void update(DatabaseSource databaseSource) {
		DatabaseSourcePO databaseSourcePO = IDatabaseSourcePOConvert.INSTANCE.fromEntity(databaseSource);
		databaseSourceMapper.updateById(databaseSourcePO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		databaseSourceMapper.deleteById(id);
	}

}
