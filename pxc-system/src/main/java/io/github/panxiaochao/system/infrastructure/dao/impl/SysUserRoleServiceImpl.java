package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysUserRoleQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysUserRoleQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysUserRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUserRole;
import io.github.panxiaochao.system.domain.repository.ISysUserRoleService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserRolePOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserRoleMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserRolePO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleServiceImpl implements ISysUserRoleService, ISysUserRoleReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysUserRoleMapper sysUserRoleMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysUserRoleQueryResponse> page(Pagination pagination,
			RequestPage<SysUserRoleQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysUserRolePO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 分页查询
		Page<SysUserRolePO> page = sysUserRoleMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysUserRolePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysUserRolePO> lambdaQuery(SysUserRoleQueryRequest queryRequest) {
		LambdaQueryWrapper<SysUserRolePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(SysUserRolePO::getId);
			// 如果 用户ID 不为空
			if (queryRequest.getUserId() != null) {
				lqw.eq(SysUserRolePO::getUserId, queryRequest.getUserId());
			}
			// 如果 角色ID 不为空
			if (queryRequest.getRoleId() != null) {
				lqw.eq(SysUserRolePO::getRoleId, queryRequest.getRoleId());
			}
			// 如果 创建时间 不为空
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysUserRolePO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysUserRolePO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysUserRole 实体
	 */
	@Override
	public SysUserRole getById(String id) {
		SysUserRolePO sysUserRolePO = sysUserRoleMapper.selectById(id);
		return ISysUserRolePOConvert.INSTANCE.toEntity(sysUserRolePO);
	}

	/**
	 * 保存
	 * @param sysUserRole SysUserRole 实体
	 * @return SysUserRole 实体
	 */
	@Override
	public SysUserRole save(SysUserRole sysUserRole) {
		SysUserRolePO sysUserRolePO = ISysUserRolePOConvert.INSTANCE.fromEntity(sysUserRole);
		sysUserRoleMapper.insert(sysUserRolePO);
		return ISysUserRolePOConvert.INSTANCE.toEntity(sysUserRolePO);
	}

	/**
	 * 根据主键更新
	 * @param sysUserRole SysUserRole 实体
	 */
	@Override
	public void update(SysUserRole sysUserRole) {
		SysUserRolePO sysUserRolePO = ISysUserRolePOConvert.INSTANCE.fromEntity(sysUserRole);
		sysUserRoleMapper.updateById(sysUserRolePO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysUserRoleMapper.deleteById(id);
	}

}

